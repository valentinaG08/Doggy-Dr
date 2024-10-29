package com.doggydr.demo.servicio;

import java.util.List;

import com.doggydr.demo.entidad.Admin;

public interface AdminService {
    public Admin findByUsername(String username);

    public Admin findByPassword(String password);
}
