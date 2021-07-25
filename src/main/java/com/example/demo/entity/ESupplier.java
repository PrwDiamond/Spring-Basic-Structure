package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "supplier")
public class ESupplier extends BaseEntity {
    @Column(nullable = false, length = 120)
    private String name;
}
