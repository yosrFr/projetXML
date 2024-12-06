package com.example.projet.projet.service;

import com.example.projet.projet.modele.Dto.SessionDto;
import com.example.projet.projet.modele.XMLUtils.EvenementXMLUtils;
import com.example.projet.projet.modele.Dto.EvenementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvenementService {
    @Autowired
    private final EvenementXMLUtils evenementXMLUtils;

    public EvenementService(EvenementXMLUtils evenementXMLUtils) {
        this.evenementXMLUtils = evenementXMLUtils;
    }

    public void ajouterEvenement (EvenementDto evenement){
        List<EvenementDto> list = evenementXMLUtils.unmarshaller();
        list.add(evenement);
        evenementXMLUtils.marshaller(list);
    }

    public List<EvenementDto> getAllEvenements(){
        return evenementXMLUtils.unmarshaller();
    }

    public EvenementDto getEvenementById(long id){
        List<EvenementDto> list = evenementXMLUtils.unmarshaller();
        return list.stream().filter(evenement -> evenement.getIdEvenement() == id).findFirst().orElse(null);
    }

    public void modifierEvenement(EvenementDto evenement){
        List<EvenementDto> list = evenementXMLUtils.unmarshaller();
        EvenementDto event = getEvenementById(evenement.getIdEvenement());
        list.remove(event);
        list.add(evenement);
        evenementXMLUtils.marshaller(list);
    }

    public void supprimerEvenement(long id){
        List<EvenementDto> list = evenementXMLUtils.unmarshaller();
        EvenementDto evenement = getEvenementById(id);
        list.remove(evenement);
        evenementXMLUtils.marshaller(list);
    }

    public List<SessionDto> getAllSessionsEventOrderedByDate(long id){
        List<EvenementDto> list = evenementXMLUtils.unmarshaller();
        return list.stream()
                .filter(evenement -> evenement.getIdEvenement() == id)
                .flatMap(evenement -> evenement.getSessions()
                        .stream())
                .sorted(Comparator.comparing(SessionDto::getDateSession)
                        .thenComparing(SessionDto::getHeureDebutSession))
                .collect(Collectors.toList());
    }
}
