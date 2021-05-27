package com.loizenai.jwtauthentication.repository;

import java.util.List;

import com.loizenai.jwtauthentication.model.livreurs_primes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface  livreurs_primesRepository extends JpaRepository<livreurs_primes, Long> {
    
    @Query(value = "SELECT * FROM `livreurs_primes` WHERE id_livreur LIKE :id_livreur", nativeQuery = true)
    public List<livreurs_primes> getAllPrimeByLivreur(@Param("id_livreur") String id_livreur);

}