package utilidades;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelPadre extends JPanel {
	private Image fondo;
	
	public PanelPadre() {
		this.setSize(600, 800);
		this.setLayout(null);
		fondo = ImageLoader.getInstance().getFondo();
	}
	
	@Override
	public void paint(Graphics g){
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        super.setOpaque(false);
        super.paint(g);
    }
	
	public void setFondo(int opcion) {
		ImageLoader.getInstance().setFondo(opcion);
		fondo = ImageLoader.getInstance().getFondo();
	}
	
	public Image getFondo() {
		return fondo;
	}
	
}
