package juego;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
@SuppressWarnings("serial")
public class Tablero extends JPanel {
	private Esfera esferas[][];
	private Esfera esferasSeleccionadas[];
	private Conector conectores[];
	private int esferasCargadas = -1; //-1 es que no hay nada cargado
	private int sumatoriaValores; //me guarda los valores de las esferas seleccionadas
	
	public Tablero() {
		this.setLayout(null);
		this.setOpaque(false);
		
		do {
			iniciarEsferas();
		} while (!hayJugadasDisponibles()); 
		
		for (int i = 0; i < 7; i++) 
			for (int j = 0; j < 5; j++) 
				this.add(esferas[i][j]);
	}
	
	private void iniciarEsferas() {
		esferas = null;
		esferas = new Esfera[7][5];  
		
		int x, y;
		for (int i = 0; i < 7; i++) {
			y = (80*i) + 15;
			for (int j = 0; j < 5; j++) {
				x = (80 * j) + 105;
				int aux = (int) (Math.random() * 8) + 1;
				esferas[i][j] = new Esfera(aux);
				esferas[i][j].setLocation(x, y);
				esferas[i][j].setX(x);
				esferas[i][j].setY(y);
				esferas[i][j].addMouseListener(eventoEsferas(i, j));
			}//for j
		}//for i
		
	}//iniciarEsferas()
	
	private MouseListener eventoEsferas(int i, int j) {
		MouseListener ml = new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				esferasCargadas = -1;
				sumatoriaValores = 0;
				esferas[i][j].setActivo(false);
				esferasSeleccionadas = null;
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if (esferasCargadas >= 0) {
					if (esferasCargadas > 0 && esferasSeleccionadas[esferasCargadas-1]==esferas[i][j]) {
						sumatoriaValores -= esferasSeleccionadas[esferasCargadas].getValor();
						esferasSeleccionadas[esferasCargadas].setActivo(false);
						esferasSeleccionadas[esferasCargadas] = null;
						conectores[esferasCargadas] = null;
						esferasCargadas--;
						
						if (esferasCargadas == -1) {
							esferasSeleccionadas = null;
						}
					}//if mi esfera actual es la misma que la anterior de la lista
					else {
						if (!(esferas[i][j].getActivo()) && (esferas[i][j].getValor() == sumatoriaValores || (esferasCargadas > 0 && esferas[i][j].getValor() == esferasSeleccionadas[esferasCargadas-1].getValor()))) {
							int direccion = retornarDireccion(i, j);
							if (direccion != 0) {
								sumatoriaValores += esferas[i][j].getValor();
								esferasCargadas++;
								esferas[i][j].setActivo(true);
								esferasSeleccionadas[esferasCargadas] = esferas[i][j];
								anyadirConector(direccion);
							}
							//TODO CONECTOR SE COLOCA MAL Y SE ROTA MAL
						}//if
					}//else
					revalidate();
					repaint();
				}//if sesferasCargadas mayor o igual a cero
			}//mouseEntered
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				esferasSeleccionadas = new Esfera[35];
				conectores = new Conector[35];
				
				esferasCargadas++;
				esferas[i][j].setActivo(true);
				esferasSeleccionadas[esferasCargadas] = esferas[i][j];
				sumatoriaValores = esferas[i][j].getValor();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if (esferasCargadas >= 0) {
					if (esferasCargadas > 0) {
						for(int i = 0; i < 35 && esferasSeleccionadas[i]!=null; i++) {
							esferasSeleccionadas[i].setValor(sumatoriaValores); //TODO CAMBIAR
							esferasSeleccionadas[i].setActivo(false);
							
							conectores[i] = null;
						}
						sumatoriaValores = esferasSeleccionadas[0].getValor();
						EntornoJuego.actualizarPuntaje(sumatoriaValores);
					}
					
					esferasCargadas = -1;
					sumatoriaValores = 0;
					esferasSeleccionadas = null;
					conectores = null;
				}
			}
		};
		return ml;
	}
	
	private int retornarDireccion(int i, int j) {
		int direccion = 0;
		
		if (i!=0 && j!=0 && esferas[i-1][j-1] == esferasSeleccionadas[esferasCargadas]) //sup izq
			direccion = 1;
		else if (i!=0 && esferas[i-1][j] == esferasSeleccionadas[esferasCargadas]) //arriba
			direccion = 2;
		else if (i!=0 && j!=4 && esferas[i-1][j+1] == esferasSeleccionadas[esferasCargadas])//sup der
			direccion = 3;
		else if (j!=0 && esferas[i][j-1] == esferasSeleccionadas[esferasCargadas]) //izq
			direccion = 4;
		else if (j!=4 && esferas[i][j+1] == esferasSeleccionadas[esferasCargadas]) //der
			direccion = 5;
		else if (i!=6 && j!=0 && esferas[i+1][j-1] == esferasSeleccionadas[esferasCargadas]) //inf izq
			direccion = 6;
		else if (i!=6 && esferas[i+1][j] == esferasSeleccionadas[esferasCargadas]) //abajo
			direccion = 7;
		if (i!=6 && j!=4 && esferas[i+1][j+1] == esferasSeleccionadas[esferasCargadas]) //inf der
			direccion = 8;
		
		return direccion;
	}//retornarDireccion(int, int)
	
	private void anyadirConector(int direccion) {
		conectores[esferasCargadas] = esferasSeleccionadas[esferasCargadas].getConector();
		
		switch(direccion) {
			case 1:
				conectores[esferasCargadas].setRotacion(2.3561);
				conectores[esferasCargadas].setLocation(esferasSeleccionadas[esferasCargadas].getX(),
						esferasSeleccionadas[esferasCargadas].getY());
				this.add(conectores[esferasCargadas]);
				break;
			case 2:
				conectores[esferasCargadas].setRotacion(1.5708);
				conectores[esferasCargadas].setLocation((esferasSeleccionadas[esferasCargadas].getX() + esferasSeleccionadas[esferasCargadas].getWidth())/2,
						(esferasSeleccionadas[esferasCargadas].getY() + esferasSeleccionadas[esferasCargadas].getHeight())/2);
				break;
			case 3:
				conectores[esferasCargadas].setRotacion(0.7853);
				conectores[esferasCargadas].setLocation(esferasSeleccionadas[esferasCargadas].getX(),
						esferasSeleccionadas[esferasCargadas].getY());
				break;
			case 4:
				conectores[esferasCargadas].setLocation(esferasSeleccionadas[esferasCargadas].getX(),
						(esferasSeleccionadas[esferasCargadas].getY() + esferasSeleccionadas[esferasCargadas].getHeight())/2);
				break;
			case 5:
				conectores[esferasCargadas].setLocation(esferasSeleccionadas[esferasCargadas].getX() + esferasSeleccionadas[esferasCargadas].getWidth(),
						(esferasSeleccionadas[esferasCargadas].getY() + esferasSeleccionadas[esferasCargadas].getHeight())/2);
				//der
				break;
			case 6:
				conectores[esferasCargadas].setRotacion(0.7853);
				conectores[esferasCargadas].setLocation(esferasSeleccionadas[esferasCargadas].getX(),
						esferasSeleccionadas[esferasCargadas].getY() + esferasSeleccionadas[esferasCargadas].getHeight());
				break;
			case 7:
				conectores[esferasCargadas].setRotacion(1.5708);
				conectores[esferasCargadas].setLocation((esferasSeleccionadas[esferasCargadas].getX() + esferasSeleccionadas[esferasCargadas].getWidth()),
						(esferasSeleccionadas[esferasCargadas].getY() + esferasSeleccionadas[esferasCargadas].getHeight()));
				break;
			case 8:
				conectores[esferasCargadas].setRotacion(2.3561);
				conectores[esferasCargadas].setLocation((esferasSeleccionadas[esferasCargadas].getX() + esferasSeleccionadas[esferasCargadas].getWidth()),
						(esferasSeleccionadas[esferasCargadas].getY() + esferasSeleccionadas[esferasCargadas].getHeight()));
				break;
		}//switch
		
		this.add(conectores[esferasCargadas]);
	}
	
	private boolean hayJugadasDisponibles() {
		boolean jugadas = false;
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 5 && jugadas!=true; j++) {
				try { //try para cuando el i o j se salen del array
					if (esferas[i][j].getValor() == esferas[i-1][j-1].getValor()) { //diag sup izq
						jugadas = true;
					}
					else if (esferas[i][j].getValor() == esferas[i-1][j].getValor()) { //arriba
						jugadas = true;
					}
					else if (esferas[i][j].getValor() == esferas[i-1][j+1].getValor()) { //diag sup der
						jugadas = true;
					}
					else if (esferas[i][j].getValor() == esferas[i][j-1].getValor()) { //izq
						jugadas = true;
					}
					else if (esferas[i][j].getValor() == esferas[i][j+1].getValor()) { //der
						jugadas = true;
					}
					else if (esferas[i][j].getValor() == esferas[i+1][j-1].getValor()) { //diag inf izq
						jugadas = true;
					}
					else if (esferas[i][j].getValor() == esferas[i+1][j].getValor()) { //abajo
						jugadas = true;
					}
					else if (esferas[i][j].getValor() == esferas[i+1][j+1].getValor()) {//diag inf der
						jugadas = true;
					}
				} catch (ArrayIndexOutOfBoundsException e) {
				} catch (NegativeArraySizeException e) {
				}
			}//for j
		}//for i
		return jugadas;
	}//hayJugadasDisponibles
	
}
