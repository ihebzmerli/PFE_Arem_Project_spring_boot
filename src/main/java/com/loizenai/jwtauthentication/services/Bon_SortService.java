package com.loizenai.jwtauthentication.services;

import java.util.List;

import com.loizenai.jwtauthentication.model.BonSort;
import com.loizenai.jwtauthentication.model.Fournis;
import com.loizenai.jwtauthentication.repository.Bon_SortRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Bon_SortService {
          
    @Autowired
    private Bon_SortRepository repository;


    public List<BonSort> getBonSorts(){
        return repository.findAll();
    }

    public void addBonSort(BonSort bonSort){
        repository.save(bonSort);
    }

    public BonSort updateBonSort(BonSort bonSort){
       return repository.save(bonSort);
    }

    public void deleteBonSort(String numBon){
        repository.deleteById(numBon);
    }  



    /** start les searsh from repository */

    public List<BonSort> getBonSortEncoreEnStock(){
        return repository.getBonSortEncoreEnStock();
    }

    public List<BonSort> getAllBonSortDeMemeBonPreparation(String numBonprep){
        return repository.getAllBonSortDeMemeBonPreparation(numBonprep);
    }

    public List<BonSort> getAllBonSortByCentre(String centre){
        return repository.getAllBonSortByCentre(centre);
    }

    public List<BonSort> getAllBonSortByUser(long id){
        return repository.getAllBonSortByUser(id);
    }

    public List<BonSort> getAllBonSortBydateBetween(String startDate,String endDate){
        return repository.getAllBonSortBydateBetween(startDate,endDate);
    }
    /** end searsh */
}
