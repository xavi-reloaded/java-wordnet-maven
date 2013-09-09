package com.apiumtech.wordnet;

import com.google.gson.JsonObject;
import net.didion.jwnl.JWNLException;

import java.io.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xavi
 * Date: 9/8/13
 * Time: 9:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class DictionaryExporter {

    public void createTxtDictionaryMode1(String fileWithIndexPath) throws IOException, JWNLException {

        String readline;
        String[] line;
        String key;
        String value;
        List hyponyms;
        List hypernyms;

        int cont=0;

        JWNLWrapper wordnetWrapper = new JWNLWrapper();

        InputStreamReader is = new InputStreamReader(new FileInputStream(new File(fileWithIndexPath)));
        BufferedReader br = new BufferedReader(is);
        while ((readline = br.readLine()) != null) {

            key = readline.trim();
            hyponyms = wordnetWrapper.getHyponymList(key);
            hypernyms = wordnetWrapper.getHypernymList(key);
            value = getJsonSerializedValue(hyponyms, hypernyms);
            System.out.println(cont++ + "\t [" + key + "*" + value + "]");


        }
    }

    private String getJsonSerializedValue(List<String> hyponyms, List<String> hypernyms) {
        JsonObject json = new JsonObject();
        json.addProperty("hypo",hyponyms.toString().replace("_"," "));
        json.addProperty("hype",hypernyms.toString().replace("_"," "));
        return json.toString();
    }
}
