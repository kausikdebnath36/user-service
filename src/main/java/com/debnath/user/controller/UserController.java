package com.debnath.user.controller;

import com.debnath.user.service.UserServiceImpl;
import com.debnath.user.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {




    private UserServiceImpl userService;

    public UserController(final UserServiceImpl userService) {
        this.userService = userService;
    }
        @GetMapping("/all")
        public List<UserDto> getAllUser(){

         return userService.getAllUser();
         }

        @GetMapping
        public UserDto getUser(@RequestParam(name = "email") String email){

            return userService.getUser(email);
        }

        @PostMapping
        public UserDto addUser(@Validated @RequestBody UserDto userDto){

            return userService.addUser(userDto);
        }

    @PutMapping
    public UserDto updateUser(@Validated @RequestBody UserDto userDto){

        return userService.updateUser(userDto);
    }

    @DeleteMapping
    public Boolean deleteUser(@RequestParam (name = "email")String email){
            return userService.deleteUser(email);
    }

    @GetMapping("/validate")
    public String validateUser(@RequestParam (name = "email")String email){

            return userService.validateUser(email);
    }

}
