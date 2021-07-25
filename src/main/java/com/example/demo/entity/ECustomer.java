package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "customer")
public class ECustomer extends BaseEntity {

    @Column(nullable = false, length = 60)
    private String name_customer;

    @Column(nullable = false, length = 60)
    private String lastname_customer;

    @Column(nullable = false, length = 60)
//    @Temporal(TemporalType.DATE)
    private LocalDate birthdate;

    @Column(nullable = false, length = 60)
    private String sex;

    @Column(nullable = false, length = 60)
    private String career;

    @Column(nullable = false, unique = true)
    private String card;

    @Column(nullable = false, unique = true)
    private String passport;
}
