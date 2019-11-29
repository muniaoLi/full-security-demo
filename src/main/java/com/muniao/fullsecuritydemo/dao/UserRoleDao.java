package com.muniao.fullsecuritydemo.dao;

import com.muniao.fullsecuritydemo.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleDao extends JpaRepository<UserRole, Integer>
{
}
