package com.soap.soap_dev.converter;


import com.soap.soap_dev.model.InvoiceModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InvoiceConverter {

    public  InvoiceModel convertInvoiceToInvoiceModel(Invoice invoice) {
        InvoiceModel invoiceModel = new InvoiceModel();
        invoiceModel.setIdFacturador(invoice.getIdFacturador());
        invoiceModel.setCorreoCliente(invoice.getCorreoCliente());
        invoiceModel.setNumeroDocumento(invoice.getNumeroDocumento());
        invoiceModel.setPrefijo(invoice.getPrefijo());
        invoiceModel.setTipoDocumento(invoice.getTipoDocumento());
        return invoiceModel;
    }

    public Invoice convertInvoiceModelToInvoice(InvoiceModel invoiceModel) {
        Invoice invoice = new Invoice();
        invoice.setIdFacturador(invoiceModel.getIdFacturador());
        invoice.setCorreoCliente(invoiceModel.getCorreoCliente());
        invoice.setNumeroDocumento(invoiceModel.getNumeroDocumento());
        invoice.setPrefijo(invoiceModel.getPrefijo());
        invoice.setTipoDocumento(invoiceModel.getTipoDocumento());
        return invoice;
    }

    public List<InvoiceModel> convertInvoicesToInvoiceModels(List<Invoice> invoices) {
        List<InvoiceModel> invoiceModels = new ArrayList<>();
        for (Invoice invoice : invoices) {
            invoiceModels.add(convertInvoiceToInvoiceModel(invoice));
        }
        return invoiceModels;
    }

    public List<Invoice> convertInvoiceModelsToInvoices(List<InvoiceModel> InvoiceModels) {
        List<Invoice> invoices = new ArrayList<>();
        for (InvoiceModel InvoiceModel : InvoiceModels) {
            invoices.add(convertInvoiceModelToInvoice(InvoiceModel));
        }
        return invoices;
    }


}