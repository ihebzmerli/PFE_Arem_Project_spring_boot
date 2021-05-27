package com.loizenai.jwtauthentication.services;

import java.util.List;

import com.loizenai.jwtauthentication.model.DetPrep;
import com.loizenai.jwtauthentication.repository.Det_PrepRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Det_PrepService {
        
    @Autowired
    private Det_PrepRepository repository;

    public List<DetPrep> getDetPreps(){
        return repository.findAll();
    }

    public void addDetPrep(DetPrep detPrep){
        repository.save(detPrep);
    }

    public DetPrep updateDetPrep(DetPrep detPrep){
       return repository.save(detPrep);
    }

    public void deleteDetPrep(Long id){
        repository.deleteById(id);
    }

    public List<DetPrep> getAllDetPrepByZone(String zone){
        return repository.getAllDetPrepByZone(zone);
    }

    public List<DetPrep> getAllDetPrepByPrepara(String preparateur){
        return repository.getAllDetPrepByPrepara(preparateur);
    }

    public List<DetPrep> getAllDetPrepByBonPrep(String idprepra){
        return repository.getAllDetPrepByBonPrep(idprepra);
    }

}
