package com.debnath.user.configuration;

import com.debnath.user.dto.UserDto;
import com.debnath.user.mapper.UserMapper;
import com.debnath.user.repository.UserRepository;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //fetching user from DB

       CustomUserDetails userDetails=new CustomUserDetails(userRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("No User found user with this Email...!")));

        return userDetails;
    }
}
