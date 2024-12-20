package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.ReservationMaterielsDto;
import com.example.projet.projet.modele.Wrapper.ReservationMaterielWrapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class ReservationMaterielXMLUtils {
    public static final String XML_FILE = "../donnees/ReservationMateriaux.xml";

    public void marshaller(List<ReservationMaterielsDto> reservationMateriel) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(ReservationMaterielWrapper.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.example.com/ReservationsMateriaux ReservationsMateriaux.xsd");
            ReservationMaterielWrapper wrapper = new ReservationMaterielWrapper(reservationMateriel);
            jaxbMarshaller.marshal(wrapper, new File(XML_FILE));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ReservationMaterielsDto> unmarshaller(){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(ReservationMaterielWrapper.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            File file = new File(XML_FILE);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            ReservationMaterielWrapper wrapper = (ReservationMaterielWrapper) jaxbUnmarshaller.unmarshal(new File(XML_FILE));
            return wrapper.getReservationMateriels();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
