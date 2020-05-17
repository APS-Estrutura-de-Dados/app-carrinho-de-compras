import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class App {

	// Para armazenar a resolucao da maquina
	public static Toolkit toolkit = Toolkit.getDefaultToolkit();
	public static Dimension dimension = toolkit.getScreenSize();
	public static int x;
	public static int y;

	// Para mostrar o cursor do mouse diferente para clicar nas coisas
	static Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

	public static void main(String[] args) {

		// Para armazenar a resolucao da maquina
		x = dimension.width;
		y = dimension.height;

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Mostrar Bot�o de Fechar do Sistema
		frame.setExtendedState(6); // Deixa a janela em tela cheia
		frame.setTitle("App Carrinho de Compras");
		frame.setLayout(null);
		frame.setVisible(true);

	}

}
