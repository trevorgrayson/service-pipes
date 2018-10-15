package com.ipsumllc.ServicePipes

object Router {
  val stream: String = "direct:start"

  val transformEndpoint: String = "direct:transform"

  val publishEndpt: String = "direct:publish"
}

trait Router {
  import Router._
}
