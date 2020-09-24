package com.solr.connector;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

public class BuildSolrClient {
	

	static String solrurl="http://localhost:8983/solr/coreecommerce";

	public static SolrClient getSolrClient() {
		
		return new HttpSolrClient.Builder(solrurl)
				.withConnectionTimeout(1999)
				.withSocketTimeout(1000)
				.build();
}


}
