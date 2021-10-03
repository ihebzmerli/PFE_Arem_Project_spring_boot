package com.loizenai.jwtauthentication.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.Livreur_Expide;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Livreur_ExpideRepository extends JpaRepository<Livreur_Expide, Long> {
    
    @Query(value = "SELECT * FROM `livreurs_expides` WHERE id_expide LIKE %:id_expide%", nativeQuery = true)
    public List<Livreur_Expide> getAllLivreursAndBonliv(@Param("id_expide") Long id_expide);

    @Query(value = "SELECT * FROM `livreurs_expides` WHERE id_expide LIKE :id_expide", nativeQuery = true)
    public Optional<Livreur_Expide> getAllLivreursAndBonliv2(@Param("id_expide") String id_expide);



    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `livreurs_expides` WHERE `id_expide` LIKE %:id_expide%", nativeQuery = true)
    public void deleteAllByExpidition(@Param("id_expide") Long id_expide);







 
}
