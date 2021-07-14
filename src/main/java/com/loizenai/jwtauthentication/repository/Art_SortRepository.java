package com.loizenai.jwtauthentication.repository;

import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.ArtSort;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Art_SortRepository extends JpaRepository<ArtSort, Long> {

    /**drop down list dor add */
    
        @Query(value = "SELECT COD_ART,DES_ART,QUT_STK,QUT_STK2,QUT_DEP,PRIX_VEN,REMISE,PRIX_AREM FROM `article` WHERE COD_ART IS NOT NULL AND DES_ART IS NOT NULL", nativeQuery = true)
        public List<String> getArtSortOfAdd();
    
    /**drop down list dor add */

    @Query(value = "SELECT * FROM `bon_sorts_articles` WHERE num_bon_sort LIKE %:num_bon_sort%", nativeQuery = true)
    public List<ArtSort> getArtSortForBonSort(@Param("num_bon_sort") String num_bon_sort);

    @Query(value = "SELECT * FROM `bon_sorts_articles` WHERE num_bon_sort LIKE %:num_bon_sort% AND cod_art LIKE %:cod_art%", nativeQuery = true)
    public Optional<ArtSort> getArtSortBS_CA(@Param("num_bon_sort") String num_bon_sort,@Param("cod_art") String cod_art);



@Query(value = "SELECT SUM(`prix_ht`) FROM `bon_sorts_articles` WHERE `num_bon_sort` LIKE %:num_bon_sort%", nativeQuery = true)
public Optional<Integer> getSumQutByBSht(@Param("num_bon_sort") String num_bon_sort);
@Query(value = "SELECT SUM(`PRIX_AREM`) FROM `bon_sorts_articles` WHERE `num_bon_sort` LIKE %:num_bon_sort%", nativeQuery = true)
public Optional<Integer> getSumQutByBSAREM(@Param("num_bon_sort") String num_bon_sort);
}