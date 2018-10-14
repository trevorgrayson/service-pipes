package com.ipsumllc.ServicePipes.protocols

import com.ipsumllc.ServicePipes.Router
import org.apache.camel.Exchange
import org.apache.camel.builder.RouteBuilder

object HttpProtocol extends Protocol {
  import Router._

  def producer(url: String, transform: String = transformEndpoint): RouteBuilder = {
    return new RouteBuilder() {
      override def configure() = {
        from(stream)
          .setHeader(Exchange.HTTP_METHOD, constant("GET"))
          .to(url + "?disableStreamCache=true")
          .noStreamCaching
          .to(transform)
          .end
      }
    }
  }

  def consumer(url: String) = new RouteBuilder() {
    def configure() = {
      from(publishEndpt)
        .setHeader(Exchange.HTTP_METHOD, constant("POST"))
        .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
        .to(url)
        .process((exchange) =>
          log.info("The response code is: {}", exchange.getIn
          .getHeader(Exchange.HTTP_RESPONSE_CODE)))
        .end
    }
  }


}
