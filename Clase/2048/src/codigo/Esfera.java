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
		difuminado = new JLabel(Loader.getInstance().getEsfera(0));
		difuminado.setSize(70, 70);
	}//
	
	public Esfera(Esfera esfera) {
		this.valor = esfera.valor;
		this.setValor(valor);
		this.setSize(60, 60);
		this.activo = false;
		this.setLocation(esfera.getLocation());
		difuminado = new JLabel(Loader.getInstance().getEsfera(0));
	}//

	public void setValor(int valor) {
		//redondeo el valor que recibe la funcion
		int i = 1;
		while (valor >= Math.pow(2, i) && i <= 16) {
			i++;
		}
		if (i > 1)
			i--;
		valor = (int) (Math.pow(2, i));

		this.valor = valor;
		
		i = 1;
		while (i < Loader.MAX_ESFERAS && Math.pow(2, i-1) != this.valor) {
			i++;
		}
		i--;
		
		this.setIcon(Loader.getInstance().getEsfera(i));
	}
	
	public int getValor() {
		return valor;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
		if (activo) {
			this.getParent().add(difuminado);
			difuminado.setLocation(this.getX() - 5, this.getY() - 5);
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
	//TODO perdi cuando no debi
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
