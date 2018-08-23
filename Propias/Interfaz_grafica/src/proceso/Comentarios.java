package proceso;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
		
		this.setSize(700, 700);
		titulosVarios(); //un titulo aleatorio de 5
		this.setMaximumSize(new Dimension(700, 700));
		this.setMinimumSize(new Dimension(500, 500));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		iniciarComponentes();
	}//Chat()
	
	private void titulosVarios() {
		int dado = ((int) (Math.random()*5)) + 1;
		
		switch (dado) {
			case 1:
				this.setTitle("Comentarios de Rey: ¡Ahora con más memoria disponible!");
				break;
			case 2:
				this.setTitle("Comentarios de Rey: ¡Ahora con manejo de archivos!");
				break;
			case 3:
				this.setTitle("Comentarios de Rey: ¡Ahora con más rikura!");
				break;
			case 4:
				this.setTitle("Comentarios de Rey: ¡Ahora con mejores gráficos!");
				break;
			case 5:
				this.setTitle("Comentarios de Rey: ¡Ahora con nueva presentación!");
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
		cajaDer.setBackground(Color.GRAY);
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
		
		ImageIcon imagen = new ImageIcon("fantasma.png");
		JLabel imagencita = new JLabel(new ImageIcon (imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		
		etiquetica.add(imagencita, BorderLayout.LINE_START);
		etiquetica.add(etiqueta, BorderLayout.CENTER);
		
		descripcion = new JLabel("Hola, me llamo Reyner y este es mi programa. Sientase libre de escribir en el.");
		descripcion.setFont(new Font("Calibri", Font.ITALIC, 16));
		descripcion.setForeground(Color.BLUE);
		
		cierre = new JLabel("Publicado el: "+ Calendar.getInstance().getTime());
		cierre.setFont(new Font("Calibri", Font.BOLD, 12));
		
		publicacion = new JLabel("Publicaciones: ");
		publicacion.setBackground(Color.LIGHT_GRAY);
		publicacion.setForeground(Color.ORANGE);
		publicacion.setFont(new Font("Calibri", Font.BOLD, 20));
		
		cajaDer.add(publicacion);
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
		int cont = 0;
		
		try {
			Scanner entrada = new Scanner(new File("comentarios.txt"));
			while (entrada.hasNextLine()) {
				String nombre, fecha;
				String linea = entrada.nextLine();
				StringTokenizer tokenizer = new StringTokenizer(linea, "-");
				nombre = tokenizer.nextToken();
				fecha = tokenizer.nextToken();
				
				JLabel pub = new JLabel("De: " + nombre + " el " + fecha);
				pub.setFont(new Font("Arial", Font.ITALIC, 14));
				pub.setBackground(Color.LIGHT_GRAY);
				pub.setOpaque(true);
				cajaDer.add(pub);
				
				while (entrada.next().compareTo("---------------")!=0) {
					entrada.nextLine();
				}//llego hasta la linea delimitadora
				entrada.nextLine(); //me salto el texto hasta la linea delimitadora
				
				cont++;
			}
			entrada.close();
		} catch(FileNotFoundException e) {
			System.out.println("No hay publicaciones recientes.");
		}//try de leerArchivo
		
		if(cont == 0) {
			JLabel noPub = new JLabel("No hay publicaciones recientes.");
			noPub.setFont(new Font ("Calibri", Font.BOLD, 15));
			cajaDer.add(noPub);
		}
	}//cargarPublicaciones
	
	private void crearArch() throws IOException {
		String nombre = cajaNombre.getText();
		
		FileWriter fw = new FileWriter("comentarios.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		pw.println(nombre + "-" + Calendar.getInstance().getTime() + "-");
		pw.println(textArea.getText());
		pw.println("---------------");
		pw.close();
	}
	
	private void iniciarEventos(int i) {
		switch (i) {
		 case 1:
			 ActionListener pressBoton = new ActionListener() {
				 @Override
				 public void actionPerformed(ActionEvent arg0) {
					 if (textArea.getText().isEmpty() || (textArea.getText().compareTo("\\s* \\s*")==0)) {
						 JOptionPane.showMessageDialog(null, "No se puede añadir un comentario vacio.");
					 }//si area de texto vacia
					 else if (cajaNombre.getText().isEmpty()) {
						 JOptionPane.showMessageDialog(null, "Para poder enviar un comentario debe identificarse.");
					 }//si caja de texto vacia
					 else {
					 	try {
					 		crearArch();
					 		String nombre = cajaNombre.getText();
					 		//OCURRE ALGO RARO Y ESTO NO ME LO HACE AAAAAAA
					 		//DEBO VERIFICAR QUE EL NOMBRE NO PUEDE CONTENER EL CARACTER DELIMITADOR
					 		//DEBO VERIFICAR QUE EL NOMBRE NO PUEDE CONTENER SALTOS DE LINEA
					 		//DEBO ARREGLARLO PARA QUE LOS SALTOS DE LINEA INNECESARIOS NO ME LOS CUENTA
					 		//Y QUE UN COMENTARIO NO PUEDA TENER SOLO SALTOS DE LINEA O ESPACIOS (no funciono lo que hice)
					 		JLabel noPub = new JLabel("De: " + nombre + " el " + Calendar.getInstance().getTime());
					 		noPub.setFont(new Font("Arial", Font.ITALIC, 14));
					 		noPub.setBackground(Color.LIGHT_GRAY);
					 		cajaDer.add(noPub);
					 		
					 	} catch (IOException e) {
					 		e.printStackTrace();
					 		System.out.println("Ocurrio un error extraño.");
					 	}//catch
					 }//else para cuando esta correcto
				 }//actionPerformed
			 };//actionListener 
			 enviar.addActionListener(pressBoton);
			 this.revalidate();
			 this.repaint();
			 break;
			 
		 case 2:
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
			 break;
		 case 3:
			 
			 break;
			 
		 case 4:
			 
			 break;
		}//switch
	}//iniciarEventos
	
}//class Chat
