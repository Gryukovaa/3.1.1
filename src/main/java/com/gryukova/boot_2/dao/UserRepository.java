package com.gryukova.boot_2.dao;


import com.gryukova.boot_2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
