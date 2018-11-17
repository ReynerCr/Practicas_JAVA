package ruleta;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Ruleta extends JFrame{
	private static Ruleta instancia = null;
	
	private String frase; //contendra la frase a descubrir
	private String categoria; //contendra la categoria que se juega
	private int puntos; //puntaje del jugador
	
	private JLabel eCategoria; //label para categoria
	private JLabel eLetra; //label para letra:
	private JLabel flecha; //label para flecha
	private JLabel ruleta; //label para ruleta
	private JLabel puntaje; //label para puntaje
	private JTextField tLetra; //caja de texto para letra
	private JButton enviar; //boton de enviar
	private JButton tirarRuleta; //boton para girar la ruleta
	private Cuadro cuadros[][];
	
	private Color verdeOscuro; //para las letras de los labels
	
	Timer timerRuleta; //para las vueltas de la ruleta
	private int vueltaRuleta = CargadorDeImagenes.RULETA_INICIO - 1;
	private int detenerEn;
	
	private Ruleta() {
		super("Ruleta de la Fortuna");
		this.setSize(900, 600);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.WHITE);
		this.getContentPane().setSize(this.getWidth(), this.getHeight());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(204, 255, 204));
		
		iniciarComponentes();
	}//Ruleta()
	
	public static Ruleta getInstancia() {
		if (instancia == null)
			instancia = new Ruleta();
		
		return instancia;
	}//getInstancia()
	
	private void iniciarComponentes() {
		puntos = 0;
		verdeOscuro = new Color(79, 98, 40);
		
		iniciarCategoria();
		iniciarPuntaje();
		iniciarLetra();
		iniciarRuleta();
		iniciarFlecha();
		iniciarRuleta();
		iniciarCajaTexto();
		inciarEnviar();
		iniciarTirarRuleta();
		
		iniciarPalabras();
	}//iniciarComponentes()
	
	private void iniciarTirarRuleta() {
		tirarRuleta = new JButton("Tirar Ruleta");
		tirarRuleta.setFont(new Font("Arial", Font.BOLD, 20));
		tirarRuleta.setBounds((ruleta.getX() + ruleta.getWidth() + 15), (flecha.getY() - 10), 180, 50);
		this.getContentPane().add(tirarRuleta);
		
		tirarRuleta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int random = (int) ((Math.random() * 50) + 20);
				timerRuleta.setDelay(random);
				
				detenerEn = (int) ((Math.random() * 8) + CargadorDeImagenes.RULETA_INICIO);
				timerRuleta.start();
			}
		});
	}//iniciarTirarRuleta()
	
	private void inciarEnviar() {
		enviar = new JButton("Enviar");
		enviar.setFont(new Font("Arial", Font.BOLD, 20));
		enviar.setBounds((tLetra.getX() - 30), (tLetra.getY() + tLetra.getHeight() + 15), tLetra.getWidth(), tLetra.getHeight());
		this.getContentPane().add(enviar);
		enviar.setEnabled(false);
		
		enviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				char cajaT[] = tLetra.getText().toCharArray();
				
				if ((cajaT.length == 1) && Character.isLetter(cajaT[0])) {
					comprobarLetra(cajaT[0]);
				}
				else {
					JOptionPane.showMessageDialog(null, "ERROR!!!");
				}
				tLetra.setText("");
				enviar.setEnabled(false);
				tirarRuleta.setEnabled(true);
			}//actionPerformed()
		});//actionListener
	}//inciarEnviar
	
	private int retornarPuntajeRuleta() {
		int num;
		
		switch (vueltaRuleta) {
			case 30:
				num = 80;
				break;
			case 31:
				num = 10;
				break;
			case 32:
				num = 200;
				break;
			case 33:
				num = 30;
				break;
			case 34:
				num = 60;
				break;
			case 35:
				num = 20;
				break;
			case 36:
				num = 100;
				break;
			case 37:
				num = 50;
				break;
			default:
				num = 0;
				break;
		}//switch
		
		return num;
	}//retornarPuntajeRuleta()
	
	private void iniciarCajaTexto() {
		tLetra = new JTextField();
		tLetra.setBounds((eLetra.getX() + eLetra.getWidth()) + 5, (eLetra.getY() - 5), 100, 50);
		tLetra.setFont(new Font("Arial", Font.BOLD, 30));
		tLetra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER)
					enviar.doClick();
			}
		});
		this.getContentPane().add(tLetra);
	}
	
	private void iniciarCategoria() {
		categoria = "Dulces Criollos";
		
		eCategoria = new JLabel("Categoria: " + categoria);
		eCategoria.setBounds(100, 40, 250, 30);
		eCategoria.setFont(new Font("Arial", Font.BOLD, 20));
		eCategoria.setForeground(verdeOscuro);
		this.getContentPane().add(eCategoria);
	}
	
	private void iniciarPuntaje() {
		puntaje = new JLabel("Puntos: XXX");
		puntaje.setBounds(650, eCategoria.getY(), 200, 60);
		puntaje.setFont(new Font("Arial", Font.BOLD, 30));
		puntaje.setForeground(Color.RED);
		this.getContentPane().add(puntaje);
	}
	
	private void iniciarLetra() {
		eLetra = new JLabel("Letra:");
		eLetra.setBounds((puntaje.getX() + 20), 150, 60, 30);
		eLetra.setFont(new Font("Arial", Font.BOLD, 20));
		eLetra.setForeground(verdeOscuro);
		this.getContentPane().add(eLetra);
	}
	
	private void iniciarFlecha() {
		ImageIcon icono = CargadorDeImagenes.getInstancia().getImagen(CargadorDeImagenes.FLECHA);
		flecha = new JLabel(icono);
		flecha.setBounds(ruleta.getX() - (icono.getIconWidth() + 10) , 450, icono.getIconWidth(), icono.getIconHeight());
		this.getContentPane().add(flecha);
	}
	
	private void iniciarRuleta() { //TODO RULETA NO TIENE ICONO AL PRINCIPIO PERO SI LO PONGO ENTONCES NO SE ACTUALIZA ._.
		ImageIcon icono = CargadorDeImagenes.getInstancia().getImagen(CargadorDeImagenes.RULETA_INICIO);
		ruleta = new JLabel();
		ruleta.setBounds(200, 350, icono.getIconWidth(), icono.getIconHeight());
		this.getContentPane().add(ruleta);
		
		timerRuleta = new Timer(1000, new TimerRuleta());
	}
	
	private void iniciarPalabras() {
		frase = " CONSERVA DE COCO";
		frase = frase.toUpperCase(); //por si la frase inicial es minuscula
		
		if (frase.length() <= 30){
			String cadenas[] = frase.split(" ");
			for (int i = 0; i < cadenas.length; i++) {
				if (cadenas[i].length() > 10) { //si alguna palabra excede las 10 letras, entonces se aborta la ejecucion
					JOptionPane.showMessageDialog(null, "Error con la frase oculta. Se saldra del programa.");
					System.exit(1);
				}//if
			}//for para validar que cada palabra sea menor o igual a 10
			
			cuadros = new Cuadro[3][10];
			int posX = (eCategoria.getX() - 50);
			int posY = (eCategoria.getY() + eCategoria.getHeight() + 20);
 			int k = 0;
 			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 10; j++) {
					if (k < cadenas.length && (cadenas[k].length() - 1) <= (9 - j)) {
						for (int z = 0; z < cadenas[k].length(); z++) {
							cuadros[i][j] = new Cuadro(cadenas[k].charAt(z));
							cuadros[i][j].setBounds(posX, posY, 50, 50);
							this.getContentPane().add(cuadros[i][j]);
							posX += 50;
							j++;
						}//for z
						
						cuadros[i][j] = new Cuadro();
						cuadros[i][j].setBounds(posX, posY, 50, 50);
						this.getContentPane().add(cuadros[i][j]);
						posX += 50;
						k++;
					}//if aun quedan palabras y palabra cabe en la linea
					
					else {
						cuadros[i][j] = new Cuadro();
						cuadros[i][j].setBounds(posX, posY, 50, 50);
						this.getContentPane().add(cuadros[i][j]);
						posX += 50;
					}
				}//for j
				posX = (eCategoria.getX() - 50);
				posY += 50;
			}//for i
			
			if (k < (cadenas.length-1)) {
				System.out.println("Error de arreglo. Se abortara la ejecucion.");
				System.exit(1);
			}//no deberia ocurrir pero bueno.
		}//if frase.lenght menor o igual a 30
		
		else {
			JOptionPane.showMessageDialog(null, "Error con la frase oculta. Se saldra del programa.");
			System.exit(1);
		}//else
	}//acomodarPalabras()
	
	private void comprobarLetra(char letra) {
		letra = Character.toUpperCase(letra);
		boolean adivinada = false;
		if (frase.contains(Character.toString(letra))) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 10; j++) {
					if (cuadros[i][j].getLetra() == letra && !cuadros[i][j].getAdivinada()) {
						cuadros[i][j].setAdivinada(letra);
						adivinada = true;
					}
					else if (cuadros[i][j].getLetra() == letra && cuadros[i][j].getAdivinada())
						JOptionPane.showMessageDialog(null, "Letra ya adivinada, no se le sumara el puntaje.");
				}//for j
			}//for i
			if (adivinada) {
				puntos += retornarPuntajeRuleta();
				puntaje.setText("Puntos: " + puntos);
			}
		}//if
		else {
			JOptionPane.showMessageDialog(null, "ERROR!!!");
		}
	}//comprobarLetra()
	
	class TimerRuleta implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (detenerEn == vueltaRuleta && (int) (Math.random() * 2) == 1) {
				timerRuleta.stop();
				enviar.setEnabled(true);
				tirarRuleta.setEnabled(false);
			}
			
			vueltaRuleta++;
			if (vueltaRuleta > CargadorDeImagenes.RULETA_FIN)
				vueltaRuleta = CargadorDeImagenes.RULETA_INICIO;
			
			ruleta.setIcon(CargadorDeImagenes.getInstancia().getImagen(vueltaRuleta));
		}//actionPerformed()
	}//TimerRuleta
}//Ruleta