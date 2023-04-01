package com.srjons.templatejpa.security;

import com.srjons.templatejpa.entity.User;
import com.srjons.templatejpa.repo.UserRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class AuthUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            log.error("User not found: " + username);
            throw new UsernameNotFoundException("User not found: " + username);
        } else {
            log.info("user found: " + user);
        }
        return new AuthUserDetails(user);
    }
}
