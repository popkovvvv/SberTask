package com.sberbank.sber.service;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sberbank.sber.SberApplication;
import com.sberbank.sber.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Component
public class Parser {

    private static final Logger log = LoggerFactory.getLogger(SberApplication.class);

    @PostConstruct
    private void init() throws IOException, SAXException, ParserConfigurationException, XMLStreamException {
        log.info("AppInitializator initialization logic ...");

        InputStream xmlRessource = Parser.class.getClassLoader().getResourceAsStream("sber.xml");

        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(xmlRessource);

        XmlMapper mapper = new XmlMapper();
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        Order order = mapper.readValue(xmlStreamReader, Order.class);
        System.err.println(order);

    }
}
