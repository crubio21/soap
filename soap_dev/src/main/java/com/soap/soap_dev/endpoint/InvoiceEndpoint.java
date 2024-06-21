package com.soap.soap_dev.endpoint;

import com.soap.soap_dev.gen.*;
import com.soap.soap_dev.repository.InvoiceRepository;
import com.soap.soap_dev.converter.InvoiceConverter;
import com.soap.soap_dev.model.InvoiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class InvoiceEndpoint {

    private static final String NAMESPACE_URI = "http://www.soap.com/soap_dev/gen";

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceConverter invoiceConverter;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getInvoiceRequest")
    @ResponsePayload
    public GetInvoiceResponse getInvoice(@RequestPayload GetInvoiceRequest request) {
        GetInvoiceResponse response = new GetInvoiceResponse();
        InvoiceModel invoiceModel = invoiceRepository.findByNumeroDocumento(request.getNumeroDocumento());
        response.setInvoice(invoiceConverter.convertInvoiceModelToInvoice(invoiceModel));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getInvoicesRequest")
    @ResponsePayload
    public GetInvoicesResponse getInvoices(@RequestPayload GetInvoicesRequest request) {
        GetInvoicesResponse response = new GetInvoicesResponse();
        List<InvoiceModel> invoiceModels = invoiceRepository.findAll();
        List<Invoice> invoices = invoiceConverter.convertInvoiceModelsToInvoices(invoiceModels);
        response.getInvoices().addAll(invoices);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postInvoiceRequest")
    @ResponsePayload
    public PostInvoiceResponse postInvoices(@RequestPayload PostInvoiceRequest request) {
        PostInvoiceResponse response = new PostInvoiceResponse();
        InvoiceModel invoiceModel = invoiceConverter.convertInvoiceToInvoiceModel(request.getInvoice());
        Invoice invoice = invoiceConverter.convertInvoiceModelToInvoice(invoiceRepository.save(invoiceModel));
        response.setInvoice(invoice);
        return response;
    }



}
