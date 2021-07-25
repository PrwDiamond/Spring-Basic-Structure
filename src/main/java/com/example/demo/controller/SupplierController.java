package com.example.demo.controller;

import com.example.demo.business.supplierBusiness;
import com.example.demo.entity.ESupplier;
import com.example.demo.exception.BaseException;
import com.example.demo.model.MSupplier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("supplier")
public class SupplierController {
    private final supplierBusiness supplierBusiness;

    public SupplierController(com.example.demo.business.supplierBusiness supplierBusiness) {
        this.supplierBusiness = supplierBusiness;
    }

    @PostMapping
    public ResponseEntity<MSupplier> createSupplier(@RequestBody ESupplier eSupplier) throws BaseException {
        MSupplier response = supplierBusiness.createSupplier(eSupplier);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<MSupplier>> readSupplier() throws BaseException {
        List<MSupplier> response = supplierBusiness.readSupplier();
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{names}")
    public ResponseEntity<MSupplier> readSupplierByName(@PathVariable String names) throws BaseException {
        MSupplier response = supplierBusiness.readSupplierByName(names);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/{names}")
    public ResponseEntity<MSupplier> updateSupplier(@PathVariable String names, @RequestBody ESupplier eSupplier) throws BaseException {
        MSupplier response = supplierBusiness.updateSupplier(names, eSupplier);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{names}")
    public ResponseEntity<String> deleteSupplier(@PathVariable String names) throws BaseException {
        supplierBusiness.deleteSupplierByName(names);
        return ResponseEntity.ok(" Supplier  with ID :" + names + " deleted successfully");
    }
}
