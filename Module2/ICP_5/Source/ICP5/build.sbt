name := "ICP5"


scalaVersion := "2.12.10"

resolvers += "SparkPackages" at "https://dl.bintray.com/spark-packages/maven"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "3.0.0",
  "org.apache.spark" %% "spark-mllib" % "3.0.0" % "provided",
  "org.apache.spark" %% "spark-sql" % "3.0.0",
  "org.apache.spark" %% "spark-graphx" % "3.0.0",
  "graphframes" % "graphframes" % "0.8.0-spark3.0-s_2.12"
)


