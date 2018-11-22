package utilidades;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Conector extends JComponent {
    private ImageIcon conector;
    
    public Conector(int direccion, int conectorI) {
    	dibujar(direccion, conectorI);
    }

    private void dibujar(int direccion, int conectorI) {
    	conectorI = conectorI * 4; //inicio de mi esfera la lista de conectores en imageloader
    	
    	if (direccion == 4 || direccion == 5)
    		conectorI += 3;
    	else if (direccion == 2 || direccion == 7)
    		conectorI += 1;
    	else if (direccion == 3 || direccion == 6)
    		conectorI += 2;
    	
    	conector = ImageLoader.getInstance().getConectores(conectorI);
    	this.setSize(conector.getIconWidth(), conector.getIconHeight());
    	System.out.println(conectorI +"  " + conector.getIconWidth() + " " +conector.getIconHeight());
    }
}
