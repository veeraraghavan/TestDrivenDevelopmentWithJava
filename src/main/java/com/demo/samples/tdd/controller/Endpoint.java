package com.demo.samples.tdd.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.samples.tdd.responses.Category;
import com.demo.samples.tdd.responses.Product;
import com.demo.samples.tdd.responses.Structure1Root;
import com.demo.samples.tdd.responses.Structure2Root;
import com.demo.samples.tdd.util.MyHttpClient;
import com.demo.samples.tdd.util.Response;

@RestController
@RequestMapping(path = Endpoint.base)
public class Endpoint {
	public static final String base = "/api";
	@Autowired
	MyHttpClient<Structure2Root> client;
	@Autowired
	MyHttpClient<Structure1Root> Cclient;

	@GetMapping(path = "/endpoint1")
	public ResponseEntity<Structure2Root> callEndpt1(@RequestParam String token) {
		Response<Structure2Root> resp = client
				.execute("https://services.odata.org/V2/Northwind/Northwind.svc/Products(1)?$format=json", Structure2Root.class);
		return new ResponseEntity<Structure2Root>(resp.getResponse(), HttpStatus.OK);
	}

	@GetMapping(path = "/endpoint2")
	public ResponseEntity<Structure1Root> callEndpt2(@RequestParam String token) {
		Response<Structure1Root> resp = Cclient.execute(
				"https://services.odata.org/V2/Northwind/Northwind.svc/Categories(1)?$format=json", Structure1Root.class);
		return new ResponseEntity<Structure1Root>(resp.getResponse(),HttpStatus.OK);
	}

}
