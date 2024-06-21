package com.soap.soap_dev.repository;

import com.soap.soap_dev.model.InvoiceModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<InvoiceModel, Long> {
    Optional<InvoiceModel> findByNumeroDocumento(String numeroDocumento);
}