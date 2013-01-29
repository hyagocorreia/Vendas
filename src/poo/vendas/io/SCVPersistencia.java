package poo.vendas.io;

import java.util.List;

import poo.vendas.Cliente;
import poo.vendas.ItemDePedido;
import poo.vendas.Pedido;
import poo.vendas.Produto;

public interface SCVPersistencia {
	public abstract void salvar(Produto produto);
	public abstract void salvar(Cliente cliente);
	public abstract void salvar(ItemDePedido item);
	public abstract void salvar(Pedido pedido);
	public abstract List<Produto> recuperarProdutos();
	public abstract List<Cliente> recuperarClientes();
	public abstract List<ItemDePedido> recuperarItemPedidos();
	public abstract List<Pedido> recuperarPedidos();
}
