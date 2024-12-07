package com.example.projet.projet.modele.Wrapper;

import com.example.projet.projet.modele.Dto.AffectationPersonnelDto;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "AffectationsPersonnel")
public class AffectationPersonnelWrapper {
    private List<AffectationPersonnelDto> affectationsPersonnel;

    public AffectationPersonnelWrapper() {

    }

    public AffectationPersonnelWrapper(List<AffectationPersonnelDto> affectationsPersonnel) {
        this.affectationsPersonnel = affectationsPersonnel;
    }

    @XmlElement(name = "AffectationPersonnel")
    public List<AffectationPersonnelDto> getAffectationsPersonnel() {
        return affectationsPersonnel;
    }

    public void setAffectationsPersonnel(List<AffectationPersonnelDto> affectationsPersonnel) {
        this.affectationsPersonnel = affectationsPersonnel;
    }
}
