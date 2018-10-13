package com.ipsumllc.ServicePipes.formats

import org.apache.camel.builder.RouteBuilder

object XmlSplitter extends Transform {

  val FORMAT = "xml"

  def transform(element: String) =  new RouteBuilder() {
    def configure(): Unit = {
      from(transformEndpt) //formatEndpoint(element))
        .split
        .tokenizeXML(element)
        .streaming
        .parallelProcessing(true)
        .to(publishEndpt)
        .end
    }
  }

  def formatEndpoint(delimiter: String) = {
    transformEndpt + ":" + FORMAT + ":" + delimiter
  }
}
