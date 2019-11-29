package com.muniao.fullsecuritydemo.service;

import com.muniao.fullsecuritydemo.dao.MenuDao;
import com.muniao.fullsecuritydemo.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@CacheConfig(cacheNames = "menus_cache")
public class MenuService
{

    @Autowired
    MenuDao menuDao;

    @Cacheable(key = "#root.methodName")
    public List<Menu> findAllMenu(){
        return menuDao.findAll();
    }

    @CacheEvict(allEntries = true)
    public void delAllMenuCache()
    {
        System.out.println("delete all menu cache");
    }

}
