package poo.vendas;

public class ItemDePedido {
	private Produto produto;
	private Integer qtde;
	private String descricao;
	private double preco;
	
	public ItemDePedido(Produto produto, int qtde) {
		this.produto = produto;
		this.qtde = qtde;
	}

	public double totalItem(){
		return qtde*produto.getPreco();
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return qtde;
	}

	public void setQuantidade(Integer quantidade) {
		this.qtde = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}