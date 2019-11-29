package com.muniao.fullsecuritydemo;

import com.muniao.fullsecuritydemo.dao.MenuDao;
import com.muniao.fullsecuritydemo.dao.MenuRoleDao;
import com.muniao.fullsecuritydemo.dao.RoleDao;
import com.muniao.fullsecuritydemo.dao.UserDao;
import com.muniao.fullsecuritydemo.dao.UserRoleDao;
import com.muniao.fullsecuritydemo.entity.Menu;
import com.muniao.fullsecuritydemo.entity.MenuRole;
import com.muniao.fullsecuritydemo.entity.Role;
import com.muniao.fullsecuritydemo.entity.User;
import com.muniao.fullsecuritydemo.entity.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
public class UserDaoTest
{
    @Autowired
    UserDao userDao;

    @Test
    public void test1()
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode("123");

        User u = new User();
        u.setUsername("lisi");
        u.setPassword(password);
        u.setEnabled(true);
        u.setLocked(false);

        u = userDao.save(u);
        System.out.println(u);
    }

    @Test
    @Transactional
    public void test5()
    {
        User u = userDao.getOne(2);
        System.out.println(u.getUsername());
        System.out.println(u.getRoles());
        Role r = u.getRoles().get(0);
        System.out.println(r.getName());
        System.out.println("");
    }

    @Test
    @Transactional
    public void test6()
    {
        User u = userDao.findUserByUsername("lixp");
        System.out.println(u);
    }

    @Autowired
    RoleDao roleDao;
    @Test
    public void test2()
    {
        Role r = new Role();
        r.setName("user");
        r.setNameZh("普通用户");
        roleDao.save(r);
        System.out.println(r);
    }

    @Autowired
    UserRoleDao urDao;
    @Test
    public void test3()
    {
        UserRole ur1 = new UserRole();
        ur1.setUid(2);
        ur1.setRid(1);
        urDao.save(ur1);

        UserRole ur2 = new UserRole();
        ur2.setUid(3);
        ur2.setRid(2);
        urDao.save(ur2);

        UserRole ur3 = new UserRole();
        ur3.setUid(4);
        ur3.setRid(3);
        urDao.save(ur3);
    }

    @Autowired
    MenuDao menuDao;
    @Test
    public void insertMenu()
    {
        Menu m1 = new Menu();
        m1.setPattern("/dba/**");
        menuDao.save(m1);
         Menu m2 = new Menu();
        m2.setPattern("/admin/**");
        menuDao.save(m2);
        Menu m3 = new Menu();
        m3.setPattern("/user/**");
        menuDao.save(m3);


    }

    @Autowired
    MenuRoleDao menuRoleDao;
    @Test
    public void insertMenuRole()
    {
        MenuRole m1 = new MenuRole();
        m1.setMid(1);
        m1.setRid(1);
        menuRoleDao.save(m1);

        MenuRole m2 = new MenuRole();
        m2.setMid(2);
        m2.setRid(2);
        menuRoleDao.save(m2);

        MenuRole m3 = new MenuRole();
        m3.setMid(3);
        m3.setRid(3);
        menuRoleDao.save(m3);
    }

    @Test
    public void selectAllMenu()
    {
        List<Menu> allMenu = menuDao.findAll();
        System.out.println(allMenu);
    }
}
