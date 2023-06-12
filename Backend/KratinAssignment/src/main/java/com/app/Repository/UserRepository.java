package com.app.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.app.pojos.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmailAndPassword(String email,String password);

	Optional<User> findByEmail(String email);

}
