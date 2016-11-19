package com.luckyakhi.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BookingDAOImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateBooking() throws IOException {
		Configuration hbaseConfiguration = HBaseConfiguration.create();
		hbaseConfiguration.set("hbase.zookeeper.quorum", "localhost:2181");
		HTableInterface bookingTable = new HTable(hbaseConfiguration, "booking");
		Put put = new Put(Bytes.toBytes("row3"));
		put.add(Bytes.toBytes("passenger_info"), Bytes.toBytes("category"), Bytes.toBytes("vip"));
		bookingTable.put(put);
	}

	@Test
	public void testUpdateBooking() {
	}

}
