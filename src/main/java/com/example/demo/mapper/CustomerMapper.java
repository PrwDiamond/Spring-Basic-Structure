package com.example.demo.mapper;

import com.example.demo.entity.ECustomer;
import com.example.demo.model.MCustomer;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    MCustomer toECustomer(ECustomer eCustomer);

    List<MCustomer> toListECustomer(List<ECustomer> eCustomers);

    MCustomer toECustomer(Optional<ECustomer> eCustomer);
}
