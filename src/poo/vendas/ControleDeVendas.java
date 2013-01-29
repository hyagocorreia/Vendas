package poo.vendas;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class ControleDeVendas {
	
	Set<Cliente> clientes = new HashSet<Cliente>();
	Set<Produto> produtos = new HashSet<Produto>();
	ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	
	public Pedido novoPedido(Pedido pedido) {
		pedidos.add(pedido);
		return pedido;
	}
	
	public ArrayList<Pedido> listarPedidos() {
		return pedidos;
	}
	
	public ArrayList<Pedido> listarPedidos(Date data) {
		ArrayList<Pedido> pedidosC = new ArrayList<Pedido>();
		for (int i = 0; i < pedidos.size(); i++) {
			if (pedidos.get(i).getData().equals(data)) {
				pedidosC.add(pedidos.get(i));
			}
		}
		return pedidosC;
	}
	
	public ArrayList<Pedido> listarPedidos(Cliente cliente) {
		ArrayList<Pedido> pedidosC = new ArrayList<Pedido>();
		for (int i = 0; i < pedidos.size(); i++) {
			if (pedidos.get(i).getCliente().equals(cliente)) {
				pedidosC.add(pedidos.get(i));
			}
		}
		return pedidosC;
	}
	
	public void addProduto(Produto produto) {
		produtos.add(produto);
	}
	
	public void addCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public Cliente getCliente(String cpf) {
		Iterator<Cliente> iCliente = clientes.iterator();
		while (iCliente.hasNext()){
			Cliente c = iCliente.next();
			if (c.getCpf().equals(cpf)) {
				return c;
			}
		}
		return null;
	}
	
	public Set<Cliente> getClientes() {
		return clientes;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}
	
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}
	
}