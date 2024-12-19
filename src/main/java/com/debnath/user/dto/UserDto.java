package com.debnath.user.dto;

import com.debnath.user.util.Role;
import com.debnath.user.util.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private Long id;

    private String Name;

    private Status status;

    private  String mobileNo;

    private String email;

    private String countryCode;

    private  String password;

    private Role role;
}
