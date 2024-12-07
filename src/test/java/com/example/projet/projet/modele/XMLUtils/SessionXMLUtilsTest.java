package com.example.projet.projet.modele.XMLUtils;

import com.example.projet.projet.modele.Dto.SessionDto;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SessionXMLUtilsTest {
    private SessionXMLUtils sessionXMLUtils;
    private Marshaller mockMarshaller;
    private Unmarshaller mockUnmarshaller;

    @BeforeEach
    public void setUp() {
        sessionXMLUtils = new SessionXMLUtils();
        mockMarshaller = mock(Marshaller.class);
        mockUnmarshaller = mock(Unmarshaller.class);
    }

    @Test
    public void testMarshal() throws JAXBException {
        SessionDto sessionDto = new SessionDto(1L, new Date(), "Test Session", LocalTime.of(9, 0), LocalTime.of(12, 0));

        // Mocking marshaller
        doNothing().when(mockMarshaller).marshal(sessionDto, new File("sessions.xml"));

        List<SessionDto> list = new ArrayList<>();
        list.add(sessionDto);
        // Verifying marshalling process
        sessionXMLUtils.marshaller(list);

        verify(mockMarshaller, times(1)).marshal(sessionDto, new File("sessions.xml"));
    }

    @Test
    public void testUnmarshal() throws JAXBException {
        // Mocking unmarshaller
        when(mockUnmarshaller.unmarshal(new File("sessions.xml"))).thenReturn(new SessionDto(1L, new Date(), "Test Session", LocalTime.of(9, 0), LocalTime.of(12, 0)));

        // Verifying unmarshalling process
        SessionDto result = (SessionDto) sessionXMLUtils.unmarshaller();

        assertEquals(1L, result.getIdSession());
        assertEquals("Test Session", result.getTitreSession());
        assertEquals(LocalTime.of(9, 0), result.getHeureDebutSession());
        assertEquals(LocalTime.of(12, 0), result.getHeureFinSession());
    }
}
