package com.ipsumllc.ServicePipes.protocols

import com.ipsumllc.ServicePipes.Router
import org.apache.camel.builder.RouteBuilder

trait Protocol {
  // seda:
  import Router._

  def producer(url: String, transform: String = transformEndpoint): RouteBuilder

  def consumer(url: String): RouteBuilder

}
