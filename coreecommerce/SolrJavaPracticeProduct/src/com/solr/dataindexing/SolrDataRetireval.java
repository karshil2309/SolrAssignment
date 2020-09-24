package com.solr.dataindexing;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import com.solr.connector.BuildSolrClient;

public class SolrDataRetireval {

	public static void main(String args[]) throws SolrServerException, IOException {
		SolrClient solrClient=BuildSolrClient.getSolrClient();
		
		SolrQuery solrquery=new SolrQuery("*");
		QueryResponse query=solrClient.query(solrquery);
		SolrDocumentList solrdocumentlist=query.getResults();
		for(SolrDocument documen:solrdocumentlist) {
			
			System.out.println("************************");
			System.out.println(documen.getFieldValue("id"));
			System.out.println(documen.getFieldValue("name"));
			System.out.println(documen.getFieldValue("price"));
			System.out.println(documen.getFieldValue("category"));
			
			
		}
	}
}
