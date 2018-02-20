package com.example.springSecurityLogin.service;

import com.example.springSecurityLogin.model.User;

/**
 * @author Karen 19 de fev de 2018
 */
public interface UserService {
	public User findUserByEmail(String email);

	public void saveUser(User user);
}
