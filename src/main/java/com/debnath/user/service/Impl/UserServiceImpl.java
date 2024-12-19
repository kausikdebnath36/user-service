package com.debnath.user.service.Impl;

import com.debnath.user.dto.UserDto;
import com.debnath.user.entity.User;
import com.debnath.user.mapper.UserMapper;
import com.debnath.user.repository.UserRepository;
import com.debnath.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.rmi.server.LogStream.log;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> user=userRepository.findAll();
        return user.stream().map(list-> UserMapper.maptoUserDto(list)).collect(Collectors.toList());
    }

    @Override
    public UserDto getUser(String email) {
        User user=userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("No user Found"));
        return UserMapper.maptoUserDto(user);
    }

    @Override
    public UserDto addUser(UserDto userDto) {
       if(isUserPresent(userDto)){
           throw new RuntimeException("User with this email already exists");
       }
       User user=UserMapper.mapToUser(userDto);
       User saved=userRepository.save(user);
       log("User Created");
       return UserMapper.maptoUserDto(saved);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user=userRepository.findByEmail(userDto.getEmail()).orElseThrow(()->new RuntimeException("user Does not exist"));
        user.setCountryCode(userDto.getCountryCode());
        user.setName(userDto.getName());
        user.setMobileNo(userDto.getMobileNo());
        user.setPassword(userDto.getPassword());
        User saved=userRepository.save(user);
        log("User Updated");
        return UserMapper.maptoUserDto(saved);
    }

    @Override
    public Boolean deleteUser(String email) {
        User user=userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("User doesn't exists..!"));
        userRepository.delete(user);
        if(userRepository.findByEmail(email)!=null){
            log("User not deleted");
            return false;
        }
        log("User Deleted");
        return true;
    }

    @Override
    public String validateUser(String email) {
        User user=userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("User doesn't exists..!"));
        if(user.getStatus().equals("ACTIVE"))
            return "ACTIVE";
        if(user.getStatus().equals("BANNED"))
            return "NON-ACTIVE";
        if (user.getStatus().equals("DORMANT"))
            return "NON-ACTIVE";
        return "NON-ACTIVE";
    }

    private Boolean isUserPresent(UserDto userDto){
        List<UserDto>userlist=getAllUser();
        for(UserDto obj:userlist){
           if(userDto.getEmail().equals(obj.getEmail())){
               return true;
            }
        }
       return false;
    }
}
