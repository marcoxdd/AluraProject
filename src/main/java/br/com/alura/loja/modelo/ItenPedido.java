package br.com.alura.loja.modelo;

import javax.persistence.*;

@Entity
@Table(name = "itens_pedido")
public class ItenPedido {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double precoUnitario;
    private Integer quantidade;
    @ManyToOne
    private Produto produto;
    @ManyToOne
    private Pedido pedido;

    public ItenPedido() {
    }

    public ItenPedido(Integer quantidade, Produto produto, Pedido pedido) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.pedido = pedido;
        this.precoUnitario = produto.getPreco();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
