package de.bitnoise.example.osgi.rest;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class Test12 extends Application {

	public Restlet createInboundRoot() {
		// Create a router
		final Router router = new Router(getContext());

		// Attach the resources to the router
		router.attach("/status", Status.class);

		// Return the root router
		return router;
	}
}
