package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.AffectationPersonnelDto;
import com.example.projet.projet.modele.Dto.PersonnelDto;
import com.example.projet.projet.modele.Dto.RolePersonnelDto;
import com.example.projet.projet.modele.Dto.SessionDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AffectationPersonnelXMLUtilsTest {
    /*

    private static final String TEST_XML_FILE = "AffectationPersonnel.xml";
    private AffectationPersonnelXMLUtils xmlUtils;

    @BeforeEach
    void setUp() {
        xmlUtils = new AffectationPersonnelXMLUtils();
    }

    @AfterEach
    void tearDown() {
        // Supprimez le fichier de test après chaque exécution
        File file = new File(TEST_XML_FILE);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testMarshallerAndUnmarshaller() {
        // Préparer une liste de données
        RolePersonnelDto role = new RolePersonnelDto(1, "role1", "DescriptionRole1");

        PersonnelDto personnel1 = new PersonnelDto("nom1", "prenom1", "adresse1", "email1", "telephone1", new Date(), "F", 1, role);
        PersonnelDto personnel2 = new PersonnelDto("nom2", "prenom2", "adresse2", "email2", "telephone2", new Date(), "M", 2, role);

        SessionDto session1 = new SessionDto(1, new Date(), "session1", LocalTime.of(9, 0));
        SessionDto session2 = new SessionDto(2, new Date(), "session2", LocalTime.of(10, 0));

        List<AffectationPersonnelDto> originalList = new ArrayList<>();
        originalList.add(new AffectationPersonnelDto(1, personnel1, session1));
        originalList.add(new AffectationPersonnelDto(2, personnel2, session2));

        // Sérialiser les données dans le fichier XML
        xmlUtils.marshaller(originalList);

        // Vérifiez que le fichier a été créé
        File file = new File(TEST_XML_FILE);
        assertTrue(file.exists(), "Le fichier XML doit être créé après l'exécution de la méthode marshaller.");

        // Lire les données depuis le fichier XML
        List<AffectationPersonnelDto> unmarshalledList = xmlUtils.unmarshaller();

        // Vérifiez que la liste désérialisée n'est pas nulle et a la bonne taille
        assertNotNull(unmarshalledList, "La liste désérialisée ne doit pas être nulle.");
        assertEquals(originalList.size(), unmarshalledList.size(), "Les tailles des listes doivent correspondre.");

        // Comparer chaque élément de la liste
        for (int i = 0; i < originalList.size(); i++) {
            AffectationPersonnelDto original = originalList.get(i);
            AffectationPersonnelDto unmarshalled = unmarshalledList.get(i);

            // Vérifier les ID
            assertEquals(original.getIdAffectationPersonnel(), unmarshalled.getIdAffectationPersonnel(), "Les ID doivent correspondre.");

            // Vérifier les données du personnel
            PersonnelDto originalPersonnel = original.getPersonnel();
            PersonnelDto unmarshalledPersonnel = unmarshalled.getPersonnel();
            assertEquals(originalPersonnel.getNom(), unmarshalledPersonnel.getNom(), "Les noms des personnels doivent correspondre.");
            assertEquals(originalPersonnel.getPrenom(), unmarshalledPersonnel.getPrenom(), "Les prénoms des personnels doivent correspondre.");
            assertEquals(originalPersonnel.getAdresse(), unmarshalledPersonnel.getAdresse(), "Les adresses des personnels doivent correspondre.");
            assertEquals(originalPersonnel.getEmail(), unmarshalledPersonnel.getEmail(), "Les emails des personnels doivent correspondre.");
            assertEquals(originalPersonnel.getTelephone(), unmarshalledPersonnel.getTelephone(), "Les téléphones des personnels doivent correspondre.");
            assertEquals(originalPersonnel.getSexe(), unmarshalledPersonnel.getSexe(), "Les sexes des personnels doivent correspondre.");
            assertEquals(originalPersonnel.getIdPersonnel(), unmarshalledPersonnel.getIdPersonnel(), "Les IDs des personnels doivent correspondre.");

            // Vérifier le rôle du personnel
            RolePersonnelDto originalRole = originalPersonnel.getRolePersonnel();
            RolePersonnelDto unmarshalledRole = unmarshalledPersonnel.getRolePersonnel();
            assertEquals(originalRole.getIdRolePersonnel(), unmarshalledRole.getIdRolePersonnel(), "Les IDs des rôles doivent correspondre.");
            assertEquals(originalRole.getNomRolePersonnel(), unmarshalledRole.getNomRolePersonnel(), "Les noms des rôles doivent correspondre.");
            assertEquals(originalRole.getDescriptionRolePersonnel(), unmarshalledRole.getDescriptionRolePersonnel(), "Les descriptions des rôles doivent correspondre.");

            // Vérifier les données de session
            SessionDto originalSession = original.getSession();
            SessionDto unmarshalledSession = unmarshalled.getSession();
            assertEquals(originalSession.getIdSession(), unmarshalledSession.getIdSession(), "Les IDs des sessions doivent correspondre.");
            assertEquals(originalSession.getTitreSession(), unmarshalledSession.getTitreSession(), "Les noms des sessions doivent correspondre.");
            assertEquals(originalSession.getHeureDebutSession(), unmarshalledSession.getHeureDebutSession(), "Les heures de début des sessions doivent correspondre.");
            }
    }

     */
}
