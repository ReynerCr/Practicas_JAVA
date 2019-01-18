package codigo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Tablero extends JPanel {
	private Esfera esferas[][];
	private Esfera esfLista[];
	//private Conector conectores[];
	private int esfNum = -1; //-1 es que no hay nada cargado
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
				esferas[i][j].setI(i);
				esferas[i][j].setJ(j);
				esferas[i][j].addMouseListener(eventoEsferas(i, j));
			}//for j
		}//for i
		
	}//iniciarEsferas()
	//TODO embellecer este evento; en teoria funciona bien pero esta mal organizado creo yo
	private MouseListener eventoEsferas(int i, int j) {
		MouseListener ml = new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (EntornoJuego.getInstance().getTime().getActivo()) {
					esfNum = -1;
					sumatoriaValores = 0;
					esferas[i][j].setActivo(false);
					esfLista = null;
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if (esfNum >= 0) {
					if (esfNum > 0 && esfLista[esfNum-1]==esferas[i][j]) {
						sumatoriaValores -= esfLista[esfNum].getValor();
						esfLista[esfNum].setActivo(false);
						esfLista[esfNum] = null;
						//remove(conectores[esfNum]);
						//conectores[esfNum] = null;
						esfNum--;
						
						if (esfNum == -1) {
							esfLista = null;
						}
					}//if mi esfera actual es la misma que la anterior de la lista
					else if (!(esferas[i][j].getActivo())) {
						if  (esferas[i][j].getValor() == sumatoriaValores || (esfNum > 0 && esfLista[esfNum].getValor() == esferas[i][j].getValor())) {
							int direccion = retornarDireccion(i, j);
							if (direccion != 0) {
								sumatoriaValores += esferas[i][j].getValor();
								esfNum++;
								esferas[i][j].setActivo(true);
								esfLista[esfNum] = esferas[i][j];
								//anyadirConector(direccion);
							}
						}//if
					}//else if 
					revalidate();
					repaint();
				}//if esferasCargadas mayor o igual a cero
			}//mouseEntered
			@Override
			
			public void mouseExited(MouseEvent e) {
				//aqui va que se quite el "conector" de esa esfera si es que la tenia
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if (EntornoJuego.getInstance().getTime().getActivo()) {
					esfLista = new Esfera[35];
					//conectores = new Conector[35];
					
					esfNum++;
					esferas[i][j].setActivo(true);
					esfLista[esfNum] = esferas[i][j];
					sumatoriaValores = esferas[i][j].getValor();
				}
				
				//TODO aqui sonido de inicio
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if (esfNum >= 0) {
					if (esfNum > 0) {
						esfLista[esfNum].setValor(sumatoriaValores);
						esfLista[esfNum].setActivo(false);
						
						int aux = 0;
						for (int i = 0; i < 7; i++) {
							for (int j = 0; j < 5; j++) {
								if (esferas[i][j].getValor() > aux)
									aux = esferas[i][j].getValor();
								if(esferas[i][j].getActivo()) {
									int x = esferas[i][j].getX();
									int y = esferas[i][j].getY();
									remove(esferas[i][j]);
									
									esferas[i][j] = null;
									esferas[i][j] = new Esfera((int) (Math.random() * aux));
									esferas[i][j].setLocation(x, y);
									esferas[i][j].addMouseListener(eventoEsferas(i, j));
									add(esferas[i][j]);
								}//if
							}//for
						}//for
						EntornoJuego.getInstance().actualizarPuntaje(sumatoriaValores);
						
						if (hayJugadasDisponibles()) {
							EntornoJuego.getInstance().finDeJuego();
						}
						
						revalidate();
						repaint();
						//TODO anyadir sonido de fin de cadena
					}
					
					esfLista[esfNum].setActivo(false);
					esfNum = -1;
					sumatoriaValores = 0;
					esfLista = null;
					//conectores = null;
				}
			}
		};
		
		return ml;
	}//eventoEsferas
	
	private int retornarDireccion(int i, int j) {
		int direccion = 0;
		
		if (i!=0 && j!=0 && esferas[i-1][j-1] == esfLista[esfNum]) //inf der
			direccion = 8;
		else if (i!=0 && esferas[i-1][j] == esfLista[esfNum]) //abajo
			direccion = 7;
		else if (i!=0 && j!=4 && esferas[i-1][j+1] == esfLista[esfNum])//inf izq
			direccion = 6;
		else if (j!=0 && esferas[i][j-1] == esfLista[esfNum]) //der
			direccion = 5;
		else if (j!=4 && esferas[i][j+1] == esfLista[esfNum]) //izq
			direccion = 4;
		else if (i!=6 && j!=0 && esferas[i+1][j-1] == esfLista[esfNum]) //sup der
			direccion = 3;
		else if (i!=6 && esferas[i+1][j] == esfLista[esfNum]) //arriba
			direccion = 2;
		if (i!=6 && j!=4 && esferas[i+1][j+1] == esfLista[esfNum]) //sup izq
			direccion = 1;
		
		return direccion;
	}//retornarDireccion(int, int)
	
	/*private void anyadirConector(int direccion) {
		conectores[esfNum] = new Conector(direccion, esfLista[esfNum-1].getConector());
		switch(direccion) {
			case 1:
				conectores[esfNum].setLocation(esfLista[esfNum].getX() - conectores[esfNum].getHeight(),
						esfLista[esfNum].getY() + 10);
				break;
			case 2://
				conectores[esfNum].setLocation(esfLista[esfNum].getX() - (esfLista[esfNum].getWidth()/2),
						esfLista[esfNum].getY() + (esfLista[esfNum].getHeight()));
				
				break;
			case 3:
				conectores[esfNum].setLocation(esfLista[esfNum].getX() + esfLista[esfNum].getWidth(),
						esfLista[esfNum].getY() + esfLista[esfNum].getHeight());
				break;
			case 4://
				conectores[esfNum].setLocation(esfLista[esfNum].getX() + (esfLista[esfNum].getWidth()/2),
						esfLista[esfNum].getY() + (esfLista[esfNum].getHeight()/2));
				break;
			case 5://
				conectores[esfNum].setLocation(esfLista[esfNum].getX() - (esfLista[esfNum].getWidth()/2),
						esfLista[esfNum].getY() + (esfLista[esfNum].getHeight()/2));
				break;
			case 6:
				conectores[esfNum].setLocation(esfLista[esfNum].getX(),
						esfLista[esfNum].getY() + esfLista[esfNum].getHeight());
				break;
			case 7: //
				conectores[esfNum].setLocation(esfLista[esfNum].getX() + 6,
						esfLista[esfNum].getY() - 10);
				break;
			case 8:
				break;
		}//switch
		this.add(conectores[esfNum]);
	}*/
	
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
