package com.everis.serviciovisitas.domains;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.util.Date;

@Entity
@Table(name="visitas")
public class Visita {
    @Id
    private Integer id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Column(name = "visit_date")
    private Date visitDate;

    @Digits(integer = 5, fraction = 2)
    @DecimalMin("0.0")
    @Column(name = "importe")
    private double importe;

    @Column(name = "estado_visita")
    private String estadoVisita;

    @Column(name = "cliente_id")
    private Integer clienteId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getEstadoVisita() {
        return estadoVisita;
    }

    public void setEstadoVisita(String estadoVisita) {
        this.estadoVisita = estadoVisita;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }
}