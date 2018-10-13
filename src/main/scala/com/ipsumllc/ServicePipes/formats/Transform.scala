package com.ipsumllc.ServicePipes.formats

import com.ipsumllc.ServicePipes.Router
import org.apache.camel.builder.RouteBuilder

object Transform {
  val transformEndpoint = "direct:format"
}

trait Transform extends Router {

  def transform(url: String): RouteBuilder

}
