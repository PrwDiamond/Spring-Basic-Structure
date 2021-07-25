package com.example.demo.business;

import com.example.demo.entity.ESupplier;
import com.example.demo.exception.BaseException;
import com.example.demo.mapper.SupplierMapper;
import com.example.demo.model.MSupplier;
import com.example.demo.service.SupplierService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class supplierBusiness {
    private final SupplierService supplierService;

    private final SupplierMapper supplierMapper;

    public supplierBusiness(SupplierService supplierService, SupplierMapper supplierMapper) {
        this.supplierService = supplierService;
        this.supplierMapper = supplierMapper;
    }

    public List<MSupplier> readSupplier() throws BaseException {
        List<ESupplier> eSuppliers = supplierService.readSupplier();
        return supplierMapper.toListESupplier(eSuppliers);
    }

    public MSupplier readSupplierByName(String name) throws BaseException {
        ESupplier eSupplier = supplierService.readSupplierByName(name);
        return supplierMapper.toESupplier(eSupplier);
    }


    public MSupplier createSupplier(ESupplier supplier) throws BaseException {
        ESupplier esupplier = supplierService.createSupplier(supplier.getName());
        return supplierMapper.toESupplier(esupplier);
    }

    public MSupplier updateSupplier(String edit_name, ESupplier supplier) throws BaseException {
        ESupplier eSupplier = supplierService.updateSupplier(edit_name, supplier.getName());
        return supplierMapper.toESupplier(eSupplier);
    }

    public void deleteSupplierByName(String name) throws BaseException {
        supplierService.deleteSupplierByName(name);
    }
}
