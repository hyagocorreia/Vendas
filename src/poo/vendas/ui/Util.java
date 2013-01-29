package poo.vendas.ui;

import javax.swing.JOptionPane;

public class Util {
	
	public static String lerString(String msg) throws EntradaInvalidaException {
		boolean fim = false;
		String entrada = "";
		do{
			entrada = JOptionPane.showInputDialog(msg);
			if(entrada == null || entrada.equals(""))
				alert("Entrada inválida!");
			else
				fim = true;
		}while(!fim);
		return entrada;
	}

	public static int lerInteiro(String msg) throws EntradaInvalidaException {
		boolean fim = false;
		int valor = 0;
		do{
			try{
				String entrada = "";
				entrada = lerString(msg);
				valor = Integer.parseInt(entrada);
				fim = true;
			}catch(Exception e){
				alert("Entrada inválida!");
			}
		}while(!fim);
		return valor;
	}
	
	public static double lerFloat(String msg) throws EntradaInvalidaException {
		boolean fim = false;
		double valor = 0.0;
		do{
			try{
				String entrada = "";
				entrada = lerString(msg);
				valor = Double.parseDouble(entrada);
				fim = true;
			}catch(Exception e){
				alert("Entrada inválida!");
			}
		}while(!fim);
		return valor;
	}
	
	public static void alert(String msg){
		JOptionPane.showMessageDialog(null,msg);
	}

}
