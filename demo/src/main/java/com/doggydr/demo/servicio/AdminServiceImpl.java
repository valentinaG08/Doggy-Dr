package com.doggydr.demo.servicio;

import java.util.List;

import com.doggydr.demo.entidad.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.doggydr.demo.repositorio.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
    
    @Autowired
    AdminRepository adminRepo;
    @Override
    public Admin findByUsername(String username) {
        return adminRepo.findByUsername(username);
    }

    @Override
    public Admin findByPassword(String password) {
        return adminRepo.findByPassword(password);
    }
    
}
