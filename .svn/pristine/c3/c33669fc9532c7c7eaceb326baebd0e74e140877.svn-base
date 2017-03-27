package com.dm.httpSender;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import com.zc.httpSender.RequestAndHandler;
import com.zc.httpSender.ResponseHandlers;

public class GetRequestUtil implements RequestAndHandler<String>{

	private String url;
	private Map<String, String> headers;
	public GetRequestUtil(String url, Map<String, String> headers){
		this.url = url;
		this.headers = headers;
	}
	@Override
	public HttpUriRequest getRequest() {
		HttpGet get = new HttpGet(url);
		if (headers != null) {
			Set<String> keys = headers.keySet();
			for (Iterator<String> i = keys.iterator(); i.hasNext();) {
				String key = (String) i.next();
				get.addHeader(key, headers.get(key));
			}
		}
		return get;
	}

	@Override
	public ResponseHandler<String> getResponseHandler() {
		return ResponseHandlers.getStringResponseHandler();
	}

}
