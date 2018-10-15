package com.ipsumllc.ServicePipes.formats

import com.ipsumllc.ServicePipes.Router
import org.apache.camel.builder.RouteBuilder

trait Transform extends Router {

  def transform(): RouteBuilder

}
