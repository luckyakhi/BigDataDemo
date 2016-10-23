package com.luckyakhi.mapreducedemo.jobs;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;

import com.luckyakhi.mapreducedemo.mappers.MaxTemperatureMapper;

public class MaxTemperatureJob extends Configured implements Tool{
	
	
	@Override
	public int run(String[] args) throws Exception {
		Job maxTemperatureJob = new Job(getConf());
		maxTemperatureJob.setJarByClass(Job.class);
		maxTemperatureJob.setInputFormatClass(TextInputFormat.class);
		maxTemperatureJob.setMapOutputKeyClass(Text.class);
		maxTemperatureJob.setMapOutputValueClass(LongWritable.class);
		maxTemperatureJob.setOutputKeyClass(Text.class);
		maxTemperatureJob.setOutputValueClass(LongWritable.class);
		maxTemperatureJob.setJobName("Max Temperature Job");
		maxTemperatureJob.setMapperClass(MaxTemperatureMapper.class);
		FileInputFormat.setInputPaths(maxTemperatureJob, new Path(args[0]));
		FileOutputFormat.setOutputPath(maxTemperatureJob, new Path(args[1]));
		return maxTemperatureJob.waitForCompletion(true)==true?0:1;
	}

}
