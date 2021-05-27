package com.loizenai.jwtauthentication.services;

import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.EtatLiv;
import com.loizenai.jwtauthentication.repository.Etat_LivRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Etat_LivService {
       
    @Autowired
    private Etat_LivRepository repository;

    public List<EtatLiv> getEtatLivs(){
        return repository.findAll();
    }

    public void addEtatLiv(EtatLiv etatLiv){
        repository.save(etatLiv);
    }

    public EtatLiv updateEtatLiv(EtatLiv etatLiv){
       return repository.save(etatLiv);
    }

    public void deleteEtatLiv(long id){
        repository.deleteById(id);
    } 

    public List<EtatLiv>getAllEtatLivByRegion(String region){
        return repository.getAllEtatLivByRegion(region);
    }

    public List<EtatLiv>getAllEtatLivBydateBetween(String startDate,String endDate){
        return repository.getAllEtatLivBydateBetween(startDate,endDate);
    }

    public List<EtatLiv>getAllEtatLivByBL(String bon_liv){
        return repository.getAllEtatLivByBL(bon_liv);
    }

    public Optional<Integer> getEtatCronometre(String endDate,String startDate){
        return repository.getEtatCronometre(endDate,startDate);
    }







        /**statistique X ANEX ETAT liv */
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
    public Optional<Integer> getSumBar8(){
        return repository.getSumBar8();
    }
    public Optional<Integer> getSumBar9(){
        return repository.getSumBar9();
    }
    public Optional<Integer> getSumBar10(){
        return repository.getSumBar10();
    }
    public Optional<Integer> getSumBar11(){
        return repository.getSumBar11();
    }
    public Optional<Integer> getSumBar12(){
        return repository.getSumBar12();
    }




    /*********2 */
    public Optional<Integer> getSumBar21(){
        return repository.getSumBar21();
    }

    public Optional<Integer> getSumBar22(){
        return repository.getSumBar22();
    }
    public Optional<Integer> getSumBar23(){
        return repository.getSumBar23();
    }
    public Optional<Integer> getSumBar24(){
        return repository.getSumBar24();
    }
    public Optional<Integer> getSumBar25(){
        return repository.getSumBar25();
    }
    public Optional<Integer> getSumBar26(){
        return repository.getSumBar26();
    }
    public Optional<Integer> getSumBar27(){
        return repository.getSumBar27();
    }
    public Optional<Integer> getSumBar28(){
        return repository.getSumBar28();
    }
    public Optional<Integer> getSumBar29(){
        return repository.getSumBar29();
    }
    public Optional<Integer> getSumBar210(){
        return repository.getSumBar211();
    }
    public Optional<Integer> getSumBar211(){
        return repository.getSumBar211();
    }
    public Optional<Integer> getSumBar212(){
        return repository.getSumBar212();
    }




    /******** */

    public Optional<Integer> getSumBar31(){
        return repository.getSumBar31();
    }
    public Optional<Integer> getSumBar32(){
        return repository.getSumBar32();
    }
    public Optional<Integer> getSumBar33(){
        return repository.getSumBar33();
    }
    public Optional<Integer> getSumBar34(){
        return repository.getSumBar34();
    }
    public Optional<Integer> getSumBar35(){
        return repository.getSumBar35();
    }
    public Optional<Integer> getSumBar36(){
        return repository.getSumBar36();
    }
    public Optional<Integer> getSumBar37(){
        return repository.getSumBar37();
    }
    public Optional<Integer> getSumBar38(){
        return repository.getSumBar38();
    }
    public Optional<Integer> getSumBar39(){
        return repository.getSumBar39();
    }
    public Optional<Integer> getSumBar310(){
        return repository.getSumBar310();
    }
    public Optional<Integer> getSumBar311(){
        return repository.getSumBar311();
    }
    public Optional<Integer> getSumBar312(){
        return repository.getSumBar312();
    }





    /************* */
    public Optional<Integer> getSumBar41(){
        return repository.getSumBar41();
    }
    public Optional<Integer> getSumBar42(){
        return repository.getSumBar42();
    }
    public Optional<Integer> getSumBar43(){
        return repository.getSumBar43();
    }
    public Optional<Integer> getSumBar44(){
        return repository.getSumBar44();
    }
    public Optional<Integer> getSumBar45(){
        return repository.getSumBar45();
    }
    public Optional<Integer> getSumBar46(){
        return repository.getSumBar46();
    }
    public Optional<Integer> getSumBar47(){
        return repository.getSumBar47();
    }
    public Optional<Integer> getSumBar48(){
        return repository.getSumBar48();
    }
    public Optional<Integer> getSumBar49(){
        return repository.getSumBar49();
    }
    public Optional<Integer> getSumBar410(){
        return repository.getSumBar410();
    }
    public Optional<Integer> getSumBar411(){
        return repository.getSumBar411();
    }
    public Optional<Integer> getSumBar412(){
        return repository.getSumBar412();
    }


}
