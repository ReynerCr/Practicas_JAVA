package juego;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Menu extends JPanel {
	public static Menu instancia = null;
	
	private Menu() {
		super(new BoxLayout(instancia, BoxLayout.Y_AXIS));
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		//Nuevo juego; instrucciones, top 10, creditos y salir
		//en el proyecto de aranoid esta ara cambiar el fondo entero
		iniciarBotones();
	}
	
	public Menu getInstancia() {
		if (instancia == null) {
			instancia = new Menu();
		}
		
		return instancia;
	}
	
	private void iniciarBotones() {
		//titulo 2048, botones para ir a un lado a otro
	}
	
	
}
