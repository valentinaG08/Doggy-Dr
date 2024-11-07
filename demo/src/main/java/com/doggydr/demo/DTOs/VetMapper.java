package com.doggydr.demo.DTOs;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.doggydr.demo.entidad.Vet;

@Mapper
public interface VetMapper {
    VetMapper INSTANCE = Mappers.getMapper(VetMapper.class);

    VetDTO convert(Vet vet);
}
