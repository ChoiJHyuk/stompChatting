package com.rosoa0475.stompchat.User.Service;

import com.rosoa0475.stompchat.User.Domain.LocalUser;
import com.rosoa0475.stompchat.User.Domain.UserRole;
import com.rosoa0475.stompchat.User.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<LocalUser> ou = userRepository.findByUserName(username);
        if(ou.isEmpty()){
            throw new UsernameNotFoundException("가입하지 않은 사용자입니다.");
        }
        LocalUser user = ou.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        if ("admin".equals(username)) {
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getCode()));
        } else {
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getCode()));
        }
        return new User(user.getUserName(), user.getPassword(), authorities);
    }
}
