import javax.swing.JOptionPane;

public class Ejercicio_19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Pedir 10 numeros y al final decir si se introdujo uno negativo
		int numero;
		boolean hay_negativos = false;
		
		for (int i=1; i<=10; i++) {
			numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero"));
			if (numero < 0) {
				hay_negativos = true;
			}
		}
		
		if (hay_negativos == true) {
			JOptionPane.showMessageDialog(null,"Si existe algun numero negativo");
		}
			
		
		else {
			JOptionPane.showMessageDialog(null,"No existe ningun numero negativo");
		}
			
	}

}
