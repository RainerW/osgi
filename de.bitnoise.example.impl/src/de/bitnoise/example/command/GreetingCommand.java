package de.bitnoise.example.command;

import java.io.PrintStream;
import java.util.StringTokenizer;

import org.apache.felix.shell.Command;

import de.bitnoise.example.api.Greeting;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;

@Component
public class GreetingCommand implements Command {
	private Greeting grettingSvc;

	@Reference
	public void setGreeting(Greeting svc) {
		grettingSvc = svc;
	}
	
	public void execute(String line, PrintStream out, PrintStream err) {
		StringTokenizer tokenizer = new StringTokenizer(line);
		tokenizer.nextToken(); // discard first token

		String name = "";
		if (tokenizer.hasMoreTokens())
			name = tokenizer.nextToken();

		System.out.println(grettingSvc.sayHello(name));
	}
	public String getName() {
		return "greet";
	}
	public String getShortDescription() {
		return "Example command";
	}
	public String getUsage() {
		return "greet <name>";
	}
}
