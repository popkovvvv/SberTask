package com.sberbank.sber.service.utils;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class DocumentTypes extends DefaultHandler {
    private List<String> result = null;
    private boolean isInListOfDocuments;

    public List<String> getDocuments() {
        return result;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if ("par".equals(qName) && "ВИД_ДОК".equals(attributes.getValue("name"))) {
            isInListOfDocuments = true;
            result = new ArrayList<>();
        }
        if (isInListOfDocuments && "par_list".equals(qName)) {
            result.add(attributes.getValue("value"));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if ("par".equals(qName)) {
            isInListOfDocuments = false;
        }
    }
}
