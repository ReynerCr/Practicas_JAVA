package juego;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import utilidades.EtiquetaPersonalizada;
import utilidades.ImageLoader;
import utilidades.PanelPadre;
import utilidades.Tiempo;

@SuppressWarnings("serial")
public class Entorno extends PanelPadre {
	private long puntaje = 0;
	private String nombre;
	private Tiempo tiempo;
	EtiquetaPersonalizada ePuntaje;
	JButton pausar;
	
	public Entorno(String nombre) {
		this.nombre = nombre;
		this.setLayout(new BorderLayout());

		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		inciarParteSuperior();
		iniciarTablero();
		iniciarParteInferior();
	}

	private void inciarParteSuperior() {
		JPanel parteSuperior = new JPanel(new FlowLayout());
		parteSuperior.setOpaque(false);
		tiempo = new Tiempo();
		parteSuperior.add(tiempo);
		
		ePuntaje = new EtiquetaPersonalizada(Long.toString(puntaje), 200, 80, 18);
		parteSuperior.add(ePuntaje);
		
		pausar = new JButton(ImageLoader.getInstance().getOtros(4));
		pausar.setRolloverIcon(ImageLoader.getInstance().getOtros(2));
		pausar.setBorderPainted(false);
		pausar.setContentAreaFilled(false);
		pausar.setPreferredSize(new Dimension(80, 80));
		pausar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tiempo.getActivo()) {
					tiempo.pararTiempo();
					pausar.setIcon(ImageLoader.getInstance().getOtros(5));
					pausar.setRolloverIcon(ImageLoader.getInstance().getOtros(3));
				}
					
				else {
					tiempo.iniciarTiempo();
					pausar.setIcon(ImageLoader.getInstance().getOtros(4));
					pausar.setRolloverIcon(ImageLoader.getInstance().getOtros(2));
				}
			}
		});
		parteSuperior.add(pausar);
		
		this.add(parteSuperior, BorderLayout.PAGE_START);
	}
	
	private void iniciarTablero() {
		Tablero tablero = new Tablero();
		
		this.add(tablero, BorderLayout.CENTER);
	}
	
	private void iniciarParteInferior() {
		JPanel parteInferior = new JPanel(new FlowLayout());
		parteInferior.setOpaque(false);
		this.add(parteInferior, BorderLayout.PAGE_END);
	}

	
}
