package juego;

import javax.swing.JLabel;

import utilidades.ImageLoader;

@SuppressWarnings("serial")
public class Esfera extends JLabel {
	private int valor;
	private Conector conector;
	private boolean activo;
	private int x;
	private int y;
	
	public Esfera(int valor) {
		this.valor = valor;
		setValor(valor);
		this.setSize(this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
		activo = false;
	}//

	public void setValor(int valor) {
		valor = redondear(valor);
		this.valor = valor;
		
		int i = 0;
		while (i < ImageLoader.MAX_ESFERAS && Math.pow(2, i) != valor) {
			i++;
		}
		i--;
		
		this.setIcon(ImageLoader.getInstance().getEsfera(i));
		if (i >= ImageLoader.MAX_CONECTORES)
			i -= 8;
		
		conector = new Conector(ImageLoader.getInstance().getConectores(i));
	}
	
	public int getValor() {
		return valor;
	}
	
	public Conector getConector() {
		return conector;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public boolean getActivo() {
		return activo;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	private int redondear(int valor) {
		if (valor < 2)
			valor = 2;
		else if (valor < 4)
			valor = 2;
		else if (valor < 8)
			valor = 4;
		else if (valor < 16)
			valor = 8;
		else if (valor < 32)
			valor = 16;
		else if (valor < 64)
			valor = 32;
		else if (valor < 128)
			valor = 64;
		else if (valor < 256)
			valor = 128;
		else if (valor < 512)
			valor = 256;
		else if (valor < 1024)
			valor = 512;
		else if (valor < 2048)
			valor = 1024;
		else if (valor < 4096)
			valor = 2048;
		else if (valor < 8192)
			valor = 4096;
		else if (valor < 16384)
			valor = 8192;
		else if (valor < 32768)
			valor = 16384;
		else if (valor < 65336)
			valor = 32768;
		else if (valor > 65336)
			valor = 65336;
		
		return valor;
	}
}
