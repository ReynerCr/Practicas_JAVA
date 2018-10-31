package ventana;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Ventana extends JFrame {
	private JPanel campos;
	private JPanel botones;
	
	public Ventana () {
		this.setSize(400, 300);
		this.setMinimumSize(new Dimension(300, 200));
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

		iniciar();
		this.pack();
	}
	
	private void iniciar() {
		this.setTitle("Iniciar sesion");
		
		iniciarCampos();
		iniciarBotones();
		registroYolvidoC();
		
		pack();
		getContentPane().revalidate();
		getContentPane().repaint();
	}//iniciar
	
	private void iniciarCampos() {
		campos = new JPanel(new GridLayout(2, 2));

		JLabel eUsuario = new JLabel("Usuario: ");
		eUsuario.setFont(new Font("Arial", Font.BOLD, 15));
		JTextField usuario = new JTextField();
		usuario.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel eContrasena = new JLabel("Contrasena: ");
		eContrasena.setFont(new Font("Arial", Font.BOLD, 15));
		JPasswordField contrasena = new JPasswordField();
		
		campos.add(eUsuario);
		campos.add(usuario);
		campos.add(eContrasena);
		campos.add(contrasena);
		this.getContentPane().add(campos);
	}//iniciarCampos
	
	private void iniciarBotones() {
		botones = new JPanel(new FlowLayout());
		JButton aceptar = new JButton("Aceptar");
		aceptar.setMnemonic('\n');
		eliminarALs(aceptar);
		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JTextField usuario = (JTextField) campos.getComponent(1);
				usuario.setText(usuario.getText().trim());

				if (!usuario.getText().isEmpty()) {
					JTextField contrasena = (JTextField) campos.getComponent(3);
					contrasena.setText(contrasena.getText().trim());
					
					if (!contrasena.getText().isEmpty()) {
						Scanner entrada;
						boolean correcto = false;
						
						try {
							entrada = new Scanner(new File("src\\recursos\\cuentas.dat"));
							while (entrada.hasNextLine()) {
								String linea = entrada.nextLine();
								
								if(linea.compareTo("######") == 0) {
									linea = entrada.nextLine();
									StringTokenizer tokenizer = new StringTokenizer(linea, "#####");
									System.out.println(linea);
									linea = tokenizer.nextToken();
									System.out.println(linea);
									
									if (linea.compareTo(usuario.getText()) == 0) {
										linea = tokenizer.nextToken();
										if (linea.compareTo(contrasena.getText()) != 0) {
											break;
										}//si contrasena no coincide rompo el ciclo TODO validar que no se repitan usuarios
										else {
											correcto = true;
											
											JOptionPane.showMessageDialog(null, "¡Hola " + usuario.getText() + "!");
											usuario.setText("");
											contrasena.setText("");
										}//cuando todo esta correcto e inicio sesion bien

									}//si nombre no coincide rompo el ciclo
								}//si consigue el separador
							}//while hayan mas lineas
							
							if (!correcto) {
								JOptionPane.showMessageDialog(null, "Nombre o contrasena incorrectos.");
							}
							
							entrada.close();
						} catch (FileNotFoundException e) {
							JOptionPane.showMessageDialog(null, "Ha ocurrido un error al leer! " + e.getMessage());
						}
						
						
						
					}//si campo de contrasena no esta vacio
					else {
						JOptionPane.showMessageDialog(null, "Campo de contrasena no puede estar vacio.");
					}
				}//si campo de usuario no esta vacio
				else {
					JOptionPane.showMessageDialog(null, "Campo de usuario no puede estar vacio.");
				}
			}//actionPerformed
		});
		
		JButton cancelar = new JButton("Cancelar");
		eliminarALs(cancelar);
		
		cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JTextField usuario = (JTextField) campos.getComponent(1);
				usuario.setText("");
				
				JTextField contrasena = (JTextField) campos.getComponent(3);
				contrasena.setText("");
			}
		});
		
		botones.add(aceptar);
		botones.add(cancelar);
		this.getContentPane().add(botones);
	}//iniciarBotones

	private void registroYolvidoC() {
		JPanel registroYolvido = new JPanel(new FlowLayout());
		
		JButton registro = new JButton("No tienes una cuenta?");
		registro.setFont(new Font("Arial", Font.BOLD, 11));
		registro.setForeground(Color.blue);
		registro.setBorderPainted(false);
		registro.setContentAreaFilled(false);
		registro.addActionListener(registrar());
		registroYolvido.add(registro);
		
		JButton olvido = new JButton("Olvidaste tu contrasena?");
		olvido.setFont(new Font("Arial", Font.BOLD, 11));
		olvido.setForeground(Color.blue);
		olvido.setBorderPainted(false);
		olvido.setContentAreaFilled(false);
		registroYolvido.add(olvido);
		this.getContentPane().add(registroYolvido);
	}//registroYolvidoC
	
	private ActionListener registrar() {
		ActionListener registro = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setTitle("Registrar una cuenta");
				getContentPane().remove(2);
				
				JTextField usuario = (JTextField) campos.getComponent(1);
				JTextField contrasena = (JTextField) campos.getComponent(3);
				
				JButton aceptar = (JButton) botones.getComponent(0);
				eliminarALs(aceptar);
				aceptar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						usuario.setText(usuario.getText().trim());
						if (!usuario.getText().isEmpty()) {
							contrasena.setText(contrasena.getText().trim());
							//TODO VALIDAR QUE NO CONTENGAN #####
							if (!contrasena.getText().isEmpty()) {
								try {
									FileWriter fw = new FileWriter("src\\recursos\\cuentas.dat", true);
									BufferedWriter bw = new BufferedWriter(fw);
									PrintWriter pw = new PrintWriter(bw);
									
									pw.println("######");
									pw.println(usuario.getText()+"#####"+contrasena.getText());
									
									JOptionPane.showMessageDialog(null, "Hecho, ya puede iniciar sesion.");
									pw.close();
								} catch (IOException e) {
									JOptionPane.showMessageDialog(null, "Ha ocurrido un error al abrir! " + e.getMessage());
								}
								
								//borro todo y luego vuelvo a mandar al menu inicial
								getContentPane().removeAll();
								iniciar();
							}//si campo de contrasena no esta vacio
							else {
								JOptionPane.showMessageDialog(null, "Campo de contrasena no puede estar vacio.");
							}
						}//si campo de usuario no esta vacio
						else {
							JOptionPane.showMessageDialog(null, "Campo de usuario no puede estar vacio.");
						}
					}//actionPerformed
				});
				
				JButton volver = (JButton) botones.getComponent(1);
				eliminarALs(volver);
				volver.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						getContentPane().removeAll();
						iniciar();
					}//actionPerformed
				});
				
				pack();
				getContentPane().revalidate();
				getContentPane().repaint();
			}//actionPerformed
		};
		
		return registro;
	}//registrar
	
	private JButton eliminarALs(JButton boton) {
		ActionListener vector[] = boton.getActionListeners();
		for (int i = 0; i < vector.length; i++) {
			boton.removeActionListener(vector[i]);
		}//for i
		return boton;
	}//eliminarALs
}
