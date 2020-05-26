package app;

import java.util.Random;

import Estruturas.Fila;

public class Caixa {

	public Caixa(Carrinho carrinho) {
		this.carrinho = carrinho;
		caixa = new Fila(this.carrinho.VerificarCarrinho());
	}

	Fila caixa;
	Carrinho carrinho;

	public void AdicionarProdutos() {
		String posicoesUtilizadas = "";
		int posicao;
		Random random = new Random();
		for (int i = 0; i < 10;) {
			posicao = random.nextInt(10);
			if (!posicoesUtilizadas.contains(posicao + "")) {
				caixa.enqueue(BuscarProdutoCarrinho(posicao));
				posicoesUtilizadas += posicao;
				i++;
			}
		}
	}

	public String BuscarProdutoCarrinho(int posicao) {
		return carrinho.BuscarProduto(posicao);
	}

	public String BuscarProdutosCaixa() {
		String data = caixa.display();
		data = "1� Produto: " + data.substring(0, data.length()-3);
		for (int i = 2; i < data.length()+2; i++) {
			data = data.replaceFirst(" , ", "\n"+i+"� Produto: ");
		}
		return data;
	}

}
