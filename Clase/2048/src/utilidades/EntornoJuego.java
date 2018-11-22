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
	
	public EntornoJuego(String nombre) {
		EntornoJuego.nombre = nombre;
		this.setLayout(new BorderLayout());

		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		inciarParteSuperior();
		iniciarTablero();
		iniciarParteInferior();
		Tiempo.getInstance().iniciarTiempo();
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
		Tablero tablero = new Tablero();
		
		this.add(tablero, BorderLayout.CENTER);
	}
	
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
		this.add(parteInferior, BorderLayout.PAGE_END);
	}

	
}
