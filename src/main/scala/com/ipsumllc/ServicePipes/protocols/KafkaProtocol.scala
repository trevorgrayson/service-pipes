package com.ipsumllc.ServicePipes.protocols
import org.apache.camel.builder.RouteBuilder

object KafkaProtocol extends Protocol {
  import com.ipsumllc.ServicePipes.Router._

  val PARAMS = "&maxPollRecords=1000&consumersCount=4&groupId=source-consumer"

  override def producer(url: String, transform: String = transformEndpoint): RouteBuilder = {
    return new RouteBuilder() {
      def configure(): Unit = {
        from(url + PARAMS)
          .to(transformEndpoint)
          .end
      }
    }
  }

  override def consumer(url: String): RouteBuilder = {
    // I.O.U
    DefaultProtocol.consumer(url)
  }
}
