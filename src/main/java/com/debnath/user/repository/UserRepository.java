package com.debnath.user.repository;

import com.debnath.user.entity.User;
import com.debnath.user.util.Role;
import com.debnath.user.util.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

 Optional<User>findByEmail(String email);

 Optional<User>findByMobileNo(String mobileno);

 Optional<User>findByCountryCode(String counrtyCode);

 Optional<User>findByRole(Role role);

 Optional<User>findByStatus(Status status);
}
