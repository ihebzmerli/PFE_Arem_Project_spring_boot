package com.loizenai.jwtauthentication.repository;

import java.util.List;

import com.loizenai.jwtauthentication.model.Xcommand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface XcommandRepository extends JpaRepository<Xcommand, Long> {

    @Query(value = "SELECT * FROM `xcommand` where `TRAITE` LIKE 'NO'", nativeQuery = true)
    public List<Xcommand> getXcommandBlNull();
    /**drop down list dor add */


}
