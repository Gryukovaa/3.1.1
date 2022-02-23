package com.gryukova.boot_2.service;


import com.gryukova.boot_2.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public void saveUser(User user);
    public void deleteUser(Long id);
    public User getUser(Long id);
}
