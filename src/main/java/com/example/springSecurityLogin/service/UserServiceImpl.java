package com.example.springSecurityLogin.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springSecurityLogin.model.Role;
import com.example.springSecurityLogin.model.User;
import com.example.springSecurityLogin.repository.RoleRepository;
import com.example.springSecurityLogin.repository.UserRepository;

/**
 * @author Karen 19 de fev de 2018
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.springSecurityLogin.service.UserService#findUserByEmail(java.
	 * lang.String)
	 */
	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.springSecurityLogin.service.UserService#saveUser(com.example.
	 * springSecurityLogin.model.User)
	 */
	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role userRole = roleRepository.findByRole("ADMIN");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);

	}

}
