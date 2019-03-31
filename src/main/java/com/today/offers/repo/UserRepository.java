package com.today.offers.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.today.offers.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUserNameAndPassword(String userName,String password);

}
