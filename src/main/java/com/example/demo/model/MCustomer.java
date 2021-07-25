package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class MCustomer {

    private String name_customer;

    private String lastname_customer;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

    private String sex;

    private String career;

    private String card;

    private String passport;
}
