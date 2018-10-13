package com.ipsumllc.ServicePipes

import java.net.URL

import com.ipsumllc.ServicePipes.protocols.{DefaultProtocol, HttpProtocol, Protocol}
import com.ipsumllc.ServicePipes.formats.{DefaultTransform, XmlSplitter}
import org.apache.camel.impl.DefaultCamelContext

class ServicePipe(from: String, to: String) {

  val context = new DefaultCamelContext()

  implicit def `string to url`(s: String) = {
    new URL(s.replace("http4:", "http:"))
  }

  def process() = {

    // producer
    context.addRoutes(
      getProtocol(from).producer(from, DefaultTransform.transformEndpt)
    )

    // transform
    context.addRoutes(XmlSplitter.transform("program"))

    // publish to consumer
    context.addRoutes(
      getProtocol(to).consumer(to)
    )

    context.start()
    val producer = context.createProducerTemplate
    producer.sendBody(HttpProtocol.stream, "")
    context.stop()
  }

  def getProtocol(url: URL): Protocol = {
    url.getProtocol() match {
      case "http" => HttpProtocol
      case _ => DefaultProtocol
    }
  }

}
