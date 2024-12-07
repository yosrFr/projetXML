package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.SessionDto;
import com.example.projet.projet.modele.Wrapper.SessionWrapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class SessionXMLUtils {
    public static final String XML_FILE = "C:/Users/asus/Desktop/Session.xml";

    public void marshaller(List<SessionDto> sessions) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(SessionWrapper.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            SessionWrapper wrapper = new SessionWrapper(sessions);
            jaxbMarshaller.marshal(wrapper, new File(XML_FILE));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SessionDto> unmarshaller(){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(SessionWrapper.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            File file = new File(XML_FILE);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            SessionWrapper wrapper = (SessionWrapper) jaxbUnmarshaller.unmarshal(new File(XML_FILE));
            return wrapper.getSessions();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
