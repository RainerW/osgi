package de.bitnoise.example.osgi.cmd;

import java.io.PrintStream;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.felix.shell.Command;
import org.osgi.service.component.ComponentContext;

import de.bitnoise.example.osgi.api.model.User;
import de.bitnoise.example.osgi.api.repo.UserRepository;

import aQute.bnd.annotation.component.*;

@Component
public class RepositoryCommand implements Command {
	private UserRepository grettingSvc;

	@Reference
	public void setGreeting(UserRepository svc) {
		grettingSvc = svc;
	}
	
	@Activate
	public void activate(ComponentContext x) {
		System.out.println("activated " + x);
	}
	
	@Deactivate
	public void shutdown() {
		System.out.println("down ...");
	}

	public void execute(String line, PrintStream out, PrintStream err) {
		StringTokenizer tokenizer = new StringTokenizer(line);
		tokenizer.nextToken(); // discard first token

		String action = "list";
		if (tokenizer.hasMoreTokens()) {
			action = tokenizer.nextToken();
		}
		if (action.equalsIgnoreCase("create")) {
			addUser(tokenizer);
		} else {
			listUsers();
		}
	}

	private void addUser(StringTokenizer tokenizer) {
		String name = tokenizer.nextToken();
		grettingSvc.createUser(name);
	}

	private void listUsers() {
		List<User> all = grettingSvc.getUserList(null);
		for (User user : all) {
			System.out.println(user);
		}
	}

	public String getName() {
		return "repo";
	}

	public String getShortDescription() {
		return "Example command";
	}

	public String getUsage() {
		return "greet <name>";
	}
}
