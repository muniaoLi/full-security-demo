package com.muniao.fullsecuritydemo.service;

import com.muniao.fullsecuritydemo.dao.UserDao;
import com.muniao.fullsecuritydemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@CacheConfig(cacheNames = "user_cache")
public class UserDetailsServiceImpl implements UserDetailsService
{
    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userDao.findUserByUsername(username);
        if(user==null)
            throw new UsernameNotFoundException("账号不存在！");

        return user;
    }

    @Cacheable(key = "#root.methodName")
    public List<User> getAllUser()
    {
        return userDao.findAll();
    }

    @Cacheable(key = "#username")
    public User getUserByName(String username)
    {
        return userDao.findUserByUsername(username);
    }

    @CachePut(key = "#username")
    public User updateUserByName(String username)
    {
        User user = getUserByName(username);
        user.setUsername(user.getUsername()+"new");
        return user;
    }

    @CacheEvict(key = "#username")
    public void deleteUserByName(String username)
    {
        System.out.println("delete "+username);
    }
}
