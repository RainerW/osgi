package de.bitnoise.example.osgi.api.repo;

import java.util.List;

import de.bitnoise.example.osgi.api.auth.AuthData;
import de.bitnoise.example.osgi.api.model.User;

public interface UserRepository {
	List<User> getUserList(AuthData authentication);

	void createUser(String username);
}
