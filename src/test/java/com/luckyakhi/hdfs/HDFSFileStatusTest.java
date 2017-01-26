package com.luckyakhi.hdfs;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HDFSFileStatusTest {
	
	private String userDirectory=System.getProperty("user.dir")+"/target/test-classes";
	private Configuration conf;

	@Before
	public void setUp() throws Exception {
		System.setProperty("hadoop.home.dir", userDirectory+"/hadoop");
		conf=new Configuration();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_list_file_statuses() throws IllegalArgumentException, IOException {
		Path testDirectory = new Path(userDirectory+"/test-files");
		FileSystem fs = FileSystem.get(testDirectory.toUri(), conf);
		FileStatus[] fileStatuses=fs.listStatus(testDirectory);
		for (FileStatus fileStatus : fileStatuses) {
			System.out.printf("Owner %s Path %s Group %s Length %s Block size %s",
					fileStatus.getOwner(),fileStatus.getPath(),fileStatus.getGroup(),fileStatus.getLen(),fileStatus.getBlockSize());
			System.out.println("--");
			assertFalse(fileStatus.isDirectory());
		}
	
	}
	
	@Test
	public void test_list_file_statuses_with_filter() throws IllegalArgumentException, IOException {
		Path testDirectory = new Path(userDirectory+"/test-files");
		FileSystem fs = FileSystem.get(testDirectory.toUri(), conf);
		FileStatus[] fileStatuses=fs.listStatus(testDirectory,x->x.getName().endsWith("txt"));
		for (FileStatus fileStatus : fileStatuses) {
			System.out.printf("Owner %s Path %s Group %s Length %s Block size %s",
					fileStatus.getOwner(),fileStatus.getPath(),fileStatus.getGroup(),fileStatus.getLen(),fileStatus.getBlockSize());
			System.out.println("--");
			assertFalse(fileStatus.isDirectory());
		}
		assertEquals(7, fileStatuses.length);
	
	}
	
	@Test
	public void test_glob_statuses() throws IllegalArgumentException, IOException {
		Path testDirectory = new Path(userDirectory+"/test-files");
		FileSystem fs = FileSystem.get(testDirectory.toUri(), conf);
		FileStatus[] fileStatuses=fs.globStatus(new Path(userDirectory+"/test-files/*.txt"));
		for (FileStatus fileStatus : fileStatuses) {
			System.out.printf("Owner %s Path %s Group %s Length %s Block size %s",
					fileStatus.getOwner(),fileStatus.getPath(),fileStatus.getGroup(),fileStatus.getLen(),fileStatus.getBlockSize());
			System.out.println("--");
			assertFalse(fileStatus.isDirectory());
		}
		assertEquals(7, fileStatuses.length);
	
	}
	
	@Test
	public void test_glob_statuses_with_filter() throws IllegalArgumentException, IOException {
		Path testDirectory = new Path(userDirectory+"/test-files");
		FileSystem fs = FileSystem.get(testDirectory.toUri(), conf);
		FileStatus[] fileStatuses=fs.globStatus(new Path(userDirectory+"/test-files/*.txt"),x->x.getName().contains("data"));
		for (FileStatus fileStatus : fileStatuses) {
			System.out.printf("Owner %s Path %s Group %s Length %s Block size %s",
					fileStatus.getOwner(),fileStatus.getPath(),fileStatus.getGroup(),fileStatus.getLen(),fileStatus.getBlockSize());
			System.out.println("--");
			assertFalse(fileStatus.isDirectory());
		}
		assertEquals(4, fileStatuses.length);
	
	}

}
