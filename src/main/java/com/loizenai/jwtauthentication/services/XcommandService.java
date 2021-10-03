package com.loizenai.jwtauthentication.services;

import java.util.List;
import java.util.Optional;

import com.loizenai.jwtauthentication.model.Xcommand;
import com.loizenai.jwtauthentication.repository.XcommandRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XcommandService {
    

        
    @Autowired
    private XcommandRepository repository;

    public List<Xcommand> getXcommands(){
        return repository.findAll();
    }

    public Optional<Xcommand> getXcommand(long numCom){
        return repository.findById(numCom);
    }
    
    public List<Xcommand> getXcommandBlNull(){
        return repository.getXcommandBlNull();
    }

    
    public Xcommand updateXcommand(Xcommand xcommand){
        return repository.save(xcommand);
    }
}
