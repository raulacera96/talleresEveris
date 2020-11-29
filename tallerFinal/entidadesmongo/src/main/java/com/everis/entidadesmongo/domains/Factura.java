package com.everis.entidadesmongo.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("facturas")
public class Factura {
    private @Id String id;

    private String forma_pago;

    private List<Integer> lineas_factura;

    private String estado_factura;
}
