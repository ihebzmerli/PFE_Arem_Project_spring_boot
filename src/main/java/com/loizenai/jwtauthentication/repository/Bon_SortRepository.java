package com.loizenai.jwtauthentication.repository;

import com.loizenai.jwtauthentication.model.BonSort;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Bon_SortRepository extends JpaRepository<BonSort, String> {


@Query(value = "SELECT * FROM `bon_sort` WHERE num_char is Null", nativeQuery = true)
public List<BonSort> getBonSortEncoreEnStock();

@Query(value = "SELECT * FROM `bon_sort` WHERE num_bon_prep LIKE %:numBonprep%", nativeQuery = true)
public List<BonSort> getAllBonSortDeMemeBonPreparation(@Param("numBonprep") String numBonprep);

@Query(value = "SELECT * FROM `bon_sort` WHERE CENTRE LIKE %:centre%", nativeQuery = true)
public List<BonSort> getAllBonSortByCentre(@Param("centre") String centre);

@Query(value = "SELECT * FROM `bon_sort` WHERE id =(:id)", nativeQuery = true)
public List<BonSort> getAllBonSortByUser(@Param("id") long id);

@Query(value = "SELECT * FROM `bon_sort` WHERE DAT_BON  BETWEEN :startDate AND :endDate", nativeQuery = true)
public List<BonSort> getAllBonSortBydateBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);

    List<BonSort> findByVehicule(String vehicule);
}