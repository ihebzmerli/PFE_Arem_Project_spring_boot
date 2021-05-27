package com.loizenai.jwtauthentication.repository;

import java.util.List;

import com.loizenai.jwtauthentication.model.Fournis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisRepository extends JpaRepository<Fournis, Long>{
    @Query(value = "SELECT COD_FRS FROM `fournis` WHERE COD_FRS IS NOT NULL", nativeQuery = true)
    public List<Long> getFournisOfAdd();
}
