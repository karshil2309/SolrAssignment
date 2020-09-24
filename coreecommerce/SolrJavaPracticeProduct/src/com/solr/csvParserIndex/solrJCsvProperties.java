package com.solr.csvParserIndex;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
 
public class solrJCsvProperties{
    private static final String SEPARATOR = ",";
 
    private static final String SOLR_ID_FIELDNAME = "id";
 
    private Properties _properties = new Properties();
 
    public solrJCsvProperties(String propertyFilename) throws IOException {
        FileReader fileReader = new FileReader(propertyFilename);
 
        _properties.load(fileReader);
    }
 
    public String getSeparator() {
        String result = null;
 
        result = getProperty(SEPARATOR);
 
        return result;
    }
 
    public String getIdFieldName() {
        String result = null;
 
        result = getProperty(SOLR_ID_FIELDNAME);
 
        return result;
    }
 
    private String getProperty(String fieldname) {
        String result = null;
 
        result = _properties.getProperty(fieldname);
        result = result == null ? "" : result;
 
        return result;
    }
}