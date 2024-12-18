package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.RolePersonnelDto;
import com.example.projet.projet.modele.Wrapper.RolePersonnelWrapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class RolePersonnelXMLUtils {
    public static final String XML_FILE = "../donnees/RolesPersonnel.xml";

    public void marshaller(List<RolePersonnelDto> rolePersonnel) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(RolePersonnelWrapper.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.example.com/RolesPersonnel RolesPersonnel.xsd");
            RolePersonnelWrapper wrapper = new RolePersonnelWrapper(rolePersonnel);
            jaxbMarshaller.marshal(wrapper, new File(XML_FILE));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public List<RolePersonnelDto> unmarshaller(){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(RolePersonnelWrapper.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            File file = new File(XML_FILE);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            RolePersonnelWrapper wrapper = (RolePersonnelWrapper) jaxbUnmarshaller.unmarshal(new File(XML_FILE));
            return wrapper.getRolesPersonnel();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
