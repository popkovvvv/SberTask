package com.sberbank.sber.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;

@Data
public class ParList {
    @JacksonXmlProperty(isAttribute = true, localName = "value")
    private String value;

    @JacksonXmlText
    private String valueString;
}
