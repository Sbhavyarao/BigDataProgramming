/**
 * Illustrates flatMap + countByValue for wordcount.
 */


import org.apache.spark._

object WordCount {
    def main(args: Array[String]) {

      System.setProperty("hadoop.home.dir","C:\\winutils" )
      //val inputFile = args(0)
      //val outputFile = args(1)
      val conf = new SparkConf().setAppName("wordCount").setMaster("local[*]")
      // Create a Scala Spark Context.
      val sc = new SparkContext(conf)
      // Load our input data.
      //val input =  sc.textFile(inputFile)
      val input = sc.textFile("input.txt")
      // Split up into words.
      val words = input.flatMap(line => line.split(" "))
       //.filter(value => value=="hello")
      // Transform into word and count.
      val counts = words.map(word => (word, 1)).reduceByKey{case (x, y) => x + y}
      println(counts.take(4).foreach(println))
      //.sortBy(_._1, ascending = true)
      // Save the word count back out to a text file, causing evaluation.
      val result = words.distinct() // transform count
      //println(result.collect().mkString(",")) // transform count
      println("Word Count" ,words.count())
      //counts.saveAsTextFile("output_WordCount_count")
    }
}
