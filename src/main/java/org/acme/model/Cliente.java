package org.acme.model;

import jakarta.persistence.*;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import java.util.List;

@Entity
public class Cliente extends DefaultEntity {

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    private List<ItemPedido> listaDesejo;



}
