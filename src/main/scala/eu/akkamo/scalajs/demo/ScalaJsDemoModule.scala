package eu.akkamo.scalajs.demo

import akka.event.LoggingAdapter
import eu.akkamo._
import eu.akkamo.scalajs.demo.shared.Messages

import scala.util.Try

/**
  * Created by xwinus on 09.09.16.
  */
class ScalaJsDemoModule extends Module with Initializable {

  override def dependencies(dependencies: Dependency): Dependency =
    dependencies.&&[LogModule]

  override def initialize(ctx: Context): Res[Context] = Try {
    val log: LoggingAdapter = ctx.get[LoggingAdapterFactory].apply(getClass)
    log.info(Messages.HelloWorld)
    ctx
  }
}
