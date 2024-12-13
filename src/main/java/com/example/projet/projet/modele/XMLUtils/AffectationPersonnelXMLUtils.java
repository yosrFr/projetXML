package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.AffectationPersonnelDto;
import com.example.projet.projet.modele.Wrapper.AffectationPersonnelWrapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class AffectationPersonnelXMLUtils {
    public static final String XML_FILE = "../donnees/AffectationsPersonnel.xml";

    public void marshaller(List<AffectationPersonnelDto> affectationPersonnel) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(AffectationPersonnelWrapper.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            AffectationPersonnelWrapper wrapper = new AffectationPersonnelWrapper(affectationPersonnel);
            jaxbMarshaller.marshal(wrapper, new File(XML_FILE));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public List<AffectationPersonnelDto> unmarshaller(){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(AffectationPersonnelWrapper.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            File file = new File(XML_FILE);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            AffectationPersonnelWrapper wrapper = (AffectationPersonnelWrapper) jaxbUnmarshaller.unmarshal(new File(XML_FILE));
            return wrapper.getAffectationsPersonnel();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
