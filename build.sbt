name := "geocoder"

organization := "com.koddi"

version := "1.1.0"

scalaVersion := "2.13.1"

scalacOptions := Seq("-unchecked", "-feature", "-deprecation", "-encoding", "utf8")

crossScalaVersions := Seq("2.10.4", "2.11.7", "2.12.2", "2.13.1")

libraryDependencies ++= scalaxml(scalaVersion.value) ++ scalatest(scalaVersion.value)

def scalaxml(scalaVersion: String) = {
    val lib =
    if (scalaVersion.startsWith("2.11") || scalaVersion.startsWith("2.12") || scalaVersion.startsWith("2.13")) {
        "org.scala-lang.modules" %% "scala-xml" % "1.2.0"
    } else {
        null
    }

    if (null == lib) {
        Seq.empty[sbt.ModuleID]
    } else {
        Seq(lib)
    }
}

def scalatest(scalaVersion: String) = {
    Seq((scalaVersion match {
        case "2.10.4" => "org.scalatest" %% "scalatest" % "2.1.3"
        case _        => "org.scalatest" %% "scalatest" % "3.0.8"
    }) % "test")
}

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

licenses := Seq("MIT-style" -> url("http://www.opensource.org/licenses/mit-license.php"))

homepage := Some(url("https://koddidev.github.io/geocoder/"))

sonatypeProfileName := "com.koddi"

scmInfo := Some(
    ScmInfo(
        url("https://github.com/KoddiDev/geocoder"),
        "scm:git@github.com:KoddiDev/geocoder.git"
    )
)

developers := List(
    Developer(
        id    = "geocoder",
        name  = "Koddi Developers",
        email = "dev@koddi.com",
        url   = url("http://www.koddi.com")
    )
)

publishTo := Some("S3 Artifacts" at "s3://homebay-artifacts/ext-releases-local")
