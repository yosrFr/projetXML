package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.ReservationLocalDto;
import com.example.projet.projet.modele.Wrapper.ReservationLocalWrapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class ReservationLocalXMLUtils {
    public static final String XML_FILE = "C:/Users/asus/Desktop/ReservationLocal.xml";

    public void marshaller(List<ReservationLocalDto> reservationLocal) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(ReservationLocalWrapper.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            ReservationLocalWrapper wrapper = new ReservationLocalWrapper(reservationLocal);
            jaxbMarshaller.marshal(wrapper, new File(XML_FILE));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ReservationLocalDto> unmarshaller(){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(ReservationLocalWrapper.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            File file = new File(XML_FILE);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            ReservationLocalWrapper wrapper = (ReservationLocalWrapper) jaxbUnmarshaller.unmarshal(new File(XML_FILE));
            return wrapper.getReservationsLocal();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
