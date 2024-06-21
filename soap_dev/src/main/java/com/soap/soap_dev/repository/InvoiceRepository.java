package com.soap.soap_dev.repository;

import com.soap.soap_dev.model.InvoiceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<InvoiceModel, Long> {
    InvoiceModel findByNumeroDocumento(String numeroDocumento);
}