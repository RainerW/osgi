package de.bitnoise.example.osgi.repo;

import de.bitnoise.example.osgi.api.model.User;

public class UserImpl implements User {
	private String _name;

	public UserImpl(String name) {
		_name = name;
	}

	@Override
	public String toString() {
		return _name;
	}
}
