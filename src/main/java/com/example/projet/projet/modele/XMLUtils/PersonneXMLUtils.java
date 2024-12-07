package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.PersonneDto;
import com.example.projet.projet.modele.Wrapper.PersonneWrapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonneXMLUtils {
    private static final String XML_FILE = "Personne.xml";

    public void marshaller(List<PersonneDto> affectationPersonnel) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(PersonneWrapper.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            PersonneWrapper wrapper = new PersonneWrapper(affectationPersonnel);
            jaxbMarshaller.marshal(wrapper, new File(XML_FILE));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PersonneDto> unmarshaller(){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(PersonneWrapper.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            File file = new File(XML_FILE);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            PersonneWrapper wrapper = (PersonneWrapper) jaxbUnmarshaller.unmarshal(new File(XML_FILE));
            return wrapper.getPersonnes();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
