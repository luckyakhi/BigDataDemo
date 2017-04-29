package com.luckyakhi.spark;

import org.apache.spark.SparkContext;
import org.apache.spark.rdd.RDD;

public class WordCount {

	public static void main(String[] args) {
		SparkContext sc = new SparkContext("local", "WordCount");
		RDD<String> wordCountRDD =sc.textFile(System.getProperty("user.dir")+"/target/classes/word_count.txt", 1);
		System.out.println(wordCountRDD.count());
	}

}
