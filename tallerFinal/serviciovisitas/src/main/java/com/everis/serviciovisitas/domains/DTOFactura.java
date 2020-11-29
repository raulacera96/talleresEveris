package com.everis.serviciovisitas.domains;

import java.util.ArrayList;

public class DTOFactura {
    private ArrayList<Factura> facturas;

    public DTOFactura() {
        facturas = new ArrayList<Factura>();
    }

    public ArrayList<Factura> getListaFacturas() {
        return facturas;
    }

    public void setListaFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }
}
