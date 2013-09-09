package com.apiumtech.wordnet;

import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: xavi
 * Date: 9/8/13
 * Time: 9:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class DictionaryExporterTest {

    @Test
    public void test_Name() throws Exception {
        String destPath = "/media/halfer/sources_apocrifos_dix/apocryphs";
        DictionaryExporter dictionaryExporter = new DictionaryExporter(destPath);
        String path = DictionaryExporterTest.class.getResource("/wordIndex.txt").getPath();
        dictionaryExporter.createTxtDictionaryMode1(path);



    }
}
