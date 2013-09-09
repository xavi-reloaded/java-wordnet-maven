package com.apiumtech.wordnet;

import com.androidxtrem.commonsHelpers.FileHelper;
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

    private String destPath;

    public DictionaryExporter(String destPath) {
        this.destPath = destPath;
    }

    public void createTxtDictionaryMode1(String fileWithIndexPath) throws IOException, JWNLException {

        String readline;
        String key;
        String value;
        List hyponyms;
        List hypernyms;

        int cont=0;

        JWNLWrapper wordnetWrapper = new JWNLWrapper();

        final File file = new File(fileWithIndexPath);
        final File fileDest = new File(destPath+"/"+file.getName());
        InputStreamReader is = new InputStreamReader(new FileInputStream(file));
        BufferedReader br = new BufferedReader(is);
        while ((readline = br.readLine()) != null) {

            key = readline.trim();
            hyponyms = wordnetWrapper.getHyponymList(key);
            hypernyms = wordnetWrapper.getHypernymList(key);
            value = getJsonSerializedValue(hyponyms, hypernyms);
            StringBuilder builder = new StringBuilder();
            builder.append(key).append("*").append(value).append("\n");
            System.out.println(cont++ + builder.toString());
            FileHelper.stringToFile(builder.toString(),fileDest,true,"UTF-8");
        }
    }

    private String getJsonSerializedValue(List<String> hyponyms, List<String> hypernyms) {
        JsonObject json = new JsonObject();
        json.addProperty("hypo",hyponyms.toString().replace("_"," "));
        json.addProperty("hype",hypernyms.toString().replace("_"," "));
        return json.toString();
    }
}
