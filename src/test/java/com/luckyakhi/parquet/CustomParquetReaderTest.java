package com.luckyakhi.parquet;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kitesdk.data.Formats;

public class CustomParquetReaderTest {
	
	private CustomParquetReader customParquetReader;

	@Before
	public void setUp() throws Exception {
		customParquetReader = new CustomParquetReader();
		System.setProperty("hadoop.home.dir", System.getProperty("user.dir")+"/target/test-classes/hadoop");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRead() {
		customParquetReader.read("c://tmp/akhi", Formats.PARQUET.toString());
	}

}
