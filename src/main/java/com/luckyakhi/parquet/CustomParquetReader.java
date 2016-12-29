package com.luckyakhi.parquet;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.parquet.hadoop.ParquetReader;
import org.apache.parquet.tools.read.SimpleReadSupport;
import org.apache.parquet.tools.read.SimpleRecord;

public class CustomParquetReader {
	public void read(String sourcePath,String format){
		SimpleReadSupport readSupport = new SimpleReadSupport();
 		Path path = new Path(sourcePath);
 		try {
			ParquetReader<SimpleRecord> simpleRecordBuilder = ParquetReader.builder(readSupport, path).build();
			SimpleRecord record = simpleRecordBuilder.read();
			System.out.println(record);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
