package com.soap.soap_dev.config;

import com.soap.soap_dev.model.InvoiceModel;
import com.soap.soap_dev.repository.InvoiceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public CommandLineRunner dataLoader(InvoiceRepository invoiceRepository) {
        return args -> {
            InvoiceModel invoice1 = new InvoiceModel();
            invoice1.setCorreoCliente("cliente1@example.com");
            invoice1.setNumeroDocumento("1001");
            invoice1.setPrefijo("INV");
            invoice1.setTipoDocumento("Factura");

            InvoiceModel invoice2 = new InvoiceModel();
            invoice2.setCorreoCliente("cliente2@example.com");
            invoice2.setNumeroDocumento("1002");
            invoice2.setPrefijo("INV");
            invoice2.setTipoDocumento("Factura");

            invoiceRepository.save(invoice1);
            invoiceRepository.save(invoice2);
        };
    }

}
