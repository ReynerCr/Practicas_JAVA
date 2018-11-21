package juego;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Tablero extends JPanel {
	private Esfera esferas[][];
	private Esfera esferasSeleccionadas[];
	private int esferasCargadas = -1; //-1 es que no hay nada cargado
	private int sumatoriaValores; //me guarda los valores de las esferas seleccionadas
	
	public Tablero() {
		this.setLayout(null);
		this.setOpaque(false);
		iniciarEsferas();
	}
	
	private void iniciarEsferas() {
		esferas = new Esfera[7][5];  
		
		int x, y;
		for (int i = 0; i < 7; i++) {
			y = (80*i) + 15;
			for (int j = 0; j < 5; j++) {
				x = (80 * j) + 105;
				int aux = (int) (Math.random() * 8) + 1;
				esferas[i][j] = new Esfera(aux);
				esferas[i][j].setLocation(x, y);
				esferas[i][j].addMouseListener(eventoEsferas(esferas[i][j]));
				
				this.add(esferas[i][j]);
			}//for j
		}//for i
		
	}//iniciarEsferas()
	
	//TODO se siguen repitiendo esferas no se xq, revisar
	private MouseListener eventoEsferas(Esfera esfera) {
		MouseListener ml = new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				esferasCargadas = -1;
				sumatoriaValores = 0;
				esfera.setActivo(false);
				esferasSeleccionadas = null;
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if (esferasCargadas >= 0) {
					if (esferasCargadas > 0 && esferasSeleccionadas[esferasCargadas-1]==esfera) {
						sumatoriaValores -= esferasSeleccionadas[esferasCargadas].getValor();
						esferasSeleccionadas[esferasCargadas].setActivo(false);
						esferasSeleccionadas[esferasCargadas] = null;
						esferasCargadas--;
						
						if (esferasCargadas == -1) {
							esferasSeleccionadas = null;
						}
					}//if mi esfera actual es la misma que la anterior de la lista
					else {
						if (!(esfera.getActivo()) && (esfera.getValor() == sumatoriaValores || (esferasCargadas > 0 && esfera.getValor() == esferasSeleccionadas[esferasCargadas-1].getValor()))) {
							sumatoriaValores += esfera.getValor();
							esferasCargadas++;
							esfera.setActivo(true);
							esferasSeleccionadas[esferasCargadas] = esfera;
						}//if
					}//else
				}//if sesferasCargadas mayor o igual a cero
			}//mouseEntered
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				esferasSeleccionadas = new Esfera[35];
				
				esferasCargadas++;
				esfera.setActivo(true);
				esferasSeleccionadas[esferasCargadas] = esfera;
				sumatoriaValores = esfera.getValor();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if (esferasCargadas >= 0) {
					if (esferasCargadas > 0) {
						for(int i = 0; i < 35 && esferasSeleccionadas[i]!=null; i++) {
							esferasSeleccionadas[i].setValor(sumatoriaValores); //TODO PRUEBA
							esferasSeleccionadas[i].setActivo(false);
						}
						sumatoriaValores = esferasSeleccionadas[0].getValor();
						Entorno.actualizarPuntaje(sumatoriaValores);
					}
					
					esferasCargadas = -1;
					sumatoriaValores = 0;
					esferasSeleccionadas = null;
				}
			}
		};
		
		return ml;
	}
	
}
