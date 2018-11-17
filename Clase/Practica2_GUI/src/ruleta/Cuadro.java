package ruleta;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Cuadro extends JLabel {
	private char letra;
	private boolean adivinada;
	private ImageIcon icono;
	
	public Cuadro (char letra) {
		this.letra = letra;
		adivinada = false;
		if (letra != ' ')
			icono = CargadorDeImagenes.getInstancia().getImagen(CargadorDeImagenes.CUADRO_AMARILLO);
		else 
			icono = CargadorDeImagenes.getInstancia().getImagen(CargadorDeImagenes.CUADRO_BLANCO);
		this.setIcon(icono);
	}//Cuadro(char)
	
	public Cuadro () {
		this.letra = ' ';
		adivinada = false;
		icono = CargadorDeImagenes.getInstancia().getImagen(CargadorDeImagenes.CUADRO_BLANCO);
		this.setIcon(icono);
	}//Cuadro(char)
	
	public void setLetra(char letra) {
		this.letra = letra;
	}//setLetra(char)
	
	public void setAdivinada(char caracter) { //se supone que solo se invocara este metodo para hacerla true
		if (letra != ' ') {
			adivinada = true;
			int pos = 0;
			if (((int) caracter) > 100) {
				pos = 16; //donde esta posicionada la enye
			}
			else {
				pos = ((int) caracter - 65) + CargadorDeImagenes.LETRAS_INICIO;
				if (pos >= 16)
					pos++;
			}//else
			
			icono = CargadorDeImagenes.getInstancia().getImagen(pos);
			this.setIcon(icono);
		}//if letra != ' '; o sea que desde un principio era cuadro blanco,
		
		else {
			System.out.println("Esto no debio ocurrir, la letra es: " + caracter);
		}//else
	}//setAdivinada()
	
	public char getLetra() {
		return letra;
	}//getLetra()
	
	public boolean getAdivinada() {
		return adivinada;
	}//getAdivinada()
	
}//Cuadro
