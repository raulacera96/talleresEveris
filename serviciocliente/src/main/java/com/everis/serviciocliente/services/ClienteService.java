package com.everis.serviciocliente.services;

//import com.everis.entidadesmysql.domains.Cliente;
import com.everis.serviciocliente.domains.Cliente;

import java.util.Collection;
import java.util.List;

public interface ClienteService {
    public Collection<Cliente> findAll();

    public List<Cliente> save(List<Cliente> clientes);

    public Cliente save(Cliente cliente);

    public void deleteById(Integer cliente);

    public Cliente findById(int id);
}
