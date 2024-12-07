package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.CategorieEvenementDto;
import com.example.projet.projet.modele.Wrapper.CategorieEvenementWrapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class CategorieEvenementXMLUtils {
    public static final String XML_FILE = "C:/Users/asus/Desktop/CategorieEvenement.xml";

    public void marshaller(List<CategorieEvenementDto> categorieEvenement) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(CategorieEvenementWrapper.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            CategorieEvenementWrapper wrapper = new CategorieEvenementWrapper(categorieEvenement);
            jaxbMarshaller.marshal(wrapper, new File(XML_FILE));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public List<CategorieEvenementDto> unmarshaller(){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(CategorieEvenementWrapper.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            File file = new File(XML_FILE);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            CategorieEvenementWrapper wrapper = (CategorieEvenementWrapper) jaxbUnmarshaller.unmarshal(new File(XML_FILE));
            return wrapper.getCategoriesEvenement();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
