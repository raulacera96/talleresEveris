package com.everis.serviciocliente.services.imp;

//import com.everis.entidadesmysql.domains.Cliente;
import com.everis.serviciocliente.domains.Cliente;

import com.everis.serviciocliente.repositories.ClienteRepository;
import com.everis.serviciocliente.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ClienteServiceImp implements ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public Collection<Cliente> findAll() { return clienteRepository.findAll(); }

    public List<Cliente> save(List<Cliente> clientes){
        return clienteRepository.save(clientes);
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteById(Integer cliente) { clienteRepository.deleteById(cliente); }

    public Cliente findById(int id) { return clienteRepository.findById(id); }
}
