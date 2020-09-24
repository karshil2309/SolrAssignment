package com.solr.csvParserIndex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
 

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
 
public class SolrjCsv {
    private Reader             _reader;
    private solrJCsvProperties _properties;
 
    public static void main(String args[]) throws Exception {
      

 
        SolrjCsv app = new SolrjCsv();
 		
		
 
        // open the file with the content
        String filename = "src/ecom.txt";
        FileReader reader = new FileReader(filename);
 

        app.setReader(reader);
 
        app.parseFile();
    }
 
    public void setReader(FileReader reader) {
        _reader = reader;
    }
 
 
 
    private void parseFile() throws Exception {
    	String urlString = "http://localhost:8983/solr/new_core";
		HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
        BufferedReader bufReader = new BufferedReader(_reader);
 
      
        String line = bufReader.readLine();
      
        String[] fieldNames = line.split(",");
 
   
        int idIdx = getIdFieldIndex(fieldNames,"id");
      
 
        while ((line = bufReader.readLine()) != null) {
 
            // parse a line
            Map<String, String> map = parseLine(idIdx, fieldNames, line);
 
            // create the document
            SolrInputDocument doc = new SolrInputDocument();
            doc.addField("id", map.get("id"));
            for (String fieldName : fieldNames) {
            	doc.addField(fieldName, map.get(fieldName));
                
            }
 
            // store the docs in an ArrayList
            Collection<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
            docs.add(doc);
            System.out.print(doc);
            solr.add(docs);
 
        }
 
        bufReader.close();
    }
 
    private int getIdFieldIndex(String[] fieldNames, String idFieldName) {
        int result = -1;
 
        for (int i = 0; i < fieldNames.length; i++) {
            if (fieldNames[i].equals(idFieldName)) {
                result = i;
                break;
            }
        }
 
        return result;
    }
 
    private Map<String, String> parseLine(int idIdx, String[] fieldNames, String line) {
        Map<String, String> map = new HashMap<String, String>();
 
        String[] cols = line.split(",");
 
        map.put("id", cols[idIdx]);
        for (int i = 0; i < cols.length; i++) {
            map.put(fieldNames[i], cols[i]);
        }
 
        return map;
    }
 
}

