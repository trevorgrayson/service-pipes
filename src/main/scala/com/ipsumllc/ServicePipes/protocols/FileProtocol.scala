package com.ipsumllc.ServicePipes.protocols

import com.ipsumllc.ServicePipes.Router
import org.apache.camel.Exchange
import org.apache.camel.builder.RouteBuilder

object FileProtocol extends Protocol {
  import Router._

  def producer(url: String, transform: String = transformEndpoint): RouteBuilder = {
    return new RouteBuilder() {
      override def configure() = {
        from(camelFileUrl(url))
          .noStreamCaching
          .to(transform)
          .end
      }
    }
  }

  def consumer(url: String) = new RouteBuilder() {
    def configure() = {
      from(publishEndpt)
        .to(camelFileUrl(url))
        .end
    }
  }

  def camelFileUrl(url: String) = {
    val lastSlash = url.lastIndexOf("/")
    val folder = url.substring(0, lastSlash + 1)
    val fileName = url.substring(lastSlash + 1, url.length)

    s"${folder}?fileName=${fileName}&noop=true"
  }


}
