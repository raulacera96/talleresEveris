package com.curso.petclinic.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
/*
@Entity
@Table(name="bill_lines")*/
public class BillLine extends BaseEntity {
    //@Column(name = "line")
    //@NotEmpty
    private String line;

    /*@ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill_id;*/
}
