package com.loizenai.jwtauthentication.repository;

import com.loizenai.jwtauthentication.model.DetEmba;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Det_EmbaRepository extends JpaRepository<DetEmba, Long> {

    @Query(value = "SELECT * FROM `det_emba` WHERE num_bon_prep LIKE %:Nbon_prep%", nativeQuery = true)
    public List<DetEmba> getAllDetEmbaByBPrep(@Param("Nbon_prep") String Nbon_prep);

    @Query(value = "SELECT * FROM `det_emba` WHERE id_artliv LIKE %:idArtliv%", nativeQuery = true)
    public List<DetEmba> getAllDetEmbaByArtLiv(@Param("idArtliv") String idArtliv);
}