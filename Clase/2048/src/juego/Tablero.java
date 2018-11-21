package juego;

import java.awt.Color;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Tablero extends JPanel {
	Esfera esferas[][];
	
	public Tablero() {
		this.setLayout(null);
		this.setOpaque(false);
		
		iniciarEsferas();
	}
	
	private void iniciarEsferas() {
		esferas = new Esfera[7][5];  
		
		int x, y;
		for (int i = 0; i < 7; i++) {
			y = (80*i) + 30;
			
			for (int j = 0; j < 5; j++) {
				x = (80 * j) + 105;
				
				int aux = (int) (Math.random() * 8) + 1;
				esferas[i][j] = new Esfera(aux);
				esferas[i][j].setLocation(x, y);
				this.add(esferas[i][j]);
			}//for j
		}//for i
	}//iniciarEsferas()
	
	
}
