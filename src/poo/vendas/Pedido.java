package poo.vendas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Pedido {
	private String data;
	private Cliente cliente;
	private Integer codigoPedido ;
	private ArrayList<ItemDePedido> listaItens = new ArrayList<ItemDePedido>();
	@SuppressWarnings("unused")
	private HashMap<Produto, ItemDePedido> mapItens = new HashMap<Produto, ItemDePedido>();	
	
	public void addProduto(Produto produto){
		ItemDePedido item = new ItemDePedido(produto, 1);
		listaItens.add(item);
		//mapItens.put(produto, new ItemDePedido(produto, 1));
	}
	
	public void addProdturo(Produto produto, int qtde){
		ItemDePedido item = new ItemDePedido(produto, qtde);
		listaItens.add(item);
		//if(mapItens.containsKey(produto)){
		//	mapItens.put(produto, new ItemDePedido(produto,qtde));
		//}
	}
	
	public double totalPedido(){
		double total = 0;
		for (ItemDePedido item : listaItens) {
			total += item.getProduto().getPreco() * item.getQuantidade();
		}
		return total;
	}
	
	public void setListaItens(ArrayList<ItemDePedido> itenspedido) {
		listaItens = itenspedido;
	}
	
	public Iterator<ItemDePedido> listarItensPedido() {
		return listaItens.iterator();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setCodigo(int codigo) {
		this.codigoPedido = codigo;
	}
	
	public Integer getCodigo() {
		return codigoPedido;
	}
}