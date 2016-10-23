package com.luckyakhi.mapreducedemo.mappers;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MaxTemperatureMapper extends Mapper<LongWritable, Text,Text, LongWritable> {
	@Override
	public void map(LongWritable key,Text value,Context context) throws IOException, InterruptedException{
		StringTokenizer tokens = new StringTokenizer(value.toString(),",");
		context.write(new Text(tokens.nextToken()), new LongWritable(new Long(tokens.nextToken())));
	}
}
