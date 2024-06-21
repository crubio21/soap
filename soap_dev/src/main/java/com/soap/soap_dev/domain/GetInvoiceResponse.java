package com.soap.soap_dev.domain;

import com.soap.soap_dev.converter.Invoice;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "invoice"
})
@XmlRootElement(name = "getInvoiceResponse")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetInvoiceResponse {
    @XmlElement(required = true)
    private Invoice invoice;
}
