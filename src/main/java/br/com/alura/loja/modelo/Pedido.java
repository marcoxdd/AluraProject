package br.com.alura.loja.modelo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data = LocalDate.now();
    private Double valorTotal;
    @ManyToOne
    private Cliente cliente;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    List<ItenPedido> itensPedido = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(LocalDate data, Double valorTotal, Cliente cliente_id) {
        this.data = data;
        this.valorTotal = valorTotal;
        this.cliente = cliente_id;

    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItenPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItenPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public void adicionarItem(ItenPedido item){
        item.setPedido(this);
        this.itensPedido.add(item);
    }


}