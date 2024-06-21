package com.soap.soap_dev.domain;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "checkZipRequest", namespace = "http://www.example.com/demosoap/zip")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheckZipRequest {
    @XmlElement(required = true, namespace = "http://www.example.com/demosoap/zip")
    private String zipXmlBase64;
}
