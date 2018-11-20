package juego;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class PanelPadre extends JPanel {
	private static Image fondo;
	
	public PanelPadre(Image fondo) {
		this.setSize(600, 800);
		this.setLayout(null);
		PanelPadre.fondo = fondo;
	}
	
	@Override
	public void paint(Graphics g){
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        super.setOpaque(false);
        super.paint(g);
    }
	
	public void setFondo(Image fondo) {
		PanelPadre.fondo = fondo;
	}
	
	public Image getFondo() {
		return fondo;
	}
	
}
