//Autor: Reyner Contreras; CI: V.-26934400; Programacion I seccion 1.
//Practica 1 del tercer parcial.
package ventana;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Juego extends JFrame {
	private JPanel pFlechas;
	private JPanel pCuadros;
	private JLabel cLetras[];
	@SuppressWarnings("rawtypes")
	private JComboBox combo;
	private JButton reinicio;
	
	private int botonSeleccionado;
	
	/** Constructor por defecto y unico del proyecto. */
	public Juego() {
		super("Practica 1.");
		this.setSize(500, 300);
		this.setResizable(false);
		this.setBackground(Color.white);
		this.getContentPane().setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		botonSeleccionado = -1;
		
		iniciarComponentes();
	}//Juego()
	
	/** Metodo para iniciar todos los componentes. */
	private void iniciarComponentes() {
		iniciarComboBox();
		iniciarBotonesDireccionales();
		iniciarBotonReinicio();
		iniciarCuadrosJuego();
	}//iniciarComponentes()
	
	/** Metodo para iniciar el comboBox que permite cambiar el color de las letras. */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void iniciarComboBox() {
		JLabel colorcitos = new JLabel("Color: ");
		colorcitos.setBounds(305, 20, 80, 30);
		this.getContentPane().add(colorcitos);
		
		String[] colores = {"Negro", "Rojo", "Amarillo", "Azul", "Verde"};
		combo = new JComboBox(colores);
		combo.setMaximumRowCount(3);
		combo.setBounds(355, 20, 120, 30);
		this.getContentPane().add(combo);
		
		combo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				 if ( event.getStateChange() == ItemEvent.SELECTED) {
					 cambiarColorLetras();
					 combo.setEnabled(false);
					 pCuadros.setVisible(true);
					 pFlechas.setVisible(true);
					 reinicio.setVisible(true);
				 }//if itemStateChanged
			}//itemSateChanged
		});//combo.addItemListener
		
	}//iniciarComboBox()
	
	/** Metodo que retorna el objeto Color correspondiente a lo seleccionado en el comboBox. */
	private Color getColorLetras() {
		Color color;
		switch (combo.getSelectedIndex()) {
			case 0:
				color = Color.BLACK;
				break;
			case 1:
				color = Color.RED;
				break;
			case 2:
				color = Color.YELLOW;
				break;
			case 3:
				color = Color.BLUE;
				break;
			case 4:
				color = Color.GREEN;
				break;
			default:
				color = Color.BLACK;
				System.out.println("El color no esta definido asi que se utilizara negro.");
				break;
		}//switch
		return color;
	}//getColor()
	
	/** Metodo para iniciar los botones direccionales. */
	private void iniciarBotonesDireccionales() {
		pFlechas = new JPanel(null);
		pFlechas.setBounds(300, 70, 200, 110);
		pFlechas.setVisible(false);
		
		JButton flecha[] = new JButton[4];
		for (int i = 0; i < 4; i++) {
			ImageIcon fl = new ImageIcon("src\\recursos\\flecha" + i + ".png");
			flecha[i] = new JButton(fl);
			flecha[i].setContentAreaFilled(false);
			pFlechas.add(flecha[i]);
		}//for para inicializacion de flechas
		
		//izquierda = flecha0
		flecha[0].setBounds(0, 60, 50, 50);
		flecha[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (botonSeleccionado != -1 && cLetras[botonSeleccionado].getX() - 5 >= pCuadros.getX())
					cLetras[botonSeleccionado].setLocation(cLetras[botonSeleccionado].getX() - 5, cLetras[botonSeleccionado].getY());
			}//actionPerformed
		});//addActionListener
		
		//abajo = flecha1
		flecha[1].setBounds(55, 60, 50, 50);
		flecha[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (botonSeleccionado != -1 && cLetras[botonSeleccionado].getY() + 5 <= pCuadros.getHeight() - cLetras[botonSeleccionado].getHeight())
					cLetras[botonSeleccionado].setLocation(cLetras[botonSeleccionado].getX(), cLetras[botonSeleccionado].getY() + 5);
			}//actionPerformed
		});//addActionListener
		
		//derecha = flecha2
		flecha[2].setBounds(110, 60, 50, 50);
		flecha[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (botonSeleccionado != -1 && cLetras[botonSeleccionado].getX() + 5 <= pCuadros.getWidth() - cLetras[botonSeleccionado].getWidth())
					cLetras[botonSeleccionado].setLocation(cLetras[botonSeleccionado].getX() + 5, cLetras[botonSeleccionado].getY());
			}//actionPerformed
		});//addActionListener
		
		//arriba = flecha3
		flecha[3].setBounds(55, 0, 50, 50);
		flecha[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (botonSeleccionado != -1 && cLetras[botonSeleccionado].getY() - 5 >= pCuadros.getY())
					cLetras[botonSeleccionado].setLocation(cLetras[botonSeleccionado].getX(), cLetras[botonSeleccionado].getY() - 5);
			}//actionPerformed
		});//addActionListener
		
		this.getContentPane().add(pFlechas);
	}//iniciarBotonesDireccionales()
	
	/** Metodo para iniciar el boton de reiniciar. */
	private void iniciarBotonReinicio() {
		reinicio = new JButton("Reiniciar");
		reinicio.setBounds(330, 200, 100, 30);
		reinicio.setVisible(false);
		
		//reinicio
		reinicio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().remove(pCuadros);
				iniciarCuadrosJuego();
				
				combo.setEnabled(true);
				reinicio.setVisible(false);
				pFlechas.setVisible(false);
				
				revalidate();
				repaint();
			}//actionPerformed
		});//reinicio.addActionListener
		
		this.getContentPane().add(reinicio);
	}//iniciarBotonReinicio()
	
	/** Metodo para iniciar los cuadros del juego y las letras. */
	private void iniciarCuadrosJuego() {
		pCuadros = new JPanel(null);
		pCuadros.setBounds(0, 0, 250, 250);
		
		cLetras = new JLabel[4];
		char[] letras = {'U', 'N', 'E', 'T'};
		letras = aleatorizarOrdenLetras(letras);
		
		for (int i = 0; i < 4; i++) {
			JLabel cuadro = new JLabel();
			cuadro.setSize(40, 40);
			cuadro.setBackground(Color.WHITE);
			cuadro.setOpaque(true);
			cuadro.setLocation((50 * i), 80);
			
			cLetras[i] = new JLabel(Character.toString(letras[i]));
			cLetras[i].setBounds((50 * i) + 15, 90, 15, 20);
			cLetras[i].setFont(new Font("Arial", Font.BOLD, 18));
			
			final int k = i;
			cLetras[i].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent event) {
					botonSeleccionado = k;
				}//mouseClicked
			});//addMouseListener
			
			pCuadros.add(cLetras[i]);
			pCuadros.add(cuadro);
		}//for
		
		pCuadros.setVisible(false);
		this.getContentPane().add(pCuadros);
	}//iniciarCuadrosJuego()
	
	/** Metodo que cambia el color de las letras. */
	private void cambiarColorLetras() {
		Color colorLetras = getColorLetras();
		
		for (int i = 0; i < 4; i++)
			cLetras[i].setForeground(colorLetras);
	}//cambiarColorLetras()
	
	/** Metodo que desordena las letras. */
	private char[] aleatorizarOrdenLetras(char[] letras) {
		char[] letras2 = new char[4];
		
		//aleatorizar orden de letras
		int random = (int) (Math.random() * 4);
		int i = 0;	
		while (i < 4){
			if (letras[random] == ' ') //si letra vacia es porque letra esta usada
				random = (int) (Math.random() * 4);
			
			else { 
				letras2[i] = letras[random];
				letras[random] = ' ';
				i++;
			}
			random = (int) (Math.random() * 4);
		}while (letras[random] != ' '); //do while letras no este vacio (letra usada)
		
		if (letras2.toString().equals("UNET"))
			return aleatorizarOrdenLetras(letras2);
		else
			return letras2;
	}//aleatorizarOrdenLetras(char[])
	
}//Juego
