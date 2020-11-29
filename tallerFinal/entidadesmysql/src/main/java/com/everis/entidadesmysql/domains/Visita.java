package com.everis.entidadesmysql.domains;

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
    private Date visit_date;

    @Digits(integer = 5, fraction = 2)
    @DecimalMin("0.0")
    @Column(name = "importe")
    private double importe;

    @Column(name = "estado_visita")
    private String estado_visita;

    @Column(name = "cliente_id")
    private Integer cliente;
}