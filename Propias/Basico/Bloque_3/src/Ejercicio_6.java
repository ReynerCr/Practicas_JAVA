import javax.swing.JOptionPane;

public class Ejercicio_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Pedir numeros hasta que se teclee 0; sumarlos todos y mostrar el resultado.
		
		int numero, total=0;
		do {
			numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));
			total += numero;
		} while (numero!=0);
		JOptionPane.showMessageDialog(null, "El total es de "+total);
	}

}
