package com.everis.serviciocliente.domains;

import javax.persistence.*;

@Entity
@Table(name="direccion")
public class Direccion {
    @Id
    private Integer id;

    @Column(name = "linea_dir")
    private String lineaDir;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "cliente_id")
    private Integer clienteId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLineaDir() {
        return lineaDir;
    }

    public void setLineaDir(String lineaDir) {
        this.lineaDir = lineaDir;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

}
