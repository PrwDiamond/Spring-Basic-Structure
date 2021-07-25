package com.example.demo.controller;

import com.example.demo.business.customerBusiness;
import com.example.demo.entity.ECustomer;
import com.example.demo.exception.BaseException;
import com.example.demo.model.MCustomer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    private final customerBusiness customerBusiness;

    public CustomerController(com.example.demo.business.customerBusiness customerBusiness) {
        this.customerBusiness = customerBusiness;
    }

    @PostMapping
    public ResponseEntity<MCustomer> createCustomer(@RequestBody ECustomer customer) throws BaseException {
        MCustomer response = customerBusiness.createCustomer(customer);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<MCustomer>> readCustomer() throws BaseException {
        List<MCustomer> response = customerBusiness.readCustomer();
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{card}")
    public ResponseEntity<MCustomer> readCustomerByCard(@PathVariable String card) throws BaseException {
        MCustomer response = customerBusiness.readCustomerByCard(card);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/{card}")
    public ResponseEntity<MCustomer> updateCustomer(@PathVariable String card, @RequestBody ECustomer eCustomer) throws BaseException {
        MCustomer response = customerBusiness.updateCustomer(card, eCustomer);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{card}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable String card) throws BaseException {
        customerBusiness.deleteCustomerByCard(card);
        return ResponseEntity.ok(" Customer  with ID :" + card + " deleted successfully");
    }
}
