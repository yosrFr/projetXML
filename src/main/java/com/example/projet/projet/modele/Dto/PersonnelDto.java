package com.example.projet.projet.modele.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;
import java.util.Date;

@XmlRootElement
public class PersonnelDto extends PersonneDto {
    @NotNull
    private long idPersonnel;
    @NotNull
    private RolePersonnelDto rolePersonnel;

    public PersonnelDto() {
        super();
    }

    public PersonnelDto(String nom, String prenom, String adresse, String email, String telephone, Date dateNaissance, String sexe, long idPersonnel, RolePersonnelDto rolePersonnel) {
        super(nom, prenom, adresse, email, telephone, dateNaissance, sexe);
        this.idPersonnel = idPersonnel;
        this.rolePersonnel = rolePersonnel;
    }

    @XmlElement
    public long getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(long idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    @XmlElement
    public RolePersonnelDto getRolePersonnel() {
        return rolePersonnel;
    }

    public void setRolePersonnel(RolePersonnelDto rolePersonnel) {
        this.rolePersonnel = rolePersonnel;
    }

}
