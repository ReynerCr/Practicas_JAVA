package juego;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import utilidades.ManejaEventos;

@SuppressWarnings("serial")
public class Juego extends JFrame {
	private static Juego instance = null;
	private Image fondo; 
	
	private Juego() {
		super("2048");
		this.setSize(600, 800);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		fondo = new ImageIcon(this.getClass().getResource("recursos/background1.png")).getImage();
		
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		if (Menu.getInstance() == null)
			Menu.newInstance(fondo);
			
		this.setContentPane(Menu.getInstance()); //creo instancia de menu y aparte lo utilizo como panel
	}
	
	public static Juego getInstance() {
		if (instance==null)
			instance = new Juego();
		
		return instance;
	}
	
	public Image getFondo() {
		return fondo;
	}
	
	public void setFondo(Image fondo) {
		this.fondo = fondo;
		iniciarComponentes();
		ManejaEventos.actualizarFrame();
	}
	
}
