package com.solr.dataindexing;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.common.SolrInputDocument;

import com.solr.connector.BuildSolrClient;

public class SolrAddINdex {

	public static void main(String args[]) throws SolrServerException, IOException {
//	String urlString = "http://localhost:8983/solr/core";
//	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
	
	SolrClient solr=BuildSolrClient.getSolrClient();
	
	
	((HttpSolrClient) solr).setParser(new XMLResponseParser());
	
		

	SolrInputDocument document = new SolrInputDocument();
	document.addField("id", "111");
	document.addField("name", "Laptop");
	document.addField("description", "A gaming laptop with 16 gb ram");
	document.addField("price", "5000");

	solr.add(document);
	solr.commit();
	
	System.out.println("Successfully adddd the document!");
	
  }
}
