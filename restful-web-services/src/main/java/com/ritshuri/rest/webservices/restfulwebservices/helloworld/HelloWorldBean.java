package com.ritshuri.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {
	String message;
	public void setMessage(String message) {
		this.message = message;
	}

	public HelloWorldBean(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
}
