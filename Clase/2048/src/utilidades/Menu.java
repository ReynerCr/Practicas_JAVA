package utilidades;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Menu extends PanelPadre {
	
	private static Menu instance = null;
	
	private BotonMenu nuevoJ;
	private BotonMenu instrucciones;
	private BotonMenu top10;
	private BotonMenu creditos;
	private BotonMenu salir;
	private BotonMenu volver;
	private ActionListener volverMenu;
	
	private Menu() {
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		iniciarBotones();
	}
	
	public static Menu getInstance() {
		if (instance == null)
			instance = new Menu();
		
		return instance;
	}
	
	private void iniciarBotones() {
		eVolverMenu();
		bNuevoJuego();
		bInstrucciones();
		bTop10();
		bCreditos();
		bSalir();
	}
	
	private void eVolverMenu() {
		volverMenu =  new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getInstance().actualizarFrame(Menu.getInstance());
			}
		};
		
		volver = new BotonMenu("Volver");
		volver.addActionListener(volverMenu);
		volver.setSize(150, 80);
	}
	
	private void bNuevoJuego() { 
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelPadre panel = new PanelPadre();
				
				BotonMenu nombre = new BotonMenu("Ingrese su nombre.", 200, 50, 15);
				nombre.setLocation(200, 400);
				panel.add(nombre);
				
				BotonMenu etiqueta = new BotonMenu("Maximo 8 caracteres y ninguno igual a \"@\".", 480, 30, 16);
				etiqueta.setLocation(60, 450);
				panel.add(etiqueta);
				
				JTextField cajaT = new JTextField();
				cajaT.setFont(new Font("Arial", Font.BOLD, 20));
				cajaT.setBounds(200, 350, 200, 50);
				
				ActionListener al2 = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						cajaT.setText(cajaT.getText().trim());
						
						if (cajaT.getText().isEmpty()) 
							JOptionPane.showMessageDialog(null, "Nombre no puede estar vacio.");
						
						else if(cajaT.getText().contains("@")) 
							JOptionPane.showMessageDialog(null, "Lo sentimos, el caracter \"@\" no esta permitido en el nombre.");
						else if (cajaT.getText().length() > 8)
							JOptionPane.showMessageDialog(null, "Nombre no puede ser mayor de 8 caracteres.");
						else {
							Juego.getInstance().actualizarFrame(EntornoJuego.getInstance());
							EntornoJuego.getInstance().getTime().iniciar();
							EntornoJuego.getInstance().setNombre(cajaT.getText());
						}
					}
				};
				
				cajaT.addActionListener(al2);
				nombre.addActionListener(al2);
				
				
				panel.add(cajaT);
				volver.setLocation(30, panel.getHeight() - 150);
				panel.add(volver);
				
				String ruta = this.getClass().getResource("recursos/").getPath();
				ruta = ruta + "top10.dat";
				
				Juego.getInstance().setContentPane(panel);
				Juego.getInstance().actualizarFrame(panel);
			}
		};
		
		nuevoJ = new BotonMenu("Nuevo juego");
		nuevoJ.addActionListener(al);
		nuevoJ.setBounds((this.getWidth()/2)/2, 200, 300, 50);
		
		this.add(nuevoJ);
	}
	
	private void bInstrucciones() { //TODO Basicamente hacer todo lo de adentro
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelPadre panel = new PanelPadre();
				
				volver.setLocation(30, panel.getHeight() - 150);
				panel.add(volver);
				
				Juego.getInstance().actualizarFrame(panel);
			}
		};
		
		instrucciones = new BotonMenu("Instrucciones");
		instrucciones.addActionListener(al);
		instrucciones.setBounds((this.getWidth()/2)/2, nuevoJ.getY() + 80, 300, 50);
		
		this.add(instrucciones);
	}
	
	private void bTop10() { //TODO mostrar ordenado de mayor a menor
		ActionListener al = new ActionListener() {
			@SuppressWarnings("resource")
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelPadre panel = new PanelPadre();
				EtiquetaPersonalizada etiqueticas[] = new EtiquetaPersonalizada[10];
				URL url = this.getClass().getResource("recursos/top10.dat");
				Scanner entrada = null;
				try {
					if (url == null)
						throw new FileNotFoundException();
					
					entrada = new Scanner (new File(url.getPath()));
					int i = 0;
					while(entrada.hasNextLine() && i < 10) {
						String cadenas[] = (entrada.nextLine()).split("@");
						Long.parseLong(cadenas[1]); //valido que el puntaje si sean numeros
						etiqueticas[i] = new EtiquetaPersonalizada((i+1) + ". " + cadenas[0] + "......"+ cadenas[1], 540, 50, 18);
						etiqueticas[i].setLocation(30, 190 + (i*40));
						panel.add(etiqueticas[i]);
						i++;
					}//while
					
					if (i == 0) 
						throw new FileNotFoundException(); //reutilizo codigo en caso de que nadie haya jugado y terminado
					
					entrada.close();
				} catch (FileNotFoundException e1) {
					etiqueticas[0] = new EtiquetaPersonalizada("No hay registros de jugadores.", 540, 50, 18);
					etiqueticas[0].setLocation(30, 320);
					panel.add(etiqueticas[0]);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "El archivo esta corrupto, se creara una copia en el directorio y se borrara el original.");
					entrada.close();
					try {
						for (int i = 0; i < etiqueticas.length && etiqueticas[i]!=null; i++)
							panel.remove(etiqueticas[i]);
						
						String dir = this.getClass().getResource("recursos/").getPath();
						dir = dir + "DANADO_top10.dat";
						
						FileWriter fw = new FileWriter(new File(dir));
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter pw = new PrintWriter(bw);
						
						entrada = new Scanner(new File(url.getPath()));
						
						while (entrada.hasNextLine())
							pw.println(entrada.nextLine());
						
						entrada.close();
						pw.close();
						
						System.out.println(new File(url.getPath()).delete());
					} catch (IOException e2) {
						JOptionPane.showMessageDialog(null, "Ocurrio un error grave: " + e2.getMessage());
					}//catch
				}//catch
				
				volver.setLocation(30, panel.getHeight() - 150);
				panel.add(volver);
				
				Juego.getInstance().actualizarFrame(panel);
			}//ActionPerformed
		};//ActionListener al
		
		top10 = new BotonMenu("Top 10");
		top10.addActionListener(al);
		top10.setBounds((this.getWidth()/2)/2, instrucciones.getY() + 80, 300, 50);
		
		this.add(top10);
	}
	
	private void bCreditos() { //TODO mejorar o cambiar todo
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelPadre panel = new PanelPadre();
				EtiquetaPersonalizada etiqueta;
				
				etiqueta = new EtiquetaPersonalizada("Reyner Contreras;  C.I: V.-26934400;  seccion 01.", 540, 50, 18);
				etiqueta.setLocation(30, 300);
				panel.add(etiqueta);
						
				etiqueta = new EtiquetaPersonalizada("Version: 1.00");
				etiqueta.setFont(new Font("Arial", Font.BOLD, 25));
				etiqueta.setLocation((panel.getWidth()/2)/2, 500);
				panel.add(etiqueta);
				volver.setLocation(30, panel.getHeight() - 150);
				panel.add(volver);
				
				Juego.getInstance().actualizarFrame(panel);
			}//actionPerformed
		};//ActionListener al
		
		creditos = new BotonMenu("Creditos");
		creditos.addActionListener(al);
		creditos.setBounds((this.getWidth()/2)/2, top10.getY() + 80, 300, 50);
		
		this.add(creditos);
	}

	private void bSalir() {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
		
		salir = new BotonMenu("Salir");
		salir.addActionListener(al);
		salir.setBounds((this.getWidth()/2)/2, creditos.getY() + 80, 300, 50);
		
		this.add(salir);
	}
}
