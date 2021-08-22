package com.loizenai.jwtauthentication.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loizenai.jwtauthentication.model.Article;
import com.loizenai.jwtauthentication.repository.ArticleRepository;
import com.loizenai.jwtauthentication.services.ArticleService;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import javax.servlet.ServletContext;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ArticleController {
   
    @Autowired
    ArticleService service;
    
    @Autowired
    ArticleRepository repository;

    @Autowired
    ServletContext context;

    @GetMapping("/articles")
    public ResponseEntity<List<Article>> getAllBonlivs() {
        List<Article> articles = new ArrayList<>();
        try {
            service.getArticles().forEach(articles::add);

            if (articles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(articles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } 

    @PostMapping(value = "/articles")
    public ResponseEntity<Article> postArticle(@RequestBody Article article) {
        try {
            service.addArticle(article);
            return new ResponseEntity<>(article, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }
/*****************post article upload image */

    @PostMapping(value = "/articlesTest")
    public ResponseEntity<Article> postArticleTest(@RequestParam("file") MultipartFile file,@RequestParam("article") String article)
    throws JsonParseException , JsonMappingException , Exception
    {
        System.out.println("OK............");
        Article arti =  new ObjectMapper().readValue(article,Article.class);
        boolean isExist = new File(context.getRealPath("/imgArticles/Images/")+arti.getCodArt()+"/").exists();
        if(!isExist){
            new File (context.getRealPath("/imgArticles/Images/")+arti.getCodArt()+"/").mkdir();
            System.out.println("mk dir............");
        }

        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/imgArticles/Images/"+arti.getCodArt()+"/"+File.separator+newFileName));
        try {
            System.out.println("Image"); 
            org.apache.commons.io.FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
        }catch(Exception e){
            e.printStackTrace();
        }
        arti.setFileName(newFileName);

        try {
            service.addArticle(arti);
            return new ResponseEntity<>(arti, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(path="/Imgarticles/{codArt}")
    public byte[] getPhoto(@PathVariable("codArt") String codArt) throws Exception {
        Article Article = repository.findById(codArt).get();
        return Files.readAllBytes(Paths.get(context.getRealPath("/imgArticles/Images/")+Article.getCodArt()+"/"+Article.getFileName()));

    }
/*****************post article upload image */
    @GetMapping("/articles/{COD_ART}")
    public ResponseEntity<Article> getArticleById(@PathVariable("COD_ART") String codArt) {
        Optional<Article> articleData = repository.findById(codArt);

        if (articleData.isPresent()) {
            return new ResponseEntity<>(articleData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /** for seelect list */
    @GetMapping(value = "/bonPreps/miniListArticle")
    public ResponseEntity<List<Article>> getArticleOfAdd() {
        try {
            List<Article> ArticleListMini = service.getArticleOfAdd();

            if (ArticleListMini.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les article small kist*/
            }
            return new ResponseEntity<>(ArticleListMini, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(value = "/bonLivs/AllListMarqueNoDuplication")
    public ResponseEntity<List<String>> getArticleMarqueAddForBonLiv() {
        try {
            List<String> ArticleOwned = service.getArticleMarqueAddForBonLiv();

            if (ArticleOwned.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les marque without duplicate d article */
            }
            return new ResponseEntity<>(ArticleOwned, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    
    @GetMapping(value = "/bonLivs/AllListArticleByMarque/{id_model}")
    public ResponseEntity<List<Article>> getArticleOfFromMarqueAddForBonLiv(@PathVariable("id_model") long id_model) {
        try {
            List<Article> ArticleOwned = service.getArticleOfFromMarqueAddForBonLiv(id_model);

            if (ArticleOwned.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les article from the model */
            }
            return new ResponseEntity<>(ArticleOwned, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping(value = "/bonPreps/AllListArticleByMarque/{marque}")
    public ResponseEntity<List<Article>> getArticleOfFromMarqueAddForBonPrep(@PathVariable String marque) {
        try {
            List<Article> ArticleOwned = service.getArticleOfFromMarqueAddForBonPrep(marque);

            if (ArticleOwned.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les article from the marque */
            }
            return new ResponseEntity<>(ArticleOwned, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }


    @GetMapping(value = "/bonPreps/AllListMarqueNoDuplication")
    public ResponseEntity<List<String>> getArticleMarqueAddForBonPrep() {
        try {
            List<String> ArticleOwned = service.getArticleMarqueAddForBonPrep();

            if (ArticleOwned.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les marque without duplicate d article */
            }
            return new ResponseEntity<>(ArticleOwned, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    
    @GetMapping(value = "/bonPreps/AllListArticle")
    public ResponseEntity<List<Article>> getArticleOfAddForBonPrep() {
        try {
            List<Article> ArticleOwned = service.getArticleOfAddForBonPrep();

            if (ArticleOwned.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les Article existe ilkoll */
            }
            return new ResponseEntity<>(ArticleOwned, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(value = "/bonPreps/AllListArticleMissing")
    public ResponseEntity<List<Article>> getArticleNeedToAddForRectif() {
        try {
            List<Article> ArticleMissing = service.getArticleNeedToAddForRectif();

            if (ArticleMissing.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les Article don t existe ilkoll */
            }
            return new ResponseEntity<>(ArticleMissing, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(value = "/bonPreps/ListStockByArticle/{codArticle}")
    public ResponseEntity<List<Article>> getArticleFromStock(@PathVariable String codArticle) {
        try {
            List<Article> ArticleStocked = service.getArticleFromStock(codArticle);

            if (ArticleStocked.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les stock d article */
            }
            return new ResponseEntity<>(ArticleStocked, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }





    @GetMapping(value = "/articles/AllListMarque")
    public ResponseEntity<List<String>> getMarquesList() {
        try {
            List<String> MarqueOwned = service.getMarquesList();

            if (MarqueOwned.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les marque without duplicate d article */
            }
            return new ResponseEntity<>(MarqueOwned, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(value = "/articles/dateBetweenDAT_CREAT/{startDate}to{endDate}")
    public ResponseEntity<List<Article>> getAllArticleBydateBetweenDAT_CREAT(@PathVariable String startDate,@PathVariable String endDate) {
        try {
            List<Article> ArticleByDateBetween= service.getAllArticleBydateBetweenDAT_CREAT(startDate,endDate);
    
            if (ArticleByDateBetween.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les bon preparation entre 2 date */
            }
            return new ResponseEntity<>(ArticleByDateBetween, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping(value = "/articles/dateBetweenDER_ACH/{startDate}to{endDate}")
public ResponseEntity<List<Article>> getAllArticleBydateBetweenDER_ACH(@PathVariable String startDate,@PathVariable String endDate) {
    try {
        List<Article> ArticleByDateBetween= service.getAllArticleBydateBetweenDER_ACH(startDate,endDate);

        if (ArticleByDateBetween.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les bon preparation entre 2 date */
        }
        return new ResponseEntity<>(ArticleByDateBetween, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
@GetMapping(value = "/articles/dateBetweenDER_MVT/{startDate}to{endDate}")
public ResponseEntity<List<Article>> getAllArticleBydateBetweenDER_MVT(@PathVariable String startDate,@PathVariable String endDate) {
    try {
        List<Article> ArticleByDateBetween= service.getAllArticleBydateBetweenDER_MVT(startDate,endDate);

        if (ArticleByDateBetween.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les bon preparation entre 2 date */
        }
        return new ResponseEntity<>(ArticleByDateBetween, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
@GetMapping(value = "/articles/dateBetweenDAT_RUP/{startDate}to{endDate}")
public ResponseEntity<List<Article>> getAllArticleBydateBetweenDAT_RUP(@PathVariable String startDate,@PathVariable String endDate) {
    try {
        List<Article> ArticleByDateBetween= service.getAllArticleBydateBetweenDAT_RUP(startDate,endDate);

        if (ArticleByDateBetween.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les bon preparation entre 2 date */
        }
        return new ResponseEntity<>(ArticleByDateBetween, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
@GetMapping(value = "/articles/dateBetweenDAT_PACH/{startDate}to{endDate}")
public ResponseEntity<List<Article>> getAllArticleBydateBetweenDAT_PACH(@PathVariable String startDate,@PathVariable String endDate) {
    try {
        List<Article> ArticleByDateBetween= service.getAllArticleBydateBetweenDAT_PACH(startDate,endDate);

        if (ArticleByDateBetween.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les bon preparation entre 2 date */
        }
        return new ResponseEntity<>(ArticleByDateBetween, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}


    /** for seelect list */


    @GetMapping(value = "/bonSorts/AllListArticleByMarque/{marque}")
    public ResponseEntity<List<Article>> getArticleOfFromMarqueAddForBonSort(@PathVariable String marque) {
        try {
            List<Article> ArticleOwned = service.getArticleOfFromMarqueAddForBonSort(marque);

            if (ArticleOwned.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les article from the marque */
            }
            return new ResponseEntity<>(ArticleOwned, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }


    @GetMapping(value = "/bonSorts/AllListMarqueNoDuplication")
    public ResponseEntity<List<String>> getArticleMarqueAddForbonSort() {
        try {
            List<String> ArticleOwned = service.getArticleMarqueAddForBonSort();

            if (ArticleOwned.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les marque without duplicate d article */
            }
            return new ResponseEntity<>(ArticleOwned, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    
    @GetMapping(value = "/bonSorts/AllListArticle")
    public ResponseEntity<List<Article>> getArticleOfAddForBonSort() {
        try {
            List<Article> ArticleOwned = service.getArticleOfAddForBonSort();

            if (ArticleOwned.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les Article existe ilkoll */
            }
            return new ResponseEntity<>(ArticleOwned, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping(value = "/bonLivs/AllListArticle")
    public ResponseEntity<List<Article>> getArticleOfAddForBonLiv() {
        try {
            List<Article> ArticleOwned = service.getArticleOfAdd();

            if (ArticleOwned.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les Article existe ilkoll */
            }
            return new ResponseEntity<>(ArticleOwned, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping(value = "/bonSorts/ListStockByArticle/{codArticle}")
    public ResponseEntity<List<Article>> getArticleFromStockBS(@PathVariable("codArticle") String codArticle) {
        try {
            List<Article> ArticleStocked = service.getArticleFromStockBS(codArticle);

            if (ArticleStocked.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les stock d article */
            }
            return new ResponseEntity<>(ArticleStocked, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping(value = "/bonLivs/ListStockByArticle/{codArticle}")
    public ResponseEntity<List<Article>> getArticleFromStockBL(@PathVariable("codArticle") String codArticle) {
        try {
            List<Article> ArticleStocked = service.getArticleFromStockBL(codArticle);

            if (ArticleStocked.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les stock d article */
            }
            return new ResponseEntity<>(ArticleStocked, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(value = "/bonLivs/priAcha/{codArticle}")
    public long getArticlePrixAch(@PathVariable("codArticle") String codArticle) {

            long ArticleStocked = service.getArticlePrixAch(codArticle);            
            return ArticleStocked;

    }


@GetMapping(value = "/articles/ZONE/{centre}and{codArticle}")
public ResponseEntity<List<String>> getZoneArticle(@PathVariable("centre") String centre,@PathVariable("codArticle") String codArticle) {
    try {
        List<String> ZoneOwned = service.getZoneArticle(centre,codArticle);

        if (ZoneOwned.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les ZoneOwned */
        }
        return new ResponseEntity<>(ZoneOwned, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
    
    @PutMapping("/articles/{COD_ART}")
    public ResponseEntity<Article> UpdateStkArticle(@PathVariable("COD_ART") String codArt, @RequestBody Article article) {
        Optional<Article> articleData = repository.findById(codArt);

        if (articleData.isPresent()) {
            Article OldArticle = service.getArticleOrUpdate(codArt);
            Article _article = articleData.get();
            
            if(article.getQutStk()==null){
                article.setQutStk(0); 
            }
            if(OldArticle.getQutStk() == null){
                OldArticle.setQutStk(0);
            }
            /** Stk 1 */
            if(article.getQutStk2()==null){
                article.setQutStk2(0); 
            }
            if(OldArticle.getQutStk2() == null){
                OldArticle.setQutStk2(0);
            }
            /** Stk 2 */
            if(article.getStkGar()==null){
                article.setStkGar(0); 
                
            }
            if(OldArticle.getStkGar() == null){
                OldArticle.setStkGar(0);
            }
            /** Stk GAR */
            if(article.getStkIni()==null){
                article.setStkIni(0); 
            }
            if(OldArticle.getStkIni() == null){
                OldArticle.setStkGar(0);
            }
            /** Stk ANAL */
            if(article.getAnalStk()==null){
                article.setAnalStk(0); 
            }
            if(OldArticle.getAnalStk() == null){
                OldArticle.setAnalStk(0);
            }
            /** Stk NBJ */
            if(article.getNbjStk()==null){
                article.setNbjStk(0); 
            }
            if(OldArticle.getNbjStk() == null){
                OldArticle.setNbjStk(0);
            }
            /** Stk vS */
            if(article.getvSstk()==null){
                article.setvSstk(0); 
            }
            if(OldArticle.getvSstk() == null){
                OldArticle.setvSstk(0);
            }
            /** Stk COM */
            if(article.getComStk()==null){
                article.setComStk(0); 
            }
            if(OldArticle.getComStk() == null){
                OldArticle.setComStk(0);
            }
            /** Stk xANAL */
            if(article.getXanalStk()==null){
                article.setXanalStk(0);
            }
            if(OldArticle.getXanalStk() == null){
                OldArticle.setXanalStk(0);
            }
            /** Stk ATRSF */
            if(article.getStkAtrsf()==null){
                article.setStkAtrsf(0); 
            }
            if(OldArticle.getStkAtrsf() == null){
                OldArticle.setStkAtrsf(0);
            }
            /** Stk TRSF */
            if(article.getStkTrsf()==null){
                article.setStkTrsf(0);
            }
            if(OldArticle.getStkTrsf() == null){
                OldArticle.setStkTrsf(0);
            }
            /** Stk REEL */
            if(article.getStkReel()==null){
                article.setStkReel(0);
            }
            if(OldArticle.getStkReel() == null){
                OldArticle.setStkReel(0);
            }
            /** Stk RES */
            if(article.getStkRes()==null){
                article.setStkRes(0);
            }
            if(OldArticle.getStkRes() == null){
                OldArticle.setStkRes(0);
            }
            /** Stk NP */
            if(article.getStkNp()==null){
                article.setStkNp(0);
            }
            if(OldArticle.getStkNp() == null){
                OldArticle.setStkNp(0);
            }
            /** MODIFICATION */
            _article.setDerMvt(article.getDerMvt());
            _article.setQutStk(article.getQutStk()+OldArticle.getQutStk());
            _article.setQutStk2(article.getQutStk2()+OldArticle.getQutStk2());
            _article.setStkGar(article.getStkGar()+OldArticle.getStkGar());
            _article.setStkIni(article.getStkIni()+OldArticle.getStkIni());
            _article.setAnalStk(article.getAnalStk()+OldArticle.getAnalStk());
            _article.setNbjStk(article.getNbjStk()+OldArticle.getNbjStk());
            _article.setvSstk(article.getvSstk()+OldArticle.getvSstk());
            _article.setComStk(article.getComStk()+OldArticle.getComStk());
            _article.setXanalStk(article.getXanalStk()+OldArticle.getXanalStk());
            _article.setStkAtrsf(article.getStkAtrsf()+OldArticle.getStkAtrsf());
            _article.setStkTrsf(article.getStkTrsf()+OldArticle.getStkTrsf());
            _article.setStkReel(article.getStkReel()+OldArticle.getStkReel());
            _article.setStkRes(article.getStkRes()+OldArticle.getStkRes());
            _article.setStkNp(article.getStkNp()+OldArticle.getStkNp());
                
                return new ResponseEntity<>(service.UpdateStkArticle(_article), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }


        @PutMapping("/articles/OUT/{COD_ART}")
        public ResponseEntity<Article> UpdateStkArticleOut(@PathVariable("COD_ART") String codArt, @RequestBody Article article) {
            Optional<Article> articleData = repository.findById(codArt);
    
            if (articleData.isPresent()) {
                Article OldArticle = service.getArticleOrUpdate(codArt);
                Article _article = articleData.get();
                
                if(article.getQutStk() == null || article.getQutStk() <= 0){
                    article.setQutStk(0); 
                }
                if(OldArticle.getQutStk() == null || OldArticle.getQutStk() <= 0){
                    OldArticle.setQutStk(0);
                }
                /** Stk 1 */
                if(article.getQutStk2() == null || article.getQutStk2() <= 0){
                    article.setQutStk2(0); 
                }
                if(OldArticle.getQutStk2() == null || OldArticle.getQutStk2() <= 0){
                    OldArticle.setQutStk2(0);
                }
                /** Stk 2 */
                if(article.getStkGar() == null || article.getStkGar() <= 0){
                    article.setStkGar(0); 
                    
                }
                if(OldArticle.getStkGar() == null || OldArticle.getStkGar() <= 0){
                    OldArticle.setStkGar(0);
                }
                /** Stk GAR */
                if(article.getStkIni() == null || article.getStkIni() <= 0){
                    article.setStkIni(0); 
                }
                if(OldArticle.getStkIni() == null || OldArticle.getStkIni() <= 0){
                    OldArticle.setStkGar(0);
                }
                /** Stk ANAL */
                if(article.getAnalStk() == null || article.getAnalStk() <= 0){
                    article.setAnalStk(0); 
                }
                if(OldArticle.getAnalStk() == null || OldArticle.getAnalStk() <= 0){
                    OldArticle.setAnalStk(0);
                }
                /** Stk NBJ */
                if(article.getNbjStk() == null || article.getNbjStk() <= 0){
                    article.setNbjStk(0); 
                }
                if(OldArticle.getNbjStk() == null || OldArticle.getNbjStk() <= 0){
                    OldArticle.setNbjStk(0);
                }
                /** Stk vS */
                if(article.getvSstk() == null || article.getvSstk() <= 0){
                    article.setvSstk(0); 
                }
                if(OldArticle.getvSstk() == null || OldArticle.getvSstk() <= 0){
                    OldArticle.setvSstk(0);
                }
                /** Stk COM */
                if(article.getComStk() == null || article.getComStk() <= 0){
                    article.setComStk(0); 
                }
                if(OldArticle.getComStk() == null || OldArticle.getComStk() <= 0){
                    OldArticle.setComStk(0);
                }
                /** Stk xANAL */
                if(article.getXanalStk() == null || article.getXanalStk() <= 0){
                    article.setXanalStk(0);
                }
                if(OldArticle.getXanalStk() == null || OldArticle.getXanalStk() <= 0){
                    OldArticle.setXanalStk(0);
                }
                /** Stk ATRSF */
                if(article.getStkAtrsf() == null || article.getStkAtrsf() <= 0){
                    article.setStkAtrsf(0); 
                }
                if(OldArticle.getStkAtrsf() == null || OldArticle.getStkAtrsf() <= 0){
                    OldArticle.setStkAtrsf(0);
                }
                /** Stk TRSF */
                if(article.getStkTrsf() == null || article.getStkTrsf() <= 0){
                    article.setStkTrsf(0);
                }
                if(OldArticle.getStkTrsf() == null || OldArticle.getStkTrsf() <= 0){
                    OldArticle.setStkTrsf(0);
                }
                /** Stk REEL */
                if(article.getStkReel() == null || article.getStkReel() <= 0){
                    article.setStkReel(0);
                }
                if(OldArticle.getStkReel() == null || OldArticle.getStkReel() <= 0){
                    OldArticle.setStkReel(0);
                }
                /** Stk RES */
                if(article.getStkRes() == null || article.getStkRes() <= 0){
                    article.setStkRes(0);
                }
                if(OldArticle.getStkRes() == null || OldArticle.getStkRes() <= 0){
                    OldArticle.setStkRes(0);
                }
                /** Stk NP */
                if(article.getStkNp() == null || article.getStkNp() <= 0){
                    article.setStkNp(0);
                }
                if(OldArticle.getStkNp() == null || OldArticle.getStkNp() <= 0){
                    OldArticle.setStkNp(0);
                }


                /** MODIFICATION */
                Date date1 = new Date();
                Timestamp timestamp2 = new Timestamp(date1.getTime());
                _article.setDerMvt(timestamp2);
                System.out.println(timestamp2);
                _article.setQutStk(OldArticle.getQutStk()-article.getQutStk());
                _article.setQutStk2(OldArticle.getQutStk2()-article.getQutStk2());
                _article.setStkGar(OldArticle.getStkGar()-article.getStkGar());
                _article.setStkIni(OldArticle.getStkIni()-article.getStkIni());
                _article.setAnalStk(OldArticle.getAnalStk()-article.getAnalStk());
                _article.setNbjStk(OldArticle.getNbjStk()-article.getNbjStk());
                _article.setvSstk(OldArticle.getvSstk()-article.getvSstk());
                _article.setComStk(OldArticle.getComStk()-article.getComStk());
                _article.setXanalStk(OldArticle.getXanalStk()-article.getXanalStk());
                _article.setStkAtrsf(OldArticle.getStkAtrsf()-article.getStkAtrsf());
                _article.setStkTrsf(OldArticle.getStkTrsf()-article.getStkTrsf());
                _article.setStkReel(OldArticle.getStkReel()-article.getStkReel());
                _article.setStkRes(OldArticle.getStkRes()-article.getStkRes());
                _article.setStkNp(OldArticle.getStkNp()-article.getStkNp());
                
            /********** */
            if(_article.getQutStk() <= 0){
                _article.setQutStk(0); 
            }
            if(_article.getQutStk2() <= 0){
                _article.setQutStk2(0); 
            }
            if(_article.getStkGar() <= 0){
                _article.setStkGar(0); 
            }
            if(_article.getStkIni() <= 0){
                _article.setStkIni(0); 
            }
            if(_article.getAnalStk() <= 0){
                _article.setAnalStk(0); 
            }
            if(_article.getNbjStk() <= 0){
                _article.setNbjStk(0); 
            }
            if(_article.getvSstk() <= 0){
                _article.setvSstk(0); 
            }
            if(_article.getComStk() <= 0){
                _article.setComStk(0); 
            }
            if(_article.getXanalStk() <= 0){
                _article.setXanalStk(0); 
            }
            if(_article.getStkAtrsf() <= 0){
                _article.setStkAtrsf(0); 
            }
            if(_article.getStkTrsf() <= 0){
                _article.setStkTrsf(0); 
            }
            if(_article.getStkReel() <= 0){
                _article.setStkReel(0); 
            }
            if(_article.getStkRes() <= 0){
                _article.setStkRes(0); 
            }
            if(_article.getStkNp() <= 0){
                _article.setStkNp(0); 
            }
            
                    return new ResponseEntity<>(service.UpdateStkArticle(_article), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }

            @PutMapping("/articles/resetSTK/{COD_ART}")
            public ResponseEntity<Article> resetStkArticle(@PathVariable("COD_ART") String codArt) {
                Optional<Article> articleData = repository.findById(codArt);
        
                if (articleData.isPresent()) {
                    Article _article = articleData.get();
                    
                    _article.setQutStk(0);
                    _article.setQutStk2(0);
                    _article.setStkGar(0);
                    _article.setStkIni(0);
                    _article.setAnalStk(0);
                    _article.setNbjStk(0);
                    _article.setvSstk(0);
                    _article.setComStk(0);
                    _article.setXanalStk(0);
                    _article.setStkAtrsf(0);
                    _article.setStkTrsf(0);
                    _article.setStkReel(0);
                    _article.setStkRes(0);
                    _article.setStkNp(0);
                    return new ResponseEntity<>(service.updateArticle(_article), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }



            @PutMapping("/articles/ChangeAll/{COD_ART}")
            public ResponseEntity<Article> updateArticle(@PathVariable("COD_ART") String codArt, @RequestBody Article article) throws InterruptedException {
                Optional<Article> articleData = repository.findById(codArt);
                
                if (articleData.isPresent()) {
                    Article _article = articleData.get();
                    
                        _article.setRefOrg(article.getRefOrg());
                        _article.setRefRem(article.getRefRem());
                        _article.setDesArt(article.getDesArt());
                        _article.setCodNgp(article.getCodNgp());
                        _article.setMarque(article.getMarque());
                        _article.setNumCas(article.getNumCas());
                        _article.setUnitVen(article.getUnitVen());
                        _article.setPrixMin(article.getPrixMin());
                        _article.setPrixDev(article.getPrixDev());
                        _article.setCodFrs(article.getCodFrs());
                        _article.setDatPAch(article.getDatPAch());
                        _article.setDerPAch(article.getDerPAch());
                        _article.setRemise(article.getRemise());
                        _article.setPrixVen(article.getPrixVen());
                        _article.setPrixArem(article.getPrixArem());
                        _article.setTva(article.getTva());
                        _article.setCumulVen(article.getCumulVen());
                        _article.setCumulAch(article.getCumulAch());
                        _article.setUnitInv(article.getUnitInv());
                        _article.setControle(article.getControle());
                        _article.setModel(article.getModel());
                        _article.setEnergie(article.getEnergie());
                        _article.setPoids(article.getPoids());
                        _article.setDerAch(article.getDerAch());
                        _article.setDerMvt(article.getDerMvt());
                        _article.setClasse(article.getClasse());
                        _article.setTypAnal(article.getTypAnal());
                        _article.setCodBar(article.getCodBar());
                        _article.setPrixCEur(article.getPrixCEur());
                        _article.setPrixIni(article.getPrixIni());
                        _article.setCentre(article.getCentre());
                        _article.setDerPDev(article.getDerPDev());
                        _article.setPrixEuro(article.getPrixEuro());
                        _article.setDatRup(article.getDatRup());
                        _article.setDatPAch(article.getDatPAch());
                        _article.setQutStk(article.getQutStk());
                        _article.setQutStk2(article.getQutStk());
                        _article.setStkGar(article.getQutStk());
                        _article.setStkIni(article.getQutStk());
                        _article.setAnalStk(article.getQutStk());
                        _article.setNbjStk(article.getQutStk());
                        _article.setvSstk(article.getQutStk());
                        _article.setComStk(article.getQutStk());
                        _article.setXanalStk(article.getQutStk());
                        _article.setStkAtrsf(article.getQutStk());
                        _article.setStkTrsf(article.getQutStk());
                        _article.setStkReel(article.getQutStk());
                        _article.setStkRes(article.getQutStk());
                        _article.setStkNp(article.getQutStk());
                        
                        
                        return new ResponseEntity<>(service.updateArticle(_article), HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                    }
                }
   
                






   /**  statistique Articles */ 
   @GetMapping("/articles/SumSTKS1")
   public ResponseEntity<Optional<Integer>> getSum1() {
       try {
           Optional<Integer> SumSTKS1 = service.getSum1();  /** pour get Sum Quantité de Livraison */
           if (SumSTKS1.isEmpty()) {
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
           return new ResponseEntity<>(SumSTKS1, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       }
   }     
   @GetMapping("/articles/SumSTKS2")
   public ResponseEntity<Optional<Integer>> getSum2() {
       try {
           Optional<Integer> SumSTKS2 = service.getSum2();  /** pour get Sum Quantité de Livraison */
           if (SumSTKS2.isEmpty()) {
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
           return new ResponseEntity<>(SumSTKS2, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       }
   } 
   @GetMapping("/articles/SumSTKS3")
   public ResponseEntity<Optional<Integer>> getSum3() {
       try {
           Optional<Integer> SumSTKS3 = service.getSum3();  /** pour get Sum Quantité de Livraison */
           if (SumSTKS3.isEmpty()) {
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
           return new ResponseEntity<>(SumSTKS3, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       }
   }       
   @GetMapping("/articles/SumSTKS4")
   public ResponseEntity<Optional<Integer>> getSum4() {
       try {
           Optional<Integer> SumSTKS4 = service.getSum4();  /** pour get Sum Quantité de Livraison */
           if (SumSTKS4.isEmpty()) {
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
           return new ResponseEntity<>(SumSTKS4, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       }
   }
   @GetMapping("/articles/SumSTKS5")
   public ResponseEntity<Optional<Integer>> getSum5() {
       try {
           Optional<Integer> SumSTKS5 = service.getSum5();  /** pour get Sum Quantité de Livraison */
           if (SumSTKS5.isEmpty()) {
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
           return new ResponseEntity<>(SumSTKS5, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       }
   }
   @GetMapping("/articles/SumSTKS6")
   public ResponseEntity<Optional<Integer>> getSum6() {
       try {
           Optional<Integer> SumSTKS6 = service.getSum6();  /** pour get Sum Quantité de Livraison */
           if (SumSTKS6.isEmpty()) {
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
           return new ResponseEntity<>(SumSTKS6, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       }
   }
   @GetMapping("/articles/SumSTKS7")
   public ResponseEntity<Optional<Integer>> getSum7() {
       try {
           Optional<Integer> SumSTKS7 = service.getSum7();  /** pour get Sum Quantité de Livraison */
           if (SumSTKS7.isEmpty()) {
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
           return new ResponseEntity<>(SumSTKS7, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       }
   }
   @GetMapping("/articles/SumSTKS8")
   public ResponseEntity<Optional<Integer>> getSum8() {
       try {
           Optional<Integer> SumSTKS8 = service.getSum8();  /** pour get Sum Quantité de Livraison */
           if (SumSTKS8.isEmpty()) {
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
           return new ResponseEntity<>(SumSTKS8, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       }
   }
   @GetMapping("/articles/SumSTKS9")
   public ResponseEntity<Optional<Integer>> getSum9() {
       try {
           Optional<Integer> SumSTKS9 = service.getSum9();  /** pour get Sum Quantité de Livraison */
           if (SumSTKS9.isEmpty()) {
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
           return new ResponseEntity<>(SumSTKS9, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       }
   }
   @GetMapping("/articles/SumSTKS10")
   public ResponseEntity<Optional<Integer>> getSum10() {
       try {
           Optional<Integer> SumSTKS10 = service.getSum10();  /** pour get Sum Quantité de Livraison */
           if (SumSTKS10.isEmpty()) {
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
           return new ResponseEntity<>(SumSTKS10, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       }
   }
   @GetMapping("/articles/SumSTKS11")
   public ResponseEntity<Optional<Integer>> getSum11() {
       try {
           Optional<Integer> SumSTKS11 = service.getSum11();  /** pour get Sum Quantité de Livraison */
           if (SumSTKS11.isEmpty()) {
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
           return new ResponseEntity<>(SumSTKS11, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       }
   }
   @GetMapping("/articles/SumSTKS12")
   public ResponseEntity<Optional<Integer>> getSum12() {
       try {
           Optional<Integer> SumSTKS12 = service.getSum12();  /** pour get Sum Quantité de Livraison */
           if (SumSTKS12.isEmpty()) {
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
           return new ResponseEntity<>(SumSTKS12, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       }
   }
   @GetMapping("/articles/SumSTKS13")
   public ResponseEntity<Optional<Integer>> getSum13() {
       try {
           Optional<Integer> SumSTKS13 = service.getSum13();  /** pour get Sum Quantité de Livraison */
           if (SumSTKS13.isEmpty()) {
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
           return new ResponseEntity<>(SumSTKS13, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       }
   }
   @GetMapping("/articles/SumSTKS14")
   public ResponseEntity<Optional<Integer>> getSum14() {
       try {
           Optional<Integer> SumSTKS14 = service.getSum14();  /** pour get Sum Quantité de Livraison */
           if (SumSTKS14.isEmpty()) {
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
           return new ResponseEntity<>(SumSTKS14, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       }
   }





      /**  statistique  Bar Articles */ 

      @GetMapping("/articles/SumBar1")
      public ResponseEntity<Optional<Integer>> getSumBar1() {
          try {
              Optional<Integer> SumBar1 = service.getSumBar1();  /** pour get Sum Quantité de Livraison */
              if (SumBar1.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumBar1, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/articles/SumBar2")
      public ResponseEntity<Optional<Integer>> getSumBar2() {
          try {
              Optional<Integer> SumBar2 = service.getSumBar2();  /** pour get Sum Quantité de Livraison */
              if (SumBar2.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumBar2, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/articles/SumBar3")
      public ResponseEntity<Optional<Integer>> getSumBar3() {
          try {
              Optional<Integer> SumBar3 = service.getSumBar3();  /** pour get Sum Quantité de Livraison */
              if (SumBar3.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumBar3, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/articles/SumBar4")
      public ResponseEntity<Optional<Integer>> getSumBar4() {
          try {
              Optional<Integer> SumBar4 = service.getSumBar4();  /** pour get Sum Quantité de Livraison */
              if (SumBar4.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumBar4, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/articles/SumBar5")
      public ResponseEntity<Optional<Integer>> getSumBar5() {
          try {
              Optional<Integer> SumBar5 = service.getSumBar5();  /** pour get Sum Quantité de Livraison */
              if (SumBar5.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumBar5, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/articles/SumBar6")
      public ResponseEntity<Optional<Integer>> getSumBar6() {
          try {
              Optional<Integer> SumBar6 = service.getSumBar6();  /** pour get Sum Quantité de Livraison */
              if (SumBar6.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumBar6, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }
      @GetMapping("/articles/SumBar7")
      public ResponseEntity<Optional<Integer>> getSumBar7() {
          try {
              Optional<Integer> SumBar7 = service.getSumBar7();  /** pour get Sum Quantité de Livraison */
              if (SumBar7.isEmpty()) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              }
              return new ResponseEntity<>(SumBar7, HttpStatus.OK);
          } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
          }
      }

}
