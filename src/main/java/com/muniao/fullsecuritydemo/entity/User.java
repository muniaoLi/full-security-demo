package com.muniao.fullsecuritydemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
public class User implements UserDetails , Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private Boolean enabled;
    @JsonIgnore
    private Boolean locked;

    @ManyToMany(fetch = FetchType.EAGER)   //多对多
    @JoinTable(                    //jointable。维护方加此注释
            name = "user_role",        //name是表名，
            //joincolumns需要将此entity中的什么字段添加到表的什么字段，name是存储在多对多关系表中的字段名，referencedColumnName为此外键
            joinColumns = {@JoinColumn(name = "uid", referencedColumnName = "id")},
            //inverseJoinColumns,name字段是关系entity Role的id以role_id存储在关系表tyg_user_role中
            inverseJoinColumns = {@JoinColumn(name = "rid", referencedColumnName = "id")})
    private List<Role> roles;

    @ManyToOne
    @JoinColumn(name = "nation_id", foreignKey = @ForeignKey(name = "id"))
    private Nation nation;

    @JsonIgnore
    //该登录用的角色
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(Role role : roles)
            authorities.add(new SimpleGrantedAuthority(role.getName()));

        return authorities;
    }

    @JsonIgnore
    //当前账号是否未过期
    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @JsonIgnore
    //当前账号是否未锁定
    @Override
    public boolean isAccountNonLocked()
    {
        return !locked;
    }

    @JsonIgnore
    //当前密码是否未过期
    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @JsonIgnore
    //当前账号是否可用
    @Override
    public boolean isEnabled()
    {
        return enabled;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }
}
