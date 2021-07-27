package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "customer", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<AddressCustomer> addressCustomerList;
}
