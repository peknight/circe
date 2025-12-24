import com.peknight.build.gav
import com.peknight.build.gav.*
import com.peknight.build.sbt.*

commonSettings

lazy val circe = (project in file("."))
  .settings(name := "circe")
  .aggregate(
    circeCore.jvm,
    circeCore.js,
    circeCore.native,
    circeParser.jvm,
    circeParser.js,
    circeParser.native,
  )

lazy val circeCore = (crossProject(JVMPlatform, JSPlatform, NativePlatform) in file("circe-core"))
  .settings(name := "circe-core")
  .settings(crossDependencies(gav.circe))

lazy val circeParser = (crossProject(JVMPlatform, JSPlatform, NativePlatform) in file("circe-parser"))
  .settings(name := "circe-parser")
  .settings(crossDependencies(
    gav.circe.parser,
    gav.circe.jawn,
  ))
