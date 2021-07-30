package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "roles")
public class Role extends BaseEntity {
    @Column(nullable = false, length = 45, unique = true)
    private String name;
}
