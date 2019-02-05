package codigo;

import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelPadre extends JPanel {
	public PanelPadre() {
		this.setSize(600, 800);
		this.setLayout(null);
	}
	
	@Override
	public void paint(Graphics g){
        g.drawImage(Loader.getInstance().getFondo(), 0, 0, getWidth(), getHeight(), this);
        super.setOpaque(false);
        super.paint(g);
    }
}
