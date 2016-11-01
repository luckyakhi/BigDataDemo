package com.luckyakhi.mapreducedemo.jobs;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import com.luckyakhi.mapreducedemo.mappers.MaxTemperatureMapper;
import com.luckyakhi.mapreducedemo.reducers.MaxTemperatureReducer;

public class MaxTemperatureJob{
	
	public static void main(String[] args) throws Exception {
		Job maxTemperatureJob = new Job();
		maxTemperatureJob.setJarByClass(MaxTemperatureJob.class);
		maxTemperatureJob.setInputFormatClass(TextInputFormat.class);
		maxTemperatureJob.setMapOutputKeyClass(Text.class);
		maxTemperatureJob.setMapOutputValueClass(LongWritable.class);
		maxTemperatureJob.setOutputKeyClass(Text.class);
		maxTemperatureJob.setOutputValueClass(LongWritable.class);
		maxTemperatureJob.setJobName("Max Temperature Job");
		maxTemperatureJob.setMapperClass(MaxTemperatureMapper.class);
		maxTemperatureJob.setReducerClass(MaxTemperatureReducer.class );
		FileInputFormat.setInputPaths(maxTemperatureJob, new Path(args[0]));
		FileOutputFormat.setOutputPath(maxTemperatureJob, new Path(args[1]));
		System.exit(maxTemperatureJob.waitForCompletion(true)==true?0:1);
	}

}
