package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false, length = 45, unique = true)
    private String email;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(nullable = false, length = 20)
    private String firstname;

    @Column(nullable = false, length = 20)
    private String lastname;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> role = new HashSet<>();

    public void addRole(Role role){
        this.role.add(role);
    }
}
