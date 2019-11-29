package com.muniao.fullsecuritydemo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Menu implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String pattern;

    @ManyToMany(fetch = FetchType.EAGER)   //多对多
    @JoinTable(                    //jointable。维护方加此注释
            name = "menu_role",        //name是表名，
            //joincolumns需要将此entity中的什么字段添加到表的什么字段，name是存储在多对多关系表中的字段名，referencedColumnName为此外键
            joinColumns = {@JoinColumn(name = "mid", referencedColumnName = "id")},
            //inverseJoinColumns,name字段是关系entity Role的id以role_id存储在关系表tyg_user_role中
            inverseJoinColumns = {@JoinColumn(name = "rid", referencedColumnName = "id")})
    private List<Role> roles;

}
