package app;

import Estruturas.ListaDinamica;

public class AppController {
	
	public AppController() {
		Carrinho = new ListaDinamica();
	}

	ListaDinamica Carrinho;
	
	public void InserirProduto(String produto) {
		Carrinho.insertAtBack(produto);
	}
	
	public void RemoverProduto(String produto) {
		System.out.println(Carrinho.remove(produto));
	}
	
	public void LimparCarrinho() {
		Carrinho.removeFromFront();
	}
	
	public int VerificarCarrinho() {
		
		if(Carrinho.size() < 10) {
			return Carrinho.size();
		}else {
			return 10;
		}
		
	}
	
	public String ListarProdutos() {
		String produtos = Carrinho.print();
		return produtos.substring(0, produtos.length()-3);
	}
	
}
