package com.example.projet.projet.modele.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.Objects;

@XmlRootElement
public class PersonneDto {
    @NotNull
    private String nom;
    @NotNull
    private String prenom;
    private String adresse;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Length(min =12, max = 12)
    private String telephone;
    @NotNull
    private String dateNaissance;
    private String sexe;

    public PersonneDto() {

    }

    public PersonneDto(String nom, String prenom, String adresse, String email, String telephone, String dateNaissance, String sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
    }

    @XmlElement (name = "IdPar")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlElement (name = "Prenom")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @XmlElement (name = "Adresse")
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @XmlElement (name = "Mail")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElement (name = "NumTel")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @XmlElement (name = "DateNais")
    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @XmlElement (name = "Sexe")
    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PersonneDto that)) return false;
        return Objects.equals(nom, that.nom) && Objects.equals(prenom, that.prenom) && Objects.equals(adresse, that.adresse) && Objects.equals(email, that.email) && Objects.equals(telephone, that.telephone) && Objects.equals(dateNaissance, that.dateNaissance) && Objects.equals(sexe, that.sexe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, adresse, email, telephone, dateNaissance, sexe);
    }
}

