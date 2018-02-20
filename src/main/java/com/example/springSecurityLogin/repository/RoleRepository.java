package com.example.springSecurityLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springSecurityLogin.model.Role;

/**
 * @author Karen 19 de fev de 2018
 */

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}
