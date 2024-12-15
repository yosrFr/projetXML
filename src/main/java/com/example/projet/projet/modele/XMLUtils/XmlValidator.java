package com.example.projet.projet.modele.XMLUtils;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class XmlValidator {

    public static void main(String[] args) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("../donnee/Inscriptions.xsd"));

            Validator validator = schema.newValidator();

            validator.validate(new StreamSource(new File("../donnee/Inscriptions.xml")));
            System.out.println("Le fichier XML est valide.");

        } catch (SAXException | IOException e) {
            System.err.println("Erreur de validation : " + e.getMessage());
        }
    }
}

