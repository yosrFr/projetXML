package com.example.projet.projet.modele.Dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;

@XmlRootElement
public class RolePersonnelDto {
    private long idRolePersonnel;
    private String nomRolePersonnel;
    private String descriptionRolePersonnel;

    public RolePersonnelDto() {

    }

    public RolePersonnelDto(long idRolePersonnel, String nomRolePersonnel, String descriptionRolePersonnel) {
        this.idRolePersonnel = idRolePersonnel;
        this.nomRolePersonnel = nomRolePersonnel;
        this.descriptionRolePersonnel = descriptionRolePersonnel;
    }

    @XmlElement
    public long getIdRolePersonnel() {
        return idRolePersonnel;
    }

    public void setIdRolePersonnel(long idRolePersonnel) {
        this.idRolePersonnel = idRolePersonnel;
    }

    @XmlElement
    public String getNomRolePersonnel() {
        return nomRolePersonnel;
    }

    public void setNomRolePersonnel(String nomRolePersonnel) {
        this.nomRolePersonnel = nomRolePersonnel;
    }

    @XmlElement
    public String getDescriptionRolePersonnel() {
        return descriptionRolePersonnel;
    }

    public void setDescriptionRolePersonnel(String descriptionRolePersonnel) {
        this.descriptionRolePersonnel = descriptionRolePersonnel;
    }

}
