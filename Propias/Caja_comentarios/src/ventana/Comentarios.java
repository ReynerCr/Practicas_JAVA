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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


//SI SE UTILIZA NETBEANS HAY QUE ACOMODAR LAS RUTAS DE LAS IMAGENES PARA QUE CONCUERDEN CON EL DIRECTORIO DE ESE IDE


@SuppressWarnings("serial")
public class Comentarios extends JFrame {
	private JPanel panel, fondo, cajaDer, cajaComentario, panelDatos;
	private JButton enviar;
	private JLabel etiqueta;
	private JTextArea textArea;
	private JLabel descripcion;
	private JLabel cierre;
	private JLabel publicacion;
	private JPanel etiquetica;
	private JTextField cajaNombre;
	
	public Comentarios() {
		
		this.setSize(800, 800);
		titulosVarios(); //un titulo aleatorio de 5
		this.setMaximumSize(new Dimension(800, 800));
		this.setMinimumSize(new Dimension(700, 700));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		iniciarComponentes();
	}//Chat()
	
	private void titulosVarios() {
		int dado = ((int) (Math.random()*5)) + 1;
		
		switch (dado) {
			case 1:
				this.setTitle("Comentarios de Rey: �Ahora con m�s memoria disponible!");
				break;
			case 2:
				this.setTitle("Comentarios de Rey: �Ahora con manejo de archivos!");
				break;
			case 3:
				this.setTitle("Comentarios de Rey: �Ahora con m�s rikura!");
				break;
			case 4:
				this.setTitle("Comentarios de Rey: �Ahora con mejores gr�ficos!");
				break;
			case 5:
				this.setTitle("Comentarios de Rey: �Ahora con nueva presentaci�n!");
				break;
		}//switch
	}//titulosVarios
	
	private void iniciarComponentes() {
		iniciarPaneles();
		iniciarEtiqueta();
		iniciarTextArea();
		iniciarTextField();
		iniciarBotones();
		cargarPublicaciones();
	}//iniciarComponente
	
	private void iniciarPaneles() {
		panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.BLACK);
		
		fondo = new JPanel(new BorderLayout());

		cajaDer = new JPanel();
		cajaDer.setLayout(new BoxLayout(cajaDer, BoxLayout.Y_AXIS));
		cajaDer.setBackground(Color.LIGHT_GRAY);
		JScrollPane scrollCajaDer = new JScrollPane(cajaDer, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);		
		cajaComentario = new JPanel(new BorderLayout());
		cajaComentario.setBackground(Color.white);
		
		panelDatos = new JPanel();
		panelDatos.setLayout(new FlowLayout());
		panelDatos.setOpaque(false);
		
		cajaComentario.add(panelDatos, BorderLayout.PAGE_END);
		fondo.add(cajaComentario, BorderLayout.CENTER);
		fondo.add(scrollCajaDer, BorderLayout.LINE_END);
		panel.add(fondo, BorderLayout.CENTER);
		
		this.getContentPane().add(panel);
	}//iniciarPanel
	
	private void iniciarEtiqueta() {
		etiquetica = new JPanel(new BorderLayout());
		etiquetica.setBackground(Color.BLACK);
		
		etiqueta = new JLabel("CAJA DE COMENTARIOS");
		etiqueta.setFont(new Font("Arial", Font.BOLD, 30));
		etiqueta.setForeground(Color.WHITE);
		
		ImageIcon imagen = new ImageIcon("src\\recursos\\fantasma.png");
		JLabel imagencita = new JLabel(new ImageIcon (imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		
		etiquetica.add(imagencita, BorderLayout.LINE_START);
		etiquetica.add(etiqueta, BorderLayout.CENTER);
		
		descripcion = new JLabel("Hola, me llamo Reyner y este es mi programa. Si�ntase libre de escribir en �l.");
		descripcion.setFont(new Font("Calibri", Font.ITALIC, 16));
		descripcion.setForeground(Color.BLUE);
		
		cierre = new JLabel("No se han cargado publicaciones.");
		cierre.setFont(new Font("Calibri", Font.BOLD, 12));
		
		fondo.add(cierre, BorderLayout.PAGE_END);		
		fondo.add(descripcion, BorderLayout.PAGE_START);
		panel.add(etiquetica, BorderLayout.PAGE_START);
	}//iniciarEtiqueta

	private void iniciarTextArea() {
		textArea = new JTextArea();
		JScrollPane scrollBar = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		cajaComentario.add(scrollBar, BorderLayout.CENTER);
	}//iniciarTextArea
	
	private void iniciarTextField() {
		JLabel nombre = new JLabel("Nombre: ");
		nombre.setFont(new Font("Arial", Font.PLAIN, 12));
		panelDatos.add(nombre);
		
		cajaNombre = new JTextField();
		cajaNombre.setFont(new Font("Arial", Font.ITALIC, 14));
		cajaNombre.setPreferredSize(new Dimension(160, 27));
		
		panelDatos.add(cajaNombre);
		iniciarEventos(2); //teclado
	}
	
	private void iniciarBotones() {
		enviar = new JButton("Enviar");
		enviar.setMnemonic(KeyEvent.VK_ENTER);
		
		panelDatos.add(enviar);
		iniciarEventos(1); //boton enviar
	}//iniciarBotones
	
	private void cargarPublicaciones() {
		int cont = 1;     cajaDer.removeAll();
		
		publicacion = new JLabel("Publicaciones: ");
		publicacion.setBackground(Color.LIGHT_GRAY);
		publicacion.setForeground(Color.BLUE);
		publicacion.setFont(new Font("Calibri", Font.BOLD, 20));
		
		cajaDer.add(publicacion);
		
		try {
			Scanner entrada = new Scanner(new File("src\\recursos\\ventana.txt"));
			while (entrada.hasNextLine()) {
				String nombre, fecha;
				String linea = entrada.nextLine();
				StringTokenizer tokenizer = new StringTokenizer(linea, "#");
				nombre = tokenizer.nextToken();
				fecha = tokenizer.nextToken();
				
				JPanel panelPub = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
				panelPub.setOpaque(false);
				
				JButton pub = new JButton("De: " + nombre + " el " + fecha);
				pub.setFont(new Font("Arial", Font.ITALIC, 12));
				pub.setMargin(new Insets(0,0,0,0));
				
				ImageIcon imagen = new ImageIcon("src\\recursos\\remove.png");
				JButton eliminarPub = new JButton(new ImageIcon(imagen.getImage().getScaledInstance(20, 17, Image.SCALE_FAST)));
				eliminarPub.setContentAreaFilled(false);
				eliminarPub.setMargin(new Insets(0,0,0,0));
				
				panelPub.add(pub);
				panelPub.add(eliminarPub);
				
				
				cajaDer.add(panelPub, cont);
				presionarPublicacion(cajaDer.getComponentCount(), pub);
				eliminarPublicacion(cajaDer.getComponentCount(), eliminarPub);
				
				while (entrada.next().compareTo("###############")!=0) {
					entrada.nextLine();
				}//llego hasta la linea delimitadora
				entrada.nextLine(); //me salto el texto hasta la linea delimitadora
				
				cont++;
			}
			entrada.close();
		} catch(IOException e) {
			JOptionPane.showMessageDialog(null, ("Ocurrio un error inesperado. " + e.getMessage()));
		}//try de leerArchivo
		
		if(cont == 0) {
			JLabel noPub = new JLabel("No hay publicaciones recientes.");
			noPub.setFont(new Font ("Calibri", Font.BOLD, 15));
			cajaDer.add(noPub);
		}
	}//cargarPublicaciones
	
	private void crearArch() throws IOException {
		String nombre = cajaNombre.getText();
		FileWriter fw = new FileWriter("src\\recursos\\ventana.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		pw.println(nombre + "#" + Calendar.getInstance().getTime() + "#");
		pw.println(textArea.getText());
		pw.println("###############");
		pw.close();
	}
	private void saltarComentario(String linea, Scanner entrada) {
		while (entrada.hasNextLine() && linea.compareTo("###############")!=0) {
			linea = entrada.nextLine();
		}//while para saltar ventana
	}//saltarComentario
	
	private void eliminarPublicacion(int auxi, JButton pub) {
		ActionListener eliminarPub = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int aux = auxi-2;
				borrarPublicacion(aux);
			}//actionPerformed
	 	};
	 	
	 	pub.addActionListener(eliminarPub);
	}
	
	private void borrarPublicacion(int aux) {
		int i = 0;
		try {
			File arch = new File("src\\recursos\\ventana.txt");
			
			boolean mover = arch.renameTo(new File("src\\recursos\\comentarios1.txt"));
			if (!mover) {
				throw new IOException("No se pudo editar el archivo (posiblemente permisos insuficientes).");
			}//rompo el try y mando mensaje
			
			arch = new File("src\\recursos\\comentarios1.txt");
			
			Scanner entrada = new Scanner(arch);
			String linea = "";
			
			FileWriter fw = new FileWriter(new File("src\\recursos\\ventana.txt"), true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			while (entrada.hasNextLine()) {
				if (i==aux) {
					linea = entrada.nextLine(); //el scanner quedo en la linea delimitadora y eso me hace bucle infinito en la funcion de salto
					saltarComentario(linea, entrada);
					i++;
				}
				else {
					linea = entrada.nextLine();
					pw.println(linea);
					
					if (linea.compareTo("###############")==0) 
						i++;
					
				}//else
			}//while
			
			cajaNombre.setText("");
			textArea.setText("");
			
			entrada.close();
			arch.delete();
			pw.close();
			
			cierre.setText("Comentario eliminado satisfactoriamente.");
		}//try
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocurrio un error al abrir. " + e.getMessage());
			e.printStackTrace();
		}//catch
		
		cargarPublicaciones();
		this.revalidate();
		this.repaint();
	}//borrarPublicacion
	
	private void presionarPublicacion(int auxi, JButton pub) {
		ActionListener pressPub = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int aux = auxi-2;
				cargarUnComentario(aux);
			}//actionPerformed
	 	};
	 	
	 	pub.addActionListener(pressPub);
	}//presionarPublicacion
	
	private void cargarUnComentario(int aux) {
		int i = 0;
		try {
			textArea.setText("");
			cajaNombre.setText("");
			
			Scanner entrada = new Scanner(new File("src\\recursos\\ventana.txt"));
			String linea = "";
			
			while (i<aux && entrada.hasNextLine()) {
				saltarComentario(linea, entrada);
				i++;
			}//while
			
			linea = entrada.nextLine();
			StringTokenizer tokenizer = new StringTokenizer(linea, "#");
			linea = tokenizer.nextToken();
			cajaNombre.setText(linea);
			linea = tokenizer.nextToken();
			cierre.setText("Publicado el: " + linea);

			linea = entrada.nextLine(); //debio funcionar con un entrada.nextLine(), igual con el while pero no se por que se volvia loco y entonces lo dejo asi.
			
			while (entrada.hasNextLine() && linea.compareTo("###############")!=0) {
				textArea.append(linea);
				linea = entrada.nextLine();
			}//while
			
			entrada.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Ocurrio un error al abrir el comentario, reintente luego.");
		}//catch
		
		this.revalidate();
		this.repaint();
	}//cargarUnComentario
	
	private void iniciarEventos(int i) {
		switch (i) {
		 case 1: {
			 ActionListener pressBoton = new ActionListener() {
				 @Override
				 public void actionPerformed(ActionEvent arg0) {
					 textArea.setText(textArea.getText().trim());   //trim elimina espacios y saltos de linea al inicio y final de la cadena, justo lo que necesitaba
					 cajaNombre.setText(cajaNombre.getText().trim());
					 
					 if (textArea.getText().isEmpty()) {
						 JOptionPane.showMessageDialog(null, "No se puede a�adir un comentario vacio.");
					 }//si area de texto vacia
					 else if (textArea.getText().contains("###############")) {
						 JOptionPane.showMessageDialog(null, "Lo sentimos, no se permite crear un comentario que contenga \"###############\".");
					 }
					 else if (cajaNombre.getText().isEmpty()) {
						 JOptionPane.showMessageDialog(null, "Para poder enviar un comentario debe identificarse.");
					 }//si caja de texto vacia
					 else if (cajaNombre.getText().contains("#")) {
						 JOptionPane.showMessageDialog(null, "Lo sentimos, no se permite usar el caracter '#' en el nombre.");
					 }
					 else {
					 	try {
					 		crearArch();
					 		
							cargarPublicaciones();
							
							textArea.setText("");
							cajaNombre.setText("");
							
							cierre.setText("Comentario guardado correctamente, no hay publicaciones cargadas.");
							
							getContentPane().revalidate();
							getContentPane().repaint();
					 	} catch (IOException e) {
					 		e.printStackTrace();
					 		JOptionPane.showMessageDialog(null, "Ocurrio un error extra�o.");
					 	}//catch
					 }//else para cuando esta correcto
				 }//actionPerformed
			 };//actionListener 
			 enviar.addActionListener(pressBoton);
		 	}
			 break;
			 
		 case 2: {
			 KeyListener teclado = new KeyListener() {
				@Override
				public void keyPressed(KeyEvent arg0) {
				}

				@Override
				public void keyReleased(KeyEvent arg0) {
				}

				@Override
				public void keyTyped(KeyEvent ke) {
					if (ke.getKeyChar() == KeyEvent.VK_ENTER) {
						enviar.doClick();
					}//cuando se presione enter mientras se esta en la caja de texto se guardara
				}
			};
			 
			cajaNombre.addKeyListener(teclado);
		 	}
			break;
		 case 3: //para cuando presionan una publicacion
			 
			break;
			 
		 case 4:
			 
			 break;
		}//switch
	}//iniciarEventos
	
	
}//class Comentarios
