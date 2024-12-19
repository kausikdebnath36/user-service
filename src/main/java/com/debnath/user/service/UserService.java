package com.debnath.user.service;

import com.debnath.user.dto.UserDto;

import java.util.List;

public interface UserService {
    public List<UserDto> getAllUser();

    public UserDto getUser(String email);

    public UserDto addUser(UserDto userDto);

    public UserDto updateUser(UserDto userDto);

    public Boolean deleteUser(String email);

    public String validateUser(String email);
}
