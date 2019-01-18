package codigo;

import javax.swing.ImageIcon;
//Autores: Reyner Contreras, seccion 01
//Programacion I.
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Juego extends JFrame {
	private static Juego instance = null;

	private Juego() {
		super("2048");
		this.setSize(600, 800);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon(this.getClass().getResource("/recursos/icon.png")).getImage());
		
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		Menu.getInstance();
		
		this.setContentPane(Menu.getInstance()); //creo instancia de menu y aparte lo utilizo como panel
	}
	
	public static Juego getInstance() {
		if (instance==null)
			instance = new Juego();
		
		return instance;
	}
	
	public void actualizarFrame(PanelPadre panel) {
		Juego.getInstance().setContentPane(panel);
		Juego.getInstance().revalidate();
		Juego.getInstance().repaint();
	}
}
