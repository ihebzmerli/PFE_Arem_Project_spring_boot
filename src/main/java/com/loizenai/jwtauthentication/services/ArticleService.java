package com.loizenai.jwtauthentication.services;

import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.Article;
import com.loizenai.jwtauthentication.model.Marque;
import com.loizenai.jwtauthentication.repository.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository repository;


    public List<Article> getArticles(){
        return repository.findAll();
    }

    
    public void addArticle(Article codArt){
        repository.save(codArt);
    }

    public Article updateArticle(Article article){
       return repository.save(article);
    }

    public void deleteArticle(String codArt){
        repository.deleteById(codArt);
    }
/** end drop down list */
    public List<Article> getArticleOfFromMarqueAddForBonPrep(String marque){
        return repository.getArticleOfFromMarqueAddForBonPrep(marque);
    }

    public List<Article> getArticleOfAdd(){
        return repository.getArticleOfAdd();
    }

    public List<Article> getArticleOfAddForBonPrep(){
        return repository.getArticleOfAddForBonPrep();
    }
    public List<String> getArticleMarqueAddForBonPrep(){
        return repository.getArticleMarqueAddForBonPrep();
    }
/** end drop down list */
public List<Article> getArticleFromStock(String codArticle){
    return repository.getArticleFromStock(codArticle);
}

public List<Article> getArticleOfFromMarqueAddForBonLiv(String marque){
    return repository.getArticleOfFromMarqueAddForBonLiv(marque);
}

public List<String> getArticleMarqueAddForBonLiv(){
    return repository.getArticleMarqueAddForBonLiv();
}



public List<Article> getArticleNeedToAddForRectif(){
    return repository.getArticleOfAddForBonPrep();
}

/** end drop down list */
public List<Article> getArticleFromStockBL(String codArticle){
    return repository.getArticleFromStockBL(codArticle);
}
public List<Article> getArticleFromStockBS(String codArticle){
    return repository.getArticleFromStockBS(codArticle);
}

public List<Article> getArticleOfFromMarqueAddForBonSort(String marque){
    return repository.getArticleOfFromMarqueAddForBonSort(marque);
}

public List<String> getArticleMarqueAddForBonSort(){
    return repository.getArticleMarqueAddForBonSort();
}
public List<Article> getArticleOfAddForBonSort(){
    return repository.getArticleOfAddForBonSort();
}

public long getArticlePrixAch(String codArt){
    return repository.getArticlePrixAch(codArt);
}

public Article UpdateStkArticle(Article article){
    return repository.save(article);
}

public Article getArticleOrUpdate(String codArt){
    return repository.getArticleOrUpdate(codArt);
}

public String getZoneArticle(String codArt){
    return repository.getZoneArticle(codArt);
}

public List<String> getMarquesList(){
    return repository.getMarquesList();
}





/**statistique Article stk */

public Optional<Integer> getSum1(){
    return repository.getSum1();
}
public Optional<Integer> getSum2(){
    return repository.getSum2();
}
public Optional<Integer> getSum3(){
    return repository.getSum3();
}
public Optional<Integer> getSum4(){
    return repository.getSum4();
}
public Optional<Integer> getSum5(){
    return repository.getSum5();
}
public Optional<Integer> getSum6(){
    return repository.getSum6();
}
public Optional<Integer> getSum7(){
    return repository.getSum7();
}
public Optional<Integer> getSum8(){
    return repository.getSum8();
}
public Optional<Integer> getSum9(){
    return repository.getSum9();
}
public Optional<Integer> getSum10(){
    return repository.getSum10();
}
public Optional<Integer> getSum11(){
    return repository.getSum11();
}
public Optional<Integer> getSum12(){
    return repository.getSum12();
}
public Optional<Integer> getSum13(){
    return repository.getSum13();
}
public Optional<Integer> getSum14(){
    return repository.getSum14();
}

/**statistique Bar Article stk */
public Optional<Integer> getSumBar1(){
    return repository.getSumBar1();
}
public Optional<Integer> getSumBar2(){
    return repository.getSumBar2();
}
public Optional<Integer> getSumBar3(){
    return repository.getSumBar3();
}
public Optional<Integer> getSumBar4(){
    return repository.getSumBar4();
}
public Optional<Integer> getSumBar5(){
    return repository.getSumBar5();
}
public Optional<Integer> getSumBar6(){
    return repository.getSumBar6();
}
public Optional<Integer> getSumBar7(){
    return repository.getSumBar7();
}
}
