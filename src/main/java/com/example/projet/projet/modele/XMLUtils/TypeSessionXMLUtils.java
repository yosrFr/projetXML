package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.TypeSessionDto;
import com.example.projet.projet.modele.Wrapper.TypeSessionWrapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class TypeSessionXMLUtils {
    public static final String XML_FILE = "C:/Users/asus/Desktop/TypeSession.xml";

    public void marshaller(List<TypeSessionDto> typeSessions) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(TypeSessionWrapper.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            TypeSessionWrapper wrapper = new TypeSessionWrapper(typeSessions);
            jaxbMarshaller.marshal(wrapper, new File(XML_FILE));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TypeSessionDto> unmarshaller(){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(TypeSessionWrapper.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            File file = new File(XML_FILE);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            TypeSessionWrapper wrapper = (TypeSessionWrapper) jaxbUnmarshaller.unmarshal(new File(XML_FILE));
            return wrapper.getTypeSession();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
