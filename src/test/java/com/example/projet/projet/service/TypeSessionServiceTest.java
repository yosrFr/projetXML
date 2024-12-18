package com.example.projet.projet.service;

import com.example.projet.projet.modele.Dto.TypeSessionDto;
import com.example.projet.projet.modele.XMLUtils.TypeSessionXMLUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class TypeSessionServiceTest {
    private TypeSessionService typeSessionService;
    private TypeSessionXMLUtils typeSessionXMLUtils;
    private List<TypeSessionDto> typeSessionDtos;

    @BeforeEach
    public void setUp() {
        typeSessionXMLUtils = new TypeSessionXMLUtils();
        typeSessionService = new TypeSessionService(typeSessionXMLUtils);
        typeSessionDtos = new ArrayList<>();
        typeSessionDtos.add(new TypeSessionDto(1, "Nom1", "Description1"));
        typeSessionDtos.add(new TypeSessionDto(2, "Nom2", "Description2"));
        typeSessionXMLUtils.marshaller(typeSessionDtos);
    }

    @Test
    public void testGetALLNomsTypesSession() {
        List<String> result = typeSessionService.getALLNomsTypesSession();
        List<String> nomsTypesSession = typeSessionDtos.stream().map(TypeSessionDto::getNomTypeSession).collect(Collectors.toList());
        assertEquals(nomsTypesSession, result);
    }

    @Test
    public void testGetAllTypesSession() {
        List<TypeSessionDto> allTypesSession = typeSessionService.getAllTypesSession();
        assertEquals(typeSessionDtos.size(), allTypesSession.size());
    }

    @Test
    public void testGetTypeSessionById() {
        for ( int i = 0; i < typeSessionDtos.size(); i++ ) {
            TypeSessionDto result = typeSessionService.getTypeSessionById(typeSessionDtos.get(i).getIdTypeSession());
            assertEquals(typeSessionDtos.get(i).getIdTypeSession(), result.getIdTypeSession());
            assertEquals(typeSessionDtos.get(i).getDescriptionTypeSession(), result.getDescriptionTypeSession());
            assertEquals(typeSessionDtos.get(i).getNomTypeSession(), result.getNomTypeSession());
        }
    }

    @Test
    public void testAjouterTypeSession() {
        TypeSessionDto newTypeSession = new TypeSessionDto(3, "Nom1", "Description1");
        typeSessionService.ajouterTypeSession(newTypeSession);
        List<TypeSessionDto> result = typeSessionService.getAllTypesSession();
        assertEquals(typeSessionDtos.size() + 1, result.size());
    }

    @Test
    public void testModifierTypeSession() {
        TypeSessionDto updatedTypeSession = new TypeSessionDto(1, "Nom1", "Description2");
        typeSessionService.modifierTypeSession(updatedTypeSession);
        TypeSessionDto result = typeSessionService.getTypeSessionById(1);
        assertNotNull(result);
        assertEquals(1, result.getIdTypeSession());
        assertEquals("Description2", result.getDescriptionTypeSession());
    }

    @Test
    public void testSupprimerTypeSession() {
        typeSessionService.supprimerTypeSession(1);
        List<TypeSessionDto> result = typeSessionService.getAllTypesSession();
        assertEquals(typeSessionDtos.size() - 1, result.size());
        assertNull(typeSessionService.getTypeSessionById(1));
    }
/*
    @AfterEach
    public void tearDown() {
        File xmlFile  = new File(TypeSessionXMLUtils.XML_FILE);
        if (xmlFile.exists()) {
            xmlFile.delete();
        }
    }*/
}
