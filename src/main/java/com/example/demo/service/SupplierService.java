package com.example.demo.service;

import com.example.demo.entity.ECustomer;
import com.example.demo.entity.ESupplier;
import com.example.demo.exception.BaseException;
import com.example.demo.exception.SupplierException;
import com.example.demo.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<ESupplier> readSupplier() throws BaseException {
        List<ESupplier> eSupplier = supplierRepository.findAll();

        //Check Validate
        if (eSupplier.isEmpty()) {
            throw SupplierException.findSupplierNotFound();
        }
        return eSupplier;
    }

    public ESupplier readSupplierByName(String name) throws BaseException {
        Optional<ESupplier> byName = supplierRepository.findByName(name);
        if(Objects.isNull(byName)){
            throw  SupplierException.findIdSupplierNotFound();
        }
        return byName.get();
    }

    public Optional<ESupplier> findSupplierByName(String name) {
        return supplierRepository.findByName(name);
    }

    public ESupplier createSupplier(String name) throws BaseException {
        //Check Validate
        if (Objects.isNull(name)) {
            throw SupplierException.createNameSupplierNull();
        }

        ESupplier supplier = new ESupplier();
        supplier.setName(name);
        return supplierRepository.save(supplier);
    }

    public ESupplier updateSupplier(String edit_name, String name) throws BaseException {
        Optional<ESupplier> eSupplier = supplierRepository.findByName(edit_name);

        //Check Validate
        if (eSupplier.isEmpty()) {
            throw SupplierException.notFound();
        }

        ESupplier supplier = eSupplier.get();
        supplier.setName(name);
        return supplierRepository.save(supplier);
    }

    public void deleteSupplierByName(String name) throws BaseException {
        Optional<ESupplier> eSupplier = supplierRepository.findByName(name);

        //Check Validate
        if (eSupplier.isEmpty()) {
            throw SupplierException.findIdSupplierNotFound();
        }
        supplierRepository.delete(eSupplier.get());
    }

}
