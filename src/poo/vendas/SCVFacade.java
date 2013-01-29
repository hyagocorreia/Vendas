package poo.vendas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import poo.vendas.io.SCVPersistencia;
import poo.vendas.io.SCVPersistenciaException;
import poo.vendas.io.SCVPersistenciaMemoria;

public class SCVFacade {
	private SCVPersistencia persistencia;
	private static int numPedido = 0;
	public SCVFacade(){
		persistencia = new SCVPersistenciaMemoria();
	}

	public Cliente criarCliente(String nome, String cpf, String telefone) throws SCVException {
		Cliente cliente = new Cliente(nome, cpf, telefone);
		persistencia.salvar(cliente);
		return cliente;
	}

	public Produto criarProduto(int codigo, String nome, String descricao, double preco) throws SCVException {
		List <Produto> aux = persistencia.recuperarProdutos();
		for(Produto p: aux){
			if(p.getCodigo() == codigo || p.getNome().equals(nome))
				throw new SCVException("Código ou nome já existem!");
		}
		Produto produto = new Produto(nome, preco);
		produto.setCodigo(codigo);
		produto.setDescricao(descricao);
		persistencia.salvar(produto);
		return produto;
	}

	public Produto criarProdutoPerecivel(int codigo, String nome, String descricao, double preco, String validade) throws SCVException {
		List <Produto> aux = persistencia.recuperarProdutos();
		for(Produto p: aux){
			if(p.getCodigo() == codigo || p.getNome().equals(nome))
				throw new SCVException("Código ou nome já existem!");
		}
		Produto produto = new ProdutoPerecivel(nome, preco);
		produto.setCodigo(codigo);
		produto.setDescricao(descricao);
		((ProdutoPerecivel) produto).setVencimento(validade);
		persistencia.salvar(produto);
		return produto;
	}	
	
	public ItemDePedido criarItemPedido(Produto produto, int qtde) {
		ItemDePedido item = new ItemDePedido(produto, qtde);
		return item;
	}
	
	public Pedido criarPedido(String data, Cliente cliente, ArrayList<ItemDePedido> itenspedido) {
		Pedido pedido = new Pedido();
		pedido.setData(data);
		pedido.setCliente(cliente);
		pedido.setListaItens(itenspedido);
		pedido.setCodigo(numPedido);
		numPedido++;
		persistencia.salvar(pedido);
		return pedido;
	}
	
	public String pegarData() {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();
		return (format.format(data));
	}
	
	public Cliente verificarCPF(String cpf) {
		ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) persistencia.recuperarClientes();
		for (int i = 0; i < listaClientes.size(); i++) {
			if (listaClientes.get(i).getCpf().equals(cpf)) {
				return listaClientes.get(i);
			}
		}
		return null;
	}
	
	public Produto verificarProduto(int codigo) {
		ArrayList<Produto> listaProdutos = (ArrayList<Produto>) persistencia.recuperarProdutos();
		for (int i = 0; i < listaProdutos.size(); i++) {
			if (listaProdutos.get(i).getCodigo().equals(codigo)) {
				return listaProdutos.get(i);
			}
		}
		return null;
	}

	public Iterator<Produto> getProdutosIterator() {
		return persistencia.recuperarProdutos().iterator();
	}

	public Iterator<Cliente> getClientesIterator() {
		return persistencia.recuperarClientes().iterator();
	}

	public Iterator<ItemDePedido> getItemPedidosIterator() {
		return persistencia.recuperarItemPedidos().iterator();
	}	

	
	public Iterator <Pedido> getPedidosIterator() throws SCVPersistenciaException{
		return persistencia.recuperarPedidos().iterator();
	}
	
	public Produto criarPedido(Produto produto, int qtde) throws SCVException, SCVPersistenciaException{
		Pedido pedido = new Pedido();
		pedido.addProdturo(produto, qtde);
		persistencia.salvar(pedido);
		return produto;
	}
	
	public List<Pedido> listarProfessores() throws SCVPersistenciaException{
		List<Pedido> pedidos = persistencia.recuperarPedidos();
		return pedidos;
	}
}
