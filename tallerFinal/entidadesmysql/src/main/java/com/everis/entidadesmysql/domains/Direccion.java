package com.everis.entidadesmysql.domains;

import javax.persistence.*;

@Entity
@Table(name="direcciones")
public class Direccion {
    @Id
    private Integer id;

    @Column(name = "linea_dir")
    private String linea_dir;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "cliente_id")
    private Integer cliente_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinea_dir() {
        return linea_dir;
    }

    public void setLinea_dir(String linea_dir) {
        this.linea_dir = linea_dir;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Integer getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Integer cliente_id) {
        this.cliente_id = cliente_id;
    }

}
