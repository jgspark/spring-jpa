package com.example.springjpa.domain.user;

import com.example.springjpa.domain.BaseEntity;
import com.example.springjpa.domain.group.Group;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "APP_USER")
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(name = "email" , nullable = false)
    private String email;

    @Column(name = "password" , nullable = false)
    private String password;

    @Column( name = "name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Group> groups;

    @Builder
    public User(String email, String password, String name , List<Group> groups) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.groups = groups;
    }

}
