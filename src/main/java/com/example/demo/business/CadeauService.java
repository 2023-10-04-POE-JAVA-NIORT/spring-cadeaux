package com.example.demo.business;

import com.example.demo.dao.Cadeau;
import com.example.demo.dao.CadeauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadeauService {

    @Autowired
    CadeauRepository cadeauRepository;

    public List<Cadeau> getCadeaux(){
        return cadeauRepository.findAll();
    }

    public Optional<Cadeau> getCadeauById(Integer id){
        return cadeauRepository.findById(id);
    }

    public void addCadeau(Cadeau cadeau){
        cadeauRepository.save(cadeau);
    }

    public void deleteCadeau(Integer id){
        cadeauRepository.deleteById(id);
    }

    // Attention si l'id dans l'objet cadeau n'existe pas
    // dans la table SQL alors Hibernate va faire un INSERT
    public void update(Cadeau cadeau){
        cadeauRepository.save(cadeau);
    }
}
