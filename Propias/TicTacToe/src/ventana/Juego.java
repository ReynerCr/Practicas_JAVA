package ventana;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Juego extends JFrame {
	
	private JPanel principal;
	private JPanel panelJuego;
	private JPanel inferior;
	private char simboloHumano;
	private char simboloIA;
	private int victorias = 0;
	private int derrotas = 0;
	private int empates = 0;
	
	public Juego() {
		iniciarVentana();
		iniciarPanelPrincipal();
		iniciarTitulo();
		iniciarPanelJuego();
		iniciarParteInferior();
		reiniciarBotones();
		
		pack();
	}//Juego
	
	private void iniciarVentana() {
		setTitle("Tic tac toe");
		setSize(700, 700);
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//iniciarVentana
	
	private void iniciarPanelPrincipal() {
		principal = new JPanel();
		principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));
		principal.setForeground(Color.lightGray);
		
		this.add(principal);
	}//iniciarPanelPrincipal
	
	private void iniciarTitulo() {
		JPanel superior = new JPanel (new FlowLayout());
		superior.setForeground(Color.white);
		
		JLabel titulo = new JLabel("Tic Tac Toe");
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		superior.add(titulo);
		
		ImageIcon fantasma = new ImageIcon("src//recursos//fantasma.png");
		JLabel imagencita = new JLabel (new ImageIcon(fantasma.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		superior.add(imagencita);
		
		principal.add(superior);
	}//iniciarTitulo
	
	private void iniciarPanelJuego() {
		panelJuego = new JPanel(new GridLayout(3, 3));
		
		for (int i = 0; i < 9; i++) {
			JButton casilla = new JButton();
			panelJuego.add(casilla);
		}//for i
		
		principal.add(panelJuego);
	}//iniciarPanelJuego
	
	private void iniciarBoton(JButton casilla) {
		casilla.removeActionListener(eventoCasilla(casilla));
		
		casilla.setText("   ");
		casilla.setEnabled(true);
		casilla.setBackground(Color.white);
		casilla.setFocusable(false);
		casilla.setFont(new Font("Arial", Font.BOLD, 100));
		
		casilla.addActionListener(eventoCasilla(casilla));
	}

	private void iniciarParteInferior() {
		inferior = new JPanel();
		inferior.setLayout(new BoxLayout(inferior, BoxLayout.Y_AXIS));
		
		JLabel indicacion = new JLabel();
		indicacion.setFont(new Font("Arial", Font.BOLD, 12));
		inferior.add(indicacion);
		
		JLabel contador = new JLabel("Victorias:" + victorias + "\nDerrotas:" + derrotas + "\nEmpates:" + empates);
		inferior.add(contador);
		
		JButton reiniciar = new JButton("Reiniciar");
		reiniciar.setFont(new Font("Arial", Font.BOLD, 12));
		reinicio(reiniciar);
		inferior.add(reiniciar);
		
		principal.add(inferior);
	}//iniciarParteInferior
	
	
	private void reiniciarBotones() {
		simboloHumano = ((int) (Math.random() * 2) == 0 ? 'O':'X');
		simboloIA = (simboloHumano == 'X' ? 'O':'X');
		
		for (int i = 0; i < 9; i++) {
			JButton casilla = (JButton) panelJuego.getComponent(i);
			iniciarBoton(casilla);
		}//añado los botones con sus respectivos eventos
		
		JLabel etiqueta = (JLabel) inferior.getComponent(0);
		etiqueta.setText("Humano: " + simboloHumano + " -  Computadora: " + simboloIA);
	}//iniciarBotones
	
	private ActionListener eventoCasilla(JButton casilla) {
		ActionListener pressCasilla = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				casilla.setText(Character.toString(simboloHumano));
				casilla.setEnabled(false);
			}
			
		}; //actionListener
		
		return pressCasilla;
	}//eventoCasilla
	
	//PRACTICA: TERMINAR LA PANTALLA DE LOGIN Y CUANDO DEN CLICK A ACEPTAR DE UN MENSAJE DE BIENVENIDA (+ NOMBRE DE USUARIO) Y CUANDO LE DE A CANCELAR BORRA LOS CAMPOS.
	
	private void reinicio(JButton reinicio) {
		ActionListener pressReincio = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				reiniciarBotones();
				
				revalidate();
				repaint();
				pack();
			}//actionPerformed
		}; //actionListener
		
		reinicio.addActionListener(pressReincio);
	}//eventoReinicio
}
