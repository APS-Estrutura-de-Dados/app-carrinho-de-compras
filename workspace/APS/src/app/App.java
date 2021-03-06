package app;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Graphics;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class App extends javax.swing.JFrame {

	// Variaveis de controle
	static int inicialTime;
	static int waitTime;
	static boolean firstInserting = true;
	static int produtosEsteiraCaixa;

	// Objetos
	static App app;
	static Carrinho carrinho;
	static Caixa caixa;

	// Timer para realizar animações
	static Timer timer;

	// Para armazenar a resolucao da maquina
	public static Toolkit toolkit = Toolkit.getDefaultToolkit();
	public static Dimension dimension = toolkit.getScreenSize();
	public static int x = dimension.width;
	public static int y = dimension.height;

	// Para mostrar o cursor do mouse diferente para clicar nas coisas
	static Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

	// Construtor - Montagem da página
	public App(String path) throws IOException {

		// Buscando a imagem
		Image backgroundImage = Toolkit.getDefaultToolkit().getImage(path);

		// Inserindo a imagem de fundo
		this.setContentPane(new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				int w = x / 2;
				int h = y;
				g.drawImage(backgroundImage, (x / 2) - (w / 2), 0, w, h, null);
			}
		});

		// Configurando o JFrame
		pack();
		setTitle("Carrinho de Compras");
		setExtendedState(6); // Deixa a janela em tela cheia
		setVisible(true);

	}

	public static void main(String[] args) throws IOException {

		// Inicializando obj
		carrinho = new Carrinho();

		// Iniciando o app ------------------------------
		app = new App("imagens/carrinho0.png");
		JOptionPane.showMessageDialog(null,
				"Sistema foi desenvolvido por:\n\n" + "Jackson Souza Anizio - 21333012\n"
						+ "Mateus Donaire de Melo - 21286869\n" + "Kleber da Silva alvares 21304275\n"
						+ "Rafael de Oliveira Severino  21298419\n" + "Thales Lima de Jesus - 21255499",
				"Bem Vindo !", JOptionPane.INFORMATION_MESSAGE);

		JOptionPane.showMessageDialog(null,
				"Na próxima janela, será possível ver seu carrinho de compras, nele"
				+ "\nvocê poderá adicionar e remover produtos para comprá-los posteriormente!"
				+ "\n\n*Você possui dinheiro para comprar apenas 10 produtos, então fica esperto hein !!",
				"Iniciando o app", JOptionPane.INFORMATION_MESSAGE);

		new Timer(500, inicialInfo).start();
		// Iniciando o app ------------------------------

	}

	// Inicia o menu para inserir produtos
	public static void StartMenu() {

		if (carrinho.VerificarCarrinho() == 10) {
			IrAoCaixa();
		} else {

			String produto = null;

			produto = JOptionPane.showInputDialog(null,
					"Por Favor, indique o nome do produto:\nOu clique em \"Cancelar\" para finalizar a aplicação.",
					"Adicionando Produtos ao carrinho de compras", JOptionPane.QUESTION_MESSAGE);

			if (produto == null) {
				System.exit(0);
				;
			} else if (produto.equals("")) {
				JOptionPane.showMessageDialog(null, "Por favor, digite um produto válido!", "Produto não encontrado",
						JOptionPane.WARNING_MESSAGE);
				StartMenu();
			} else {
				JOptionPane.showMessageDialog(null, "O produto \"" + produto + "\" foi adicionado ao carrinho!",
						"Novo produto adicionado no carrinho!", JOptionPane.INFORMATION_MESSAGE);

				carrinho.InserirProduto(produto);

				timer = new Timer(250, updateWindow);
				timer.start();
			}
		}

	}

	// ActionListener para realizar as animações e timers
	static ActionListener inicialInfo = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			if (inicialTime == 0) {
				timer = new Timer(100, updateImage);
				timer.start();
			} else if (inicialTime == 4) {
				new Timer(1000, inicialInfo).stop();
				// Menu (Add Produtos) ------------------------------
				StartMenu();
				firstInserting = false;
			}
			inicialTime++;
		}
	};

	// Configura a nova imagem do carrinho de compras
	static ActionListener updateWindow = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {

			int qteProdutos = carrinho.VerificarCarrinho();
			timer.stop();

			try {

				app.dispose();
				app = new App("imagens/carrinho" + qteProdutos + ".png");

				timer = new Timer(250, updateImage);
				timer.start();

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e.getMessage(), "Erro!",
						JOptionPane.ERROR_MESSAGE);
			}

		}
	};

	// Atualiza a janela para mostrar as imagens
	static ActionListener updateImage = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {

			if (!firstInserting) {
				if (waitTime == 7) {
					// Esse sistema serve para fazer a imagem aparecer corretamente.
					app.setExtendedState(1); // Deixa a janela minimizada
					app.setExtendedState(6); // Deixa a janela em tela cheia
					timer.stop();
					waitTime = 0;
					timer = new Timer(2000, StartMenuAfterSomeTime);
					timer.start();
				}
			} else {
				// Esse sistema serve para fazer a imagem aparecer corretamente.
				app.setExtendedState(1); // Deixa a janela minimizada
				app.setExtendedState(6); // Deixa a janela em tela cheia
				waitTime = 0;
				timer.stop();
			}

			waitTime++;

		}
	};

	// Mostra o menu após utilizando um timer para fazer um delay
	static ActionListener StartMenuAfterSomeTime = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			timer.stop();
			StartMenu();
		}
	};

	// Remove produtos e atualiza as imagens
	static public void RemoverProduto() {

		boolean continueAsking = true;

		while (continueAsking) {

			if (carrinho.VerificarCarrinho() > 1) {
				String produto = JOptionPane.showInputDialog("Por favor, digite o produto a ser retirado do carrinho:\n"
						+ "Escolha a opção \"Cancelar\" caso já esteja contente com a quantidade de produtos em seu carrinho:");

				if (produto == null) {
					continueAsking = false;
					IrAoCaixa();
				} else if (produto.equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor digite o nome de algum produto válido",
							"Tente novamente", JOptionPane.ERROR_MESSAGE);
					RemoverProduto();
				} else {
					JOptionPane.showMessageDialog(null, carrinho.RemoverProduto(produto));
					continueAsking = false;
					timer = new Timer(250, updateWindow);
					timer.start();
				}
			}

		}

	}

	// Menu caixa
	static public void IrAoCaixa() {
		int confirm = JOptionPane.showConfirmDialog(null,
				"Você já pegou 10 produtos !! \nDeseja remover algum item do carrinho, antes de finalizar a compra?",
				"Pronto?", JOptionPane.YES_NO_OPTION);

		if (confirm == 1) {

			JOptionPane.showMessageDialog(null,
					"Ok, você encontrou um caixa vazio, e foi até ele para finalizar sua compra ...",
					"Que sorte hein ...", JOptionPane.INFORMATION_MESSAGE);

			caixa = new Caixa(carrinho);
			caixa.AdicionarProdutos();

			JOptionPane.showMessageDialog(null, caixa.BuscarProdutosCaixa(), "Produtos comprados:",
					JOptionPane.INFORMATION_MESSAGE);

		} else {
			RemoverProduto();
		}
	}

}
