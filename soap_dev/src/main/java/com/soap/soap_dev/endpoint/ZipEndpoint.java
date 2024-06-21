package com.soap.soap_dev.endpoint;

import com.soap.soap_dev.domain.CheckZipRequest;
import com.soap.soap_dev.domain.CheckZipResponse;
import jakarta.xml.bind.JAXBElement;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.namespace.QName;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Endpoint
public class ZipEndpoint {
    private static final String NAMESPACE_URI = "http://www.example.com/demosoap/zip";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "checkZipRequest")
    @ResponsePayload
    public JAXBElement<CheckZipResponse> checkZip(@RequestPayload CheckZipRequest request) {
        boolean isValid = isValidZipXmlBase64(request.getZipXmlBase64());
        CheckZipResponse response = new CheckZipResponse();
        response.setValid(isValid);
        return new JAXBElement<>(new QName(NAMESPACE_URI, "checkZipResponse"), CheckZipResponse.class, response);
    }
    private boolean isValidZipXmlBase64(String zipXmlBase64) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(zipXmlBase64);
            ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(decodedBytes));
            ZipEntry entry = zipInputStream.getNextEntry();
            zipInputStream.closeEntry();
            zipInputStream.close();
            return entry != null;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
