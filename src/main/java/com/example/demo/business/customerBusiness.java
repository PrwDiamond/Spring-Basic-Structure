package com.example.demo.business;

import com.example.demo.entity.ECustomer;
import com.example.demo.exception.BaseException;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.model.MCustomer;
import com.example.demo.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class customerBusiness {
    private final CustomerService customerService;

    private final CustomerMapper customerMapper;

    public customerBusiness(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    public List<MCustomer> readCustomer() throws BaseException {
        List<ECustomer> eCustomer = customerService.readCustomer();
        return customerMapper.toListECustomer(eCustomer);
    }

    public MCustomer readCustomerByCard(String card) throws BaseException {
        ECustomer eCustomer = customerService.readCustomerByCard(card);
        return customerMapper.toECustomer(eCustomer);
    }

    public MCustomer createCustomer(ECustomer customer) throws BaseException {
        ECustomer eCustomer = customerService.createCustomer(customer.getName_customer(),
                customer.getLastname_customer(),
                customer.getBirthdate(),
                customer.getSex(),
                customer.getCareer(),
                customer.getCard(),
                customer.getPassport()
        );
        return customerMapper.toECustomer(eCustomer);
    }

    public MCustomer updateCustomer(String card, ECustomer customer) throws BaseException {
        ECustomer eCustomer = customerService.updateCustomer(card,
                customer.getName_customer(),
                customer.getLastname_customer(),
                customer.getBirthdate(),
                customer.getSex(),
                customer.getCareer()
        );
        return customerMapper.toECustomer(eCustomer);
    }

    public void deleteCustomerByCard(String card) throws BaseException {
        customerService.deleteCustomerByCard(card);
    }
}
