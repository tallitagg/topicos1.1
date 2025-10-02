package org.acme.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente extends DefaultEntity {

    @OneToOne(optional = false)
    @JoinColumn(name = "usuario_id", nullable = false, foreignKey = @ForeignKey(name = "fk_cliente_usuario"))
    private Usuario usuario;

    @ManyToMany
    @JoinTable(name = "cliente_lista_desejo",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> listaDesejo;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Produto> getListaDesejo() {
        return listaDesejo;
    }

    public void setListaDesejo(List<Produto> listaDesejo) {
        this.listaDesejo = listaDesejo;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
