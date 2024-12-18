package com.example.projet.projet.modele.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.Objects;

@XmlRootElement(name = "RolesPersonnel", namespace = "http://www.example.com/RolesPersonnel")
public class RolePersonnelDto {
    @NotNull
    private long idRolePersonnel;
    @NotNull
    private String nomRolePersonnel;
    @Size(min = 10, max = 200)
    private String descriptionRolePersonnel;

    public RolePersonnelDto() {

    }

    public RolePersonnelDto(long idRolePersonnel, String nomRolePersonnel, String descriptionRolePersonnel) {
        this.idRolePersonnel = idRolePersonnel;
        this.nomRolePersonnel = nomRolePersonnel;
        this.descriptionRolePersonnel = descriptionRolePersonnel;
    }

    @XmlElement (name = "IdRolePerso")
    public long getIdRolePersonnel() {
        return idRolePersonnel;
    }

    public void setIdRolePersonnel(long idRolePersonnel) {
        this.idRolePersonnel = idRolePersonnel;
    }

    @XmlElement (name= "NomRolePerso")
    public String getNomRolePersonnel() {
        return nomRolePersonnel;
    }

    public void setNomRolePersonnel(String nomRolePersonnel) {
        this.nomRolePersonnel = nomRolePersonnel;
    }

    @XmlElement (name = "DescriptionRolePerso")
    public String getDescriptionRolePersonnel() {
        return descriptionRolePersonnel;
    }

    public void setDescriptionRolePersonnel(String descriptionRolePersonnel) {
        this.descriptionRolePersonnel = descriptionRolePersonnel;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RolePersonnelDto that)) return false;
        return idRolePersonnel == that.idRolePersonnel && Objects.equals(nomRolePersonnel, that.nomRolePersonnel) && Objects.equals(descriptionRolePersonnel, that.descriptionRolePersonnel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRolePersonnel, nomRolePersonnel, descriptionRolePersonnel);
    }
}
