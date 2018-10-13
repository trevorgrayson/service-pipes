package com.ipsumllc.ServicePipes.protocols

import org.apache.camel.builder.RouteBuilder


object DefaultProtocol extends Protocol {

  def producer(url: String, transform: String = transformEndpt): RouteBuilder = {
    return new RouteBuilder() {
      override def configure() = {
        from(url).
          to(transformEndpt).
          end()
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
