package com.doggydr.demo.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.doggydr.demo.entidad.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String userName);

    Boolean existsByUsername(String userName);

    Boolean existsByDocument(Long document);

    Optional<UserEntity> findByDocument(Long document);

    @Modifying
    @Query(value = "DELETE FROM USER_ROLES WHERE USER_ID = :id", nativeQuery = true)
    void removeRolesByUserId(@Param("id") Long id);

    @Query(value = "SELECT * FROM USER_ROLES WHERE USER_ID = :id", nativeQuery = true)
    List<Object[]> getRolesByUserId(@Param("id") Long id);
}
