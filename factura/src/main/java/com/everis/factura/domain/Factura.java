package com.everis.factura.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Factura")
public class Factura {
    private @Id String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
