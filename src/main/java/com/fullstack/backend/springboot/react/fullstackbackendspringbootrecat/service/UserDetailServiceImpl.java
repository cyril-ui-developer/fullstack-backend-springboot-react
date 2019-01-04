package com.fullstack.backend.springboot.react.fullstackbackendspringbootrecat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fullstack.backend.springboot.react.fullstackbackendspringbootrecat.domain.User;
import com.fullstack.backend.springboot.react.fullstackbackendspringbootrecat.domain.UserRepository;



@Service
public class UserDetailServiceImpl implements UserDetailsService {
  @Autowired
  private UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    { 
      User currentUser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core
            .userdetails.User(username, currentUser.getPassword()
            , true, true, true, true, 
            AuthorityUtils.createAuthorityList(currentUser.getRole()));
        return user;
    }
    
}