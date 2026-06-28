import com.peknight.build.gav
import com.peknight.build.gav.{circe as _, *}
import com.peknight.build.sbt.*

commonSettings

lazy val circe = (project in file("."))
  .settings(name := "circe")
  .aggregate(circeCore.projectRefs *)
  .aggregate(circeParser.projectRefs *)

lazy val circeCore = (projectMatrix in file("circe-core"))
  .settings(name := "circe-core")
  .settings(libraryDependencies ++= dependencies(gav.circe))
  .jvmPlatform(scalaVersions = Seq(scala.scala3.version))
  .jsPlatform(scalaVersions = Seq(scala.scala3.version))
  .nativePlatform(scalaVersions = Seq(scala.scala3.version))

lazy val circeParser = (projectMatrix in file("circe-parser"))
  .settings(name := "circe-parser")
  .settings(libraryDependencies ++= dependencies(
    gav.circe.parser,
    gav.circe.jawn,
  ))
  .jvmPlatform(scalaVersions = Seq(scala.scala3.version))
  .jsPlatform(scalaVersions = Seq(scala.scala3.version))
  .nativePlatform(scalaVersions = Seq(scala.scala3.version))
