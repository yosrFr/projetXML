package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.PersonnelDto;
import com.example.projet.projet.modele.Wrapper.PersonnelWrapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonnelXMLUtils {
    public static final String XML_FILE = "C:/Users/asus/Desktop/Personnel.xml";

    public void marshaller(List<PersonnelDto> affectationPersonnel) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(PersonnelWrapper.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            PersonnelWrapper wrapper = new PersonnelWrapper(affectationPersonnel);
            jaxbMarshaller.marshal(wrapper, new File(XML_FILE));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PersonnelDto> unmarshaller(){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(PersonnelWrapper.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            File file = new File(XML_FILE);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            PersonnelWrapper wrapper = (PersonnelWrapper) jaxbUnmarshaller.unmarshal(new File(XML_FILE));
            return wrapper.getPersonnel();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
