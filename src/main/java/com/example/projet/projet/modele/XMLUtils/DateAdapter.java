package com.example.projet.projet.modele.XMLUtils;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter extends XmlAdapter<String, Date> {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date unmarshal(String v) throws Exception {
        return DATE_FORMAT.parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return DATE_FORMAT.format(v);
    }
}