package com.ipsumllc.ServicePipes.formats

import org.apache.camel.builder.RouteBuilder

object DefaultTransform extends Transform {

  def transform(url: String): RouteBuilder = {
    noTransform
  }

  def noTransform: RouteBuilder = {
    new RouteBuilder() {
      override def configure()= {
        from(transformEndpt)
          .to(publishEndpt)
          .end
      }
    }
  }

}
