package com.ipsumllc.ServicePipes.formats

import com.ipsumllc.ServicePipes.Router
import org.apache.camel.builder.RouteBuilder

class XmlSplitter(element: String) extends Transform {
  import Router._
  val FORMAT = "xml"

  def transform() =  new RouteBuilder() {
    def configure() = {
      from(transformEndpoint) //formatEndpoint(element))
        .split
        .tokenizeXML(element)
        .streaming
        .parallelProcessing(true)
        .to(publishEndpt)
        .end
    }
  }

  def formatEndpoint(delimiter: String) = {
    transformEndpoint + ":" + FORMAT + ":" + delimiter
  }
}
