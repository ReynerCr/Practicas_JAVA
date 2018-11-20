package utilidades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import juego.Juego;
import juego.Menu;
import juego.PanelAuxiliar;

public class ManejaEventos {
	
	public static ActionListener volverAMenu() {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getInstance().setContentPane(Menu.getInstance());
				actualizarFrame();
			}
		};
		
		return al;
	}//
	
	public static ActionListener nuevoJuego() {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getInstance().setContentPane(new PanelAuxiliar(Juego.getInstance().getFondo(), 0));
				actualizarFrame();
			}
		};
		
		return al;
	}//
	
	public static ActionListener instrucciones() {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelAuxiliar intrucciones = new PanelAuxiliar(Juego.getInstance().getFondo(), 1);				
				
				
				
				Juego.getInstance().setContentPane(intrucciones);
				actualizarFrame();
			}
		};
		
		return al;
	}//
	
	public static ActionListener top10() {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelAuxiliar top10 = new PanelAuxiliar(Juego.getInstance().getFondo(), 2);
				
				Juego.getInstance().setContentPane(top10);
				actualizarFrame();
			}
		};
		
		return al;
	}//
	
	public static ActionListener creditos() {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelAuxiliar creditos = new PanelAuxiliar(Juego.getInstance().getFondo(), 3);			
				
				
				Juego.getInstance().setContentPane(creditos);
				actualizarFrame();
			}
		};
		
		return al;
	}//
	
	public static ActionListener salir() {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		};
		return al;
	}//
	//TODO ARREGLAR LOS BOTONES Y ESO DE CAJAT PORQUE ESTAN DEL CULO TERMINAR INSTRUCCIONES
	public static ActionListener cajaTexto(JTextField cajaT) {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cajaT.setText(cajaT.getText().trim());
				
				if (cajaT.getText().isEmpty()) 
					JOptionPane.showMessageDialog(null, "Nombre no puede estar vacio.");
				
				else if(cajaT.getText().contains("@")) 
					JOptionPane.showMessageDialog(null, "Lo sentimos, el caracter \"@\" no esta permitido en el nombre.");
				else if (cajaT.getText().length() > 8)
					JOptionPane.showMessageDialog(null, "Nombre no puede ser mayor de 8 caracteres.");
				else
					iniciarJuego(cajaT.getText());
					
				
			}
		};
		return al;
	}
	
	private static void iniciarJuego(String nombre) {
		//TODO aqui llamo escenarioJuego y ARREGLAR EL PUTO PANEL PADRE QUE NO ME GUSTA, MEJOR LO HAGO NE MENU
	}

	
	public static void actualizarFrame() {
		Juego.getInstance().revalidate();
		Juego.getInstance().repaint();
	}
}