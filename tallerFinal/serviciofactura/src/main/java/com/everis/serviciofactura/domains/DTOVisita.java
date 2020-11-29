package com.everis.serviciofactura.domains;

import java.util.ArrayList;

public class DTOVisita {
    private ArrayList<Visita> visitas;

    public DTOVisita() {
        visitas = new ArrayList<Visita>();
    }

    public ArrayList<Visita> getListaVisitas() {
        return visitas;
    }

    public void setListaVisitas(ArrayList<Visita> visitas) {
        this.visitas = visitas;
    }
}
