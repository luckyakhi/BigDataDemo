package com.luckyakhi.lucene;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.spell.Dictionary;
import org.apache.lucene.search.spell.PlainTextDictionary;
import org.apache.lucene.search.spell.SpellChecker;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.springframework.core.io.ClassPathResource;

public class LuceneBasedWordSuggestor implements WordSuggestor{

	private SpellChecker spellChecker;

	@Override
	public String[] getSuggestedWords(String input) throws Exception {
		return spellChecker.suggestSimilar(input, 10, 0.2F);
	}
	
	public LuceneBasedWordSuggestor() throws IOException{
		Analyzer analyzer = new EnglishAnalyzer();
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
		Directory spellIndex  = new RAMDirectory();
		spellChecker = new SpellChecker(spellIndex);
		Dictionary dict = new PlainTextDictionary(new FileInputStream(new ClassPathResource("dictionary.txt").getFile()));
		spellChecker.indexDictionary(dict, indexWriterConfig, true);
	}

}
