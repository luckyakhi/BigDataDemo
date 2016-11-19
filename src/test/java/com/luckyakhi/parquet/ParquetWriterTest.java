package com.luckyakhi.parquet;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.luckyakhi.parquet.ParquetWriter;

public class ParquetWriterTest {
	private ParquetWriter parquetWriter;
	
	@BeforeClass
	public static void setUpBeforeClass(){
		
	}

	@Before
	public void setUp() throws Exception {
		System.setProperty("hadoop.home.dir", System.getProperty("user.dir")+"/target/test-classes/hadoop");
		parquetWriter = new ParquetWriter();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWriteToStore() {
		parquetWriter.writeToStore("dataset:file:c://tmp/akhi/", null);
	}

}
