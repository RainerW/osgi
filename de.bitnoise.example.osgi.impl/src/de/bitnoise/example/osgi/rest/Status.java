package de.bitnoise.example.osgi.rest;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;


public class Status extends ServerResource {
	@Get("txt")
	public String sayHello() {
		return "ok";
	}
}
