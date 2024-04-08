package com.rosoa0475.stompchat.User.Service;

import com.rosoa0475.stompchat.User.Domain.LocalUser;
import com.rosoa0475.stompchat.User.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LocalUser saveUser(String userName, String password){
        LocalUser u = new LocalUser();
        u.setUserName(userName);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        u.setPassword(passwordEncoder.encode(password));
        u.setCreatedAt(LocalDate.now());
        this.userRepository.save(u);
        return u;
    }
}
