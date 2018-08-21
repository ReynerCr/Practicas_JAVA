package ventana;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class Ventana2 extends JFrame {
	
	private JPanel panel;
	private JLabel saludo;
	private JTextField cajaTexto;
	private JButton boton;
	private JTextArea areaTexto;
	
	
	public Ventana2 () {
		setSize(500, 500);
		setTitle("Eventos");
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(200, 200)); 
		
		iniciarComponentes();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void colocarPanel() {
		panel = new JPanel();
		panel.setLayout(new BorderLayout(5, 5));
		this.add(panel);
	}
	//ARREGLAR ESTE DESASTRE, NO ES RECOMENDADO USAR NULL LAYOUT Y TAMPOCO ME SIRVE .-.
	private void colocarCajaTexto() {
		cajaTexto = new JTextField(10);
		cajaTexto.setFont(new Font("Arial", Font.ITALIC, 12));
		panel.add(cajaTexto);
		
		
		eventosTeclado();
	}
	
	private void colocarEtiqueta() {
		JLabel pregunta = new JLabel("Ingrese su nombre: ");
		pregunta.setBounds(10, 10, 300, 40);
		pregunta.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(pregunta);
	}
	
	private void colocarBoton() {
		//boton
		boton = new JButton();
		ImageIcon imagen = new ImageIcon("flecha.png");
		boton.setBounds(360, 100, 80, 40);
		boton.setIcon(new ImageIcon (imagen.getImage().getScaledInstance(boton.getWidth(), boton.getHeight(), Image.SCALE_FAST)));
		
		panel.add(boton);
	}
	
	private void colocarAreaDeTexto() {
		areaTexto = new JTextArea(50, 50);
		JScrollPane scroll = new JScrollPane(areaTexto);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		panel.add(scroll);
		//eventoOyenteRaton();
	}
	
	private void saludar() {
		//saludo
		saludo = new JLabel();
		saludo.setFont(new Font("Arial", Font.BOLD, 20));
		saludo.setBounds(10, 110, 200, 120);
		
		panel.add(saludo);
		
		oyenteEventoAccion();
	}

	private void iniciarComponentes() {
		colocarPanel();
		colocarCajaTexto();  
		//colocarEtiqueta();  
		//colocarBoton();
		//saludar();  
		//colocarAreaDeTexto(); 
	}
	
	private void eventoOyenteRaton() {
		MouseListener oyenteRaton = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				areaTexto.append("MouseClicked\n");
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				areaTexto.append("MouseEntered\n");
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				areaTexto.append("MouseExited\n");
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				areaTexto.append("MousePressed\n");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				areaTexto.append("MouseReleased\n");
			}
			
		};
		
		boton.addMouseListener(oyenteRaton);
	}

	private void oyenteEventoAccion() {
		//Agregar evento para boton
		ActionListener oyenteAccion = new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent ae) {
				saludo.setText("Hola " + cajaTexto.getText());
			}
			
		};
		
		boton.addActionListener(oyenteAccion);
	}
	
	private void eventosTeclado() {
		
		KeyListener oyenteTeclado = new KeyListener() {

			@Override
			public void keyPressed(KeyEvent ke) {
				//areaTexto.append("KeyPressed\n");
			}

			@Override
			public void keyReleased(KeyEvent ke) {
				//areaTexto.append("KeyReleassed\n");
			}

			@Override
			public void keyTyped(KeyEvent ke) {
				//areaTexto.append("KeyTyped\n");
				if (ke.getKeyChar() == 'p') {
					areaTexto.append("Letra p\n");
				}
				else if (ke.getKeyChar() == '\n') {
					areaTexto.append("Enter\n");
				}
			}
			
		};
		
		cajaTexto.addKeyListener(oyenteTeclado);
	}
	
}
