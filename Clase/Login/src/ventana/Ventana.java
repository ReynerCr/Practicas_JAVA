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
		getContentPane().removeAll();
		this.setTitle("Iniciar sesion");
		
		iniciarCampos(); //elemento 1
		iniciarBotones(); //elemento 2
		registroYolvidoC(); //elemento 3
		
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
							
						String linea = buscarUnDato(usuario.getText(), 2);
						
						if (linea.compareTo(contrasena.getText()) == 0) {
							JOptionPane.showMessageDialog(null, "¡Hola " + usuario.getText() + "!");
							usuario.setText("");
							contrasena.setText("");
						}//si contrasena no coincide rompo el ciclo
						else {
							JOptionPane.showMessageDialog(null, "Nombre o contrasena incorrectos.");
						}//cuando todo esta correcto e inicio sesion bien

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
	
	//Metodo que busca a un usuario por su nombre y si lo consigue retorna alguno de sus datos
	private String buscarUnDato(String usuario, int opcion) {
		String linea = "";
		try {
			Scanner entrada = new Scanner(new File("src\\recursos\\cuentas.dat"));
			
			while (entrada.hasNextLine()) {
				linea = entrada.nextLine();
				if(linea.compareTo("######") == 0) {
					linea = entrada.nextLine();
					StringTokenizer tokenizer = new StringTokenizer(linea, "#####");
					linea = tokenizer.nextToken();
					
					if (linea.compareTo(usuario) == 0) {
						switch (opcion) {
							case 1: //retornar usuario
								break;
							case 2: //retornar contrasena
								linea = tokenizer.nextToken();
								break;
							default: //no deberia tener uso pero por si acaso
								linea = "";
								break;
						}//diferentes acciones segun lo que este buscando
						entrada.close();
						return linea;
					}//si nombre coincide entonces compruebo que tipo de dato quiero retornar
				}//si consigue el separador entre cuentas
			}//while hayan mas lineas
			
			entrada.close();
		} catch (FileNotFoundException e) {
			crearArch();
		}

		return ""; //no se consiguio usuario
	}//buscarContrasena
	
	private void crearArch() {
		try {
			FileWriter fw = new FileWriter("src\\recursos\\cuentas.dat", true);
			fw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocurrio un error al leer el archivo!" + e.getMessage());
		}
	}//crearArch
		
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
		olvido.addActionListener(olvidoCont());
		
		registroYolvido.add(olvido);
		
		this.getContentPane().add(registroYolvido);
	}//registroYolvidoC
	
	private ActionListener olvidoCont() {
		ActionListener olvido = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setTitle("Recuperacion de contrasena");
				getContentPane().remove(0);
				getContentPane().remove(1);

				JLabel etiqueta = new JLabel("Ingresa el usuario:");
				JTextField usuario = new JTextField();
				usuario.setFont(new Font("Arial", Font.BOLD, 15));
				
				JLabel dialogo = new JLabel("    ");
				dialogo.setFont(new Font("Arial", Font.BOLD, 15));
				dialogo.setForeground(Color.blue);
				
				JButton comprobar = (JButton) botones.getComponent(0);
				eliminarALs(comprobar);
				comprobar.setText("Comprobar");
				comprobar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						usuario.setText(usuario.getText().trim());
						
						if (!usuario.getText().isEmpty()) {
							String contra = buscarUnDato(usuario.getText(), 2);
							if (contra.compareTo("") != 0) {
								dialogo.setText("Su contrasena es: " + contra);
							}
							else {
								dialogo.setText("Nombre de usuario no registrado.");
							}
						}//si no esta vacia la caja
						else {
							JOptionPane.showMessageDialog(null, "Campo de usuario no puede estar vacio.");
						}
						
						pack();
						getContentPane().revalidate();
						getContentPane().repaint();
					}//actionPerformed
				});
				
				JButton volver = (JButton) botones.getComponent(1);
				eliminarALs(volver);
				volver.setText("Volver");
				volver.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						iniciar();
					}
				});
				
				getContentPane().add(etiqueta, 0);
				getContentPane().add(usuario, 1);
				getContentPane().add(botones, 2);
				getContentPane().add(dialogo, 3);
				
				pack();
				getContentPane().revalidate();
				getContentPane().repaint();
				
			}//actionPerformed
		};//ActionListener
		
		return olvido;
	}//olvidoCont
	
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
							if (!contrasena.getText().isEmpty()) {
								if (usuario.getText().contains("#")) {
									JOptionPane.showMessageDialog(null, "Lo sentimos, no se permite crear un nombre de usuario que contenga el siguiente caracter: #");
								}
								else if (!contrasena.getText().contains("#")) {
									if ("".compareTo(buscarUnDato(usuario.getText(), 1)) == 0) {
										try {
											FileWriter fw = new FileWriter("src\\recursos\\cuentas.dat", true);
											BufferedWriter bw = new BufferedWriter(fw);
											PrintWriter pw = new PrintWriter(bw);
											
											pw.println("######");
											pw.println(usuario.getText()+"#####" + contrasena.getText());
											
											JOptionPane.showMessageDialog(null, "Hecho, ya puede iniciar sesion.");
											pw.close();
										} catch (IOException e) {
											JOptionPane.showMessageDialog(null, "Ha ocurrido un error grave:  " + e.getMessage());
										}
										
										//borro todo y luego vuelvo a mandar al menu inicial
										getContentPane().removeAll();
										iniciar();
									}//que no exista un usario con el mismo nombre
									else {
										JOptionPane.showMessageDialog(null, "Ya existe un usuario con el mismo nombre.");
									}
								}//que la contrasena no contenga la cadena de caracteres que separan las cuentas (#####)
								else {
									JOptionPane.showMessageDialog(null, "Lo sentimos, no se permite crear una contrasena que contenga el siguiente caracter: #");
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
				
				JButton volver = (JButton) botones.getComponent(1);
				eliminarALs(volver);
				volver.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
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
