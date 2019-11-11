package com.example.crudexample.usersrepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.crudexample.model.User;

@Service
public class UserDetailsService  implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user=repo.findByUsername(username);
		return new UserPrincipal(user);
	}

	}


