package de.bitnoise.example.whiteboard.service;

import java.util.ArrayList;
import java.util.List;

import de.bitnoise.example.whiteboard.api.GreetingProvider;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;

@Component
public class WhiteboardService {

	List<GreetingProvider> greeters = new ArrayList<GreetingProvider>();

	@Reference(multiple = true, dynamic = true) // defaults to unbind="unetGreetingProvider"
	public void setGreetingProvider(GreetingProvider greeter) {
		System.out.println("# detected new greeter : " + greeter);
		greeters.add(greeter);
	}

	public void unsetGreetingProvider(GreetingProvider greeter) {
		System.out.println("# greeter is gone : " + greeter);
		greeters.remove(greeter);
	}
}
