package codigo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
//TODO arreglar codigo para que se vea bonito y anyadirle javadoc
//TODO Anyadir evento de salida al presionar la x y al darle a salir, que haga null todo para que el recolector de basura haga su trabajo
@SuppressWarnings("serial")
public class Tablero extends JPanel {
	private Esfera esferas[][];
	private Esfera esfLista[];
	private int esfNum = -1; //-1 es que no hay nada cargado
	private int sumatoriaValores; //me guarda los valores de las esferas seleccionadas
	private int mayorValor;
	private int MAX_FILAS = 7;
	private int MAX_COLUMNAS = 5;
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
		int x, y;
		esferas = new Esfera[MAX_FILAS][MAX_COLUMNAS];
		for (int i = 0; i < MAX_FILAS; i++) {
			y = (distY * i) + 15;
			for (int j = 0; j < MAX_COLUMNAS; j++) {
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
						
						Loader.getInstance().startBell(0);
					}//if mi esfera actual es la misma que la anterior de la lista
					else if (!(esferas[i][j].getActivo())) {
						if  (esferas[i][j].getValor() == sumatoriaValores || (esfNum > 0 && esfLista[esfNum].getValor() == esferas[i][j].getValor())) {
							int direccion = retornarDireccion(i, j);
							if (direccion != 0) {
								sumatoriaValores += esferas[i][j].getValor();
								esfNum++;
								esferas[i][j].setActivo(true);
								esfLista[esfNum] = esferas[i][j];
								Loader.getInstance().startBell(1);
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
					esfLista = new Esfera[MAX_FILAS * MAX_COLUMNAS];
					esfNum++;
					esferas[i][j].setActivo(true);
					esfLista[esfNum] = esferas[i][j];
					sumatoriaValores = esferas[i][j].getValor();
					Loader.getInstance().startBell(1);
				}
			}//mousePressed
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if (!pausa) {
					if (esfNum > 0) {
						pausa = true;
						esfLista[esfNum].setValor(sumatoriaValores);
						esfLista[esfNum].setActivo(false);
						
						for (int j = 0; j < MAX_COLUMNAS; j++) {
							for (int i = (MAX_FILAS - 1); i >= 0; i--) {
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
						
						Loader.getInstance().startBell(2);

						EntornoJuego.getInstance().actualizarPuntaje(sumatoriaValores);
						if (!hayJugadasDisponibles()) {
							EntornoJuego.getInstance().finDeJuego();
						}
						
						if (esfLista[esfNum].getValor() > mayorValor) {
							mayorValor = esfLista[esfNum].getValor();
						}
						
						pausa = false;
					}//esfNum > 0
					
					else {
						Loader.getInstance().startBell(0);
						esfLista[esfNum].setActivo(false);
					}
				}//if !pausa
				
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
			
			if (aux >= 0 && aux < 16) //80% de que se genere una esfera que este de 2 a  a la mayor
				aux = ((int) ((Math.random() + 0.01d) * mayorValor));
			
			else //20% de que se genere una esfera del 2 al 8
				aux = ((int) (Math.random() * 8) + 1);
			
			esferita = new Esfera(aux);
			esferita.setLocation((distX * j) + 105, -85);
			add(esferita);
			
			try {
				Thread.sleep(20);
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
	
	private int retornarDireccion(int i, int j) {
		int direccion = 0;
		
		if ((i > 0) && (j > 0) && esferas[i-1][j-1] == esfLista[esfNum]) //sup izq
			direccion = 1;
		else if ((i > 0) && esferas[i-1][j] == esfLista[esfNum]) //arriba
			direccion = 2;
		else if ((i > 0) && (j < MAX_COLUMNAS - 1) && esferas[i-1][j+1] == esfLista[esfNum])//sup der
			direccion = 3;
		else if ((j > 0) && esferas[i][j-1] == esfLista[esfNum]) //izq
			direccion = 4;
		else if ((j < MAX_COLUMNAS - 1) && esferas[i][j+1] == esfLista[esfNum]) //der
			direccion = 5;
		else if ((i < MAX_FILAS - 1) && (j > 0) && esferas[i+1][j-1] == esfLista[esfNum]) //inf izq
			direccion = 6;
		else if ((i < MAX_FILAS - 1) && esferas[i+1][j] == esfLista[esfNum]) //abajo
			direccion = 7;
		else if ((i < MAX_FILAS - 1) && (j < MAX_COLUMNAS - 1) && esferas[i+1][j+1] == esfLista[esfNum]) //inf der
			direccion = 8;
		
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
		for (int i = 0; i < MAX_FILAS; i++) {
			for (int j = 0; j < MAX_COLUMNAS && jugadas!=true; j++) {
				if ((i > 0) && (j > 0) && esferas[i][j].getValor() == esferas[i-1][j-1].getValor())  //diag sup izq
					jugadas = true;
				
				else if ((i > 0) && esferas[i][j].getValor() == esferas[i-1][j].getValor())  //arriba
					jugadas = true;
				
				else if ((i > 0) && (j < MAX_COLUMNAS - 1) && esferas[i][j].getValor() == esferas[i-1][j+1].getValor())  //diag sup der
					jugadas = true;
				
				else if ((j > 0) && esferas[i][j].getValor() == esferas[i][j-1].getValor())  //izq
					jugadas = true;
				
				else if ((j < MAX_COLUMNAS - 1) && esferas[i][j].getValor() == esferas[i][j+1].getValor())  //der
					jugadas = true;
				
				else if ((i < MAX_FILAS - 1)  && (j > 0) && esferas[i][j].getValor() == esferas[i+1][j-1].getValor())  //diag inf izq
					jugadas = true;
				
				else if ((i < MAX_FILAS - 1) && esferas[i][j].getValor() == esferas[i+1][j].getValor())  //abajo
					jugadas = true;
				
				else if ((i < MAX_FILAS - 1) && (j < MAX_COLUMNAS - 1) && esferas[i][j].getValor() == esferas[i+1][j+1].getValor()) //diag inf der
					jugadas = true;
			}//for j
		}//for i
		return jugadas;
	}//hayJugadasDisponibles
}
