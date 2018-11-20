package utilidades;

import java.awt.Font;
import java.awt.Image;
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

		ImageIcon icono = ImageLoader.getInstance().getBotones(0); //por defecto
		this.setIcon(icono);
		
		 icono = ImageLoader.getInstance().getBotones(1); //mouse por encima
		 this.setRolloverIcon(icono);
	}
	
	public BotonMenu(String texto) {
		this();
		this.setText(texto);
	}
	
	public BotonMenu(String texto, ActionListener al) {
		this(texto);
		this.addActionListener(al);
	}
	
	public BotonMenu(String texto, ActionListener al, int ancho, int alto, int tamanyoLetra) {
		this(texto, al);
		
		ImageIcon icono = new ImageIcon(ImageLoader.getInstance().getBotones(0).getImage().getScaledInstance(ancho, alto, Image.SCALE_FAST)); //por defecto
		this.setIcon(icono);
		
		 icono = new ImageIcon(ImageLoader.getInstance().getBotones(1).getImage().getScaledInstance(ancho, alto, Image.SCALE_FAST)); //mouse por encima
		 this.setRolloverIcon(icono);
		this.setFont(new Font("Arial", Font.BOLD, tamanyoLetra));
	}
}
