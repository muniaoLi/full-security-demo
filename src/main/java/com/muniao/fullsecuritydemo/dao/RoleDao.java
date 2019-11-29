package com.muniao.fullsecuritydemo.dao;

import com.muniao.fullsecuritydemo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Integer>
{
}
