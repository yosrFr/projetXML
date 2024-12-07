package com.example.projet.projet.modele.Wrapper;

import com.example.projet.projet.modele.Dto.EvenementDto;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "Evenements")
public class EvenementWrapper {
    private List<EvenementDto> evenements;

    public EvenementWrapper() {

    }

    public EvenementWrapper(List<EvenementDto> evenements) {
        this.evenements = evenements;
    }

    @XmlElement(name = "Evenement")
    public List<EvenementDto> getEvenements() {
        return evenements;
    }

    public void setEvenements(List<EvenementDto> evenements) {
        this.evenements = evenements;
    }
}
