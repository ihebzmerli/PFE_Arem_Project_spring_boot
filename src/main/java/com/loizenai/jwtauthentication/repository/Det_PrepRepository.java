package com.loizenai.jwtauthentication.repository;

import com.loizenai.jwtauthentication.model.DetPrep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Det_PrepRepository extends JpaRepository<DetPrep, Long> {
//    List<DetPrep> findByZone(String zone);

    @Query(value = "SELECT * FROM `det_prep` WHERE ZONE LIKE %:zone%", nativeQuery = true)
    public List<DetPrep> getAllDetPrepByZone(@Param("zone") String zone);

    @Query(value = "SELECT * FROM `det_prep` WHERE PREPARA LIKE %:preparateur%", nativeQuery = true)
    public List<DetPrep> getAllDetPrepByPrepara(@Param("preparateur") String preparateur);

    @Query(value = "SELECT * FROM `det_prep` WHERE id_prep LIKE %:idprepra%", nativeQuery = true)
    public List<DetPrep> getAllDetPrepByBonPrep(@Param("idprepra") String idprepra);
}