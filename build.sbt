name := "test"
version := "1.0"

//tested (fail) with both scala 2.11.5 & 2.11.6-20150127.023613-7
//resolvers += Resolver.sonatypeRepo("snapshots")
//scalaVersion := "2.11.6-SNAPSHOT"

scalaVersion := "2.11.5"

scalacOptions ++= Seq("-encoding", "UTF-8"
  ,"-optimise" //only fail with -optimise option
//  ,"-Ybackend:GenBCode" //tested (fail) with both GenASM & GenBCode backends
)

libraryDependencies += "com.sandinh" %% "couchbase-scala" % "6.0.0"

//tested (fail) with & without this setting:
libraryDependencies <+= scalaVersion(v => "org.scala-lang" %  "scala-reflect" % v)
