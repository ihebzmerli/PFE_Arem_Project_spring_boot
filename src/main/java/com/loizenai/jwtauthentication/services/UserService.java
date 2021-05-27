package com.loizenai.jwtauthentication.services;

import com.loizenai.jwtauthentication.model.Role;
import com.loizenai.jwtauthentication.model.User;
import com.loizenai.jwtauthentication.repository.RoleRepository;
import com.loizenai.jwtauthentication.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
            
    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository repositoryRole;

    public List<User> getUsers(){
        return repository.findAll();
    }

    public void addUser(User user){
        repository.save(user);
    }

    public User updateUser(User user){
        return repository.save(user);
    }

    public void deleteUser(long id){
        repository.deleteById(id);
    }


    public List<Role> getAllRoles(){
        return repositoryRole.getAllRoles();
    }
    


    
/**statistique Pie Bon Liv  */

public Optional<Integer> getSumROLE_USER(){
    return repository.getSumROLE_USER();
}
public Optional<Integer> getSumROLE_ADMIN(){
    return repository.getSumROLE_ADMIN();
}
public Optional<Integer> getSumROLE_ACHETEUR(){
    return repository.getSumROLE_ACHETEUR();
}
public Optional<Integer> getSumROLE_TRANSITAIRE(){
    return repository.getSumROLE_TRANSITAIRE();
}
public Optional<Integer> getSumROLE_CLIENT(){
    return repository.getSumROLE_CLIENT();
}
public Optional<Integer> getSumROLE_VENDEUR(){
    return repository.getSumROLE_VENDEUR();
}
public Optional<Integer> getSumROLE_DECIDEUR_BP(){
    return repository.getSumROLE_DECIDEUR_BP();
}
public Optional<Integer> getSumROLE_AGENT_CAB(){
    return repository.getSumROLE_AGENT_CAB();
}
public Optional<Integer> getSumROLE_PREPARATEUR_BR(){
    return repository.getSumROLE_PREPARATEUR_BR();
}
public Optional<Integer> getSumROLE_RESPONSABLE_DISPATCHING_BP(){
    return repository.getSumROLE_RESPONSABLE_DISPATCHING_BP();
}
public Optional<Integer> getSumROLE_PREPARATEUR(){
    return repository.getSumROLE_PREPARATEUR();
}
public Optional<Integer> getSumROLE_VALIDATEUR_DE_CHARIOT(){
    return repository.getSumROLE_VALIDATEUR_DE_CHARIOT();
}
public Optional<Integer> getSumROLE_RESPONSABLE_POINTAGE(){
    return repository.getSumROLE_RESPONSABLE_POINTAGE();
}
public Optional<Integer> getSumROLE_EMBALLEUR(){
    return repository.getSumROLE_EMBALLEUR();
}
public Optional<Integer> getSumROLE_EXPEDITEUR(){
    return repository.getSumROLE_EXPEDITEUR();
}
public Optional<Integer> getSumROLE_AGENT_SAISIE_REG(){
    return repository.getSumROLE_AGENT_SAISIE_REG();
}
public Optional<Integer> getSumROLE_CAISSIER(){
    return repository.getSumROLE_CAISSIER();
}
public Optional<Integer> getSumROLE_RESPONSABLE_SERVICE_FRS_ETRANGER(){
    return repository.getSumROLE_RESPONSABLE_SERVICE_FRS_ETRANGER();
}
public Optional<Integer> getSumROLE_RESPONSABLE_SERVICE_FRS_LOCAL(){
    return repository.getSumROLE_RESPONSABLE_SERVICE_FRS_LOCAL();
}
}
