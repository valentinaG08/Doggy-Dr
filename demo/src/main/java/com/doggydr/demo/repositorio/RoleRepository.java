package com.doggydr.demo.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.doggydr.demo.entidad.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional<Role> findByName(String name);

    @Modifying
    @Query("DELETE FROM UserRoles ur WHERE ur.user.id = :userId")
    void deleteByUserId(@Param("userId") Long userId);
    
}
