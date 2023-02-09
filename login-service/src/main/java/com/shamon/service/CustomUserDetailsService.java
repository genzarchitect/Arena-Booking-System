package com.shamon.service;

import com.shamon.model.User;
import com.shamon.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).get();
        if (user != null) {
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUseremail())
                    .password(user.getPassword())
                    .roles(user.getName().toString())
                    .build();
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}