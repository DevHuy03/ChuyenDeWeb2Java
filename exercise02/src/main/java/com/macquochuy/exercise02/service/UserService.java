package com.macquochuy.exercise02.service;

import java.util.List;

import com.macquochuy.exercise02.Entity.User;

public interface UserService {
    User createUser(User user);
    User getUserById(Long userId);
    List<User> getAllUsers();
    User updateUser(User user);
    void deleteUser(Long userId);
}
