package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.MaterielDto;
import com.example.projet.projet.modele.Wrapper.MaterielWrapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class MaterielXMLUtils {
    public static final String XML_FILE = "C:/Users/asus/Desktop/Materiel.xml";

    public void marshaller(List<MaterielDto> materiels) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(MaterielWrapper.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            MaterielWrapper wrapper = new MaterielWrapper(materiels);
            jaxbMarshaller.marshal(wrapper, new File(XML_FILE));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MaterielDto> unmarshaller(){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(MaterielWrapper.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            File file = new File(XML_FILE);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            MaterielWrapper wrapper = (MaterielWrapper) jaxbUnmarshaller.unmarshal(new File(XML_FILE));
            return wrapper.getMateriels();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
