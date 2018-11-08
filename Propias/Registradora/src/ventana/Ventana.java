package ventana;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Ventana extends JFrame {
	private Container ct;
	private JPanel panelSuperior;
	private JTextArea lista;
	private JLabel cantidadPersonas;
	
	private int contadorPersonas = 0;
	
	public Ventana() {
		super("Registradora");
		ct = this.getContentPane(); //para abreviar el panel principal
		ct.setLayout(new BoxLayout(ct, BoxLayout.Y_AXIS));
		this.setSize(600, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ct.setBackground(Color.lightGray);
		
		iniciarParteSuperior();
		iniciarParteInferior();
	}//ventana()
	
	private void iniciarParteSuperior() {
		panelSuperior = new JPanel(new GridLayout(3, 2));
		panelSuperior.setBackground(Color.lightGray);
		
		//etiqueta para nombre
		JLabel etiqueta = new JLabel("Nombres: ");
		etiqueta.setFont(new Font("Arial", Font.BOLD, 15));
		panelSuperior.add(etiqueta); 
		
		//campo de texto para nombre
		JTextField nombre = new JTextField();
		nombre.setFont(new Font("Arial", Font.PLAIN, 15));
		panelSuperior.add(nombre);
		
		//reutilizo etiqueta para cedula
		etiqueta = new JLabel("C.I: ");
		etiqueta.setFont(new Font("Arial", Font.BOLD, 15));
		panelSuperior.add(etiqueta);
		
		//campo de texto para ci
		JTextField ci = new JTextField();
		ci.setFont(new Font("Arial", Font.PLAIN, 15));
		panelSuperior.add(ci);
		
		//boton para limpiar los campos de texto
		JButton limpiar = new JButton("Limpiar");
		limpiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				nombre.setText("");
				ci.setText("");
			}
		});
		panelSuperior.add(limpiar);
	
		//Boton de aceptar
		JButton continuar = new JButton("Continuar");
		continuar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//añadir cositas del archivo
				FileWriter fw;
				try {
					Scanner entrada = new Scanner(new File("src//recursos//listado.dat"));
					//buscar la cedula
					entrada.close();
					fw = new FileWriter(new File("src//recursos//listado.dat"), true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(bw);
					
					
					
					pw.close();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error grave: " + e.getMessage());
				}
				
				contadorPersonas++;
				cantidadPersonas.setText("Personas registradas: " + contadorPersonas);
				cantidadPersonas.revalidate();
				cantidadPersonas.repaint();
			}
		});
		panelSuperior.add(continuar);
		
		ct.add(panelSuperior);
	}//inciarCampos
	
	private void iniciarParteInferior() {
		lista = new JTextArea();
		lista.setBackground(Color.white);
		lista.setFont(new Font("Arial", Font.BOLD, 12));
		lista.setEditable(false); //lista no editable desde el mismo programa
		lista.setText("Reyner Contreras, V.-26934400");
		lista.setPreferredSize(new Dimension(300, this.getWidth()));
		
		JScrollPane barra = new JScrollPane(lista, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		//cargar el archivo
		
		
	
		ct.add(barra);
		
		//añado la etiqueta del contador de personas
		cantidadPersonas = new JLabel("Personas registradas: " + contadorPersonas);
		ct.add(cantidadPersonas);
	}
}
