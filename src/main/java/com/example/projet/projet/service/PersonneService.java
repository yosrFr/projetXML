package com.example.projet.projet.service;

import com.example.projet.projet.modele.XMLUtils.PersonneXMLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonneService {
    @Autowired
    private PersonneXMLUtils personneXMLUtils;

    public PersonneService(PersonneXMLUtils personneXMLUtils) {
        this.personneXMLUtils = personneXMLUtils;
    }
}
