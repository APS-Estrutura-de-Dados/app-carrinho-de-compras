package app;

import Estruturas.ListaDinamica;

public class Carrinho {

	public Carrinho() {
		Lista = new ListaDinamica();
	}

	ListaDinamica Lista;

	public void InserirProduto(String produto) {
		if(VerificarCarrinho() < 10) {
			Lista.insertAtBack(produto);
		}
	}

	public String RemoverProduto(String produto) {
		if (Lista.remove(produto) == null) {
			return "O produto \"" + Lista.remove(produto) + "\" não foi encontrado";
		} else {
			return "O produto \"" + Lista.remove(produto) + "\" foi removido do carrinho";
		}
	}

	public int VerificarCarrinho() {

		if (Lista.size() < 10) {
			return Lista.size();
		} else {
			return 10;
		}

	}

	public String ListarProdutos() {
		return Lista.print();
	}

	public String BuscarProduto(int posicao) {
		String data = null;
		data = Lista.find(posicao); 
		return data;
	}
	
}