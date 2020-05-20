package com.lorrymgmtsyst.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lorrymgmtsyst.model.User;
import com.lorrymgmtsyst.model.UserPrinciple;
import com.lorrymgmtsyst.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUsername(username);
		if(user == null) 
			throw new UsernameNotFoundException("User doesn't exists");
			
		return new UserPrinciple(user);
		
	}
	
	public User registerUser(User user) {
		if(repo.findByUsername(user.getUsername()) == null) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encryptedPassword = encoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		return repo.save(user);
		}
		return null;
	}
	
	public User updateUser(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encryptedPassword = encoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		return repo.save(user);
	}
	
}
