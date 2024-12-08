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
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AffectationPersonnelXMLUtilsTest {
    private AffectationPersonnelXMLUtils affectationPersonnelXMLUtils;
    private List<AffectationPersonnelDto> affectationPersonnelDtos;

    @BeforeEach
    public void setUp() {
        affectationPersonnelXMLUtils = new AffectationPersonnelXMLUtils();
        affectationPersonnelDtos = new ArrayList<>();
        RolePersonnelDto role1 = new RolePersonnelDto(1, "Nom1", "Description1");
        RolePersonnelDto role2 = new RolePersonnelDto(2, "Nom2", "Description2");
        PersonnelDto personnel1 = new PersonnelDto("nom", "prenom", "adresse", "email", "telephone", new Date(), "M", 1, role1);
        PersonnelDto personnel2 = new PersonnelDto("nom", "prenom", "adresse", "email", "telephone", new Date(), "F", 2, role2);
        SessionDto session1 = new SessionDto(1, new Date(), "titreSession1", "09:45", "09:45");
        SessionDto session2 = new SessionDto(2, new Date(), "titreSession2", "09:45", "09:45");
        affectationPersonnelDtos.add(new AffectationPersonnelDto(1, personnel1, session1));
        affectationPersonnelDtos.add(new AffectationPersonnelDto(2, personnel2, session2));
    }

    @Test
    void testMarshaller() {
        affectationPersonnelXMLUtils.marshaller(affectationPersonnelDtos);
        File xmlFile = new File(AffectationPersonnelXMLUtils.XML_FILE);
        assertTrue(xmlFile.exists(), "Le fichier XML doit exister");
        assertTrue(xmlFile.length() > 0, "Le fichier XML ne devrait pas etre vide");
    }

    @Test
    public void testUnmarshaller() {
        affectationPersonnelXMLUtils.marshaller(affectationPersonnelDtos);
        List<AffectationPersonnelDto> unmarshalledDtos = affectationPersonnelXMLUtils.unmarshaller();
        assertEquals(affectationPersonnelDtos.size(), unmarshalledDtos.size(), "Les tailles des listes doivent etre égales");
        for(int i = 0; i < affectationPersonnelDtos.size(); i++) {
            assertEquals(affectationPersonnelDtos.get(i).getIdAffectationPersonnel(), unmarshalledDtos.get(i).getIdAffectationPersonnel(), "L'ID d'affectation doit etre la meme");
            assertEquals(affectationPersonnelDtos.get(i).getPersonnel().getIdPersonnel(), unmarshalledDtos.get(i).getPersonnel().getIdPersonnel(), "L'ID du personnel doit etre la meme");
            assertEquals(affectationPersonnelDtos.get(i).getPersonnel().getNom(), unmarshalledDtos.get(i).getPersonnel().getNom(), "Le nom doit etre le meme");
            assertEquals(affectationPersonnelDtos.get(i).getPersonnel().getPrenom(), unmarshalledDtos.get(i).getPersonnel().getPrenom(), "Le prenom doit etre le meme");
            assertEquals(affectationPersonnelDtos.get(i).getPersonnel().getAdresse(), unmarshalledDtos.get(i).getPersonnel().getAdresse(), "L'adresse doit etre la meme");
            assertEquals(affectationPersonnelDtos.get(i).getPersonnel().getEmail(), unmarshalledDtos.get(i).getPersonnel().getEmail(), "L'email doit etre le meme");
            assertEquals(affectationPersonnelDtos.get(i).getPersonnel().getDateNaissance(), unmarshalledDtos.get(i).getPersonnel().getDateNaissance(), "La date de naissance doit etre la meme");
            assertEquals(affectationPersonnelDtos.get(i).getPersonnel().getTelephone(), unmarshalledDtos.get(i).getPersonnel().getTelephone(), "Le numero de telephone doit etre le meme");
            assertEquals(affectationPersonnelDtos.get(i).getPersonnel().getRolePersonnel().getIdRolePersonnel(), unmarshalledDtos.get(i).getPersonnel().getRolePersonnel().getIdRolePersonnel(), "L'ID du role doit etre le meme");
            assertEquals(affectationPersonnelDtos.get(i).getPersonnel().getRolePersonnel().getDescriptionRolePersonnel(), unmarshalledDtos.get(i).getPersonnel().getRolePersonnel().getDescriptionRolePersonnel(), "La description du role doit etre la meme");
            assertEquals(affectationPersonnelDtos.get(i).getPersonnel().getRolePersonnel().getNomRolePersonnel(), unmarshalledDtos.get(i).getPersonnel().getRolePersonnel().getNomRolePersonnel(), "Le nom du role doit etre le meme");
            assertEquals(affectationPersonnelDtos.get(i).getSession().getIdSession(), unmarshalledDtos.get(i).getSession().getIdSession(), "L'ID de la session doit etre la meme");
            assertEquals(affectationPersonnelDtos.get(i).getSession().getTitreSession(), unmarshalledDtos.get(i).getSession().getTitreSession(), "Le titre de la session doit etre le meme");
            assertEquals(affectationPersonnelDtos.get(i).getSession().getDateSession(), unmarshalledDtos.get(i).getSession().getDateSession(), "La date doit etre le meme");
            assertEquals(affectationPersonnelDtos.get(i).getSession().getHeureDebutSession(), unmarshalledDtos.get(i).getSession().getHeureDebutSession(), "L'heure de debut doit etre le meme");
            assertEquals(affectationPersonnelDtos.get(i).getSession().getHeureFinSession(), unmarshalledDtos.get(i).getSession().getHeureFinSession(), "L'heure de fin doit etre la meme");
        }
    }

    @AfterEach
    void tearDown() {
        File file = new File(AffectationPersonnelXMLUtils.XML_FILE);
        if (file.exists()) {
            file.delete();
        }
    }
}
