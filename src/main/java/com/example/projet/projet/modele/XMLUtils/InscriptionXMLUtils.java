package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.InscriptionDto;
import com.example.projet.projet.modele.Wrapper.InscriptionWrapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class InscriptionXMLUtils {
    public static final String XML_FILE = "C:/Users/asus/Desktop/Inscription.xml";

    public void marshaller(List<InscriptionDto> inscriptions) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(InscriptionWrapper.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            InscriptionWrapper wrapper = new InscriptionWrapper(inscriptions);
            jaxbMarshaller.marshal(wrapper, new File(XML_FILE));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public List<InscriptionDto> unmarshaller(){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(InscriptionWrapper.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            File file = new File(XML_FILE);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            InscriptionWrapper wrapper = (InscriptionWrapper) jaxbUnmarshaller.unmarshal(new File(XML_FILE));
            return wrapper.getInscriptions();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
