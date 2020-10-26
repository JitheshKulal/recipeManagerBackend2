package com.api.recipeManager.service;


import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.recipeManager.model.Users;
import com.api.recipeManager.repository.UserRepository;

import lombok.AllArgsConstructor;
import static java.util.Collections.singletonList;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Users> optionalUser = userRepository.findByUsername(username);
		Users user = optionalUser.orElseThrow(() -> new UsernameNotFoundException("No User present with username "+username));
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),user.isActive()
				,true,true,true,getAuthority("USER"));
	}
	
	private Collection< ? extends GrantedAuthority> getAuthority(String role){
		return singletonList(new SimpleGrantedAuthority(role));
	}
}
