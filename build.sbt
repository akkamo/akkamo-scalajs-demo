
name := "akkamo-scalajs-demo"

version := "0.1.0-SNAPSHOT"

scalaVersion in Global := "2.11.8"

lazy val root = project.in(file(".")).settings(
  libraryDependencies ++= Seq(

  ),
  mainClass in Compile := Some("eu.akkamo.Main")
).enablePlugins(AkkamoSbtPlugin)