package com.example.projet.projet.modele.Wrapper;

import com.example.projet.projet.modele.Dto.MaterielDto;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "Materiaux")
public class MaterielWrapper {
    private List<MaterielDto> materiels;

    public MaterielWrapper() {

    }

    public MaterielWrapper(List<MaterielDto> materiels) {
        this.materiels = materiels;
    }

    @XmlElement(name = "Materiel")
    public List<MaterielDto> getMateriels() {
        return materiels;
    }

    public void setMateriels(List<MaterielDto> materiels) {
        this.materiels = materiels;
    }
}
