package com.debnath.user.util;
//
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//
//
//import java.security.Permission;
//import java.util.Set;
//import java.util.stream.Collectors;

public enum Role {
    USER(),

    ADMIN(),

    SUPERUSER();

//    private Set<Permission> permissions;
//
//    Role(Set<Permission> permissions) {
//        this.permissions = permissions;
//    }
//    public Set<Permission> getPermissions() {
//        return permissions;
//    }
//
//    public Set<SimpleGrantedAuthority> getAuthorities(){
//        return getPermissions().stream().map(permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());
//    }

}
