package com.sberbank.sber.service;

import com.sberbank.sber.model.Dict;
import com.sberbank.sber.repo.DictionaryRepo;
import com.sberbank.sber.service.utils.DocumentTypes;
import com.sberbank.sber.service.utils.FindAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import javax.annotation.PostConstruct;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

@Component
public class Parser extends DefaultHandler {

    private DictionaryRepo dictionaryRepo;

    public Parser(@Autowired DictionaryRepo dictionaryRepo) {
        this.dictionaryRepo = dictionaryRepo;
    }

    @PostConstruct
    private void init() throws IOException{
        File file = ResourceUtils.getFile("classpath:sber.xml");
        findDocumentsInXML(file);
        findAttributesInXML(file);
    }

    private void findDocumentsInXML(File source) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            DocumentTypes finder = new DocumentTypes();
            xmlReader.setContentHandler(finder);
            xmlReader.parse(source.toString());
            Dict dict = new Dict("docs", finder.getDocuments());
            dictionaryRepo.save(dict);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void findAttributesInXML(File source) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            FindAttribute finder = new FindAttribute();
            xmlReader.setContentHandler(finder);
            xmlReader.parse(source.toString());
            Dict dict = new Dict("attributes", finder.getAttributes());
            dictionaryRepo.save(dict);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }


}
