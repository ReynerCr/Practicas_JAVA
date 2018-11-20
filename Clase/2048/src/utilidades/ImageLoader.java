package utilidades;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class ImageLoader {
	private static ImageLoader instance = null;
	
	public final int MAX_ESFERAS = 16;
	
	private Image background;
	private ImageIcon etiquetas;
	private ImageIcon botones[];
	private ImageIcon esferas[];
	
	private ImageLoader() {
		botones = new ImageIcon[2];
		botones[0] = new ImageIcon(this.getClass().getResource("recursos/imagenes/imagen0.png"));
		botones[1] = new ImageIcon(this.getClass().getResource("recursos/imagenes/imagen1.png"));
		
		esferas = new ImageIcon[16];
		etiquetas = new ImageIcon(this.getClass().getResource("recursos/imagenes/imagen1.png"));

		URL url = this.getClass().getResource("recursos/imagenes/esferas/");
		for (int i = 0; i < esferas.length; i++) {
			esferas[i] = new ImageIcon(url.getPath() + i + ".png");
		}
		
		setFondo(0); //cambio el fondo
	}
	
	public static ImageLoader getInstance() {
		if (instance == null)
			instance = new ImageLoader();
		
		return instance;
	}
	
	public void setFondo(int opcion) {
		URL url = this.getClass().getResource("recursos/imagenes/background" + opcion + ".png");
		background = new ImageIcon(url).getImage();
	}
	
	public Image getFondo() {
		return background;
	}
	
	public ImageIcon getEtiqueta() {
		return etiquetas;
	}
	
	public ImageIcon getBotones(int i) {
		return botones[i];
	}
	
	public ImageIcon getEsfera(int i) {
		if (i <= MAX_ESFERAS)
			return esferas[i];
		else
			return null;
	}
	
	
}
