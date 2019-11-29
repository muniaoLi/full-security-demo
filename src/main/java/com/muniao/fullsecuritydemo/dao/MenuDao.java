package com.muniao.fullsecuritydemo.dao;

import com.muniao.fullsecuritydemo.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuDao extends JpaRepository<Menu,Integer>
{
}
