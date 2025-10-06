package org.acme.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.acme.model.enums.MetodoPagamento;
import org.acme.model.enums.StatusPagamento;

@Entity
@Table(name = "pagamento")
public class Pagamento extends DefaultEntity {

    @OneToOne
    @JoinColumn(name = "pedido_id",  nullable = false,
                foreignKey = @ForeignKey(name = "fk_pagamento_pedido"))
    private Pedido pedido;

    @NotNull
    @PositiveOrZero
    @Column(nullable = false)
    private Double valor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusPagamento status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 12)
    private MetodoPagamento metodo;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }

    public MetodoPagamento getMetodo() {
        return metodo;
    }

    public void setMetodo(MetodoPagamento metodo) {
        this.metodo = metodo;
    }
}
