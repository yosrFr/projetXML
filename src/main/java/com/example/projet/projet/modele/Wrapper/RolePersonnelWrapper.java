package com.example.projet.projet.modele.Wrapper;

import com.example.projet.projet.modele.Dto.RolePersonnelDto;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "RolesPersonnel")
public class RolePersonnelWrapper {
    private List<RolePersonnelDto> rolesPersonnel;

    public RolePersonnelWrapper() {

    }

    public RolePersonnelWrapper(List<RolePersonnelDto> rolesPersonnel) {
        this.rolesPersonnel = rolesPersonnel;
    }

    @XmlElement(name = "RolePersonnel")
    public List<RolePersonnelDto> getRolesPersonnel() {
        return rolesPersonnel;
    }

    public void setRolesPersonnel(List<RolePersonnelDto> rolesPersonnel) {
        this.rolesPersonnel = rolesPersonnel;
    }
}
