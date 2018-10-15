package com.ipsumllc.ServicePipes.protocols

import org.apache.camel.builder.RouteBuilder


object DefaultProtocol extends Protocol {
  import com.ipsumllc.ServicePipes.Router._

  def producer(url: String, transform: String = transformEndpoint): RouteBuilder = {
    return new RouteBuilder() {
      override def configure() = {
        from(url)
          .to(transform)
          .noStreamCaching()
          .end()

      }
    }
  }

  def consumer(_url: String): RouteBuilder  = {
    return new RouteBuilder() {
      override def configure() = {
        from(publishEndpt).
          log("$body").
          end()
      }
    }
  }
}
