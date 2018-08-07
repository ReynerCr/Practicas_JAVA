import javax.swing.JOptionPane;

public class Ejercicio_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float numero;
		
		do {
			numero = Float.parseFloat(JOptionPane.showInputDialog("Ingrese un numero"));
			if (numero < 0) {
				JOptionPane.showMessageDialog(null, "El numero "+numero+" es negativo.");
			}
			else if (numero>0) {
				JOptionPane.showMessageDialog(null, "El numero "+numero+" es positivo.");
			}
		} while (numero!=0);
	}

}
