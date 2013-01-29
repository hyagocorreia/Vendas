package poo.vendas.io;

import java.util.ArrayList;
import java.util.List;

import poo.vendas.Cliente;
import poo.vendas.ItemDePedido;
import poo.vendas.Pedido;
import poo.vendas.Produto;

public class SCVPersistenciaMemoria implements SCVPersistencia{
	private List <Pedido> listaPedidos;
	private List<Produto> listaProdutos;
	private List<Cliente> listaClientes;
	private List<ItemDePedido> listaItemPedidos;
	
	public SCVPersistenciaMemoria(){
		this.listaPedidos = new ArrayList<Pedido>();
	}

	public void salvar(Pedido pedido) {
		listaPedidos.add(pedido);
	}
	
	public void salvar(Produto produto) {
		listaProdutos.add(produto);
		
	}

	public void salvar(Cliente cliente) {
		listaClientes.add(cliente);
	}

	public void salvar(ItemDePedido item) {
		listaItemPedidos.add(item);
	}
	
	public List<Pedido> recuperarPedidos() {
		return listaPedidos;
	}

	public List<Produto> recuperarProdutos() {
		return listaProdutos;
	}

	public List<Cliente> recuperarClientes() {
		return listaClientes;
	}

	public List<ItemDePedido> recuperarItemPedidos() {
		return listaItemPedidos;
	}
}
