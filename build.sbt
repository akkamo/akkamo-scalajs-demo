
name := "akkamo-scalajs-demo"

version := "0.1.0-SNAPSHOT"

scalaVersion in Global := "2.11.8"

lazy val akkamoVersion = "1.0.3-SNAPSHOT"

lazy val root = project.in(file(".")).settings(
  libraryDependencies ++= Seq(
    "eu.akkamo" %% "akkamo" % akkamoVersion,
    "eu.akkamo" %% "akkamo-web-content" % akkamoVersion
  ),
  mainClass in Compile := Some("eu.akkamo.Main")
).dependsOn(scalaJs).aggregate(scalaJs).enablePlugins(AkkamoSbtPlugin)

lazy val scalaJs = project.in(file("scalajs")).settings(
  crossTarget in fastOptJS := baseDirectory.value / ".." / "src" / "main" / "resources" / "web" / "js"
).enablePlugins(ScalaJSPlugin)