package com.sberbank.sber.service.utils;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class FindAttribute extends DefaultHandler {

    public FindAttribute() { }

    private List<String> result;

    public List<String> getAttributes() {
        return result;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if("par".equals(qName) && "1".equals(attributes.getValue("step")) && "ГРАЖДАНСТВО".equals(attributes.getValue("name"))) {
            result = new ArrayList<>();
            for(int i = 0; i < attributes.getLength(); i++){
                result.add(attributes.getQName(i) + " = " + attributes.getValue(i));
            }
        }
    }
}
