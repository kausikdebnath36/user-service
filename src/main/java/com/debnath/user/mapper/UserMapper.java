package com.debnath.user.mapper;

import com.debnath.user.dto.UserDto;
import com.debnath.user.entity.User;

public class UserMapper {

    public static UserDto maptoUserDto(User user){

        return new UserDto(
                user.getId(),
                user.getName(),
                user.getStatus(),
                user.getMobileNo(),
                user.getEmail(),
                user.getCountryCode(),
                user.getPassword(),
                user.getRole());
    }
    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getStatus(),
                userDto.getMobileNo(),
                userDto.getEmail(),
                userDto.getCountryCode(),
                userDto.getPassword(),
                userDto.getRole());
    }

}
