package org.apache.spark.deploy

object GetJarsAndDependencies extends App {
  if (args.length < 1) {
    println(s"GetJarsAndDependencies utility needs at least the coordinates")
  }

  val usage: String = "Wrong usage"

  val (coordinates, remoteRepos, ivyPath) = args.length match {
    case 1 => (args(0), None, None)
    case 2 => (args(0), Some(args(1)), None)
    case 3 => (args(0), Some(args(1)), Some(args(2)))
    case _ => ("INVALID", None, None)
  }
  if (coordinates.contentEquals("INVALID")) {
    println(usage)
    System.exit(1)
  }

  println(PackageAndDepUtils.resolveMavenCoordinates(coordinates, remoteRepos, ivyPath))
}

object PackageAndDepUtils {
  def resolveMavenCoordinates(coordinates: String, remoteRepos: Option[String],
        ivyPath: Option[String], exclusions: Seq[String] = Nil, isTest: Boolean = false): String = {
    SparkSubmitUtils.resolveMavenCoordinates(coordinates, remoteRepos, ivyPath, exclusions, isTest)
  }
}