package com.luckyakhi.nlp;

import java.io.FileInputStream;
import java.io.InputStream;

import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;

public class OpenNLPBasedParseTreeGenerator {

	public static void main(String[] args) throws Exception {
		String testDirectory = System.getProperty("user.dir");
		InputStream modelIn = new FileInputStream(testDirectory+"/target/classes/model/en-parser-chunking.bin");
		ParserModel model = new ParserModel(modelIn);
		Parser parser = ParserFactory.create(model);
		String sentence = "Cusip should not be empty";
		Parse topParses[] = ParserTool.parseLine(sentence, parser, 1);
		topParses[0].show();
		
	}
}