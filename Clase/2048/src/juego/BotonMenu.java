package juego;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class BotonMenu extends JButton {
	
	
	private BotonMenu() {
		this.setBorderPainted(false);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setFont(new Font("Arial", Font.BOLD, 25));
		this.setContentAreaFilled(false);

		ImageIcon icono = new ImageIcon(this.getClass().getResource("recursos/boton1.png")); //por defecto
		this.setIcon(icono);
		
		 icono = new ImageIcon(this.getClass().getResource("recursos/boton2.png")); //mouse por encima
		 this.setRolloverIcon(icono);
	}
	
	public BotonMenu(String texto) {
		this();
		this.setText(texto);
	}
	
	public BotonMenu(String texto, ActionListener al) {
		this();
		this.setText(texto);
		this.addActionListener(al);
	}
}
