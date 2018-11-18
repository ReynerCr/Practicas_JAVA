/* Programa para registrar personas en una lista y verificar que no se repitan por la C.I.
 * De libre uso (aunque tampoco se a quien le pueda llegar a interesar).
 * Autor: Reyner Contreras. */

package ventana;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Ventana extends JFrame {
	private JLabel cantidadPersonas;
	private JFrame listado;
	private JPanel lista;
	
	private int contadorPersonas; 
	
	/** Constructor por defecto y unico del proyecto. */
	public Ventana() {
		super("PandaBeer");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.lightGray);
		setLocationRelativeTo(null);

		iniciarFramePrincipal();
		iniciarFrameListado();
		
		//anyado el icono a ambos frames
		ImageIcon icono = new ImageIcon("src\\recursos\\icon.png");
		this.setIconImage(icono.getImage());
		listado.setIconImage(icono.getImage());
		
		//hago visibles ambos frames
		this.setVisible(true);
		listado.setVisible(true);
	}//ventana()
	
	/** Metodo para cargar el frame donde se registra a las personas. */
	private void iniciarFramePrincipal() {
		this.getContentPane().setLayout((new GridLayout(6, 2)));
		this.getContentPane().setBackground(Color.lightGray);
		
		//etiqueta para nombre
		JLabel etiqueta = new JLabel("Nombres: ");
		etiqueta.setFont(new Font("Arial", Font.BOLD, 15));
		this.getContentPane().add(etiqueta); 
		
		//campo de texto para nombre
		JTextField nombre = new JTextField();
		nombre.setFont(new Font("Arial", Font.PLAIN, 15));
		this.getContentPane().add(nombre);
		
		//reutilizo etiqueta para cedula
		etiqueta = new JLabel("C.I: ");
		etiqueta.setFont(new Font("Arial", Font.BOLD, 15));
		this.getContentPane().add(etiqueta);
		
		//campo de texto para ci
		JTextField ci = new JTextField();
		ci.setFont(new Font("Arial", Font.PLAIN, 15));
		this.getContentPane().add(ci);
		
		//reutilizo etiqueta para telefono
		etiqueta = new JLabel("Teléfono: ");
		etiqueta.setFont(new Font("Arial", Font.BOLD, 15));
		this.getContentPane().add(etiqueta);
		
		JTextField telefono = new JTextField();
		telefono.setFont(new Font("Arial", Font.PLAIN, 15));
		this.getContentPane().add(telefono);
		
		//reutilizo etiqueta para direccion
		etiqueta = new JLabel("Dirección: ");
		etiqueta.setFont(new Font("Arial", Font.BOLD, 15));
		this.getContentPane().add(etiqueta);
				
		JTextField direccion = new JTextField();
		direccion.setFont(new Font("Arial", Font.PLAIN, 15));
		this.getContentPane().add(direccion);
		
		//boton para limpiar los campos de texto y/o abrir frame de lista
		JButton limpiar = new JButton("Limpiar/abrir listado");
		limpiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				nombre.setText("");
				ci.setText("");
				telefono.setText("");
				direccion.setText("");
				listado.setVisible(true);
			}
		});
		this.getContentPane().add(limpiar);
	
		//Boton de aceptar
		JButton continuar = new JButton("Registrar");
		continuar.addActionListener(eventoContinuar(nombre, ci, telefono, direccion));
		this.getContentPane().add(continuar);
		
		//Anyado el contador de personas por primera vez
		contadorPersonas = 0;
		try {
			contadorPersonas = buscarEnArchivo("");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocurrió un error grave: " +e.getMessage());
			contadorPersonas = 0;
		} 
		cantidadPersonas = new JLabel("Personas registradas: " + contadorPersonas);
		this.getContentPane().add(cantidadPersonas);
		
		//Escuchadora de minimizado
		this.addWindowListener(new WindowAdapter() {
				public void windowIconified(WindowEvent e) {
					listado.setVisible(false);
				}
	
			    public void windowDeiconified(WindowEvent e) {
			    	listado.setVisible(true);
			    }
			}//WindowAdapter
		);//windowListener
		
		this.pack();
		setLocation(this.getLocation().x - this.getWidth(), 0);
	}//inciarFramePrincipal()
	
	/** Metodo para iniciar el frame del listado */
	private void iniciarFrameListado() {
		listado = new JFrame("Listado");
		listado.setSize(350, 650);
		listado.setBackground(Color.white);
		listado.setLocation(this.getWidth() + this.getLocation().x + 10, this.getLocation().y);
		listado.setDefaultCloseOperation(HIDE_ON_CLOSE);
		iniciarLista();
	}//iniciarFrameListado()
	
	/** Metodo para iniciar el panel de lista. */
	private void iniciarLista() {
		lista = new JPanel();
		lista.setLayout(new BoxLayout(lista, BoxLayout.Y_AXIS));
		lista.setBackground(Color.white);
		lista.setSize(new Dimension(this.getWidth()+50, 600));
		JScrollPane barra = new JScrollPane(lista, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		listado.add(barra);
		cargarListado();
	}//iniciarLista()
	
	/** Metodo para cargar la lista de personas registradas en el frame de listado. */
	private void cargarListado() {
		if (contadorPersonas != 0) {
			Scanner entrada = null;
			try {
				entrada = new Scanner(new File("src\\recursos\\listado.dat"));
				ImageIcon imagen = new ImageIcon("src\\recursos\\remove.png");
				while (entrada.hasNextLine()) {
					String linea = entrada.nextLine();						
					String[] cadenas = linea.split("@");
					JPanel persona = new JPanel(new FlowLayout());
					JLabel datos = new JLabel("NOMBRE: " + cadenas[0] + " - C.I: " + cadenas[1]);
					persona.add(datos);
					persona.add(botonEliminar(imagen, persona));
					lista.add(persona);
				}//while hayan mas lineas
				lista.revalidate();
				lista.repaint();
				entrada.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Ocurrió un error grave: " + e.getMessage());
			}//catch del try posible IOException
			catch (IndexOutOfBoundsException e) {
				entrada.close();
				JOptionPane.showMessageDialog(null, "Ocurrió un error grave al cargar el archivo. Se recreará, por favor reinicie el programa.");
				File arch = new File("src\\recursos\\listado.dat");
				arch.delete();
				System.exit(0);
			}//catch del try posible indice fuera de rango
		}//if contadorPersonas != 0 (hay registros)
		else {
			noRegistros();
		}//else contadorPersonas == 0 (no hay registros)
	}//cargarListado()
	
	/** Metodo para crear el mensaje de no registros. */
	private void noRegistros() {
		JLabel mensaje = new JLabel("No hay personas registradas.");
		mensaje.setFont(new Font("Arial", Font.BOLD, 14));
		lista.add(mensaje);
	}//noRegistros()
	
	/** Evento utilizado para el boton de registrar. Recibe cuatro JTextField que
	 *  son nombre, cedula, telefono y cedula. */
	private ActionListener eventoContinuar(JTextField nombre, JTextField ci, JTextField telefono, JTextField direccion) {
		ActionListener evento = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				nombre.setText(nombre.getText().trim());	
				ci.setText(ci.getText().replaceAll("\\s*", ""));
				telefono.setText(telefono.getText().replaceAll("\\s*", ""));
				direccion.setText(direccion.getText().trim());
				
				//valido que nombre no contenga el caracter separador (@) del archivo
				if (!nombre.getText().contains("@") && !nombre.getText().isEmpty()) {
					//valido que campo de cedula no este vacio
					if (!ci.getText().isEmpty()) {
						//valido que campo de cedula solo contenga numeros
						try {
							Long.parseLong(ci.getText());
							try {
								if (!telefono.getText().isEmpty())
									Long.parseLong(telefono.getText());
								try {
									if (!direccion.getText().contains("@") && !direccion.getText().isEmpty()) {
										if (buscarEnArchivo(ci.getText()) != -1) {
											registrarUsuario(nombre.getText(), ci.getText(), telefono.getText(), direccion.getText());
											
											if (contadorPersonas == 0 )
												lista.removeAll();
												
											JPanel persona = new JPanel(new FlowLayout());
											JLabel nomb = new JLabel("NOMBRE: " + nombre.getText() + " - " + "C.I: " + ci.getText());
											persona.add(nomb);
											ImageIcon imagen = new ImageIcon("src\\recursos\\remove.png");
											persona.add(botonEliminar(imagen, persona));
											lista.add(persona);
											lista.revalidate();
											lista.repaint();
											actualizarContPersonas(1);
											nombre.setText("");
											ci.setText("");
											telefono.setText("");
											direccion.setText("");
										}//if buscarEnArchivo retorna total de registros
										else {
											JOptionPane.showMessageDialog(null, "Persona ya registrada.");
										}//else retorna -1
									}//if direccion no contiene "@" y no esta vacio			
									else 
										JOptionPane.showMessageDialog(null, "Campo de dirección no debe contener \"@\" ni estar vacio.");
								} catch (IOException e) {
									JOptionPane.showMessageDialog(null, "Ocurió un error grave: " + e.getMessage());
								}//catch del try de posible error de disco
							} catch(NumberFormatException e1) {
								JOptionPane.showMessageDialog(null, "El telófono solo debe contener números o estar vacio.");
							}//catch del try para validar telefono
						} catch(NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "La cédula solo debe contener números.");
						}//catch del try de solo numeros en cedula
					}//if campo de cedula no esta vacio
					else
						JOptionPane.showMessageDialog(null, "Campo de cédula no puede estar vacio.");
				}//if nombre no contiene el caracter separador
				else {
					if (nombre.getText().contains("@"))
						JOptionPane.showMessageDialog(null, "No se permite el uso de \"@\" en el nombre");
					else
						JOptionPane.showMessageDialog(null, "Campo de nombre no puede estar vacio.");
				}//cuando nombre no es valido
			}//actionPerformed
		};//ActionListener evento
		return evento;
	}//eventoContinuar(JtextField, JTextField, JTextField, JTextField)
	
	/** Metodo que recibe un String, si esta cadena es igual a "" se utiliza
	 *  para devolver el total de personas registradas; si no, se utiliza para
	 *  buscar coincidencias entre la cadena y las cedulas registradas (retorna 
	 *  -1 en caso de coincidencia, o retorna otro valor distinto en el caso 
	 *  contrario */
	private int buscarEnArchivo (String cadena) throws IOException {
		int posicion = 0;
		Scanner entrada = null;
		try {
			entrada = new Scanner(new File("src\\recursos\\listado.dat"));
			while (entrada.hasNextLine()) {
				String linea = entrada.nextLine();
				if (!cadena.equals("")) {
					String cadenas[] = linea.split("@");
					if (cadenas[1].equals(cadena)) {
						posicion = -1;
						break;
					}//si son iguales hago a posicion -1 y rompo el ciclo
				}//si cadena != "" es porque quiero comparar cedulas
				posicion++;
			}//while hayan mas lineas
			entrada.close();
		} catch (FileNotFoundException e) {
			File arch = new File("src\\recursos\\listado.dat");
			arch.createNewFile();
		} catch (IndexOutOfBoundsException e) {
			entrada.close();
			JOptionPane.showMessageDialog(null, "Ocurrió un error grave al cargar el archivo. Se recreará, por favor reinicie el programa.");
			File arch = new File("src\\recursos\\listado.dat");
			arch.delete();
			System.exit(0);
		}
		return posicion;
	}//buscarEnArchivo(String)
	
	/** Metodo para registrar a un usuario recibiendo su nombre, cedula, telefono(si tiene) y direccion (todo es String). */
	private void registrarUsuario (String nombre, String cedula, String telefono, String direccion) throws IOException {
		FileWriter fw = new FileWriter(new File("src\\recursos\\listado.dat"), true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		if (telefono.isEmpty())
			telefono = " ";
		
		pw.println(nombre + "@" + cedula + "@" + telefono + "@" + direccion);
		pw.close();
	}//registrarUsuario(String, String, String, String)
	
	/** Metodo para crear un boton, que recibe una imagen (icono para el boton
	 *  y un panel (donde se pondra el boton. Retorna un JButton. */
	private JButton botonEliminar(ImageIcon imagen, JPanel persona) {
		JButton eliminarRegistro = new JButton(imagen);
		eliminarRegistro.setMargin(new Insets(0, 0, 0, 0));
		eliminarRegistro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int aux = JOptionPane.showConfirmDialog(listado, "¿Está seguro de que desea eliminar a esta persona del registro?");

				if (aux == 0) {
					aux = lista.getComponentZOrder(persona);
					try {
						eliminarPersonaEnArchivo(aux);
						
						actualizarContPersonas(-1);
						if (contadorPersonas == 0 )
							noRegistros();
						
						lista.remove(aux);
						lista.revalidate();
						lista.repaint();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Ocurrió un error grave: " + e1.getMessage());
					}
					
				}//si opcion == 0 significa que el usuario presiono "Si"
			}//actionPerformed
		});//addActionListener
		
		return eliminarRegistro;
	}//botonEliminar(ImageIcon, JPanel)
	
	/** Metodo para actualizar el contador de personas y aumentarlo en 1. */
	private void actualizarContPersonas(int num) {
		contadorPersonas += num;
		cantidadPersonas.setText("Personas registradas: " + contadorPersonas);
		cantidadPersonas.revalidate();
		cantidadPersonas.repaint();
	}//actualizarContPersonas(int)
	
	/** Metodo para eliminar el registro de una persona del archivo. Recibe un entero
	 *  que es la posicion donde se encuentra dicho registro. */
	private void eliminarPersonaEnArchivo(int posicion) throws IOException {
		File arch = new File("src\\recursos\\listado.dat");
		boolean renombrar = arch.renameTo(new File("src\\recursos\\listado1.dat"));
		if (!renombrar) {
			throw new IOException("no se pudo abrir el archivo para eliminar el registro.");
		}//si no se puede crear el nuevo archivo, rompo el try y mando mensaje
		
		arch = new File("src\\recursos\\listado1.dat");
		Scanner entrada = new Scanner(arch);
		
		FileWriter fw = new FileWriter(new File("src\\recursos\\listado.dat"));
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		int i = 0;
		while (entrada.hasNextLine()) {
			String linea = entrada.nextLine();
			if (i != posicion) {
				pw.println(linea);
			}
			i++;
		}//while para copiar todas las lineas excepto la del registro que se desea borrar.
		
		pw.close();
		entrada.close();
		arch.delete();
	}//eliminarPersonaEnArchivo(int)
		
}//Ventana
