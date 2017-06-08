package com.luckyakhi.lucene;

public interface WordSuggestor {
	public String[] getSuggestedWords(String input) throws Exception;
}
