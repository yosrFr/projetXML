package com.example.projet.projet.service;

import com.example.projet.projet.modele.Dto.AffectationPersonnelDto;
import com.example.projet.projet.modele.Dto.PersonnelDto;
import com.example.projet.projet.modele.Dto.RolePersonnelDto;
import com.example.projet.projet.modele.Dto.SessionDto;
import com.example.projet.projet.modele.XMLUtils.AffectationPersonnelXMLUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AffectationPersonnelServiceTest {
    private AffectationPersonnelService affectationPersonnelService;
    private AffectationPersonnelXMLUtils affectationPersonnelXMLUtils;
    private List<AffectationPersonnelDto> affectationPersonnelDtos;

    @BeforeEach
    void setUp() {
        affectationPersonnelXMLUtils = new AffectationPersonnelXMLUtils();
        affectationPersonnelService = new AffectationPersonnelService(affectationPersonnelXMLUtils);
        affectationPersonnelDtos = new ArrayList<>();
        RolePersonnelDto role1 = new RolePersonnelDto(1, "Nom1", "Description1");
        RolePersonnelDto role2 = new RolePersonnelDto(2, "Nom2", "Description2");
        PersonnelDto personnel1 = new PersonnelDto("nom", "prenom", "adresse", "email", "telephone", new Date(), "M", 1, role1);
        PersonnelDto personnel2 = new PersonnelDto("nom", "prenom", "adresse", "email", "telephone", new Date(), "F", 2, role2);
        SessionDto session1 = new SessionDto(1, new Date(), "titreSession1", "09:45", "09:45");
        SessionDto session2 = new SessionDto(2, new Date(), "titreSession2", "09:45", "09:45");
        affectationPersonnelDtos.add(new AffectationPersonnelDto(1, personnel1, session1));
        affectationPersonnelDtos.add(new AffectationPersonnelDto(2, personnel2, session2));
        affectationPersonnelXMLUtils.marshaller(affectationPersonnelDtos);
    }

    @Test
    public void testAjouterAffectationPersonel() {
        RolePersonnelDto role1 = new RolePersonnelDto(1, "Nom1", "Description1");
        PersonnelDto personnel1 = new PersonnelDto("nom", "prenom", "adresse", "email", "telephone", new Date(), "M", 1, role1);
        SessionDto session2 = new SessionDto(2, new Date(), "titreSession2", "09:45", "09:45");
        AffectationPersonnelDto newAffectation = new AffectationPersonnelDto(3, personnel1, session2);
        affectationPersonnelService.ajouterAffectationPersonel(newAffectation);
        List<AffectationPersonnelDto> result = affectationPersonnelXMLUtils.unmarshaller();
        boolean exist = result.stream().anyMatch(affectation -> affectation.getIdAffectationPersonnel() == newAffectation.getIdAffectationPersonnel());
        assertTrue(exist, "L'ajout de l'affectation du personnel n'a pas réussi");
    }

    @Test
    public void testEstAffecté() {
        boolean result = affectationPersonnelService.estAffecté(1, "09:45", "09:45", new Date());
        assertTrue(result);
    }

    @AfterEach
    void tearDown() {
        File xmlFile = new File(AffectationPersonnelXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }
}
