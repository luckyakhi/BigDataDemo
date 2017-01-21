package com.luckyakhi.hdfs;

import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HDFSFileReader implements IFileReader<String>{


	@Override
	public String readFile(String path) {
		Configuration conf = new Configuration(true);

		try {
			FileSystem fileSystem = FileSystem.get(URI.create(path), conf);
			FSDataInputStream inputStream= fileSystem.open(new Path(path));
			int numberOfBytes=inputStream.available();
			System.out.println("Number of bytes read are:"+numberOfBytes);
		} catch (IOException e) {
					e.printStackTrace();
		}
		
		return null;
	}

}
