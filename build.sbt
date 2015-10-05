import play.PlayJava

val appName         = "play2.3-rest-security"
val appVersion      = "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.0"

libraryDependencies ++= Seq(
  javaCore,
  javaJdbc,
  javaEbean,
   "org.postgresql" % "postgresql" % "9.3-1102-jdbc41",
  "org.apache.commons" % "commons-dbcp2" % "2.0.1"
)

libraryDependencies += "org.webjars" %% "webjars-play" % "2.3.0"