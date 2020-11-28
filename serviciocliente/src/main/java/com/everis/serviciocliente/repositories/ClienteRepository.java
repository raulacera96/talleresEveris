package com.everis.serviciocliente.repositories;

//import com.everis.entidadesmysql.domains.Cliente;
import com.everis.serviciocliente.domains.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    List<Cliente> save(List<Cliente> clientes);

    Cliente save(Cliente cliente);

    void deleteById(Integer cliente);

    Cliente findById(int id);

    List<Cliente> findAll();
}
