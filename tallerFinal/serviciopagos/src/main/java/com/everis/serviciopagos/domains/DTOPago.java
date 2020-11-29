package com.everis.serviciopagos.domains;

import java.util.ArrayList;

public class DTOPago {
    private ArrayList<Pago> pagos;

    public DTOPago() {
        pagos = new ArrayList<Pago>();
    }

    public ArrayList<Pago> getListaPagos() {
        return pagos;
    }

    public void setListaPagos(ArrayList<Pago> pagos) {
        this.pagos = pagos;
    }
}
