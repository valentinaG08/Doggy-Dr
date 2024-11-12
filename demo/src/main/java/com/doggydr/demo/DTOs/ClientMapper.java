package com.doggydr.demo.DTOs;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.doggydr.demo.entidad.Client;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDTO convert(Client client);
}
