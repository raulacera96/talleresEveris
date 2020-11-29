package com.everis.serviciocliente.services.imp;

//import com.everis.entidadesmysql.domains.Direccion;
import com.everis.serviciocliente.domains.Direccion;

import com.everis.serviciocliente.repositories.DireccionRepository;
import com.everis.serviciocliente.services.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class DireccionServiceImp implements DireccionService {
    @Autowired
    DireccionRepository direccionRepository;

    public Collection<Direccion> findAll() { return direccionRepository.findAll(); }

    public List<Direccion> save(List<Direccion> direcciones){
        return direccionRepository.save(direcciones);
    }

    public Direccion save(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    public void deleteById(Integer direccionId) { direccionRepository.deleteById(direccionId); }

    @Transactional(readOnly = true)
    public Collection<Direccion> getDireccionesCliente(int cliente_id) {
        return direccionRepository.findByClienteId(cliente_id);
    }

    @Transactional(readOnly = true)
    public List<Direccion> getDireccionesProvincia(String provincia) {
        return direccionRepository.findByProvinciaOrderByClienteId(provincia);
    }
}
