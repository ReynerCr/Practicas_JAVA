import javax.swing.JOptionPane;

public class Ejercicio_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// leer un numero y mostrar su cuadrado, repetir el proceso hasta que se introduzca un negativo
		
		int numero, cuadrado;
		
		do {
			numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero a elevar"));
			if (numero<0) {
				JOptionPane.showMessageDialog(null, "Fin del programa.");
			}
			else {
				cuadrado = (int) Math.pow(numero, 2);
				JOptionPane.showMessageDialog(null, "Elevado al cuadrado es: "+cuadrado);
			}
		} while (numero>=0);
		
	}

}
