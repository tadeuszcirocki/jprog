name := "lab13"
version := "1.0"

scalaVersion := "2.12.8"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaV = "2.5.22"
	Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaV,
		"org.scalacheck" %% "scalacheck" % "1.14.0",
		"uk.gov.hmrc" %% "stub-data-generator" % "0.5.3"
    )
}

// parallelExecution in Test := false
