package juego;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class Conector extends JComponent {
    private ImageIcon conector;
    private double rotacion = 0.0;
    
    public Conector(ImageIcon imagen) {
    	conector = imagen;
    	this.setSize(imagen.getIconWidth(), imagen.getIconHeight());
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        // AffineTransform realiza el giro, usando como eje de giro el centro
        // de la foto (width/2, height/2) y el angulo que indica el atributo
        // rotacion.
        AffineTransform tx = AffineTransform.getRotateInstance(rotacion, conector.getIconWidth()/2, conector.getIconHeight()/2);
        
        // dibujado con la AffineTransform de rotacion
        g2d.drawImage(conector.getImage(), tx, this);
    }

    public double getRotacion() {
        return rotacion;
    }

    /**
     * Se le pasa la rotación deseada.
     * @param rotacion La rotacion en radianes.
     * @param i 
     */
    public void setRotacion(double rotacion) {
        this.rotacion = rotacion;
        
        this.revalidate();
        this.repaint();
    }
}
