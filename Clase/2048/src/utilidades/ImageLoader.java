package utilidades;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class ImageLoader {
	private static ImageLoader instance = null;
	
	public static final int MAX_ESFERAS = 16;
	public static final int MAX_CONECTORES = 8;
	
	private Image background;
	private ImageIcon etiquetas;
	private ImageIcon botones[];
	private ImageIcon esferas[];
	private ImageIcon conectores[];
	private ImageIcon otros[]; //aqui se guarda icono para boton de menu, pausar, iniciar, etc
	
	private ImageLoader() {
		botones = new ImageIcon[2];
		botones[0] = new ImageIcon(this.getClass().getResource("recursos/imagenes/imagen0.png"));
		botones[1] = new ImageIcon(this.getClass().getResource("recursos/imagenes/imagen1.png"));
		
		etiquetas = new ImageIcon(this.getClass().getResource("recursos/imagenes/imagen1.png"));

		esferas = new ImageIcon[MAX_ESFERAS];
		URL url = this.getClass().getResource("recursos/imagenes/esferas/");
		for (int i = 0; i < esferas.length; i++) {
			esferas[i] = new ImageIcon(url.getPath() + i + ".png");
		}
		
		url = this.getClass().getResource("recursos/imagenes/lineas/");
		conectores = new ImageIcon[8];
		for (int i = 0; i < 8; i++)
			conectores[i] = new ImageIcon(url.getPath() + i + ".png");
		
		url = this.getClass().getResource("recursos/imagenes/otros/");
		otros = new ImageIcon[6];
		for (int i = 0; i < 6; i++)
			otros[i] = new ImageIcon(url.getPath() + i + ".png");
		
		
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
	
	public ImageIcon getOtros(int i) {
		return otros[i];
	}
	
	public ImageIcon getConectores(int i) {
		return conectores[i];
	}
	
}
