package juego;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class EtiquetaPersonalizada extends JLabel {
	ImageIcon imagen;	
	
	public EtiquetaPersonalizada(String texto, int opcion) {
		imagen = new ImageIcon(this.getClass().getResource("recursos/boton"+ opcion +".png"));
		this.setIcon(imagen);
		
		this.setText(texto);
		this.setFont(new Font("Arial", Font.BOLD, 25));
		this.setHorizontalTextPosition(SwingConstants.CENTER);
	}
	
	public void setTamanyoImagen(int ancho, int alto) {
		this.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(ancho, alto, Image.SCALE_FAST)));
	}
	
	public ImageIcon getImagen() {
		return this.imagen;
	}
}
