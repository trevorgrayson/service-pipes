package com.ipsumllc.ServicePipes.formats

import org.apache.camel.builder.RouteBuilder

class DefaultTransform extends Transform {
  import com.ipsumllc.ServicePipes.Router._

  def transform(): RouteBuilder = {
    noTransform
  }

  def noTransform: RouteBuilder = {
    new RouteBuilder() {
      override def configure()= {
        from(transformEndpoint)
          .to(publishEndpt)
          .end
      }
    }
  }

}
