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


    /**roles modification for update user */


    public void ChangeRoleToUSER(long id){
        repository.ChangeRoleToUSER(id);
    }
    public void ChangeRoleToADMIN(long id){
        repository.ChangeRoleToADMIN(id);
    }
    public void ChangeRoleToACHETEUR(long id){
        repository.ChangeRoleToACHETEUR(id);
    }
    public void ChangeRoleToTRANSITAIRE(long id){
        repository.ChangeRoleToTRANSITAIRE(id);
    }
    public void ChangeRoleToCLIENT(long id){
        repository.ChangeRoleToCLIENT(id);
    }
    public void ChangeRoleToVENDEUR(long id){
        repository.ChangeRoleToVENDEUR(id);
    }
    public void ChangeRoleToDECIDEUR_BP(long id){
        repository.ChangeRoleToDECIDEUR_BP(id);
    }
    public void ChangeRoleToAGENT_CAB(long id){
        repository.ChangeRoleToAGENT_CAB(id);
    }
    public void ChangeRoleToPREPARATEUR_BR(long id){
        repository.ChangeRoleToPREPARATEUR_BR(id);
    }
    public void ChangeRoleToRESPONSABLE_DISPATCHING_BP(long id){
        repository.ChangeRoleToRESPONSABLE_DISPATCHING_BP(id);
    }
    public void ChangeRoleToPREPARATEUR(long id){
        repository.ChangeRoleToPREPARATEUR(id);
    }
    public void ChangeRoleToVALIDATEUR_DE_CHARIOT(long id){
        repository.ChangeRoleToVALIDATEUR_DE_CHARIOT(id);
    }
    public void ChangeRoleToRESPONSABLE_POINTAGE(long id){
        repository.ChangeRoleToRESPONSABLE_POINTAGE(id);
    }
    public void ChangeRoleToEMBALLEUR(long id){
        repository.ChangeRoleToEMBALLEUR(id);
    }
    public void ChangeRoleToEXPEDITEUR(long id){
        repository.ChangeRoleToEXPEDITEUR(id);
    }
    public void ChangeRoleToAGENT_SAISIE_REG(long id){
        repository.ChangeRoleToAGENT_SAISIE_REG(id);
    }
    public void ChangeRoleToCAISSIER(long id){
        repository.ChangeRoleToCAISSIER(id);
    }
    public void ChangeRoleToRESPONSABLE_SERVICE_FRS_ETRANGER(long id){
        repository.ChangeRoleToRESPONSABLE_SERVICE_FRS_ETRANGER(id);
    }
    public void ChangeRoleToRESPONSABLE_SERVICE_FRS_LOCAL(long id){
        repository.ChangeRoleToRESPONSABLE_SERVICE_FRS_LOCAL(id);
    }
}
