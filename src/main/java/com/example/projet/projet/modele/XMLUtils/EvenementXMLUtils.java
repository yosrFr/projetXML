package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.EvenementDto;
import com.example.projet.projet.modele.Wrapper.EvenementWrapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class EvenementXMLUtils {
    public static final String XML_FILE = "../donnees/Evenements.xml";

    public void marshaller(List<EvenementDto> evenements) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(EvenementWrapper.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.example.com/Evenements Evenements.xsd");
            EvenementWrapper wrapper = new EvenementWrapper(evenements);
            jaxbMarshaller.marshal(wrapper, new File(XML_FILE));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public List<EvenementDto> unmarshaller(){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(EvenementWrapper.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            File file = new File(XML_FILE);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            EvenementWrapper wrapper = (EvenementWrapper) jaxbUnmarshaller.unmarshal(new File(XML_FILE));
            return wrapper.getEvenements();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
