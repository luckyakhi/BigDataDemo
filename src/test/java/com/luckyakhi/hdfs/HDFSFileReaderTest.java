package com.luckyakhi.hdfs;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HDFSFileReaderTest {

	private HDFSFileReader fileReader;
	private String userDirectory;
	
	@Before
	public void setUp() throws Exception {
		userDirectory= System.getProperty("user.dir")+"/target/test-classes";
		System.setProperty("hadoop.home.dir",userDirectory+"hadoop");
		fileReader=new HDFSFileReader();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReadFile() {
		fileReader.readFile(new File(userDirectory+"temp_data_station_A.txt").toURI().toString());
	}

}
