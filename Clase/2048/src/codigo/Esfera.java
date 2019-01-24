package codigo;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Esfera extends JLabel {
	private int valor;
	private boolean activo;
	private int conector;
	
	public Esfera(int valor) {
		this.valor = valor;
		setValor(valor);
		this.setSize(70, 70);
		activo = false;
	}//
	
	public Esfera(Esfera esfera) {
		this.valor = esfera.valor;
		setValor(valor);
		this.setSize(70, 70);
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
		if (i >= 8)
			i -= 8;
		
		conector = i;
	}
	
	public int getValor() {
		return valor;
	}
	
	public int getConector() {
		return conector;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public boolean getActivo() {
		return activo;
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
