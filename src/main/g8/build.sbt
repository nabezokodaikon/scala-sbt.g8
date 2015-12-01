lazy val commonSettings = Seq(
  organization := "$organization$",
  version := "$version$",
  scalaVersion := "$scala_version$",
  scalacOptions ++= Seq(
    "-deprecation",
    "-feature",
    "-unchecked",
    "-Xlint"
  ),
  shellPrompt := { state =>
    val branch = if (file(".git").exists) {
      "git branch".lines_!.find { _.head == '*' }.map { _.drop(1) }.getOrElse("")
    } else ""
    Project.extract(state).currentRef.project + branch + " > "
  }
)

lazy val root = (project.in(file(".")))
  .settings(commonSettings: _*)
  .settings(
    name := "$name$",
    resolvers ++= {
      Seq(
      )
    },
    libraryDependencies ++= {
      Seq(
        // Test
        "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
        "org.scalacheck" %% "scalacheck" % "1.12.5" % "test",

        // Logger
        "com.typesafe.scala-logging" % "scala-logging_2.11" % "3.1.0",
        "ch.qos.logback" % "logback-classic" % "1.1.3"
      )
    }
  )

initialCommands := "import $package$._"
