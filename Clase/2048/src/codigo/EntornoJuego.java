package codigo;

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
import java.util.Scanner;

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
		inciarParteSuperior();
		iniciarParteInferior();
		reiniciar();
	}
	
	void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public static EntornoJuego getInstance() {
		if (instance == null)
			instance = new EntornoJuego();
		
		return instance;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	private void inciarParteSuperior() {
		JPanel parteSuperior = new JPanel(new FlowLayout());
		parteSuperior.setOpaque(false);
		parteSuperior.add(time);
		
		ePuntaje = new EtiquetaPersonalizada(Long.toString(puntaje), 200, 80, 18);
		parteSuperior.add(ePuntaje);

		pausar = new JButton();
		pausar.setBorderPainted(false);
		pausar.setContentAreaFilled(false);
		pausar.setPreferredSize(new Dimension(80, 80));
		pausar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (time.getActivo()) {
					time.pararTiempo();
					tablero.setPausa(true);
					pausar.setIcon(Loader.getInstance().getOtros(5));
					pausar.setRolloverIcon(Loader.getInstance().getOtros(3));
				}
				
				else {
					time.iniciarTiempo();
					tablero.setPausa(false);
					pausar.setIcon(Loader.getInstance().getOtros(4));
					pausar.setRolloverIcon(Loader.getInstance().getOtros(2));
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
		time.pararTiempo();
		tablero.setPausa(true);
		JOptionPane.showMessageDialog(null, nombre + " tu puntaje es de: " + puntaje + " y el tiempo total: " + time.getTiempo());
		String dir = "top10.dat";
		String datos[][] = new String[10][2];
		int i = 0, j = 0;
		
		Scanner entrada = null;
		try {
			entrada = new Scanner(new File(dir));
			
			String cad[] = new String[2];
			while (entrada.hasNextLine() && i < 10) {
				if (cad[0] == null) 
					cad = entrada.nextLine().split("@");
				
				if (puntaje > Long.parseLong(cad[1]) || (Long.parseLong(cad[1]) == 0 && puntaje > 0)) {
					datos[i][0] = nombre;
					datos[i][1] = Long.toString(puntaje);
					puntaje = 0;
				}
				else {
					datos[i][0] = cad[0];
					datos[i][1] = cad[1];
					cad[0] = null;
				}
				i++;
			}//while
			cad = null;
			entrada.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocurrio un error con el archivo de guardado, se creara uno nuevo solo con su puntaje actual.");
			datos[j][0] = nombre;
			datos[j][1] = Long.toString(puntaje);
			i++;
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Ocurrio un error con el archivo de guardado, se creara uno nuevo solo con su puntaje actual.");
			datos[j][0] = nombre;
			datos[j][1] = Long.toString(puntaje);
			i++;
		} finally {
			if (entrada != null)
				entrada.close();
		}
		
		PrintWriter pw = null;
		try {
			FileWriter fw = new FileWriter(new File(dir));
			BufferedWriter bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			
			for (j = 0; j < i; j++) {
				pw.println(datos[j][0] + "@" + datos[j][1]);
			}//for
			pw.println("-unknown-@0");
			pw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocurrio un error al guardar el puntaje. " + e.getMessage());
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
		
		Juego.getInstance().actualizarFrame(Menu.getInstance());
		puntaje = 0;
	}
	
	private void iniciarParteInferior() {
		JPanel parteInferior = new JPanel(new FlowLayout());
		parteInferior.setOpaque(false);
		
		volver = new JButton(Loader.getInstance().getOtros(6));
		volver.setSize(volver.getIcon().getIconWidth(), volver.getIcon().getIconHeight());
		volver.setRolloverIcon(Loader.getInstance().getOtros(8));
		volver.setContentAreaFilled(false);
		volver.setBorderPainted(false);
		volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int pregunta = 0;
				if (puntaje != 0) {
					time.pararTiempo();
					pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea volver al menu? "
							+ "Si lo hace perdera la sesion actual, pero su puntaje se guardara en "
							+ "caso de ser top10.", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					
					if (!(tablero.getPausa()))
						time.iniciarTiempo();
				}
				if (pregunta == 0) {
					if (puntaje != 0)
						finDeJuego();
					else {
						time.reiniciar();
						time.pararTiempo();
						
						time.setText(time.getTiempo());
						
						puntaje = 0;
						ePuntaje.setText(Long.toString(puntaje));
						
						Juego.getInstance().actualizarFrame(Menu.getInstance());
					}
				}//if se acepto la advertencia
			}//actionPerformed
		});
		parteInferior.add(volver);
		
		reiniciar = new JButton(Loader.getInstance().getOtros(7));
		reiniciar.setRolloverIcon(Loader.getInstance().getOtros(9));
		reiniciar.setSize(reiniciar.getIcon().getIconWidth(), reiniciar.getIcon().getIconHeight());
		reiniciar.setContentAreaFilled(false);
		reiniciar.setBorderPainted(false);
		reiniciar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				reiniciar();
				revalidate();
				repaint();
			}
		});
		parteInferior.add(reiniciar);
		this.add(parteInferior, BorderLayout.PAGE_END);
	}
	
	Tiempo getTime() {
		return time;
	}
	
	void reiniciar() {
		puntaje = 0;
		ePuntaje.setText(Long.toString(puntaje));
		
		pausar.setIcon(Loader.getInstance().getOtros(4));
		pausar.setRolloverIcon(Loader.getInstance().getOtros(2));
		
		if (tablero != null) {
			remove(tablero);
			tablero = null;
		}
			
		iniciarTablero();
		
		time.reiniciar();
		time.setText(time.getTiempo());
	}
}
