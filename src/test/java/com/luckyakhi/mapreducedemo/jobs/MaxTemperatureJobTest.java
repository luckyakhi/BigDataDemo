package com.luckyakhi.mapreducedemo.jobs;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.luckyakhi.mapreducedemo.mappers.MaxTemperatureMapper;
import com.luckyakhi.mapreducedemo.reducers.MaxTemperatureReducer;

public class MaxTemperatureJobTest {

	 MapDriver<LongWritable, Text,Text, LongWritable> mapDriver;
	 ReduceDriver<Text, LongWritable, Text, LongWritable> reduceDriver;
	 MapReduceDriver<LongWritable, Text, Text, LongWritable, Text, LongWritable> mapReduceDriver;
	
	@BeforeClass
	public static void setUpBeforeClass(){
		System.setProperty("hadoop.home.dir", System.getProperty("user.dir")+"/target/test-classes/hadoop/");
	}
	 
	@Before
	public void setUp() throws Exception {
		MaxTemperatureMapper mapper = new MaxTemperatureMapper();
		MaxTemperatureReducer reducer = new MaxTemperatureReducer();
		mapDriver=MapDriver.newMapDriver(mapper);
		reduceDriver = ReduceDriver.newReduceDriver(reducer);
		mapReduceDriver=MapReduceDriver.newMapReduceDriver(mapper, reducer);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException {
		mapDriver.withInput(new LongWritable(11L), new Text("1961,122")).withInput(new LongWritable(12L), new Text("1960,21"));
		mapDriver.withOutput(new Text("1961"), new LongWritable(122)).withOutput(new Text("1960"), new LongWritable(21));
		mapDriver.runTest();

	
	}

}
