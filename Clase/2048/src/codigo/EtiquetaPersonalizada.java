package codigo;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class EtiquetaPersonalizada extends JLabel {
	
	public EtiquetaPersonalizada(String texto) {
		ImageIcon imagen = Loader.getInstance().getEtiqueta();
		this.setIcon(imagen);
		
		this.setText(texto);
		this.setFont(new Font("Arial", Font.BOLD, 25));
		this.setHorizontalTextPosition(SwingConstants.CENTER);
	}
	
	public EtiquetaPersonalizada(String texto, int ancho, int alto, int tamanyo) {
		this(texto);
		
		this.setFont(new Font("Arial", Font.BOLD, tamanyo));
		this.setIcon(new ImageIcon(Loader.getInstance().getEtiqueta().getImage().getScaledInstance(ancho, alto, Image.SCALE_FAST)));
		this.setSize(ancho, alto);
	}
	
}
