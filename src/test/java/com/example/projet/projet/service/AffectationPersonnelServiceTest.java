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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AffectationPersonnelServiceTest {
    private AffectationPersonnelService affectationPersonnelService;
    private final AffectationPersonnelXMLUtils affectationPersonnelXMLUtils = new AffectationPersonnelXMLUtils();
    private List<AffectationPersonnelDto> affectationPersonnelDtos;

    @BeforeEach
    void setUp() {
        affectationPersonnelService = new AffectationPersonnelService(affectationPersonnelXMLUtils);
        affectationPersonnelDtos = new ArrayList<>();
        RolePersonnelDto role1 = new RolePersonnelDto(1, "Animateur", "Fait l'animation dans l'événement.");
        RolePersonnelDto role2 = new RolePersonnelDto(2, "Formateur", "Fait la formation dans l'événement");
        PersonnelDto personnel1 = new PersonnelDto("Smith", "Jane", "Tunis", "jane.smith@gmail.com", "+21698765432", "2000-11-12", "femme", 1, role1);
        PersonnelDto personnel2 = new PersonnelDto("Brown", "Emily", "Bizerte", "jane.smith@gmail.com", "+21698765432", "2000-11-11", "femme", 2, role2);
        SessionDto session1  = new SessionDto(11, "2024-12-10", "Ouverture", "8:00", "09:00");
        SessionDto session2 = new SessionDto(22, "2024-12-11", "Atelier AI", "09:00", "12:00");
        affectationPersonnelDtos.add(new AffectationPersonnelDto(1, personnel1, session1));
        affectationPersonnelDtos.add(new AffectationPersonnelDto(2, personnel2, session2));
        affectationPersonnelXMLUtils.marshaller(affectationPersonnelDtos);
    }

    @Test
    public void testAjouterAffectationPersonel() {
        RolePersonnelDto role1 = new RolePersonnelDto(1, "Nom1", "Description1");
        PersonnelDto personnel1 = new PersonnelDto("nom", "prenom", "adresse", "email", "telephone", "2024-11-12", "M", 1, role1);
        SessionDto session2 = new SessionDto(2, "2024-11-12", "titreSession2", "09:45", "09:45");
        AffectationPersonnelDto newAffectation = new AffectationPersonnelDto(3, personnel1, session2);
        affectationPersonnelService.ajouterAffectationPersonel(newAffectation);
        List<AffectationPersonnelDto> result = affectationPersonnelXMLUtils.unmarshaller();
        boolean exist = result.stream().anyMatch(affectation -> affectation.getIdAffectationPersonnel() == newAffectation.getIdAffectationPersonnel());
        assertTrue(exist, "L'ajout de l'affectation du personnel n'a pas réussi");
    }

    @Test
    public void testEstAffecté() {
        boolean result = affectationPersonnelService.estAffecté(1, "09:45", "09:45", "2024-12-10");
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
