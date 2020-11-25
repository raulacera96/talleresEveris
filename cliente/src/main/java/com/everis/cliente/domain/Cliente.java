package com.everis.cliente.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Cliente")
public class Cliente {
    private @Id String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
