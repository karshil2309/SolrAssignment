package com.solr.dataindexing;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;

public class solrupdateecommerce {
	// create the SolrJ client
	
	public static void main(String args[]) throws SolrServerException, IOException {
		
		String urlString = "http://localhost:8983/solr/coreecommerce";
		 HttpSolrClient client = new HttpSolrClient.Builder(urlString).build();
	// create the document
	SolrInputDocument sdoc = new SolrInputDocument();
	sdoc.addField("id","1");
	Map<String,Object> fieldModifier = new HashMap<String,Object>(1);
	fieldModifier.put("add","A very good smart Phone");
	sdoc.addField("comments", fieldModifier);  // add the map as the field value
	 
	client.add( sdoc );  // send it to the solr server
	System.out.println("Successfully adddd the document!");
	client.close();  
	}
}
