package com.debnath.user.entity;


import com.debnath.user.util.Role;
import com.debnath.user.util.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@JsonInclude(JsonInclude.Include.USE_DEFAULTS)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Name;

    @Column(name = "status", nullable=false, length = 20, columnDefinition = "varchar(20) default 'ACTIVE'")
    private Status status;

    private  String mobileNo;

    private String email;

    @Column(name = "country_code", nullable=false, length = 20, columnDefinition = "varchar(20) default '+ 91'")
    private String countryCode;

    private  String password;

    @Column(name = "role", nullable=false, length = 20, columnDefinition = "varchar(20) default 'USER'")
    private Role role;

}