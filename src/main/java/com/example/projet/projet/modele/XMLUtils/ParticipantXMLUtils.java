package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.ParticipantDto;
import com.example.projet.projet.modele.Wrapper.ParticipantWrapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class ParticipantXMLUtils {
    private static final String XML_FILE = "Participant.xml";

    public void marshaller(List<ParticipantDto> participants) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(ParticipantWrapper.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            ParticipantWrapper wrapper = new ParticipantWrapper(participants);
            jaxbMarshaller.marshal(wrapper, new File(XML_FILE));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ParticipantDto> unmarshaller(){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(ParticipantWrapper.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            File file = new File(XML_FILE);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            ParticipantWrapper wrapper = (ParticipantWrapper) jaxbUnmarshaller.unmarshal(new File(XML_FILE));
            return wrapper.getParticipants();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
