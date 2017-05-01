package com.luckyakhi.autocomplete;
import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.miscellaneous.PerFieldAnalyzerWrapper;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.search.spell.Dictionary;
import org.apache.lucene.search.spell.LuceneDictionary;
import org.apache.lucene.search.spell.PlainTextDictionary;
import org.apache.lucene.search.spell.SpellChecker;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.IOContext;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;


/**
 * 
 * 
 * @author <a href="mailto:liu.gang@renren-inc.com"></a>
 * @version 2013-11-25上午11:13:59
 */
public class LuceneSpellCheckerDemoService {

private static final String INDEX_FILE = System.getProperty("user.dir")+"/target/classes/dictionary_new.txt";
private static final String INDEX_FILE_SPELL = System.getProperty("user.dir")+"/target/classes/dictionary.txt";

private static final String INDEX_FIELD = "app_name_quanpin";

public static void main(String args[]) {

    try {
        //
        PerFieldAnalyzerWrapper wrapper = new PerFieldAnalyzerWrapper(new EnglishAnalyzer());

        //  read index conf
        IndexWriterConfig conf = new IndexWriterConfig(wrapper);
        conf.setOpenMode(OpenMode.CREATE_OR_APPEND);

        // read dictionary
        Directory directory = FSDirectory.open(new File(INDEX_FILE).toPath());
        RAMDirectory ramDir = new RAMDirectory((FSDirectory) directory, IOContext.READ);
        DirectoryReader indexReader = DirectoryReader.open(ramDir);

        Dictionary dic = new LuceneDictionary(indexReader, INDEX_FIELD);


        SpellChecker sc = new SpellChecker(FSDirectory.open(new File(INDEX_FILE_SPELL).toPath()));
        //sc.indexDictionary(new PlainTextDictionary(new File("myfile.txt")), conf, false);
        sc.indexDictionary(dic, conf, true);
        String[] strs = sc.suggestSimilar("fuck", 10);
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        sc.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}


}