package codigo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Esfera extends JLabel {
	private int valor;
	private boolean activo;
	private Timer caida;
	private int posicion;
	private JLabel difuminado;
	
	public Esfera(int valor) {
		this.valor = valor;
		setValor(valor);
		this.setSize(60, 60);
		activo = false;
		caida = new Timer(10, new TimerCaida());
		difuminado = new JLabel(ImageLoader.getInstance().getEsfera(0));
		difuminado.setSize(60, 60);
	}//
	
	public Esfera(Esfera esfera) {
		this.valor = esfera.valor;
		this.setValor(valor);
		this.setSize(60, 60);
		this.activo = false;
		this.setLocation(esfera.getLocation());
		difuminado = new JLabel(ImageLoader.getInstance().getEsfera(0));
	}//

	public void setValor(int valor) {
		valor = redondear(valor);
		this.valor = valor;
		
		int i = 1;
		while (i < ImageLoader.MAX_ESFERAS && Math.pow(2, i-1) != valor) {
			i++;
		}
		i--;

		this.setIcon(ImageLoader.getInstance().getEsfera(i));
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
		if (activo) {
			this.getParent().add(difuminado);
			difuminado.setLocation(this.getX(), this.getY());
		}
		else
			this.getParent().remove(difuminado);
			this.getParent().revalidate();
			this.getParent().repaint();
	}
	
	public boolean getActivo() {
		return activo;
	}
	
	public JLabel getDifuminado() {
		return difuminado;
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
	
	public void iniciarCaida(int posicion) {
		this.posicion = posicion;
		caida.start();
	}
	
	class TimerCaida implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (getY() < posicion) {
				setLocation(getX(), getY() + 10);
			}
			else {
				caida.stop();
			}
		}//actionPerformed()
	};//TimerCaida
}
