package com.everis.entidadesmongo.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("pagos")
public class Pago {
    private @Id String id;

    private String estado_pago;

    private int cliente_id;

    private int factura_id;
}
