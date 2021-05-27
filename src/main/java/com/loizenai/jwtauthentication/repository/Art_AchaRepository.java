package com.loizenai.jwtauthentication.repository;

import java.util.List;

import com.loizenai.jwtauthentication.model.ArtAcha;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Art_AchaRepository extends JpaRepository<ArtAcha, Long> {

    @Query(value = "SELECT * FROM `achatss_articles` WHERE num_doc LIKE %:num_doc%", nativeQuery = true)
    public List<ArtAcha> getAllArtAchaByNumDocAchats(@Param("num_doc") String num_doc);

    @Query(value = "SELECT * FROM `art_acha` WHERE num_doc_achat LIKE %:num_doc_achat%", nativeQuery = true)
    public List<ArtAcha> getArtAchaForAchats(@Param("num_doc_achat") String num_doc_achat);

}
