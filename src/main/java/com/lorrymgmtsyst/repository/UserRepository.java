package com.lorrymgmtsyst.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lorrymgmtsyst.model.User;

@Repository
@Component
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username);
}
