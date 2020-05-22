package app;


import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.awt.Graphics;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class App extends javax.swing.JFrame {

	// Para armazenar a resolucao da maquina
	public static Toolkit toolkit = Toolkit.getDefaultToolkit();
	public static Dimension dimension = toolkit.getScreenSize();
	public static int x = dimension.width;
	public static int y = dimension.height;

	// Para mostrar o cursor do mouse diferente para clicar nas coisas
	static Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

	// Imagem de fundo
	Image img = Toolkit.getDefaultToolkit().getImage("C:\\carrinho.png");

	// Montagem da página
	public App() throws IOException {

		// Inserindo a imagem de fundo
		this.setContentPane(new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				int w = x/2;
				int h = y;
				g.drawImage(img, (x/2)-(w/2), 0, w, h, null);
			}
		});
		
		// Configurando o JFrame
		pack();
		setTitle("Carrinho de Compras");
		setExtendedState(6); // Deixa a janela em tela cheia
		setVisible(true);
		
	}

	public static void main(String[] args) throws IOException {

		App app = new App();
		JOptionPane.showMessageDialog(null,"Sistema foi desenvolvido por:\n\n"
				+ "Jackson Souza Anizio - 21333012\n"
				+ "Mateus Donaire de Melo - 21286869\n" + 
				"Kleber da Silva alvares 21304275\n" + 
				"Rafael de Oliveira Severino  21298419\n" + 
				"Thales Lima de Jesus - 21255499", "Bem Vindo !", JOptionPane.INFORMATION_MESSAGE);
		// Esse sistema serve para fazer a imagem aparecer corretamente.
		app.setExtendedState(1); // Deixa a janela minimizada
		app.setExtendedState(6); // Deixa a janela em tela cheia
		

	}
}














