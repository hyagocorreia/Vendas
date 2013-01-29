package poo.vendas;

public class ProdutoPerecivel extends Produto{
	@SuppressWarnings("unused")
	private String vencimento;
	
	public ProdutoPerecivel(String nome, double preco) {
		super(nome, preco);
	}

	public void setVencimento(String vencimento) {
		this.vencimento = vencimento;
	}
}
