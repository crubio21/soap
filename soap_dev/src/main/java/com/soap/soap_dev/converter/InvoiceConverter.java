package com.soap.soap_dev.converter;


import com.soap.soap_dev.gen.Invoice;
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

    public Invoice convertInvoiceModelToInvoice(InvoiceModel InvoiceModel) {
        Invoice invoice = new Invoice();
        invoice.setIdFacturador(InvoiceModel.getIdFacturador());
        invoice.setCorreoCliente(InvoiceModel.getCorreoCliente());
        invoice.setNumeroDocumento(InvoiceModel.getNumeroDocumento());
        invoice.setPrefijo(InvoiceModel.getPrefijo());
        invoice.setTipoDocumento(InvoiceModel.getTipoDocumento());
        return invoice;
    }

    public List<InvoiceModel> convertInvoicesToInvoiceModels(List<Invoice> invoices) {
        List<InvoiceModel> invoiceModels = new ArrayList<InvoiceModel>();
        for (Invoice invoice : invoices) {
            invoiceModels.add(convertInvoiceToInvoiceModel(invoice));
        }
        return invoiceModels;
    }

    public List<Invoice> convertInvoiceModelsToInvoices(List<InvoiceModel> InvoiceModels) {
        List<Invoice> invoices = new ArrayList<Invoice>();
        for (InvoiceModel InvoiceModel : InvoiceModels) {
            invoices.add(convertInvoiceModelToInvoice(InvoiceModel));
        }
        return invoices;
    }


}