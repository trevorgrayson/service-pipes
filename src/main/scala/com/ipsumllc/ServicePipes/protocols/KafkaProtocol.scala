package com.ipsumllc.ServicePipes.protocols
import com.ipsumllc.ServicePipes.protocols.HttpProtocol.transformEndpt
import org.apache.camel.builder.RouteBuilder

object KafkaProtocol extends Protocol {

  val PARAMS = "&maxPollRecords=1000&consumersCount=4&groupId=source-consumer"

  override def producer(url: String, transform: String = transformEndpt): RouteBuilder = {
    return new RouteBuilder() {
      def configure(): Unit = {
        from(url + PARAMS)
          .to(transformEndpt)
          .end
      }
    }
  }

  override def consumer(url: String): RouteBuilder = {
    // I.O.U
    DefaultProtocol.consumer(url)
  }
}
