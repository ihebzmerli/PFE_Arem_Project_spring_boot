package com.loizenai.jwtauthentication.services;

import java.util.List;

import com.loizenai.jwtauthentication.model.Rectif;
import com.loizenai.jwtauthentication.repository.RectifRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RectifService {
        
    @Autowired
    private RectifRepository repository;

    public List<Rectif> getRectifs(){
        return repository.findAll();
    }

    public void addRectif(Rectif rectif){
        repository.save(rectif);
    }

    public Rectif updateRectif(Rectif rectif){
       return repository.save(rectif);
    }

    public void deleteRectif(long id){
        repository.deleteById(id);
    }


    /** start les searsh from repository */   


    public List<Rectif>getAllRectifByAchats(String numDoc){
        return repository.getAllRectifByAchats(numDoc);
    }

    public List<Rectif>getAllRectifBydateBetween(String startDate,String endDate){
        return repository.getAllRectifBydateBetween(startDate,endDate);
    }

    public List<Rectif>getAllRectifByQutArt(String MinQ_art,String MaxQ_art){
        return repository.getAllRectifByQutArt(MinQ_art,MaxQ_art);
    }

    public List<Rectif>getAllRectifByPrixAch(String MinP_ach,String MaxP_ach){
        return repository.getAllRectifByPrixAch(MinP_ach,MaxP_ach);
    }

    public List<Rectif>getAllRectifByTyMvt(String Ty_mvt){
        return repository.getAllRectifByTyMvt(Ty_mvt);
    }

    public List<Rectif>getAllRectifByNumRec(String Numrec){
        return repository.getAllRectifByNumRec(Numrec);
    }

    public List<Rectif>getAllRectifByCentre(String center){
        return repository.getAllRectifByCentre(center);
    }

    public List<Rectif>getAllRectifBydateReclamBetween(String startDateReclama,String endDateReclama){
        return repository.getAllRectifBydateReclamBetween(startDateReclama,endDateReclama);
    }

    public List<Rectif>getAllRectifBydateReponBetween(String startDateRepon,String endDateRepon){
        return repository.getAllRectifBydateReponBetween(startDateRepon,endDateRepon);
    }

    public List<Rectif>getAllRectifBydateCloturBetween(String startDateClotur,String endDateClotur){
        return repository.getAllRectifBydateCloturBetween(startDateClotur,endDateClotur);
    }
    /** end les searsh from repository */
}
