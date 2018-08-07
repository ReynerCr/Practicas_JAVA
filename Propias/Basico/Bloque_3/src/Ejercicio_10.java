import javax.swing.JOptionPane;

public class Ejercicio_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Pedir 10 numeros y mostrar la suma total
		
		int numero, suma=0;
		
		for (int i=0; i<=10; i++) {
			numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));
			suma += numero;
		}
		
		JOptionPane.showMessageDialog(null, "La suma total es de: "+suma);
	}

}
