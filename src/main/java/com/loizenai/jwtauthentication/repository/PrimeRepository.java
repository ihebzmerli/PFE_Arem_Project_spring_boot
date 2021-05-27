package com.loizenai.jwtauthentication.repository;

import com.loizenai.jwtauthentication.model.Prime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrimeRepository extends JpaRepository<Prime, Long> {
    //** les query de filtrage */

    @Query(value = "SELECT CATEGORIE,OBJ_MIN,OBJ_MAX,PRIME FROM `prime`", nativeQuery = true)
    public List<String> getLivreursOfAdd();


    @Query(value = "SELECT id_livreur,id_prime FROM `livreurs_primes`", nativeQuery = true)
    public List<Long> getLivs_PrimesOfAdd();


    //** les query de filtrage */

    //** les query de filtrage */

    @Query(value = "SELECT * FROM `prime` WHERE CATEGORIE LIKE %:cata%", nativeQuery = true)
    public List<Prime> getAllPrimeByCategorie(@Param("cata") String cata);

    @Query(value = "SELECT * FROM `prime` WHERE PRIME LIKE %:prime%", nativeQuery = true)
    public List<Prime> getAllPrimeByPrime(@Param("prime") String prime);

    @Query(value = "SELECT * FROM `prime` WHERE BLOC LIKE %:bloc%", nativeQuery = true)
    public List<Prime> getAllPrimeByBloc(@Param("bloc") String bloc);

    @Query(value = "SELECT * FROM `prime` WHERE DER_MVT LIKE %:d_mvt%", nativeQuery = true)
    public List<Prime> getAllPrimeByDerMvt(@Param("d_mvt") String d_mvt);

    //** les query de filtrage */
}