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
	private static long puntaje = 0;
	private static String nombre;
	private static EtiquetaPersonalizada ePuntaje;
	private JButton pausar;
	private JButton reiniciar;
	
	private JButton volver;
	Tablero tablero;
	
	public EntornoJuego(String nombre) {
		EntornoJuego.nombre = nombre;
		this.setLayout(new BorderLayout());
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		Tiempo.getInstance().iniciar();
		Tiempo.getInstance().iniciarTiempo();
		inciarParteSuperior();
		iniciarTablero();
		iniciarParteInferior();
	}

	private void inciarParteSuperior() {
		JPanel parteSuperior = new JPanel(new FlowLayout());
		parteSuperior.setOpaque(false);
		parteSuperior.add(Tiempo.getInstance());
		
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
				if (Tiempo.getInstance().getActivo()) {
					Tiempo.getInstance().pararTiempo();
					pausar.setIcon(ImageLoader.getInstance().getOtros(5));
					pausar.setRolloverIcon(ImageLoader.getInstance().getOtros(3));
				}
				
				else {
					Tiempo.getInstance().iniciarTiempo();
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
	//TODO reiniciar tiempo y puntaje cuando se vaya a menu y al reiniciar; al volver a menu pide nombre de nuevo
	//TODO reordenar los puntajes para que queden de mayor a menor
	
	public static void actualizarPuntaje(long puntaje) {
		EntornoJuego.puntaje += puntaje;
		EntornoJuego.ePuntaje.setText(Long.toString(EntornoJuego.puntaje));
	}
	
	public static void finDeJuego() {
		JOptionPane.showMessageDialog(null, nombre + "tu puntaje es de: " + puntaje + " y el tiempo total: " + Tiempo.getInstance().getTiempo());
		Tiempo.getInstance().pararTiempo();
		
		try {
			String dir = ManejaEventos.getRuta();
			FileWriter fw = new FileWriter(new File(dir));
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw, true);
			
			pw.print(nombre + "@" + puntaje);
			
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ManejaEventos.volverAMenu();
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
				ManejaEventos.actualizarFrame(Menu.getInstance());
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
				Tiempo.getInstance().iniciar();
				remove(tablero);
				iniciarTablero();
				puntaje = 0;
				ePuntaje.setText(Long.toString(puntaje));
				
				revalidate();
				repaint();
			}
		});
		parteInferior.add(reiniciar);
		
		this.add(parteInferior, BorderLayout.PAGE_END);
	}

	
}
