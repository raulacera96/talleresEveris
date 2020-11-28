package com.everis.serviciocliente.domains;

import java.util.ArrayList;

public class DTOFacturas {
    private ArrayList<Factura> facturas;

    public DTOFacturas() {
        facturas = new ArrayList<Factura>();
    }

    public ArrayList<Factura> getListaFacturas() {
        return facturas;
    }

    public void setListaFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }
}
