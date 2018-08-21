package ventana;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.net.SocketTimeoutException;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Ventana extends JFrame {
	
	public JPanel panel;  //creacion de panel
	
	public Ventana() {
		setSize(500, 500); //tamaño inicial
		setTitle("Hola mundo a la version grafica de java."); //titulo
		setLocationRelativeTo(null); //ventana en centro como pos inicial
		setMinimumSize(new Dimension(200, 200)); //tamaño minimo
		
		//this.getContentPane().setBackground(Color.LIGHT_GRAY); //settear color
		
		iniciarComponentes();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE); //cerrar al dar x
		
	}//constructor
	
	private void iniciarComponentes() {
		colocarPaneles();
		colocarBotones();
		colocarEtiquetas();
		//colocarRadioBotones();
		colocarCajasDeTexto();
		//colocarAreasDeTexto();
		//colocarListasDesplegables();
	}
	
	private void colocarRadioBotones() {
		JLabel etiquetica = new JLabel ("Seleccione una opcion:");
		etiquetica.setBounds(100, 50, 300, 50);
		etiquetica.setFont(new Font("Arial", Font.BOLD, 12));
		panel.add(etiquetica);
		etiquetica.setOpaque(false);
		
		JRadioButton rboton1 = new JRadioButton("Opcion 1", true);
		rboton1.setBounds(100, 100, 300, 50);
		panel.add(rboton1);
		rboton1.setOpaque(false);
		
		JRadioButton rboton2 = new JRadioButton("opcion 2", false);
		rboton2.setBounds(100, 150, 200, 50);
		panel.add(rboton2);
		rboton2.setOpaque(false);
		
		JRadioButton rboton3 = new JRadioButton("Opcion 3", false);
		rboton3.setBounds(100, 200, 200, 50);
		panel.add(rboton3);
		rboton3.setOpaque(false);
		
		ButtonGroup grupoRadioBotones = new ButtonGroup();
		grupoRadioBotones.add(rboton1);
		grupoRadioBotones.add(rboton2);
		grupoRadioBotones.add(rboton3);
	}
	
	private void colocarListasDesplegables() {
		String [] paises = {"Peru", "Colombia", "Venezuela", "Ecuador", "Chile"};
		
		JComboBox lista1 = new JComboBox(paises);
		lista1.setBounds(20, 20, 100, 30);
		lista1.addItem("Argentina");  //añadir obj al final de la lista
		
		lista1.setSelectedItem("Venezuela"); //seleccionar el obj que se vera al inicio
		
		panel.add(lista1);
	}
	
	private void colocarPaneles() {
		panel = new JPanel();
		panel.setLayout(null); //para que se pueda modificar todo
		this.getContentPane().add(panel);  //añadir a la ventana
	}//colocarPaneles
	
	private void colocarBotones() {
		ImageIcon imagen = new ImageIcon("flecha.png");
		JButton boton1 = new JButton();
		boton1.setSize(80, 40);
		boton1.setLocation(10, 100);
		boton1.setIcon(new ImageIcon (imagen.getImage().getScaledInstance(boton1.getWidth(), boton1.getHeight(), Image.SCALE_FAST)));
		panel.add(boton1);
		boton1.setMnemonic(32); //establecer letra para que interactue, si no es ASCII entonces es alt+tecla
	}//colocarBotones
	
	private void colocarEtiquetas() {
		
		JLabel etiqueta3 = new JLabel("Ingrese su nombre: ");
		etiqueta3.setOpaque(false);
		etiqueta3.setFont(new Font("Cooper Black", Font.BOLD, 15));
		etiqueta3.setBounds(10, 0, 200, 50);
		
		panel.add(etiqueta3);
		
		
		//JLabel etiqueta = new JLabel(); //crear etiqueta; OJO: hay constructores para cosas bonitas
		/*etiqueta.setText("Hola"); //settear texto
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER); //que la etiqueta este en el centro
		etiqueta.setOpaque(true);  //para que no sea transparente
		etiqueta.setForeground(Color.WHITE);  //color de letra
		etiqueta.setBackground(Color.BLACK); //color de fondo
		//etiqueta.setBounds(20, 20, 100, 100);  //tamaño y posicion
		etiqueta.setSize(40, 40);
		panel.add(etiqueta); //añadir a mi panel
		etiqueta.setFont(new Font ("CASTELLAR", Font.ITALIC, 11));*/
		
		//etiqueta imagen
		/*ImageIcon imagen = new ImageIcon ("fantasma.png"); //imageIcon para imagenes
		JLabel etiqueta2 = new JLabel(); //creo la etiqueta2
		etiqueta2.setBounds(0, 0, 60, 60); //Tamaño y posicion
		etiqueta2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta2.getWidth(), etiqueta2.getHeight(), Image.SCALE_SMOOTH))); //setteo la imagen en la etiqueta y la redimensiono
		
		panel.add(etiqueta2); //añado a mi panel*/
		
	}//colocarEtiquetas
	
	private void colocarAreasDeTexto() {
		JTextArea areaTexto = new JTextArea();
		areaTexto.setBounds(20, 20, 300, 200);
		areaTexto.setText("Esriba el texto aqui: ");
		areaTexto.append(" BIEEEN"); //añade mas texto al area
		areaTexto.setEditable(true); //que se pueda editar o no, sirve con cajas de texto
		//areaTexto.getText(); tambien devuelve lo que este dentro, igual que cajas de txt
		
		panel.add(areaTexto);
	}

	private void colocarCajasDeTexto() {
		JTextField cajita = new JTextField();
		cajita.setBounds(10, 50, 200, 30);
		
		panel.add(cajita);
	}
	
}
