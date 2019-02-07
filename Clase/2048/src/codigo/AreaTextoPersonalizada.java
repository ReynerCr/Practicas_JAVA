package codigo;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class AreaTextoPersonalizada extends JTextArea {
	//private static I
	
	public AreaTextoPersonalizada(String texto) {
		this.setFont(new Font("Arial", Font.BOLD, 25));
		this.setText(texto);
	}
	
	public AreaTextoPersonalizada(String texto, int ancho, int alto, int tamanyo) {
		super(texto);
		this.setEditable(false);
		this.setSize(ancho, alto);
		this.setFont(new Font("Arial", Font.BOLD, tamanyo));
	}
	
	@Override
	public void paint(Graphics g){
        g.drawImage(Loader.getInstance().getEtiqueta().getImage(), 0, 0, getWidth(), getHeight(), this);
        super.setOpaque(false);
        super.paint(g);
    }
}
