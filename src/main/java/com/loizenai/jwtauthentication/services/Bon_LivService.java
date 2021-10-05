package com.loizenai.jwtauthentication.services;

import java.util.List;
import java.util.Optional;
import com.loizenai.jwtauthentication.model.BonLiv;
import com.loizenai.jwtauthentication.repository.Bon_LivRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Bon_LivService {


    @Autowired
    private Bon_LivRepository repository;

    public List<BonLiv> getBonLivs(){
        return repository.findAll();
    }

    public void addBonLiv(BonLiv bonLiv){
/*        Optional<Expide> optionalExpide = expideRepository.findById(bonLiv.getExpide().getId());
        bonLiv.setExpide(optionalExpide.get());

//        expideRepository.save(bonLiv.getExpide());
*/
        repository.save(bonLiv);
    }

    public Optional<BonLiv> getBonLiv(String numBon){
        return repository.findById(numBon);
    }

    public BonLiv updateBonLiv(BonLiv bonLiv){
        return repository.save(bonLiv);
    }

    public void deleteBonLiv(String numBon){
        repository.deleteById(numBon);
    }

    public static String removeCharacterV1(String str, char ch) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            throw new IllegalArgumentException("Input String can't be null");
        }

        StringBuilder sb = new StringBuilder();
        char[] chArray = str.toCharArray();
        for (int i = 0; i < chArray.length; i++) {
            if (chArray[i] != ch) {
                sb.append(chArray[i]);
            }
        }

        return sb.toString();
    }

    public List<String> getNumDocFactureForBonLiv(){
        return repository.getNumDocFactureForBonLiv();
    }

    public List<BonLiv> getBLEnvoyer(){
        return repository.getBLEnvoyer();
    }
    public List<BonLiv> getBLEnvoyerComptoir(){
        return repository.getBLEnvoyerComptoir();
    }
    
/** end drop down list */

    public List<BonLiv> getBonLivOfAdd(){
        return repository.getBonLivOfAdd();
    }

/** end drop down list */


        /** start les searsh from repository */
        public List<BonLiv> getAllBonLivByBonLi(String numBonL){
            return repository.getAllBonLivByBonLi(numBonL);
        }
    
        public List<BonLiv> getAllBonLivByClient(String codcli){
            return repository.getAllBonLivByClient(codcli);
        }
    
        public List<BonLiv> getAllBonLivBydateBetween(String startDate, String endDate){
            return repository.getAllBonLivBydateBetween(startDate,endDate);
        }
    
        public List<BonLiv> getAllBonLivByNumFac(String numfac){
            return repository.getAllBonLivByNumFac(numfac);
        }
    
        public List<BonLiv> getAllBonLivByTrasaction(String cod_frs){
            return repository.getAllBonLivByTrasaction(cod_frs);
        }

        public List<String> getAllBonLivByCodFrs(Long cod_frs){
            return repository.getAllBonLivByCodFrs(cod_frs);
        }

        public List<BonLiv> getAllBonLivByExpidetion(String id_expide){
            return repository.getAllBonLivByExpidetion(id_expide);
        }

        public List<BonLiv> getAllBonLivByCentre(String centre){
            return repository.getAllBonLivByCentre(centre);
        }

        public List<BonLiv> getAllBonLivByPointage(String pointage){
            return repository.getAllBonLivByPointage(pointage);
        }

        public List<BonLiv> getAllBonLivByCommand(String command){
            return repository.getAllBonLivByCommand(command);
        }
        /** end searsh */








/**statistique Bon Liv  3D*/

public Optional<String> getMinChrono(){
    return repository.getMinChrono();
}
public Optional<String> getMaxChrono(){
    return repository.getMaxChrono();
}
public List<Long> getSumAvgF1(){
    return repository.getSumAvgF1();
}
public List<Float> getSumAvgF2(){
    return repository.getSumAvgF2();
}
public List<String> getSumAvgC1(){
    return repository.getSumAvgC1();
}
public List<Float> getSumAvgC2(){
    return repository.getSumAvgC2();
}



/**statistique Pie Bon Liv  */

public Optional<Integer> getSumR(){
    return repository.getSumR();
}
public Optional<Integer> getSumE(){
    return repository.getSumE();
}



    /**statistique Bar Bon Liv */

public Optional<Float> getSumBar1(){
    return repository.getSumBar1();
}
public Optional<Float> getSumBar2(){
    return repository.getSumBar2();
}
public Optional<Float> getSumBar3(){
    return repository.getSumBar3();
}
public Optional<Float> getSumBar4(){
    return repository.getSumBar4();
}
public Optional<Float> getSumBar5(){
    return repository.getSumBar5();
}
public Optional<Float> getSumBar6(){
    return repository.getSumBar6();
}
public Optional<Float> getSumBar7(){
    return repository.getSumBar7();
}
}
