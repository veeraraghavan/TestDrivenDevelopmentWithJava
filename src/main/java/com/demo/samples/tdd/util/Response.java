package com.demo.samples.tdd.util;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;

public class Response<T> {
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
	HttpStatus status;
	T response;
	public Response(HttpStatus status,T o) {
		this.status = status;
		this.response = o;
	}

}
