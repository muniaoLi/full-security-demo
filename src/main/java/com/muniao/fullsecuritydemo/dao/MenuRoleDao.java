package com.muniao.fullsecuritydemo.dao;

import com.muniao.fullsecuritydemo.entity.MenuRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRoleDao extends JpaRepository<MenuRole, Integer>
{
}
