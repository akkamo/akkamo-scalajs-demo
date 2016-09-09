package eu.akkamo.scalajs.demo.js

import eu.akkamo.scalajs.demo.shared.Messages
import org.scalajs.dom

import scala.scalajs.js

object TestApp extends js.JSApp {

  override def main(): Unit = {
    dom.window.alert(Messages.HelloWorld)
  }
}
