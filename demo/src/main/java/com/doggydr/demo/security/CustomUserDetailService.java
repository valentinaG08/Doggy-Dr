package com.doggydr.demo.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.doggydr.demo.entidad.Client;
import com.doggydr.demo.entidad.Role;
import com.doggydr.demo.entidad.UserEntity;
import com.doggydr.demo.entidad.Vet;
import com.doggydr.demo.repositorio.RoleRepository;
import com.doggydr.demo.repositorio.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //System.out.println("\n\nloadUserByUsername:" + username);
        // Busca por username y no por correo
        UserEntity userDB = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        
        System.out.println("Usuario encontrado: " + userDB.getUsername());
        System.out.println("Roles: " + userDB.getRoles());
        
        return new User(userDB.getUsername(), userDB.getPassword(),
                mapToGrantedAuthorities(userDB.getRoles()));
    }
    
    private Collection<GrantedAuthority> mapToGrantedAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public UserEntity ClienteToUser(Client client) {
        UserEntity user = new UserEntity();
        user.setUsername(client.getUsername());
        user.setPassword(passwordEncoder.encode("123"));
        Role roles = roleRepository.findByName("CLIENTE").orElseThrow(() -> 
            new RuntimeException("Role CLIENTE not found"));
        user.setRoles(List.of(roles));
        return user;
    }

    public UserEntity VetToUser(Vet vet) {
        UserEntity user = new UserEntity();
        user.setUsername(vet.getUserName());
        user.setPassword(passwordEncoder.encode(vet.getPassword()));
        Role roles = roleRepository.findByName("VETERINARIO").orElseThrow(() -> 
            new RuntimeException("Role VETERINARIO not found"));
        user.setRoles(List.of(roles));
        return user;
    }
}
