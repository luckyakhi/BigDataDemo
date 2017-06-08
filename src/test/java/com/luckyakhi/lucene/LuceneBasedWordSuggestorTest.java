package com.luckyakhi.lucene;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LuceneBasedWordSuggestorTest {
	
	private WordSuggestor wordSuggestor;

	@Before
	public void setUp() throws Exception {
		wordSuggestor = new LuceneBasedWordSuggestor();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetSuggestedWords() throws Exception {
		String[] suggestions=wordSuggestor.getSuggestedWords("amor");
		for (String word : suggestions) {
			System.out.println(word);
		}
		
	}

}
