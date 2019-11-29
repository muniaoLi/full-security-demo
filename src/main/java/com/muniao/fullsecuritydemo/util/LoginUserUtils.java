package com.muniao.fullsecuritydemo.util;

import com.muniao.fullsecuritydemo.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;


public class LoginUserUtils
{
    public static User getCurrentUser()
    {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
