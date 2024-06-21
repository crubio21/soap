package com.soap.soap_dev.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class InvoiceModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idFacturador;
    private String correoCliente;
    private String numeroDocumento;
    private String prefijo;
    private String tipoDocumento;

}
