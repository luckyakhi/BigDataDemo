package com.luckyakhi.hbase;

import org.apache.hadoop.conf.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HbaseBookingDAOImpl implements BookingsDAO {

	@Autowired
	private Configuration configuration;
	
	@Override
	public void createBooking() {
		
		
	}

	@Override
	public void updateBooking() {
		// TODO Auto-generated method stub
		
	}

}
