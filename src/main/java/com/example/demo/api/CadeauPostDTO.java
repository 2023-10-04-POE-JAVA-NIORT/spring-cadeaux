package com.example.demo.api;

public class CadeauPostDTO {

    private String nom;
    private String description;
    private Float prix;
    private Integer listeCadeauId;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Integer getListeCadeauId() {
        return listeCadeauId;
    }

    public void setListeCadeauId(Integer listeCadeauId) {
        this.listeCadeauId = listeCadeauId;
    }
}
