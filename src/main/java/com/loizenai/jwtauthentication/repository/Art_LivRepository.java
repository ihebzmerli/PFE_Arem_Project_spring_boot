package com.loizenai.jwtauthentication.repository;

import java.util.List;
import java.util.Optional;
import com.loizenai.jwtauthentication.model.ArtLiv;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Art_LivRepository extends JpaRepository<ArtLiv, Long> {
    /**drop down list dor add */
    
        @Query(value = "SELECT COD_ART,DES_ART FROM `article` WHERE COD_ART IS NOT NULL AND DES_ART IS NOT NULL", nativeQuery = true)
        public List<String> getArtLivOfAdd();
    
        @Query(value = "SELECT * FROM `bon_livs_articles` WHERE num_bon_liv LIKE %:num_bon_liv%", nativeQuery = true)
        public List<ArtLiv> getArtLivForBonLiv(@Param("num_bon_liv") String num_bon_liv);
    /**drop down list dor add */

    @Query(value = "SELECT SUM(`prix_ach`) FROM `bon_livs_articles` WHERE `num_bon_liv` LIKE %:num_bon_liv%", nativeQuery = true)
    public Optional<Integer> getSumQutByBLach(@Param("num_bon_liv") String num_bon_liv);
    @Query(value = "SELECT SUM(`prix_ht`) FROM `bon_livs_articles` WHERE `num_bon_liv` LIKE %:num_bon_liv%", nativeQuery = true)
    public Optional<Integer> getSumQutByBLht(@Param("num_bon_liv") String num_bon_liv);
    @Query(value = "SELECT SUM(`PRIX_AREM`) FROM `bon_livs_articles` WHERE `num_bon_liv` LIKE %:num_bon_liv%", nativeQuery = true)
    public Optional<Integer> getSumQutByBLAREM(@Param("num_bon_liv") String num_bon_liv);

}
