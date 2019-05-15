package com.demo.samples.tdd.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class MyHttpClient<O> {
	@Autowired
	RestTemplate client;

	public MyHttpClient() {
		// TODO Auto-generated constructor stub
	}

	public Response<O> execute(String url, Class<O> generic) {
		ResponseEntity<O> resp = client.exchange(url, HttpMethod.GET, null, generic);
		return new Response<O>(resp.getStatusCode(), resp.getBody());
	}

}
