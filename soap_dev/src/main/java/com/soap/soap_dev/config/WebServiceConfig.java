package com.soap.soap_dev.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig  extends WsConfigurerAdapter{

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean
    public XsdSchema invoiceSchema() {
        return new SimpleXsdSchema(new ClassPathResource("invoice.xsd"));
    }
    @Bean
    public XsdSchema zipSchema() {
        return new SimpleXsdSchema(new ClassPathResource("zip.xsd"));
    }

    @Bean
    public DefaultWsdl11Definition defaultInvoiceWsdl11Definition(XsdSchema invoiceSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(invoiceSchema);
        definition.setLocationUri("/ws");
        definition.setPortTypeName("InvoicesPort");
        definition.setTargetNamespace("http://www.example.com/demosoap/gen");
        return definition;
    }
    @Bean
    public DefaultWsdl11Definition defaultZipWsdl11Definition(XsdSchema zipSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(zipSchema);
        definition.setLocationUri("/ws");
        definition.setPortTypeName("ZipPort");
        definition.setTargetNamespace("http://www.example.com/demosoap/zip");
        return definition;
    }


}