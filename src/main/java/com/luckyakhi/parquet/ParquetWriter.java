package com.luckyakhi.parquet;

import java.io.IOException;
import java.util.List;

import org.apache.avro.generic.GenericData.Record;
import org.apache.avro.generic.GenericRecordBuilder;
import org.kitesdk.data.Dataset;
import org.kitesdk.data.DatasetDescriptor;
import org.kitesdk.data.DatasetWriter;
import org.kitesdk.data.Datasets;
import org.kitesdk.data.Formats;

public class ParquetWriter {
	public void writeToStore(String storeLocation,List<String[]> lines){
		try {
			DatasetDescriptor parquetDataSetDescriptor = new DatasetDescriptor.Builder().schemaUri("resource:user.avsc").format(Formats.PARQUET).build();
			Dataset<Record> userDataSet = Datasets.create(storeLocation, parquetDataSetDescriptor, Record.class);
			DatasetWriter<Record> userDataSetWriter = userDataSet.newWriter();
			GenericRecordBuilder userRecordBuilder = new GenericRecordBuilder(parquetDataSetDescriptor.getSchema());
			Record record = userRecordBuilder.set("username","luckyakhi").set("creationDate", System.currentTimeMillis()).set("favoriteColor", "RED").build();
			userDataSetWriter.write(record);
			userDataSetWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
