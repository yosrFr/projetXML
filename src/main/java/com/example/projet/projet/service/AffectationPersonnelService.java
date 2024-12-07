package com.example.projet.projet.service;

import com.example.projet.projet.modele.XMLUtils.AffectationPersonnelXMLUtils;
import com.example.projet.projet.modele.XMLUtils.PersonnelXMLUtils;
import com.example.projet.projet.modele.Dto.AffectationPersonnelDto;
import com.example.projet.projet.modele.Dto.PersonnelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Service
public class AffectationPersonnelService {
    @Autowired
    private AffectationPersonnelXMLUtils affectationPersonnelXMLUtils;
    /*
    @Autowired
    private PersonnelXMLUtils personnelXMLUtils;
     */

    public AffectationPersonnelService(AffectationPersonnelXMLUtils affectationPersonnelXMLUtils, PersonnelXMLUtils personnelXMLUtils) {
        this.affectationPersonnelXMLUtils = affectationPersonnelXMLUtils;
        //this.personnelXMLUtils = personnelXMLUtils;
    }

    public void ajouterAffectationPersonel (AffectationPersonnelDto affectation){
        List<AffectationPersonnelDto> list = affectationPersonnelXMLUtils.unmarshaller();
        list.add(affectation);
        affectationPersonnelXMLUtils.marshaller(list);
    }

    public boolean estAffecté (long idPersonnel, String tempsDebut, String tempsFin, Date date){
        /*
        List<PersonnelDto> list = personnelXMLUtils.unmarshaller();
        return list.stream().filter(personnel -> personnel.getIdPersonnel() == idPersonnel).findAny().isPresent();
         */
        List<AffectationPersonnelDto> list = affectationPersonnelXMLUtils.unmarshaller();
        return list.stream()
                .filter(affectationPersonnel -> affectationPersonnel.getPersonnel().getIdPersonnel() == idPersonnel)
                .anyMatch(affectationPersonnel ->
                        !affectationPersonnel.getSession().getDateSession().equals(date) &&
                                LocalTime.parse(tempsFin).isBefore(LocalTime.parse(affectationPersonnel.getSession().getHeureDebutSession())) &&
                                LocalTime.parse(tempsDebut).isAfter(LocalTime.parse(affectationPersonnel.getSession().getHeureFinSession())));
    }
}
