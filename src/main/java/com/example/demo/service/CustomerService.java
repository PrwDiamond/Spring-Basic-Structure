package com.example.demo.service;

import com.example.demo.entity.ECustomer;
import com.example.demo.exception.BaseException;
import com.example.demo.exception.CustomerException;
import com.example.demo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<ECustomer> readCustomer() throws BaseException {
        List<ECustomer> eCustomer = customerRepository.findAll();

        //Check Validate
        if (eCustomer.isEmpty()) {
            throw CustomerException.findCustomerNotFound();
        }
        return eCustomer;
    }

    public ECustomer readCustomerByCard(String card) throws BaseException {
        Optional<ECustomer> byCard = customerRepository.findByCard(card);

        //Check Validate
        if (Objects.isNull(byCard)) {
            throw CustomerException.findCivilIdNotFound();
        }
        return byCard.get();
    }

    public Optional<ECustomer> findCustomerByCard(String card) {
        return customerRepository.findByCard(card);
    }

    public ECustomer createCustomer(String name_customer, String lastname_customer, LocalDate birthdate, String sex, String career, String card, String passport) throws BaseException {

        //Validate
        if (Objects.isNull(name_customer)) {
            throw CustomerException.createNameCustomerNull();
        }
        if (Objects.isNull(lastname_customer)) {
            throw CustomerException.createLastnameCustomerNull();
        }
        if (Objects.isNull(birthdate)) {
            throw CustomerException.createBirthdateCustomerNull();
        }
        if (Objects.isNull(sex)) {
            throw CustomerException.createSexCustomerNull();
        }
        if (Objects.isNull(career)) {
            throw CustomerException.createCareerCustomerNull();
        }
        if (Objects.isNull(card)) {
            throw CustomerException.createCivilIdCustomerNull();
        }
        if (Objects.isNull(passport)) {
            throw CustomerException.createPassportCustomerNull();
        }
        if (card.length() != 13) {
            throw CustomerException.createCivilIdCustomerInvalid();
        }

        //Verify
        if (customerRepository.existsByCard(card)) {
            throw CustomerException.createCivilIdDuplicated();
        }
        if (customerRepository.existsByPassport(passport)) {
            throw CustomerException.createPassportDuplicated();
        }

        //Save
        ECustomer customer = new ECustomer();
        customer.setName_customer(name_customer);
        customer.setLastname_customer(lastname_customer);
        customer.setBirthdate(birthdate);
        customer.setSex(sex);
        customer.setCareer(career);
        customer.setCard(card);
        customer.setPassport(passport);
        return customerRepository.save(customer);
    }

    public ECustomer updateCustomer(String card,
                                    String name_customer,
                                    String lastname_customer,
                                    LocalDate birthdate,
                                    String sex,
                                    String career
    ) throws BaseException {
        Optional<ECustomer> eCustomer = customerRepository.findByCard(card);
        //Check Validate

        if (eCustomer.isEmpty()) {
            throw CustomerException.findCustomerNotFound();
        }

        ECustomer customer = eCustomer.get();
        customer.setName_customer(name_customer);
        customer.setLastname_customer(lastname_customer);
        customer.setBirthdate(birthdate);
        customer.setSex(sex);
        customer.setCareer(career);
        return customerRepository.save(customer);
    }

    public void deleteCustomerByCard(String card) throws BaseException {
        Optional<ECustomer> eCustomer = customerRepository.findByCard(card);

        //Check Validate
        if (eCustomer.isEmpty()) {
            throw CustomerException.findCivilIdNotFound();
        }
        customerRepository.delete(eCustomer.get());
    }
}
