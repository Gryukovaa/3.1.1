package com.gryukova.boot_2.service;

import com.gryukova.boot_2.dao.UserRepository;
import com.gryukova.boot_2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

   // _______

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

   /* @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }*/

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUser(Long id) {
        User user = null;
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            user = optionalUser.get();
        }
        return user;
    }
}
