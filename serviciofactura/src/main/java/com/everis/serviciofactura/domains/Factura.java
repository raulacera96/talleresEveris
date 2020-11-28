package com.everis.serviciofactura.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("facturas")
public class Factura {
    private @Id Integer id;

    private String formaPago;

    private List<Integer> lineasFactura;

    private String estadoFactura;

    private Integer clienteId;

    private double importe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public List<Integer> getLineasFactura() {
        return lineasFactura;
    }

    public void setLineasFactura(List<Integer> lineasFactura) {
        this.lineasFactura = lineasFactura;
    }

    public String getEstadoFactura() {
        return estadoFactura;
    }

    public void setEstadoFactura(String estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
