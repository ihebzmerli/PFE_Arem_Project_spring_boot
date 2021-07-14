package com.loizenai.jwtauthentication.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import com.loizenai.jwtauthentication.model.Marque;
import com.loizenai.jwtauthentication.repository.MarqueRepository;
import com.loizenai.jwtauthentication.services.MarqueService;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.FilenameUtils;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class MarqueController {
    
    @Autowired
    private MarqueService service;

    @Autowired
    MarqueRepository repository;

    @Autowired
    ServletContext context;
    
    @GetMapping("/marques")
    public ResponseEntity<List<Marque>> getAllMarques() {
        List<Marque> marques = new ArrayList<>();
        try {
            service.getMarques().forEach(marques::add);

            if (marques.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(marques, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/marques/{id}")
    public ResponseEntity<Marque> getMarquesById(@PathVariable("id") Long id) {
        Optional<Marque> marqueData = repository.findById(id);

        if (marqueData.isPresent()) {
            return new ResponseEntity<>(marqueData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/marques")
    public ResponseEntity<Marque> postMarque(@RequestBody Marque marque) {
        try {
            service.addMarque(marque);
            return new ResponseEntity<>(marque, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

/*****************post marque upload image */

@PostMapping(value = "/marquesTest")
public ResponseEntity<Marque> postMarqueTest(@RequestParam("file") MultipartFile file,@RequestParam("marque") String marque)
throws JsonParseException , JsonMappingException , Exception
{
    System.out.println("OK............");
    Marque marqu =  new ObjectMapper().readValue(marque,Marque.class);
    boolean isExist = new File(context.getRealPath("/imgMarques/Images/")+marqu.getCode()+"/").exists();
    if(!isExist){
        new File (context.getRealPath("/imgMarques/Images/")+marqu.getCode()+"/").mkdir();
        System.out.println("mk dir............");
    }

    String filename = file.getOriginalFilename();
    String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
    File serverFile = new File (context.getRealPath("/imgMarques/Images/"+marqu.getCode()+"/"+File.separator+newFileName));
    try {
        System.out.println("Image"); 
        org.apache.commons.io.FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
    }catch(Exception e){
        e.printStackTrace();
    }
    marqu.setFileName(newFileName);

    try {
        service.addMarque(marqu);
        return new ResponseEntity<>(marqu, HttpStatus.CREATED);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
    }
}

@GetMapping(path="/Imgmarques/{id}")
public byte[] getPhoto(@PathVariable("id") Long id) throws Exception {
    Marque Marque = repository.findById(id).get();
    return Files.readAllBytes(Paths.get(context.getRealPath("/imgMarques/Images/")+Marque.getCode()+"/"+Marque.getFileName()));

}
/*****************post article upload image */

    @DeleteMapping("/marques/{id}")
    public ResponseEntity<HttpStatus> deleteMarque(@PathVariable("id") Long id) {
        try {
            service.deleteMarque(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }




/*****************post article upload image */
    @PutMapping("/marques/Update/{id}")
    public ResponseEntity<Marque> updateMarque(@PathVariable("id") long id, @RequestParam("file") MultipartFile file,@RequestParam("marque") String marque)
    throws JsonParseException , JsonMappingException , Exception {
        Optional<Marque> marqueData = repository.findById(id);

        if (marqueData.isPresent()) {
            Marque _marque = marqueData.get();

            System.out.println("OK............");
            Marque marqu =  new ObjectMapper().readValue(marque,Marque.class);
            boolean isExist = new File(context.getRealPath("/imgMarques/Images/")+marqu.getCode()+"/").exists();
            if(!isExist){

                //deleteDirectory(new File (context.getRealPath("/imgMarques/Images/")+_marque.getCode()+"/"));

                new File (context.getRealPath("/imgMarques/Images/")+marqu.getCode()+"/").mkdir();
                System.out.println("mk dir............");
            }
        
/*            if(!(marqu.getFileName().equals(_marque.getFileName()))){
                
                File filedeleted = new File (context.getRealPath("/imgMarques/Images/"+_marque.getCode()+"/"+_marque.getFileName()));
                filedeleted.delete();
            }
            */
            String filename = file.getOriginalFilename();
            String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
            File serverFile = new File (context.getRealPath("/imgMarques/Images/"+marqu.getCode()+"/"+File.separator+newFileName));
            try {
                System.out.println("Image"); 
                org.apache.commons.io.FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
            }catch(Exception e){
                e.printStackTrace();
            }
            _marque.setFileName(newFileName);

            _marque.setCode(marqu.getCode());
            _marque.setTitle(marqu.getTitle());

            service.updateMarque(_marque);
            System.out.println(_marque); 
            return new ResponseEntity<>(_marque, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
        
    }

    /*****************post article upload image */

    @PutMapping("/marques/{id}")
    public ResponseEntity<Marque> updateModel(@PathVariable("id") long id, @RequestBody Marque marque) {
        Optional<Marque> marqueData = repository.findById(id);

        if (marqueData.isPresent()) {
            Marque _marque = marqueData.get();
            _marque.setCode(marque.getCode());
            _marque.setTitle(marque.getTitle());

            return new ResponseEntity<>(service.updateMarque(_marque), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    /***delete directory in java for marque update and delete*/

    boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }
}
