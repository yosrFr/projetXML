package com.example.projet.projet.modele.Wrapper;


import com.example.projet.projet.modele.Dto.CategorieEvenementDto;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "CategoriesEvenement")
public class CategorieEvenementWrapper {
    private List<CategorieEvenementDto> categoriesEvenement;

    public CategorieEvenementWrapper() {

    }

    public CategorieEvenementWrapper(List<CategorieEvenementDto> categoriesEvenement) {
        this.categoriesEvenement = categoriesEvenement;
    }

    @XmlElement(name = "CategorieEvenement")
    public List<CategorieEvenementDto> getCategoriesEvenement() {
        return categoriesEvenement;
    }

    public void setCategoriesEvenement(List<CategorieEvenementDto> categoriesEvenement) {
        this.categoriesEvenement = categoriesEvenement;
    }
}
