organization := "eu.akkamo"

name := "akkamo-scalajs-demo"

version := "0.1.0-SNAPSHOT"

scalaVersion in Global := "2.11.8"

lazy val akkamoVersion = "1.0.3"

lazy val root = project.in(file(".")).settings(
  libraryDependencies ++= Seq(
    "eu.akkamo" %% "akkamo" % akkamoVersion,
    "eu.akkamo" %% "akkamo-web-content" % akkamoVersion
  ),
  mainClass in Compile := Some("eu.akkamo.Main"),
  pipelineStages in Assets := Seq(scalaJSPipeline),
  scalaJSProjects := Seq(scalaJs),
  WebKeys.packagePrefix in Assets := "web/",
  managedClasspath in Runtime += (packageBin in Assets).value,
  compile in Compile <<= (compile in Compile) dependsOn scalaJSPipeline

).dependsOn(scalaJs).aggregate(scalaJs, sharedJVM, sharedJS).enablePlugins(AkkamoSbtPlugin, SbtWeb, JavaAppPackaging)

lazy val scalaJs = project.in(file("scalajs")).settings(
  libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.9.0"
  )
).enablePlugins(ScalaJSPlugin, ScalaJSWeb).dependsOn(sharedJS)

lazy val shared = crossProject.crossType(CrossType.Pure).in(file("shared")).settings(

).jsConfigure(_ enablePlugins ScalaJSPlugin)

lazy val sharedJVM = shared.jvm.settings(name := "sharedJVM")

lazy val sharedJS = shared.js.settings(name := "sharedJS")