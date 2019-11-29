package com.muniao.fullsecuritydemo.controller;

import com.muniao.fullsecuritydemo.entity.User;
import com.muniao.fullsecuritydemo.service.MenuService;
import com.muniao.fullsecuritydemo.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController
{

    @RequestMapping("/dba/hello")
    public String dbaHello()
    {
        return "hello dba";
    }

    @RequestMapping("/admin/hello")
    public String adminHello()
    {
        return "hello admin";
    }

    @RequestMapping("/user/hello")
    public String userHello()
    {
        return "hello user";
    }

    @RequestMapping("/open/hello")
    public String openHello()
    {
        return "hello open";
    }

    @Autowired
    MenuService menuService;

    @GetMapping("/deleteAllMenuCache")
    public String deleteAllMenuCache()
    {
        menuService.delAllMenuCache();
        return "delete over!";
    }

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @GetMapping("/findAllUser")
    public List<User> findAllUser()
    {
        return userDetailsService.getAllUser();
    }

    @GetMapping("/findUserByName/{username}")
    public User findUserByName(@PathVariable("username") String username)
    {
        return userDetailsService.getUserByName(username);
    }

    @GetMapping("/updateUserByName/{username}")
    public User updateUserByName(@PathVariable("username") String username)
    {
        return userDetailsService.updateUserByName(username);
    }

    @GetMapping("/deleteUserByName/{username}")
    public String deleteUserByName(@PathVariable("username") String username)
    {
        userDetailsService.deleteUserByName(username);
        return "delete over";
    }


}
