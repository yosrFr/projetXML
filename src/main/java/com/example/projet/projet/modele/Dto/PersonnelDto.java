package com.example.projet.projet.modele.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;
import java.util.Objects;

@XmlRootElement
public class PersonnelDto extends PersonneDto {
    @NotNull
    private long idPersonnel;
    @NotNull
    private RolePersonnelDto rolePersonnel;

    public PersonnelDto() {
        super();
    }

    public PersonnelDto(String nom, String prenom, String adresse, String email, String telephone, String dateNaissance, String sexe, long idPersonnel, RolePersonnelDto rolePersonnel) {
        super(nom, prenom, adresse, email, telephone, dateNaissance, sexe);
        this.idPersonnel = idPersonnel;
        this.rolePersonnel = rolePersonnel;
    }

    @XmlElement (name = "IdPersonnel")
    public long getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(long idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    @XmlElement (name = "Role")
    public RolePersonnelDto getRolePersonnel() {
        return rolePersonnel;
    }

    public void setRolePersonnel(RolePersonnelDto rolePersonnel) {
        this.rolePersonnel = rolePersonnel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonnelDto that)) return false;
        if (!super.equals(o)) return false;
        return idPersonnel == that.idPersonnel && Objects.equals(rolePersonnel, that.rolePersonnel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idPersonnel, rolePersonnel);
    }
}
