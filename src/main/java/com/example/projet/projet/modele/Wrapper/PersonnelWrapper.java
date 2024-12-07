package com.example.projet.projet.modele.Wrapper;

import com.example.projet.projet.modele.Dto.PersonnelDto;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "Personnel")
public class PersonnelWrapper {
    private List<PersonnelDto> personnel;

    public PersonnelWrapper() {

    }

    public PersonnelWrapper(List<PersonnelDto> personnel) {
        this.personnel = personnel;
    }

    @XmlElement(name = "Perso")
    public List<PersonnelDto> getPersonnel() {
        return personnel;
    }

    public void setPersonnel(List<PersonnelDto> personnel) {
        this.personnel = personnel;
    }
}
