package codigo;

import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Loader {
	private static Loader instance = null;
	
	public static final int MAX_ESFERAS = 17;

	private Image background;
	private ImageIcon etiquetas;
	private ImageIcon botones[];
	private ImageIcon esferas[];
	private ImageIcon otros[]; //aqui se guarda icono para boton de menu, pausar, iniciar, etc
	private Clip music;
	private Clip bells[];
	
	private Loader() {
		botones = new ImageIcon[2];
		botones[0] = new ImageIcon(this.getClass().getResource("/recursos/imagenes/imagen0.png"));
		botones[1] = new ImageIcon(this.getClass().getResource("/recursos/imagenes/imagen1.png"));
		
		etiquetas = new ImageIcon(this.getClass().getResource("/recursos/imagenes/imagen1.png"));

		esferas = new ImageIcon[MAX_ESFERAS];

		for (int i = 0; i < MAX_ESFERAS; i++) {
			esferas[i] = new ImageIcon(this.getClass().getResource("/recursos/imagenes/esferas/" + i + ".png"));
		}
		//al pasar strings parece ser que esto no puede hacer na
		
		otros = new ImageIcon[10];
		for (int i = 0; i < 10; i++)
			otros[i] = new ImageIcon(this.getClass().getResource("/recursos/imagenes/otros/" + i + ".png"));
		
		setFondo(0); //cambio el fondo
		
		bells = new Clip[3];
		try {
			music = AudioSystem.getClip();
			music.open(AudioSystem.getAudioInputStream(new File (this.getClass().getResource("/recursos/sonido/music0.wav").getFile())));
			music.loop(Clip.LOOP_CONTINUOUSLY);
			//TODO aqui hay un problema al exportar con ejecutable jar
			for (int i = 0; i < 3; i++) {
				bells[i] = AudioSystem.getClip();
				bells[i].open(AudioSystem.getAudioInputStream(new File(this.getClass().getResource("/recursos/sonido/bell" + i + ".wav").getFile())));
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Ocurrio un problema al cargar alguno de los archivos de sonido. " + e1.getMessage());
		}
	}//Loader
	
	public static Loader getInstance() {
		if (instance == null)
			instance = new Loader();
		
		return instance;
	}
	
	public Clip getMusic() {
		return music;
	}
	
	public void startBell(int i) {
		if (bells[i].isRunning()) {
			bells[i].stop();
		}
		bells[i].setMicrosecondPosition(0);
		
		bells[i].start();
	}
	
	public void setFondo(int opcion) {
		URL url = this.getClass().getResource("/recursos/imagenes/background" + opcion + ".png");
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
}
