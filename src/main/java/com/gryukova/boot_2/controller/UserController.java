package com.gryukova.boot_2.controller;


import com.gryukova.boot_2.model.User;
import com.gryukova.boot_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {

   private UserService userService;

   @Autowired
   public UserController(UserService userService) {
        this.userService = userService;
   }


   //ALL
    @GetMapping("")
    public String getUsers(ModelMap model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("listUsers", users);
        return "users";
    }

   // CREATE
    @GetMapping( "/save")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "save";
    }

    @PostMapping(value = "/create")
    public String createUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    // READ
    @GetMapping(value = "/{id}")
    public String getUser(@PathVariable("id") Long id, ModelMap model){
        User user = userService.getUser(id);
        model.addAttribute("key", user);
        return "profile";
    }

    // UPDATE
    @GetMapping(value = "/edit/{id}")
    public String getForEditUser(@PathVariable("id") Long id, ModelMap model) {
        User user = userService.getUser(id);
        model.addAttribute("editedUser",user);
        return "edit";
    }

    @PostMapping(value = "/edit/{id}")
    public String editUser(@PathVariable("id") Long id, @ModelAttribute("user") User user) {
        User newUser =  userService.getUser(id);
        newUser.setEmail(user.getEmail());
        newUser.setFirstname(user.getFirstname());
        newUser.setLastname(user.getLastname());
        userService.saveUser(newUser);
        return "redirect:/users";
    }

    // DELETE
    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }















}
