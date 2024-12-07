package com.example.projet.projet.service;

import com.example.projet.projet.modele.XMLUtils.InscriptionXMLUtils;
import com.example.projet.projet.modele.Dto.InscriptionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InscriptionService {
    @Autowired
    private InscriptionXMLUtils inscriptionXMLUtils;

    public InscriptionService(InscriptionXMLUtils inscriptionXMLUtils) {
        this.inscriptionXMLUtils = inscriptionXMLUtils;
    }

    public List<InscriptionDto> getAllInscriptionsByEvenenemnt(long idEvenement) {
        List<InscriptionDto> list = inscriptionXMLUtils.unmarshaller();
        return list.stream()
                .filter(inscription -> inscription.getEvenement().getIdEvenement() == idEvenement)
                .collect(Collectors.toList());
    }

    public List<InscriptionDto> getAllInscriptionsByEvenementOrderdByDate(long idEvenement){
        List<InscriptionDto> list = inscriptionXMLUtils.unmarshaller();
        return list.stream()
                .filter(inscription -> inscription.getEvenement().getIdEvenement() == idEvenement)
                .sorted(Comparator.comparing(InscriptionDto::getDateInscription))
                .collect(Collectors.toList());
    }

    public void ajouterInscription(InscriptionDto inscription) {
        List<InscriptionDto> list = inscriptionXMLUtils.unmarshaller();
        list.add(inscription);
        inscriptionXMLUtils.marshaller(list);
    }
}
