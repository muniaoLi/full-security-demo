package com.muniao.fullsecuritydemo.dao;

import com.muniao.fullsecuritydemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer>
{
    User findUserByUsername(String username);
}
