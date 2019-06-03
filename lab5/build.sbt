name := "lab05"

version := "1.0"

scalaVersion := "2.12.8"

libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.5" % "test"

parallelExecution in Test := false
fork in Test := true
// cancelable in Global := true
