package com.example.projet.projet.service;

import com.example.projet.projet.modele.XMLUtils.AffectationPersonnelXMLUtils;
import com.example.projet.projet.modele.Dto.AffectationPersonnelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class AffectationPersonnelService {
    @Autowired
    private AffectationPersonnelXMLUtils affectationPersonnelXMLUtils;

    public AffectationPersonnelService(AffectationPersonnelXMLUtils affectationPersonnelXMLUtils) {
        this.affectationPersonnelXMLUtils = affectationPersonnelXMLUtils;
    }

    public void ajouterAffectationPersonel (AffectationPersonnelDto affectation){
        List<AffectationPersonnelDto> list = affectationPersonnelXMLUtils.unmarshaller();
        list.add(affectation);
        affectationPersonnelXMLUtils.marshaller(list);
    }

    public boolean estAffecté (long idPersonnel, String tempsDebut, String tempsFin, String date){
        List<AffectationPersonnelDto> list = affectationPersonnelXMLUtils.unmarshaller();
        return list.stream()
                .filter(affectationPersonnel -> affectationPersonnel.getPersonnel().getIdPersonnel() == idPersonnel)
                .noneMatch(affectationPersonnel ->
                        !affectationPersonnel.getSession().getDateSession().equals(date) &&
                                LocalTime.parse(tempsFin, DateTimeFormatter.ofPattern("HH:mm"))
                                        .isBefore(LocalTime.parse(affectationPersonnel.getSession().getHeureDebutSession())) &&
                                LocalTime.parse(tempsDebut, DateTimeFormatter.ofPattern("HH:mm"))
                                        .isAfter(LocalTime.parse(affectationPersonnel.getSession().getHeureFinSession())));
    }
}
