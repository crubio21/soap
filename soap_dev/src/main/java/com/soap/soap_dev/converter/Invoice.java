package com.soap.soap_dev.converter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    private int idFacturador;
    private String correoCliente;
    private String numeroDocumento;
    private String prefijo;
    private String tipoDocumento;
}
