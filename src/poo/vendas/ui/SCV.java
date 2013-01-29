package poo.vendas.ui;

import poo.vendas.Produto;
import poo.vendas.ProdutoPerecivel;
import poo.vendas.SCVException;
import poo.vendas.SCVFacade;
import poo.logger.Logger;

public class SCV {
	
	private SCVFacade facade;
	
	public SCV(){
		this.facade = new SCVFacade();
	}
	
	public static void main(String[] args) {
		SCV sca = new SCV();
		sca.exibirMenu();
	}
	
	public void exibirMenu(){
		try{
			StringBuffer menu = new StringBuffer();
			menu.append(">>> SISTEMA DE CONTROLE VENDAS <<<<\n");
			menu.append("    0 - SAIR\n");
			menu.append("    1 - Cadastrar Produdo\n");
			menu.append("Digite a opção:");
			
			boolean fim = false;
			
			do{
				switch(Util.lerInteiro(menu.toString())){
				case 0:
					Util.alert("Até a próxima!");
					fim = true;
					break;
				case 1:
					cadastrarProduto();
					break;
				default:
					Util.alert("Opção inválida!");
				}
			}while(!fim);
		}catch(Throwable e){
			Logger.getInstance().log(e);
			Util.alert("Erro do sistema. Chame o suporte!");
		}
	}
	
	public static void cadastrarProduto(){
		int codigo = Util.lerInteiro("Código do Produto:");
		String nome = Util.lerString("Nome do produto:");
		String descricao = Util.lerString("Descrição do produto:");
		double preco = Util.lerFloat("Preço do produto:");
		int perecivel = Util.lerInteiro("1 - Produto Perecível\n2 - Produto não perecível");
		Produto p = null;
		try {
			if (perecivel == 1) {
				String validade = Util.lerString("Digite a validade: dd/mm/aaaa:");
				p = facade.criarProdutoPerecivel(codigo, nome, descricao, preco, validade);
				Util.alert("Produto criado com sucesso!" + p.getNome());
			}else if (perecivel == 2) {
				p = facade.criarProduto(codigo, nome, descricao, preco);
				Util.alert("Produto criado com sucesso!" + p.getNome());
			}
		} catch (SCVException e) {
			Logger.getInstance().log(e);
			Util.alert("Erro ao criar produto!");
		}
	}
	
	//private void pedir() {
	//	String nome = Util.lerString("Digite o nome do produto: ");
	//	int qtde = Util.lerInteiro("Digite a quantidade: ");
	//	double preco = Util.lerFloat("Digite o preço: ");
	//	int perecivel = Util.lerInteiro("Perecível? 1-Sim  2-Não");
	//	
	//	Produto p = null;
	//	if(perecivel == 1){
	//		String vencimento = Util.lerString("Validade - Dia:");
	//		p = new ProdutoPerecivel(nome, preco);
	//		((ProdutoPerecivel) p).setVencimento(vencimento);
	//	}else if(perecivel == 2){
	//		p = new Produto(nome, preco);
	//	}
	//	
	//	try {
	//		p = facade.criarPedido(p,qtde);
	//	} catch (SCVException e1) {
	//		Util.alert(e1.getMessage());
	//	} catch(SCVPersistenciaException e2){
	//		Util.alert("Erro na gravação do arquivo! Tente novamente ou chame o suporte.");
	//		Logger.getInstance().log(e2);
	//	}
	//}
}
