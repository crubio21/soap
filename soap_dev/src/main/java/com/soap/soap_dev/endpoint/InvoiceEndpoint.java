package com.soap.soap_dev.endpoint;

import com.soap.soap_dev.converter.InvoiceConverter;
import com.soap.soap_dev.domain.GetInvoiceRequest;
import com.soap.soap_dev.domain.GetInvoiceResponse;
import com.soap.soap_dev.model.InvoiceModel;
import com.soap.soap_dev.repository.InvoiceRepository;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Optional;

@Endpoint
public class InvoiceEndpoint {
    private static final String NAMESPACE_URI = "http://www.example.com/demosoap/gen";
    private final InvoiceRepository invoiceRepository;
    private final InvoiceConverter invoiceConverter;

    public InvoiceEndpoint(InvoiceRepository invoiceRepository, InvoiceConverter invoiceConverter) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceConverter = invoiceConverter;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getInvoiceRequest")
    @ResponsePayload
    public GetInvoiceResponse getInvoice(@RequestPayload GetInvoiceRequest request) {
        GetInvoiceResponse response = new GetInvoiceResponse();
        Optional<InvoiceModel> optionalInvoiceModel = invoiceRepository.findByNumeroDocumento(request.getNumeroDocumento());
        if (optionalInvoiceModel.isPresent()) {
            InvoiceModel invoiceModel = optionalInvoiceModel.get();
            response.setInvoice(invoiceConverter.convertInvoiceModelToInvoice(invoiceModel));
        }
        return response;
    }

}
