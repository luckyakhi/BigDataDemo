package com.luckyakhi.nlp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OpenNLPModelBasedTokenizer implements Tokenizer {

	private String openNLPDirectory;

	@Override
	public List<String> tokenize(String input) {
		try(InputStream tokenizerModelStream = new FileInputStream(openNLPDirectory+"/en-token.bin")){
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
		}
		return null;
	}

}
