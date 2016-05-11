package br.com.evoline.api.http;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.evoline.api.model.Authorization;


public class BaseHttpBuilder implements BaseHttp {
	
	private final Gson gson  = new GsonBuilder().create();
	private String URL       = "http://api.evoline.com.br";
	
	/**
	 * HTTP Call
	 * Method GET
	 * @param authorization
	 * @param endpoint
	 * @return
	 */
	public String call(Authorization authorization, String endpoint) {
		return this.call(authorization, endpoint, null);
	}
	
	/**
	 * HTTP Call
	 * IF param != null -> Method == POST
	 * IF param == null -> Method == GET
	 * @param authorization
	 * @param endpoint
	 * @param param
	 * @return
	 */
	public String call(Authorization authorization, String endpoint, Object param) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String content = null;
		CloseableHttpResponse response;
		try {
			HttpRequestBase http;
			if(param == null) {
				http = new HttpGet(URL + endpoint);
			} else {
				http = new HttpPost(URL + endpoint);
				http.addHeader("Content-Type", "application/json;charset=UTF-8");
				
				StringEntity input = new StringEntity(gson.toJson(param), Charset.forName("UTF-8"));
				input.setContentType("application/json;charset=UTF-8");
				input.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8"));
				((HttpPost) http).setEntity(input);
			}
			
			http.addHeader("Access-Token", authorization.getToken());
			response = httpclient.execute(http);
			HttpEntity entity = response.getEntity();
			content = HttpUtil.read(entity.getContent());
			EntityUtils.consume(entity);			
			
			response.close();
			httpclient.close();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

}
