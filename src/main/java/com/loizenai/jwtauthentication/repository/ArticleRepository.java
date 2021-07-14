package com.loizenai.jwtauthentication.repository;

import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.Article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, String> {
/**drop down list dor add */

    @Query(value = "SELECT * FROM `article`", nativeQuery = true)
    public List<Article> getArticleOfAdd();


    @Query(value = "SELECT * FROM `article` where QUT_STK > 0 OR QUT_STK2 > 0 OR STK_GAR > 0 OR STK_INI > 0 OR ANAL_STK > 0 OR NBJ_STK > 0 OR V_SSTK > 0 OR COM_STK > 0 OR XANAL_STK > 0 OR STK_ATRSF > 0 OR STK_TRSF > 0 OR STK_REEL > 0 OR STK_RES > 0 OR STK_NP > 0", nativeQuery = true)
    public List<Article> getArticleOfAddForBonPrep();

    @Query(value = "SELECT * FROM `article` where QUT_STK = 0 OR QUT_STK2 = 0 OR STK_GAR = 0 OR STK_INI = 0 OR ANAL_STK = 0 OR NBJ_STK = 0 OR V_SSTK = 0 OR COM_STK = 0 OR XANAL_STK = 0 OR STK_ATRSF = 0 OR STK_TRSF = 0 OR STK_REEL = 0 OR STK_RES = 0 OR STK_NP = 0", nativeQuery = true)
    public List<Article> getArticleNeedToAddForRectif();

    @Query(value = "SELECT DISTINCT MARQUE FROM `article`", nativeQuery = true)
    public List<String> getArticleMarqueAddForBonPrep();

    @Query(value = "SELECT * FROM `article` WHERE MARQUE LIKE %:marque% AND (QUT_STK > 0 OR QUT_STK2 > 0 OR STK_GAR > 0 OR STK_INI > 0 OR ANAL_STK > 0 OR NBJ_STK > 0 OR V_SSTK > 0 OR COM_STK > 0 OR XANAL_STK > 0 OR STK_ATRSF > 0 OR STK_TRSF > 0 OR STK_REEL > 0 OR STK_RES > 0 OR STK_NP > 0)", nativeQuery = true)
    public List<Article> getArticleOfFromMarqueAddForBonPrep(@Param("marque") String marque);

    @Query(value = "SELECT * FROM `article` WHERE COD_ART LIKE %:codArticle% AND (QUT_STK > 0 OR QUT_STK2 > 0 OR STK_GAR > 0 OR STK_INI > 0 OR ANAL_STK > 0 OR NBJ_STK > 0 OR V_SSTK > 0 OR COM_STK > 0 OR XANAL_STK > 0 OR STK_ATRSF > 0 OR STK_TRSF > 0 OR STK_REEL > 0 OR STK_RES > 0 OR STK_NP > 0)", nativeQuery = true)
    public List<Article> getArticleFromStock(@Param("codArticle") String codArticle);
/**drop down list for bon Prep */
    @Query(value = "SELECT DISTINCT MARQUE FROM `article`", nativeQuery = true)
    public List<String> getArticleMarqueAddForBonLiv();
    @Query(value = "SELECT * FROM `article` WHERE id_model = (:id_model)", nativeQuery = true)
    public List<Article> getArticleOfFromMarqueAddForBonLiv(@Param("id_model") long id_model);
/**drop down list for bon Liv */


    @Query(value = "SELECT * FROM `article` where QUT_STK > 0 OR QUT_STK2 > 0 OR STK_GAR > 0 OR STK_INI > 0 OR ANAL_STK > 0 OR NBJ_STK > 0 OR V_SSTK > 0 OR COM_STK > 0 OR XANAL_STK > 0 OR STK_ATRSF > 0 OR STK_TRSF > 0 OR STK_REEL > 0 OR STK_RES > 0 OR STK_NP > 0", nativeQuery = true)
    public List<Article> getArticleOfAddForBonSort();

    @Query(value = "SELECT DISTINCT MARQUE FROM `article`", nativeQuery = true)
    public List<String> getArticleMarqueAddForBonSort();

    @Query(value = "SELECT * FROM `article` WHERE MARQUE LIKE %:marque% AND (QUT_STK > 0 OR QUT_STK2 > 0 OR STK_GAR > 0 OR STK_INI > 0 OR ANAL_STK > 0 OR NBJ_STK > 0 OR V_SSTK > 0 OR COM_STK > 0 OR XANAL_STK > 0 OR STK_ATRSF > 0 OR STK_TRSF > 0 OR STK_REEL > 0 OR STK_RES > 0 OR STK_NP > 0)", nativeQuery = true)
    public List<Article> getArticleOfFromMarqueAddForBonSort(@Param("marque") String marque);

    @Query(value = "SELECT * FROM `article` WHERE COD_ART LIKE %:codArticle% AND (QUT_STK > 0 OR QUT_STK2 > 0 OR STK_GAR > 0 OR STK_INI > 0 OR ANAL_STK > 0 OR NBJ_STK > 0 OR V_SSTK > 0 OR COM_STK > 0 OR XANAL_STK > 0 OR STK_ATRSF > 0 OR STK_TRSF > 0 OR STK_REEL > 0 OR STK_RES > 0 OR STK_NP > 0)", nativeQuery = true)
    public List<Article> getArticleFromStockBS(@Param("codArticle") String codArticle);


    @Query(value = "SELECT * FROM `article` WHERE COD_ART LIKE %:codArticle% AND (QUT_STK >= 0 OR QUT_STK2 >= 0 OR STK_GAR >= 0 OR STK_INI >= 0 OR ANAL_STK >= 0 OR NBJ_STK >= 0 OR V_SSTK >= 0 OR COM_STK >= 0 OR XANAL_STK >= 0 OR STK_ATRSF >= 0 OR STK_TRSF >= 0 OR STK_REEL >= 0 OR STK_RES >= 0 OR STK_NP >= 0)", nativeQuery = true)
    public List<Article> getArticleFromStockBL(@Param("codArticle") String codArticle);
    @Query(value = "SELECT PRIX_ACH FROM `article` WHERE COD_ART LIKE %:codArticle%", nativeQuery = true)
    public long getArticlePrixAch(@Param("codArticle") String codArticle);

    @Query(value = "SELECT DISTINCT ZONE FROM `article` WHERE CENTRE LIKE %:centre% AND COD_ART LIKE %:codArticle%", nativeQuery = true)
    public List<String> getZoneArticle(@Param("centre") String centre,@Param("codArticle") String codArticle);
/**drop down list for bon Liv */
    @Query(value = "SELECT * FROM `article` WHERE COD_ART LIKE %:codArticle%", nativeQuery = true)
    public Article getArticleOrUpdate(@Param("codArticle") String codArticle);
    @Query(value = "SELECT DISTINCT marque FROM `marque`", nativeQuery = true)
    public List<String> getMarquesList();
/**drop down list for bon Liv */




/**statistique Article stk */
@Query(value = "SELECT SUM(`QUT_STK`) FROM `article`", nativeQuery = true)
public Optional<Integer> getSum1();
@Query(value = "SELECT SUM(`QUT_STK2`) FROM `article`", nativeQuery = true)
public Optional<Integer> getSum2();
@Query(value = "SELECT SUM(`STK_GAR`) FROM `article`", nativeQuery = true)
public Optional<Integer> getSum3();
@Query(value = "SELECT SUM(`STK_INI`) FROM `article`", nativeQuery = true)
public Optional<Integer> getSum4();
@Query(value = "SELECT SUM(`ANAL_STK`) FROM `article`", nativeQuery = true)
public Optional<Integer> getSum5();
@Query(value = "SELECT SUM(`NBJ_STK`) FROM `article`", nativeQuery = true)
public Optional<Integer> getSum6();
@Query(value = "SELECT SUM(`V_SSTK`) FROM `article`", nativeQuery = true)
public Optional<Integer> getSum7();
@Query(value = "SELECT SUM(`COM_STK`) FROM `article`", nativeQuery = true)
public Optional<Integer> getSum8();
@Query(value = "SELECT SUM(`XANAL_STK`) FROM `article`", nativeQuery = true)
public Optional<Integer> getSum9();
@Query(value = "SELECT SUM(`STK_ATRSF`) FROM `article`", nativeQuery = true)
public Optional<Integer> getSum10();
@Query(value = "SELECT SUM(`STK_TRSF`) FROM `article`", nativeQuery = true)
public Optional<Integer> getSum11();
@Query(value = "SELECT SUM(`STK_REEL`) FROM `article`", nativeQuery = true)
public Optional<Integer> getSum12();
@Query(value = "SELECT SUM(`STK_RES`) FROM `article`", nativeQuery = true)
public Optional<Integer> getSum13();
@Query(value = "SELECT SUM(`STK_NP`) FROM `article`", nativeQuery = true)
public Optional<Integer> getSum14();



/**statistique bar */
@Query(value = "SELECT sum(`QUT_PREP`) FROM `bon_preps_articles` WHERE WEEKDAY(`DAT_PREP`) = 0", nativeQuery = true)
public Optional<Integer> getSumBar1();
@Query(value = "SELECT sum(`QUT_PREP`) FROM `bon_preps_articles` WHERE WEEKDAY(`DAT_PREP`) = 1", nativeQuery = true)
public Optional<Integer> getSumBar2();
@Query(value = "SELECT sum(`QUT_PREP`) FROM `bon_preps_articles` WHERE WEEKDAY(`DAT_PREP`) = 2", nativeQuery = true)
public Optional<Integer> getSumBar3();
@Query(value = "SELECT sum(`QUT_PREP`) FROM `bon_preps_articles` WHERE WEEKDAY(`DAT_PREP`) = 3", nativeQuery = true)
public Optional<Integer> getSumBar4();
@Query(value = "SELECT sum(`QUT_PREP`) FROM `bon_preps_articles` WHERE WEEKDAY(`DAT_PREP`) = 4", nativeQuery = true)
public Optional<Integer> getSumBar5();
@Query(value = "SELECT sum(`QUT_PREP`) FROM `bon_preps_articles` WHERE WEEKDAY(`DAT_PREP`) = 5", nativeQuery = true)
public Optional<Integer> getSumBar6();
@Query(value = "SELECT sum(`QUT_PREP`) FROM `bon_preps_articles` WHERE WEEKDAY(`DAT_PREP`) = 6", nativeQuery = true)
public Optional<Integer> getSumBar7();
}
