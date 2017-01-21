package com.luckyakhi.hdfs;

public interface IFileReader<T> {
	public T readFile(String path);
}
