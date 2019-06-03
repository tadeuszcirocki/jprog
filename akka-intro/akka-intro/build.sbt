name 			:= "AkkaIntro"
version 		:= "0.0.1"
scalaVersion 	:= "2.12.8"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
	val akkaV = "2.5.22"
	Seq(
		"com.typesafe.akka" %% "akka-actor" % akkaV
	)
}
