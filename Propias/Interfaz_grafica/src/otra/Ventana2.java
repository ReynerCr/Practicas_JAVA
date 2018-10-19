package otra;

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

@SuppressWarnings("serial")
public class Ventana2 extends JFrame {
	
	private JPanel panel;
	private JLabel saludo;
	private JTextField cajaTexto;
	private JButton boton;
	private JTextArea areaTexto;
	
	
	public Ventana2 () {
		setTitle("Eventos");
		setLocationRelativeTo(null);
		
		setMinimumSize(new Dimension(200, 200)); 
		setPreferredSize(new Dimension(500, 500));
		setMaximumSize(new Dimension (700, 700));
		
		iniciarComponentes();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}//Ventana2()
	
	private void iniciarComponentes() {
		colocarPanel();
		colocarCajaTexto();
		colocarBoton();
		colocarAreaDeTexto(); //donde se muestran los eventos excepto saludo
		activarEvento(3); //-1=nada, 0=saludo, 1=raton, 2=teclado, 3=todo (requiere caja, boton y area activos)
	}//iniciarComponentes
	
	private void colocarPanel() {
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		this.add(panel);
	}//colocarPanel
	
	private void colocarCajaTexto() {
		cajaTexto = new JTextField(10);
		cajaTexto.setFont(new Font("Arial", Font.ITALIC, 12));
		
		panel.add(cajaTexto, BorderLayout.LINE_START);
	}//colocarCajaTexto
	
	private void colocarEtiqueta() {
		JLabel pregunta = new JLabel("Ingrese su nombre: ");
		pregunta.setFont(new Font("Arial", Font.BOLD, 15));
		
		panel.add(pregunta, BorderLayout.PAGE_START);
	}//colocarEtiqueta
	
	private void colocarBoton() {
		boton = new JButton();
		
		ImageIcon imagen = new ImageIcon("src\\recursos\\lecha.png"); 
		boton.setIcon(new ImageIcon (imagen.getImage().getScaledInstance(80, 40, Image.SCALE_FAST)));
		boton.setMnemonic(KeyEvent.VK_ENTER);
		
		panel.add(boton, BorderLayout.CENTER);
	}//colocarBoton
	
	private void colocarAreaDeTexto() {
		//area de texto
		areaTexto = new JTextArea();
		
		//barra de desplazamiento que no se por que necesito settearle tamaño para que se vea al correr el programa y no al pulsar el boton
		JScrollPane scroll = new JScrollPane(areaTexto, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setMinimumSize(new Dimension(200, 200)); 
		scroll.setPreferredSize(new Dimension(200, 200));
		scroll.setMaximumSize(new Dimension (200, 200));
		
		panel.add(scroll, BorderLayout.LINE_END);
	}//colocarAreaDeTexto
	
	private void saludar() {
		saludo = new JLabel();
		saludo.setFont(new Font("Arial", Font.BOLD, 20));
		
		panel.add(saludo, BorderLayout.PAGE_END);
	}//saludar

	private void activarEvento(int i) {
		//EVENTOS QUE SOLO MUESTRO EN EL AREA DE TEXTO
		if (i==0) {//saludo
			colocarEtiqueta(); //ingrese su nombre
			saludar();  //saluda con el nombre
			oyenteEventoAccion(); 
		}
		else if (i==1) {//raton
			eventoOyenteRaton();
		}
		else if (i==2) {//teclado
			eventosTeclado();
		}
		else if (i==3) {
			colocarEtiqueta();
			saludar();
			oyenteEventoAccion(); 
			
			eventoOyenteRaton();
			
			eventosTeclado();
		}
	}//activarEvento
	
	private void eventoOyenteRaton() {
		MouseListener oyenteRaton = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				areaTexto.append("MouseClicked\n");
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				//areaTexto.append("MouseEntered\n");
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				//areaTexto.append("MouseExited\n");
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
	}//eventoOyenteRaton

	private void oyenteEventoAccion() {
		//Agregar evento para boton
		ActionListener oyenteAccion = new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent ae) {
				saludo.setText("Hola " + cajaTexto.getText());
			}
			
		};
		
		boton.addActionListener(oyenteAccion);
	}//oyenteEventoAccion
	
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
				if (Character.isLetter(ke.getKeyChar()))
					areaTexto.append("Letra '" + ke.getKeyChar() + "' \n");
				
				if (ke.getKeyChar() == '\n') 
					areaTexto.append("Enter\n");
				
			}
			
		};//implementacion de keyListener
		
		cajaTexto.addKeyListener(oyenteTeclado);
	}//eventosTeclado
	
}//class Ventana2
