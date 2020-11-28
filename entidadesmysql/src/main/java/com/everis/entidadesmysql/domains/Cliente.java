package com.everis.entidadesmysql.domains;

import javax.persistence.*;

@Entity
@Table(name="clientes")
public class Cliente {
    @Id
    private Integer id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "estado_cliente")
    private String estado_cliente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEstado_cliente() {
        return estado_cliente;
    }

    public void setEstado_cliente(String estado_cliente) {
        this.estado_cliente = estado_cliente;
    }
}
