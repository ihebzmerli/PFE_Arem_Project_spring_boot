package com.loizenai.jwtauthentication.services;
import java.util.List;

import com.loizenai.jwtauthentication.model.Model;
import com.loizenai.jwtauthentication.repository.ModelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelService {
        

    @Autowired
    private ModelRepository repository;

    
    public List<Model> getModels(){
        return repository.findAll();
    }

    public void addModel(Model model){
        repository.save(model);
    }

    public Model updateModel(Model model){
       return repository.save(model);
    }

    public void deleteModel(Long id){
        repository.deleteById(id);
    }




    /** end drop down list */


        /** start les searsh from repository */
        public List<Model> getAllModelByMarque(Long marque_id){
            return repository.getAllModelByMarque(marque_id);
        }
}
