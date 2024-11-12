package com.doggydr.demo.DTOs;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.doggydr.demo.entidad.Admin;

@Mapper
public interface AdminMapper {
    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    AdminDTO convert(Admin admin);

    
}
