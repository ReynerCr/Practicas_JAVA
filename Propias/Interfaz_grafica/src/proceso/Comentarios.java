package proceso;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Comentarios extends JFrame {
	private JPanel panel, fondo, cajaDer, cajaComentario;
	private JButton enviar;
	private JLabel etiqueta;
	private JTextArea textArea;
	private JLabel descripcion;
	private JLabel cierre;
	private JLabel publicacion;
	private JPanel etiquetica;
	
	public Comentarios() {
		
		this.setBackground(Color.BLUE);
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
		iniciarBotones();
		iniciarTextArea();
		cargarPublicaciones();
	}//iniciarComponente
	
	private void iniciarPaneles() {
		panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.LIGHT_GRAY);
		
		fondo = new JPanel(new BorderLayout());

		cajaDer = new JPanel();
		cajaDer.setLayout(new BoxLayout(cajaDer, BoxLayout.Y_AXIS));
		cajaDer.setBackground(Color.GRAY);
		JScrollPane scrollCajaDer = new JScrollPane(cajaDer, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		cajaComentario = new JPanel(new BorderLayout());
		cajaComentario.setBackground(Color.white);
		
		fondo.add(cajaComentario, BorderLayout.CENTER);
		fondo.add(scrollCajaDer, BorderLayout.LINE_END);
		panel.add(fondo, BorderLayout.CENTER);
		
		this.getContentPane().add(panel);
	}//iniciarPanel
	
	private void iniciarEtiqueta() {
		etiquetica = new JPanel(new BorderLayout());
		etiquetica.setBackground(Color.LIGHT_GRAY);
		
		etiqueta = new JLabel("CAJA DE COMENTARIOS");
		etiqueta.setFont(new Font("Arial", Font.BOLD, 30));
		
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
		textArea.setEditable(true);
		JScrollPane scrollBar = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		cajaComentario.add(scrollBar, BorderLayout.CENTER);
	}
	
	private void iniciarBotones() {
		enviar = new JButton("Enviar");
		enviar.setMnemonic(KeyEvent.VK_ENTER);
		
		cajaComentario.add(enviar, BorderLayout.PAGE_END);
		iniciarEventos(1);
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
				
				
				entrada.nextLine();
				entrada.nextLine();
				
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
		FileWriter fw = new FileWriter("comentarios.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		pw.println("nombre-" + Calendar.getInstance().getTime() + "-");
		pw.println(textArea.getText());
		pw.println("---------------");
		pw.close();
	}
	
	private void iniciarEventos(int i) {
		switch (i) {
		 case 1: //raton
			 MouseListener raton = new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					try {
						crearArch();
						String nombre = "nombre";
						
						JLabel pub = new JLabel("De: " + nombre + " el " + Calendar.getInstance().getTime());
						pub.setFont(new Font("Arial", Font.ITALIC, 14));
						pub.setBackground(Color.LIGHT_GRAY);
						pub.setOpaque(true);
						cajaDer.add(pub);
						
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("Ocurrio un error extraño.");
					}
					
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					enviar.setBorderPainted(true);
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					enviar.setBorderPainted(false);
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					
				}
				 
			 };
			 enviar.addMouseListener(raton);
			 this.revalidate();
			 this.repaint();
			 break;
			 
		 case 2:
			 
			 break;
			 
		 case 3:
			 
			 break;
			 
		 case 4:
			 
			 break;
		}//switch
	}//iniciarEventos
	
}//class Chat
