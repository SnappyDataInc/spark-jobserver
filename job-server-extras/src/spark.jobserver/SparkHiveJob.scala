package spark.jobserver

import org.apache.spark.SparkContext
import org.apache.spark.sql.hive.HiveContext

trait SparkHiveJob extends SparkJobBase {
  type C = HiveContext

  final override def addOrReplaceJar(sc:C, jarName: String, jarPath: String): Unit = {
   sc.asInstanceOf[HiveContext].sparkContext.addJar(jarPath)
  }
}
