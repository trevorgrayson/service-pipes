package com.ipsumllc.ServicePipes

import java.net.URL

import com.ipsumllc.ServicePipes.protocols.{DefaultProtocol, HttpProtocol, Protocol}
import com.ipsumllc.ServicePipes.formats._
import org.apache.camel.impl.DefaultCamelContext

class ServicePipe(from: String, to: String) {

  val context = new DefaultCamelContext()

  implicit def `string to url`(s: String) = {
    val ss = s.replace("http4:", "http:")
    new URL(ss)
  }

  def process(request: Option[TransformRequest]) = {

    // producer
    context.addRoutes(
      getProtocol(from).producer(from)
    )

    // transform
    val transform = request.getOrElse(TransformRequest("", "")).getTransform
    context.addRoutes(transform.transform())

    // publish to consumer
    context.addRoutes(
      getProtocol(to).consumer(to)
    )

    context.start()
    val producer = context.createProducerTemplate
    producer.sendBody(Router.stream, "")
    context.stop()
  }

  def getProtocol(url: URL): Protocol = {
    url.getProtocol() match {
      case "http" => HttpProtocol
      case _ => DefaultProtocol
    }
  }

}
