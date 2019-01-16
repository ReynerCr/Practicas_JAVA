package utilidades;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class EntornoJuego extends PanelPadre {
	private static EntornoJuego instance = null;
	
	private long puntaje = 0;
	private String nombre;
	private EtiquetaPersonalizada ePuntaje;
	private JButton pausar;
	private JButton reiniciar;
	private Tiempo time;
	
	private JButton volver;
	Tablero tablero;
	
	private EntornoJuego() {
		this.setLayout(new BorderLayout());
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		time = new Tiempo();
		time.iniciar();
		time.iniciarTiempo();
		inciarParteSuperior();
		iniciarTablero();
		iniciarParteInferior();
	}
	
	void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public static EntornoJuego getInstance() {
		if (instance == null)
			instance = new EntornoJuego();
		
		return instance;
	}

	private void inciarParteSuperior() {
		JPanel parteSuperior = new JPanel(new FlowLayout());
		parteSuperior.setOpaque(false);
		parteSuperior.add(time);
		
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
				if (time.getActivo()) {
					time.pararTiempo();
					pausar.setIcon(ImageLoader.getInstance().getOtros(5));
					pausar.setRolloverIcon(ImageLoader.getInstance().getOtros(3));
				}
				
				else {
					time.iniciarTiempo();
					pausar.setIcon(ImageLoader.getInstance().getOtros(4));
					pausar.setRolloverIcon(ImageLoader.getInstance().getOtros(2));
				}
			}
		});
		parteSuperior.add(pausar);
		
		this.add(parteSuperior, BorderLayout.PAGE_START);
	}
	
	private void iniciarTablero() {
		tablero = new Tablero();
		this.add(tablero, BorderLayout.CENTER);
	}
	
	void actualizarPuntaje(long puntaje) {
		this.puntaje += puntaje;
		ePuntaje.setText(Long.toString(this.puntaje));
	}
	
	void finDeJuego() {
		JOptionPane.showMessageDialog(null, nombre + "tu puntaje es de: " + puntaje + " y el tiempo total: " + time.getTiempo());
		time.pararTiempo();
		
		try {
			String dir = this.getClass().getResource("recursos/").getPath() + "top10.dat";
			FileWriter fw = new FileWriter(new File(dir), true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.println(nombre + "@" + puntaje);
			
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Juego.getInstance().actualizarFrame(Menu.getInstance());
	}
	
	private void iniciarParteInferior() {
		JPanel parteInferior = new JPanel(new FlowLayout());
		parteInferior.setOpaque(false);
		
		volver = new JButton(ImageLoader.getInstance().getOtros(6));
		volver.setSize(volver.getIcon().getIconWidth(), volver.getIcon().getIconHeight());
		volver.setRolloverIcon(ImageLoader.getInstance().getOtros(8));
		volver.setContentAreaFilled(false);
		volver.setBorderPainted(false);
		volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				time.iniciar();
				time.pararTiempo();
				time.setText(time.getTiempo());
				
				puntaje = 0;
				ePuntaje.setText(Long.toString(puntaje));
				
				Juego.getInstance().actualizarFrame(Menu.getInstance());
			}
		});
		parteInferior.add(volver);
		
		reiniciar = new JButton(ImageLoader.getInstance().getOtros(7));
		reiniciar.setRolloverIcon(ImageLoader.getInstance().getOtros(9));
		reiniciar.setSize(reiniciar.getIcon().getIconWidth(), reiniciar.getIcon().getIconHeight());
		reiniciar.setContentAreaFilled(false);
		reiniciar.setBorderPainted(false);
		reiniciar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				remove(tablero);
				iniciarTablero();
				
				boolean condicion = false;
				if (time.getActivo()) {
					condicion = true;
				}
				time.iniciar();
				time.setText(time.getTiempo());
				
				if(!condicion)
					time.pararTiempo();
				
				puntaje = 0;
				ePuntaje.setText(Long.toString(puntaje));
				
				revalidate();
				repaint();
			}
		});
		parteInferior.add(reiniciar);
		
		this.add(parteInferior, BorderLayout.PAGE_END);
	}
	
	public Tiempo getTime() {
		return time;
	}

}
