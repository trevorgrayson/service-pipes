package com.ipsumllc.ServicePipes.protocols

import com.ipsumllc.ServicePipes.Router
import org.apache.camel.builder.RouteBuilder

trait Protocol extends Router {
  // seda:

  def producer(url: String, transform: String = transformEndpt): RouteBuilder

  def consumer(url: String): RouteBuilder

}
