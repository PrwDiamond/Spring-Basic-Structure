package com.example.demo;

import com.example.demo.entity.ECustomer;
import com.example.demo.exception.BaseException;
import com.example.demo.service.CustomerService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCustomerService {

    @Autowired
    CustomerService customerService;

    @Order(1)
    @Test
    void testCreateCustomer() throws BaseException {
        ECustomer eCustomer = customerService.createCustomer(
                createCustomer.name_customer,
                createCustomer.lastname_customer,
                createCustomer.birthdate,
                createCustomer.sex,
                createCustomer.career,
                createCustomer.card,
                createCustomer.passport
        );

        //Check not null
        Assertions.assertNotNull(eCustomer);
        Assertions.assertNotNull(eCustomer.getId());

        //Check Equals
        Assertions.assertEquals(createCustomer.name_customer, eCustomer.getName_customer());
        Assertions.assertEquals(createCustomer.lastname_customer, eCustomer.getLastname_customer());
        Assertions.assertEquals(createCustomer.birthdate, eCustomer.getBirthdate());
        Assertions.assertEquals(createCustomer.sex, eCustomer.getSex());
        Assertions.assertEquals(createCustomer.career, eCustomer.getCareer());
        Assertions.assertEquals(createCustomer.card, eCustomer.getCard());
        Assertions.assertEquals(createCustomer.passport, eCustomer.getPassport());
    }

    @Order(2)
    @Test
    void testUpdate() throws BaseException {

        ECustomer customer = customerService.updateCustomer(
                createCustomer.card,
                updateCustomer.name_customer,
                updateCustomer.lastname_customer,
                updateCustomer.birthdate,
                updateCustomer.sex,
                updateCustomer.career
        );

        //Check not null
        Assertions.assertNotNull(customer);
        Assertions.assertNotNull(customer.getId());

        //Check Equals
        Assertions.assertEquals(updateCustomer.name_customer, customer.getName_customer());
        Assertions.assertEquals(updateCustomer.lastname_customer, customer.getLastname_customer());
        Assertions.assertEquals(updateCustomer.birthdate, customer.getBirthdate());
        Assertions.assertEquals(updateCustomer.sex, customer.getSex());
        Assertions.assertEquals(updateCustomer.career, customer.getCareer());
    }

    @Order(9)
    @Test
    void testDelete() throws BaseException {
        Optional<ECustomer> customer = customerService.findCustomerByCard(createCustomer.card);
        Assertions.assertTrue(customer.isPresent());

        customerService.deleteCustomerByCard(createCustomer.card);

        Optional<ECustomer> deleteCustomer = customerService.findCustomerByCard(createCustomer.card);
        Assertions.assertTrue(deleteCustomer.isEmpty());
    }


    interface createCustomer {
        String name_customer = "Pirat";

        String lastname_customer = "Wannasiripipat";

        DateTimeFormatter f = new DateTimeFormatterBuilder().parseCaseInsensitive()
                .append(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toFormatter();

        LocalDate birthdate = LocalDate.parse("1999-01-19", f);

        String sex = "men";

        String career = "Student";

        String card = "1111111111111";

        String passport = "1111111111111";
    }

    interface updateCustomer {
        String name_customer = "Pitak";

        String lastname_customer = "Wannasiripipat";

        DateTimeFormatter f = new DateTimeFormatterBuilder().parseCaseInsensitive()
                .append(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toFormatter();

        LocalDate birthdate = LocalDate.parse("1960-01-19", f);

        String sex = "men";

        String career = "Work";
    }

}


