package com.loizenai.jwtauthentication.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import com.loizenai.jwtauthentication.model.ArtTerm;

import org.springframework.data.jpa.repository.JpaRepository;
public interface Art_TermRepository extends JpaRepository<ArtTerm, String> {
        /**drop down list start add */
    
        @Query(value = "SELECT * FROM `art_term`", nativeQuery = true)
        public List<ArtTerm> getArtTermsOfPreparation();
    
        @Query(value = "SELECT * FROM `art_term` WHERE num_bon_liv LIKE %:num_bon_liv%", nativeQuery = true)
        public List<ArtTerm> getArtTermForBonLiv(@Param("num_bon_liv") String num_bon_liv);
        
    /**drop down list end add */

}
