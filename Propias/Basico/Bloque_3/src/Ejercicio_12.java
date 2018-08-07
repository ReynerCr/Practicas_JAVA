import javax.swing.JOptionPane;

public class Ejercicio_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Pedir un número y calcular su factorial
		
		int numero, factorial=1;
		
		numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));
		
		for (int i=1; i<=numero; i++) {
			factorial *=i;
		}
		System.out.println("El factorial es: "+factorial);
	}

}
