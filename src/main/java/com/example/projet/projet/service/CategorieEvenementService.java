package com.example.projet.projet.service;

import com.example.projet.projet.modele.XMLUtils.CategorieEvenementXMLUtils;
import com.example.projet.projet.modele.Dto.CategorieEvenementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieEvenementService {
    @Autowired
    private final CategorieEvenementXMLUtils categorieEvenementXMLUtils;

    public CategorieEvenementService(CategorieEvenementXMLUtils categorieEvenementXMLUtils) {
        this.categorieEvenementXMLUtils = categorieEvenementXMLUtils;
    }

    public List<CategorieEvenementDto> getAllCategoriesEvenement() {
        return categorieEvenementXMLUtils.unmarshaller();
    }

    public CategorieEvenementDto getCategorieEvenementById(long id) {
        List<CategorieEvenementDto> list = categorieEvenementXMLUtils.unmarshaller();
        return list.stream().filter(categorie -> categorie.getIdCategorieEvenement() == id).findFirst().orElse(null);
    }

    public void ajouterCategorieEvenement(CategorieEvenementDto category) {
        List<CategorieEvenementDto> list = categorieEvenementXMLUtils.unmarshaller();
        list.add(category);
        categorieEvenementXMLUtils.marshaller(list);
    }

    public void modifierCategorieEvenement(CategorieEvenementDto categorieEvenement) {
        List<CategorieEvenementDto> list = categorieEvenementXMLUtils.unmarshaller();
        list.remove(list.stream()
                .filter(categorie -> categorie.getIdCategorieEvenement() == categorieEvenement.getIdCategorieEvenement())
                .findFirst()
                .orElse(null));
        list.add(categorieEvenement);
        categorieEvenementXMLUtils.marshaller(list);
    }

    public void supprimerCategorieEvenement(long id) {
        List<CategorieEvenementDto> list = categorieEvenementXMLUtils.unmarshaller();
        list.remove(list.stream()
                .filter(categorie -> categorie.getIdCategorieEvenement() == id)
                .findFirst()
                .orElse(null));
        categorieEvenementXMLUtils.marshaller(list);
    }
}
