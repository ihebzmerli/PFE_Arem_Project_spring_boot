package com.loizenai.jwtauthentication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.loizenai.jwtauthentication.model.Role;
import com.loizenai.jwtauthentication.model.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);


    @Query(value = "SELECT * FROM `roles`", nativeQuery = true)
    public List<Role> getAllRoles();
}