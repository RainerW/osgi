package de.bitnoise.example.osgi.repo;

import java.util.ArrayList;
import java.util.List;

import de.bitnoise.example.osgi.api.auth.AuthData;
import de.bitnoise.example.osgi.api.model.User;
import de.bitnoise.example.osgi.api.repo.UserRepository;
import aQute.bnd.annotation.component.*;

@Component
public class UserRepositoryImpl implements UserRepository {

	List<User> _data = new ArrayList<User>();
	@Override
	public List<User> getUserList(AuthData authentication) {
		return _data;
	}

	@Override
	public void createUser(String username) {
		System.out.println("### creating : " + username);
		_data.add(new UserImpl(username));
	}

}