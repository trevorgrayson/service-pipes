package com.ipsumllc.ServicePipes

import com.ipsumllc.ServicePipes.formats.TransformRequest


object Application {

  def main(args: Array[String]): Unit = {

    val split = sys.env.get("SPLIT")

    val pipe = if (args.length > 2) {
      val (from, to) = (args(0), args(1))

      println(s"$from > $to")
      new ServicePipe(from, to)

    } else {
      val (from, to) = (sys.env("PIPE_FROM"), sys.env("PIPE_TO"))

      println(s"$from => $to")
      new ServicePipe(from, to)
    }

    val transform = split.map(s => TransformRequest.parse(s))
    transform.map(split => println(s"Splitting on: $split"))

    pipe.process(transform)
  }

}
