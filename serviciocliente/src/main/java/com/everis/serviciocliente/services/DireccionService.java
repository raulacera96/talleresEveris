package com.everis.serviciocliente.services;

//import com.everis.entidadesmysql.domains.Direccion;
import com.everis.serviciocliente.domains.Direccion;

import java.util.Collection;
import java.util.List;

public interface DireccionService {
    public Collection<Direccion> findAll();

    public List<Direccion> save(List<Direccion> direcciones);

    public Direccion save(Direccion direccion);

    public void deleteById(Integer direccionId);

    public Collection<Direccion> getDireccionesCliente(int cliente_id);
}
