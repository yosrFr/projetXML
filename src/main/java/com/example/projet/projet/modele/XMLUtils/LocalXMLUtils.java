package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.LocalDto;
import com.example.projet.projet.modele.Wrapper.LocalWrapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class LocalXMLUtils {
    public static final String XML_FILE = "C:/Users/asus/Desktop/Local.xml";

    public void marshaller(List<LocalDto> local) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(LocalWrapper.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            LocalWrapper wrapper = new LocalWrapper(local);
            jaxbMarshaller.marshal(wrapper, new File(XML_FILE));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public List<LocalDto> unmarshaller(){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(LocalWrapper.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            File file = new File(XML_FILE);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            LocalWrapper wrapper = (LocalWrapper) jaxbUnmarshaller.unmarshal(new File(XML_FILE));
            return wrapper.getLocals();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
