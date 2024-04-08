package com.rosoa0475.stompchat.User.Repository;

import com.rosoa0475.stompchat.User.Domain.LocalUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<LocalUser, Long> {
    public Optional<LocalUser> findByUserName(String username);
}
