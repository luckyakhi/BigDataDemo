package com.luckyakhi.mapreducedemo.reducers;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxTemperatureReducer extends Reducer<Text, LongWritable, Text, LongWritable>{
	@Override
	public void reduce(Text key,Iterable<LongWritable> value,Context context) throws IOException, InterruptedException{
		LongWritable maxTemp = new LongWritable(Long.MIN_VALUE);
		for (LongWritable longWritable : value) {
			if(longWritable.compareTo(maxTemp)>0){
				maxTemp=longWritable;
			}
		}
		context.write(key, maxTemp);
	}
}
