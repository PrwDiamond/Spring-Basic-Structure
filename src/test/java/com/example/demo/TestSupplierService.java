package com.example.demo;

import com.example.demo.entity.ESupplier;
import com.example.demo.exception.BaseException;
import com.example.demo.service.SupplierService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestSupplierService {

    @Autowired
    SupplierService supplierService;

    @Test
    @Order(1)
    void testCreateSupplier() throws BaseException {
        ESupplier supplier = supplierService.createSupplier(createSupplier.name);

        //Check not null
        Assertions.assertNotNull(supplier.getId());
        Assertions.assertNotNull(supplier.getName());

        //Check Equals
        Assertions.assertEquals(createSupplier.name,supplier.getName());
    }

    @Test
    @Order(2)
    void testUpdateSupplier() throws BaseException {
        ESupplier supplier = supplierService.updateSupplier(createSupplier.name, updateSupplier.name);

        //Check not null
        Assertions.assertNotNull(supplier.getId());
        Assertions.assertNotNull(supplier.getName());

        //Check Equalss
        Assertions.assertEquals(updateSupplier.name,supplier.getName());
    }

    @Test
    @Order(3)
    void testDeleteSupplier() throws BaseException{
        Optional<ESupplier> supplierByName = supplierService.findSupplierByName(updateSupplier.name);
        Assertions.assertTrue(supplierByName.isPresent());

        supplierService.deleteSupplierByName(updateSupplier.name);

        Optional<ESupplier> deleteSupplierByName = supplierService.findSupplierByName(updateSupplier.name);
        Assertions.assertTrue(deleteSupplierByName.isEmpty());
    }

    interface createSupplier{
        String name = "Pirat";
    }

    interface updateSupplier{
        String name = "Nantima";
    }
}
