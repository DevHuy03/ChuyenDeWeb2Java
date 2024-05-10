package com.macquochuy.exercise02.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.macquochuy.exercise02.Entity.User;
import com.macquochuy.exercise02.Repository.UserRepository;
import com.macquochuy.exercise02.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        user.setCreated_at(new Date());
        user.setUpdated_at(new Date());
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        Optional<User> optionalExistingUser = userRepository.findById(user.getUser_id());

        if (optionalExistingUser.isPresent()) {
            User existingUser = optionalExistingUser.get();
            existingUser.setFirst_name(user.getFirst_name());
            existingUser.setLast_name(user.getLast_name());
            existingUser.setImage_url(user.getImage_url());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhone(user.getPhone());
            existingUser.setCarts(user.getCarts());
            existingUser.setAddresses(user.getAddresses());
            existingUser.setCredentials(user.getCredentials());
            existingUser.setLikes(user.getLikes());
            existingUser.setUpdated_at(new Date());

            return userRepository.save(existingUser);
        } else {
            // Trả về null nếu người dùng không tồn tại
            return null;
        }
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
