# Demo SOAP Services

Este proyecto proporciona servicios SOAP para consultar facturas y verificar archivos ZIP.

## URL del Servicio

Todos los servicios SOAP están disponibles en la siguiente URL:

localhost:{PORT}/ws

## Servicios Disponibles

### Consulta de Facturas

Para consultar una factura, utiliza la siguiente estructura de solicitud SOAP:

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:us="http://www.example.com/demosoap/gen">
    <soapenv:Header/>
    <soapenv:Body>
        <us:getInvoiceRequest>
            <us:numeroDocumento>1002</us:numeroDocumento>
        </us:getInvoiceRequest>
    </soapenv:Body>
</soapenv:Envelope>

### Validación de ZIP

Para validar un ZIP utiliza la siguiente estructura de solicitud SOAP:

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:us="http://www.example.com/demosoap/zip">
    <soapenv:Header/>
    <soapenv:Body>
        <us:checkZipRequest>
            <us:zipXmlBase64></us:zipXmlBase64>
        </us:checkZipRequest>
    </soapenv:Body>
</soapenv:Envelope>


