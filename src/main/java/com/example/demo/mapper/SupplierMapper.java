package com.example.demo.mapper;

import com.example.demo.entity.ESupplier;
import com.example.demo.model.MSupplier;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    MSupplier toESupplier(ESupplier eSupplier);

    List<MSupplier> toListESupplier(List<ESupplier> eSupplier);

    MSupplier toESupplier(Optional<ESupplier> eSupplier);
}
