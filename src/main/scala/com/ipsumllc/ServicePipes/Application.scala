package com.ipsumllc.ServicePipes


object Application {

  def main(args: Array[String]): Unit = {

    val pipe = if (args.length > 2) {
      val (from, to) = (args(0), args(1))

      println(s"$from > $to")
      new ServicePipe(from, to)

    } else {
      val (from, to) = (sys.env("PIPE_FROM"), sys.env("PIPE_TO"))

      println(s"$from > $to")
      new ServicePipe(from, to)
    }

    pipe.process()
  }

}
