package de.bitnoise.example;

import de.bitnoise.example.api.Greeting;
import aQute.bnd.annotation.component.*;

@Component
public class ExampleComponent implements Greeting {

	@Override
	public String sayHello(String name) {
		System.out.println("############ sying hello");
		return "rw";
	}


}