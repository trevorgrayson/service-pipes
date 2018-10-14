package com.ipsumllc.ServicePipes.formats


object TransformRequest {
  def parse(arg: String) = {
    val values = arg.split(":")

    TransformRequest(values(0), values(1))
  }
}

case class TransformRequest(format: String, partition: String) {

  def getTransform = {
    format match {
      case "xml" => new XmlSplitter(partition)
      case _ => new DefaultTransform()
    }
  }

}

