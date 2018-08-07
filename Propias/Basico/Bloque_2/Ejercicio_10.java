import javax.swing.JOptionPane;

public class Ejercicio_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Numero entre 0 y 99999 y decir cuantas cifras tiene
		
		float numero;
		
		numero = Float.parseFloat(JOptionPane.showInputDialog("Ingrese un numero entre 0 y 99999"));
		if (numero < 0 || numero > 99999) {
			JOptionPane.showMessageDialog(null, "No es un numero valido, fin de programa");
		}//if
		
		else {
			if (numero / 10 < 1) {
				JOptionPane.showMessageDialog(null, "1 cifra");
			}
			else if (numero / 100 < 1) {
				JOptionPane.showMessageDialog(null, "2 cifras");
			}
			else if (numero / 1000 < 1) {
				JOptionPane.showMessageDialog(null, "3 cifras");
			}
			else if (numero / 10000 < 1) {
				JOptionPane.showMessageDialog(null, "4 cifras");
			}
			else if (numero / 100000 < 1) {
				JOptionPane.showMessageDialog(null, "5 cifras");
			}
		}//else
		
	}//main
}//class
