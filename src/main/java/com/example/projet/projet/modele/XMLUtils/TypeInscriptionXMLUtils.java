package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.TypeInscriptionDto;
import com.example.projet.projet.modele.Wrapper.TypeInscriptionWrapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class TypeInscriptionXMLUtils {
    public static final String XML_FILE = "C:/Users/asus/Desktop/TypeInscription.xml";

    public void marshaller(List<TypeInscriptionDto> typeInscription){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(TypeInscriptionWrapper.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            TypeInscriptionWrapper wrapper = new TypeInscriptionWrapper(typeInscription);
            jaxbMarshaller.marshal(wrapper, new File(XML_FILE));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TypeInscriptionDto> unmarshaller(){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(TypeInscriptionWrapper.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            File file = new File(XML_FILE);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            TypeInscriptionWrapper wrapper = (TypeInscriptionWrapper) jaxbUnmarshaller.unmarshal(new File(XML_FILE));
            return wrapper.getTypesInscription();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}