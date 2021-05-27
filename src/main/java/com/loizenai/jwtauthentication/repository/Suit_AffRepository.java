package com.loizenai.jwtauthentication.repository;

import java.util.List;

import com.loizenai.jwtauthentication.model.Achats;
import com.loizenai.jwtauthentication.model.SuitAff;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface Suit_AffRepository extends JpaRepository<SuitAff, Long> {
    /**drop down list start add */
    
        @Query(value = "SELECT * FROM `suit_aff`", nativeQuery = true)
        public List<SuitAff> getSuitAffOfAddPrep();
       
    /**drop down list end add */

}