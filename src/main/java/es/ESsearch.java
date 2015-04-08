package es;



import org.apache.log4j.Logger;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.json.JSONArray;

public class ESsearch {

	protected  Logger logger = Logger.getLogger(this.getClass());
	
	public static void main(String[] args) {

//		   Logger logg=Logger.getLogger("com.es.ESsearch");
//		Settings settings = ImmutableSettings.settingsBuilder()
//        .put("client.transport.ignore_cluster_name",true).build();
		
		Client client = new TransportClient()
				.addTransportAddresses(new InetSocketTransportAddress(
						"127.0.0.1", 9300));
		long time = System.currentTimeMillis();
		try{
			
			//插入
//			IndexRequestBuilder insert = client.prepareIndex("grade", "class", "2");
//			insert.setSource(XContentFactory.jsonBuilder()
//						.startObject()
//							.field("name","reyun")
//							.field("age","12")
//							.field("height","180")
//						.endObject());
//			insert.execute().actionGet();
			//批量插入
			
			System.out.println(time);
			BulkRequestBuilder bulk = new BulkRequestBuilder(client);
			for( int i =0 ; i < 100; i++ ){
				IndexRequestBuilder insert = client.prepareIndex("qqq","re");
				insert.setSource(XContentFactory.jsonBuilder()
						.startObject()
							.field("name","{\""+i+"\":\"热云"+i+"\"}")
							.field("age",""+(int)(1000*Math.random())%20)
							.field("height", (int)(1000*Math.random()))
							.field("sale",((int)(10000*Math.random())))
						.endObject());
				bulk.add(insert);
			}
			BulkResponse actionGet = bulk.execute().actionGet();
			System.out.println(actionGet.hasFailures()+"    "+(System.currentTimeMillis()-time));
			//更新
//			UpdateRequest updateRequest = new UpdateRequest("grade","class","2")
//				.doc(XContentFactory.jsonBuilder()
//						.startObject()
//							.field("width","24")
//						.endObject());
//			 client.update(updateRequest).actionGet();
					
			//查询
//			SearchResponse actionGet = client.prepareSearch("grade")
//				.setTypes("class")
////				.setQuery(QueryBuilders.termQuery("empname", "emp4"))		//Query
//				.execute()
//				.actionGet();
//			SearchHits hits = actionGet.getHits();
//			for (SearchHit hit : hits.getHits()) {
//				System.out.println(hit.getSource());
//				JSONObject j = JSONObject.fromObject(hit.getSource());
//				System.out.println("height:"+j.getString("height"));
//				System.out.println("age:"+j.getString("age"));
//				JSONObject json = JSONObject.fromObject(j.getString("name"));
//				System.out.println("name:{"+j.getString("age")+":"+json.getString(j.getString("age"))+"}");
//			}
//			System.out.println(actionGet);
			//删除
//			DeleteResponse response = client.prepareDelete("dept","employee","3")
//							.setOperationThreaded(false)
//							.execute()
//							.actionGet();
		}catch(Exception e){
			System.out.println("Exception");
		}

	}

}
