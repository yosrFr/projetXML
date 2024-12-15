package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.AffectationPersonnelDto;
import com.example.projet.projet.modele.Dto.PersonnelDto;
import com.example.projet.projet.modele.Dto.RolePersonnelDto;
import com.example.projet.projet.modele.Dto.SessionDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AffectationPersonnelXMLUtilsTest {
    private AffectationPersonnelXMLUtils affectationPersonnelXMLUtils = new AffectationPersonnelXMLUtils();
    private List<AffectationPersonnelDto> affectationPersonnelDtos;

    @BeforeEach
    public void setUp() {
        affectationPersonnelDtos = new ArrayList<>();
        RolePersonnelDto role1 = new RolePersonnelDto(1, "Animateur", "Fait l'animation dans l'événement.");
        RolePersonnelDto role2 = new RolePersonnelDto(2, "Formateur", "Fait la formation dans l'événement");
        PersonnelDto personnel1 = new PersonnelDto("Smith", "Jane", "Tunis", "jane.smith@gmail.com", "+21698765432", "2000-11-12", "femme", 1, role1);
        PersonnelDto personnel2 = new PersonnelDto("Brown", "Emily", "Bizerte", "jane.smith@gmail.com", "+21698765432", "2000-11-11", "femme", 2, role2);
        SessionDto session1  = new SessionDto(11, "2024-12-10", "Ouverture", "8:00", "09:00");
        SessionDto session2 = new SessionDto(22, "2024-12-11", "Atelier AI", "09:00", "12:00");
        affectationPersonnelDtos.add(new AffectationPersonnelDto(1, personnel1, session1));
        affectationPersonnelDtos.add(new AffectationPersonnelDto(2, personnel2, session2));
    }

    @Test
    void testMarshaller() {
        affectationPersonnelXMLUtils.marshaller(affectationPersonnelDtos);
        File xmlFile = new File(AffectationPersonnelXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists());
        assertTrue(xmlFile.length() > 0);
    }

    @Test
    public void testUnmarshaller() {
        affectationPersonnelXMLUtils.marshaller(affectationPersonnelDtos);
        List<AffectationPersonnelDto> unmarshalledDtos = affectationPersonnelXMLUtils.unmarshaller();
        assertEquals(affectationPersonnelDtos.size(), unmarshalledDtos.size(), "Les tailles des listes doivent etre égales");
        for(int i = 0; i < affectationPersonnelDtos.size(); i++) {
            assertTrue(unmarshalledDtos.get(i).equals(affectationPersonnelDtos.get(i)));
        }
    }
/*
    @AfterEach
    void tearDown() {
        File file = new File(AffectationPersonnelXMLUtils.XML_FILE);
        if (file.exists()) {
            file.delete();
        }
    }*/
}
