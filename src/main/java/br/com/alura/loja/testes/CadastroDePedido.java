package br.com.alura.loja.testes;

import br.com.alura.loja.PedidoDao;
import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.*;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;

public class CadastroDePedido {

    public static void main(String[] args) {
        cadastrarProduto();
        cadastrarPedido();
        EntityManager em = JPAUtil.getEntityManager();
        PedidoDao pedidoDao = new PedidoDao(em);
        Pedido pedido = pedidoDao.buscarPorId(1l);
        System.out.println("Pedido do cliente: " + pedido.getCliente().getNome());
    }

    private static void cadastrarPedido() {
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        Cliente cliente = new Cliente("Marco", "029.318.150.04");
        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItenPedido(10, produtoDao.buscarPorId(1l), pedido));
        PedidoDao pedidoDao = new PedidoDao(em);
        ClienteDao clienteDao = new ClienteDao(em);
        em.getTransaction().begin();
        clienteDao.cadastrar(cliente);
        pedidoDao.cadastrar(pedido);
        em.getTransaction().commit();
        em.close();
    }

    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi Redmi", "Muito legal", 800.00 , celulares );

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);

        em.getTransaction().commit();
        em.close();
    }
}
