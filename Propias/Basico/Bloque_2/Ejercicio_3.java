import javax.swing.JOptionPane;

public class Ejercicio_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Hacer un programa que lea un número entero y muestre si el número es múltiplo de 10.
		int numero;
		numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));
		if (numero % 10 == 0) {
			JOptionPane.showMessageDialog(null, "El numero "+numero+" es multiplo de 10");
		}
		else {
			JOptionPane.showMessageDialog(null, "El numero "+numero+ " NO es multiplo de 10");
		}
	}
}
