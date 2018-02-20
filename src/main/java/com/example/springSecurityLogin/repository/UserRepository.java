package com.example.springSecurityLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springSecurityLogin.model.User;

/**
 * @author Karen 19 de fev de 2018
 */

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
