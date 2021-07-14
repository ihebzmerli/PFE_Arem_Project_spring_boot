package com.loizenai.jwtauthentication.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import com.loizenai.jwtauthentication.model.Model;
import com.loizenai.jwtauthentication.repository.ModelRepository;
import com.loizenai.jwtauthentication.services.ModelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Date;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.FilenameUtils;
import org.springframework.boot.json.JsonParseException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ModelController {
    
    @Autowired
    private ModelService service;

    @Autowired
    ModelRepository repository;

    @Autowired
    ServletContext context;
    
    @GetMapping("/models")
    public ResponseEntity<List<Model>> getAllModels() {
        List<Model> models = new ArrayList<>();
        try {
            service.getModels().forEach(models::add);

            if (models.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(models, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/models/{id}")
    public ResponseEntity<Model> getModelsById(@PathVariable("id") Long id) {
        Optional<Model> modelData = repository.findById(id);

        if (modelData.isPresent()) {
            return new ResponseEntity<>(modelData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/models")
    public ResponseEntity<Model> postModel(@RequestBody Model model) {
        try {
            service.addModel(model);
            return new ResponseEntity<>(model, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }


    @DeleteMapping("/models/{id}")
    public ResponseEntity<HttpStatus> deleteModel(@PathVariable("id") Long id) {
        try {
            service.deleteModel(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
   



    /********************  drop list  **************/

    @GetMapping(value = "/models/getByMarque/{marque_id}")
    public ResponseEntity<List<Model>> getAllModelByMarque(@PathVariable long marque_id) {
        try {
            List<Model> modelByMarque = service.getAllModelByMarque(marque_id);

            if (modelByMarque.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);     /** pour afficher les model By Marque */
            }
            return new ResponseEntity<>(modelByMarque, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }



    @PutMapping("/models/{id}")
    public ResponseEntity<Model> updateModel(@PathVariable("id") long id, @RequestBody Model model) {
        Optional<Model> modelData = repository.findById(id);

        if (modelData.isPresent()) {
            Model _model = modelData.get();
            _model.setCode(model.getCode());
            _model.setTitle(model.getTitle());
            _model.setMarque(model.getMarque());

            return new ResponseEntity<>(service.updateModel(_model), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
