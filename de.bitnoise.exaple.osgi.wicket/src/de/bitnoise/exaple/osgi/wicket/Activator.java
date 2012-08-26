package de.bitnoise.exaple.osgi.wicket;

import org.ops4j.pax.wicket.util.DefaultWebApplicationFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private DefaultWebApplicationFactory applicationFactory;

	public void start(BundleContext context) throws Exception {
		applicationFactory = new DefaultWebApplicationFactory(context,
				WicketApplication.class, "plain.simple", "plain/simple");
		applicationFactory.register();
	}

	public void stop(BundleContext context) throws Exception {
		applicationFactory.dispose();
	}

}