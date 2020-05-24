package app;

import Estruturas.ListaDinamica;

public class Carrinho {

	public Carrinho() {
		Lista = new ListaDinamica();
	}

	ListaDinamica Lista;

	public void InserirPrimeiroProduto(String produto) {
		Lista.insertAtFront(produto);
	}

	public void InserirProduto(String produto) {
		Lista.insertAtBack(produto);
	}

	public String RemoverProduto(String produto) {
		if(Lista.remove(produto)==null) {
			return "O produto \"" + Lista.remove(produto) + "\" não foi encontrado";
		}else {
			return "O produto \"" + Lista.remove(produto) + "\" foi removido do carrinho";	
		}
	}

	public void LimparCarrinho() {
		Lista.removeFromFront();
	}

	public int VerificarCarrinho() {

		if (Lista.size() < 10) {
			return Lista.size();
		} else {
			return 10;
		}

	}

	public String ListarProdutos() {
		String produtos = Lista.print();
		return produtos.substring(0, produtos.length() - 3);
	}

}
