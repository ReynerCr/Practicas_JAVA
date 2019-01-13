package utilidades;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Tiempo extends JLabel {
	private int minutos;
	private int segundos;
	private Timer timer;
	private boolean activo;
	
	private static Tiempo instance = null;
	
	private Tiempo() {
		iniciar();
		timer = new Timer(1000, new TimerTiempo());
		
		this.setSize(80, 80);
		this.setText("00:00");
		this.setFont(new Font("Arial", Font.BOLD, 25));
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setIcon(ImageLoader.getInstance().getOtros(1));
		
		timer.start();
	}
	
	public static Tiempo getInstance() {
		if(instance==null)
			instance = new Tiempo();
		
		return instance;
	}
	
	public void iniciar() {
		minutos = 0;
		segundos = 0;
		activo = true;
		if (timer != null)
			timer.restart();
	}
	
	public void pararTiempo() {
		timer.stop();
		activo = false;
	}
	
	public void iniciarTiempo() {
		timer.restart();
		activo = true;
	}
	
	public int getMinutos() {
		return minutos;
	}
	
	public int getSegundos() {
		return segundos;
	}
	
	public boolean getActivo() {
		return activo;
	}
	
	public String getTiempo() {
		String min = Integer.toString(minutos);
		String seg = Integer.toString(segundos);
		
		if (minutos < 10)
			min = String.format("%02d",minutos);
		if (segundos < 10)
			seg = String.format("%02d", segundos);
		
		return (min + ":" + seg);
	}
	
	class TimerTiempo implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			segundos++;
			
			if (segundos == 60) {
				segundos = 0;
				minutos++;
			}
			
			setText(getTiempo());
			
			revalidate();
			repaint();
		}//actionPerformed()
	};
	
}
