package com.example.projet.projet.modele.XMLUtils;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeAdapter extends XmlAdapter<String, LocalTime> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public LocalTime unmarshal(String v) throws Exception {
        return LocalTime.parse(v, FORMATTER);
    }

    @Override
    public String marshal(LocalTime v) throws Exception {
        return v.format(FORMATTER);
    }
}


