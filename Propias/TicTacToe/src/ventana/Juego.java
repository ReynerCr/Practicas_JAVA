package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
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
	
	public Juego() {
		iniciarVentana();
		iniciarPanelPrincipal();
		iniciarTitulo();
		iniciarPanelJuego();
		iniciarParteInferior();
		
		this.repaint();
		this.revalidate();
		this.pack();
	}
	
	private void iniciarVentana() {
		setTitle("Tic tac toe");
		setSize(500, 500);
		this.setMaximumSize(new Dimension(700, 700));
		this.setMinimumSize(new Dimension(700, 700));
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void iniciarPanelPrincipal() {
		principal = new JPanel();
		principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));
		principal.setForeground(Color.lightGray);
		
		this.add(principal);
	}
	
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
	}
	
	private void iniciarPanelJuego() {
		panelJuego = new JPanel();
		panelJuego.setLayout(new BoxLayout(panelJuego, BoxLayout.Y_AXIS));
		
		for (int i = 0; i < 3; i++) {
			JPanel cajaTres = new JPanel(new FlowLayout());
			
			for (int j = 0; j < 3; j++) {
				JButton casilla = new JButton("   ");
				casilla.setBackground(Color.white);
				casilla.setFocusable(false);
				casilla.setFont(new Font("Arial", Font.BOLD, 100));
				eventoCasilla(casilla);
				
				cajaTres.add(casilla);
			}//para añadir a cajaTres
			panelJuego.add(cajaTres);
		}//para añadir a panelJuego
		
		principal.add(panelJuego);
	}

	private void iniciarParteInferior() {
		inferior = new JPanel(new FlowLayout());
		
		JLabel indicacion = new JLabel("Humano: X  -  Computadora: O");
		indicacion.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel contador = new JLabel("");
		
		JButton reiniciar = new JButton("Reiniciar");
		reiniciar.setFont(new Font("Arial", Font.BOLD, 12));
		eventoReinicio(reiniciar);
		
		inferior.add(indicacion);
		inferior.add(contador);
		inferior.add(reiniciar);
		
		principal.add(inferior);
	}
	
	private void eventoCasilla(JButton casilla) {
		ActionListener pressCasilla = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				casilla.setText(" X ");
				casilla.setEnabled(false);
			}
			
		}; //actionListener
		
		casilla.addActionListener(pressCasilla);
	}
	
	private void eventoReinicio(JButton reinicio) {
		
		ActionListener pressReincio = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i < 3; i++) {
					JPanel panel = (JPanel) panelJuego.getComponent(i);
					
					for (int j = 0; j < 3; j++) {
						JButton boton = (JButton) panel.getComponent(j);
						boton.setText("   ");
					}//for j de boton
					
					panelJuego.setComponentZOrder(panel, i);
				}//for i de panel
				
			}
			
		}; //actionListener
		
		reinicio.addActionListener(pressReincio);
	}
}
