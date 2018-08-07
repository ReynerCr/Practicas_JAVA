import javax.swing.JOptionPane;

public class Ejercicio_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Pedir numeros hasta que se ingrese uno negativo y mostrar cuantos numeros se introdujeron.
		
		int numero, contador=0;
		
		do {
			numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero; para salir ingrese un numro negativo"));
			if (numero>=0) {
				contador++;
			}
		} while (numero>=0);
		
		JOptionPane.showMessageDialog(null, "La cantidad de numeros ingresados es de "+contador);
		
	}

}
