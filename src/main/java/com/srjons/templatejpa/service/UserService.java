package com.srjons.templatejpa.service;

import com.srjons.templatejpa.entity.User;
import com.srjons.templatejpa.repo.UserRepo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Resource
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public User findUserById(int userId) {
        return userRepo.findById(userId).get();
    }

    public boolean deleteById(int userId) {
        try {
            userRepo.deleteById(userId);
            return true;
        } catch (Exception e) {
            log.error("error=" + e.getMessage());
            return false;
        }
    }

    public List<User> findAllUsers() {
        return userRepo.findAll();
    }
}
