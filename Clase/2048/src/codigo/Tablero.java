package codigo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
//TODO arreglar codigo para que se vea bonito y anyadirle javadoc
@SuppressWarnings("serial")
public class Tablero extends JPanel {
	private Esfera esferas[][];
	private Esfera esfLista[];
	private int esfNum = -1; //-1 es que no hay nada cargado
	private int sumatoriaValores; //me guarda los valores de las esferas seleccionadas
	private int mayorValor;
	public final int distX = 80;
	public final int distY = 80;
	private boolean pausa = false;
	
	
	public Tablero() {
		this.setLayout(null);
		this.setOpaque(false);
		mayorValor = 8;
		
		do {
			iniciarEsferas();
		} while (!hayJugadasDisponibles()); 
	}
	
	private void iniciarEsferas() {
		esferas = null;
		esferas = new Esfera[7][5];  
		
		int x, y;
		for (int i = 0; i < 7; i++) {
			y = (distY * i) + 15;
			for (int j = 0; j < 5; j++) {
				x = (distX * j) + 105;
				int aux = (int) ((Math.random() * 8) + 1);
				esferas[i][j] = new Esfera(aux);
				esferas[i][j].setLocation(x, y);
				esferas[i][j].addMouseListener(eventoEsferas(i, j));
				this.add(esferas[i][j]);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}//for j
		}//for i
	}//iniciarEsferas()
	
	private MouseListener eventoEsferas(int i, int j) {
		MouseListener ml = new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}//mouseClicked
			
			@Override
			public void mouseEntered(MouseEvent e) {
				if (!pausa) {
					if (esfNum > 0 && esfLista[esfNum-1]==esferas[i][j]) {
						sumatoriaValores -= esfLista[esfNum].getValor();
						esfLista[esfNum].setActivo(false);
						esfLista[esfNum] = null;
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
							}//if direccion != 0
						}//if
					}//else if 
				}//if !pausa
					
			}//mouseEntered
			@Override
			
			public void mouseExited(MouseEvent e) {
				//aqui va que se quite el "conector" de esa esfera si es que la tenia
			}//mouseExited
			
			@Override
			public void mousePressed(MouseEvent e) {
				if (!pausa) {
					esfLista = new Esfera[35];
					esfNum++;
					esferas[i][j].setActivo(true);
					esfLista[esfNum] = esferas[i][j];
					sumatoriaValores = esferas[i][j].getValor();
				}
				//TODO aqui sonido de inicio
			}//mousePressed
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if (!pausa) {
					if (esfNum >= 1) {
						pausa = true;
						esfLista[esfNum].setValor(sumatoriaValores);
						esfLista[esfNum].setActivo(false);
						
						for (int j = 0; j < 5; j++) {
							for (int i = 6; i > -1; i--) {
								if (esferas[i][j] == null || esferas[i][j].getActivo()) {
									if (esferas[i][j] != null) {
										if (esferas[i][j].getActivo())
											esferas[i][j].setActivo(false);
										if (esferas[i][j] != esfLista[esfNum]) {
											remove(esferas[i][j]);
											esferas[i][j] = null;
										}//if esfera != esfLista[esfNum]
									}//if esfera != null
									
									esferas[i][j] = comprobarEsferas(i, j);
									resetearMl(i, j);
									esferas[i][j].iniciarCaida((distY * i) + 15);
								}
							}//for j
						}//for i

						//TODO al salir con el boton, que se pregunte al usuario si desea salir; si acepta PUEDE que su puntaje se guarde en top10 en caso de que su puntaje sea alto, y claro debe haber superado el puntaje minimo

						EntornoJuego.getInstance().actualizarPuntaje(sumatoriaValores);
						if (!hayJugadasDisponibles()) {
							EntornoJuego.getInstance().finDeJuego();
						}
						
						if (esfLista[esfNum].getValor() > mayorValor) {
							mayorValor = esfLista[esfNum].getValor();
						}
						
						//TODO anyadir sonido de fin de cadena
						pausa = false;
					}//esfNum > 0
					
					else
						esfLista[esfNum].setActivo(false);
				}
				
				esfNum = -1;
				esfLista = null;
				sumatoriaValores = 0;
			}//mouseReleased
		};
		
		return ml;
	}//eventoEsferas
	
	private void resetearMl(int i, int j) {
		MouseListener ml2[] = esferas[i][j].getMouseListeners();
		
		for (int k = 0; k < ml2.length; k++)
			esferas[i][j].removeMouseListener(ml2[k]);
		
		esferas[i][j].addMouseListener(eventoEsferas(i, j));
	}
	
	private Esfera comprobarEsferas(int i, int j) {
		if ((i == 0 && esferas[i][j] == null) || (i == 0 && esferas[i][j].getActivo())) {
			Esfera esferita;
			int aux = (int) ((Math.random()) * 20);
			
			if (aux == 19) //5% de que se genere la esfera de mayor valor
				aux = mayorValor;
			
			else if (aux >= 0 && aux < 16) //80% de que se genere una esfera que este de 2 a  a la mayor
				aux = ((int) ((Math.random() + 0.01d) * mayorValor));
			
			else //15% de que se genere una esfera del 2 al 8
				aux = ((int) (Math.random() * 8) + 1);
			
			esferita = new Esfera(aux);
			esferita.setLocation((distX * j) + 105, -85);
			add(esferita);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			return esferita;
		}//cuando ya no hay mas para revisar; i == 0

		else if (esferas[i][j] != null && !(esferas[i][j].getActivo())) {
			Esfera esferita = esferas[i][j];
			esferas[i][j] = null;
			return esferita;
		}
		
		else {
			Esfera esferita = comprobarEsferas(i - 1, j);
			return esferita;
		}
	}//comprobarEsfera(int i, int j)
	
	//solucion recursiva donde evaluo un null y busco si arriba hay otra esfera que no tenga null
	//en la recursividad tengo que evaluar que i!=0
	//tengo que tener una condicion de null todo asi que se deberia recrear a la fila entera
	
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
	
	public void setPausa(boolean estado) {
		pausa = estado;
	}
	
	public boolean getPausa() {
		return pausa;
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
