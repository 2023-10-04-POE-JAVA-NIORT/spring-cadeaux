package com.example.demo.api;

import com.example.demo.dao.Cadeau;
import com.example.demo.dao.ListeCadeau;

public class CadeauMapper {

    public static CadeauDTO convertFromEntityToDto(Cadeau entity){
        CadeauDTO dto = new CadeauDTO();
        dto.setNom(entity.getNom());
        dto.setDescription(entity.getDescription());
        dto.setPrix(entity.getPrix()+" €");
        dto.setListeCadeau(entity.getListeCadeau().getNom());
        return dto;
    }

    public static Cadeau convertFromDtoToEntity(CadeauPostDTO dto){
        Cadeau entity = new Cadeau();
        entity.setNom(dto.getNom());
        entity.setDescription(dto.getDescription());
        entity.setPrix(dto.getPrix());
        ListeCadeau listeCadeau = new ListeCadeau();
        listeCadeau.setId(dto.getListeCadeauId());
        entity.setListeCadeau(listeCadeau);
        return entity;
    }
}
