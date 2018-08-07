import javax.swing.JOptionPane;

public class Ejercicio_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero, dato = 5;
		numero = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero: ")); 
		
		if (numero == dato) {
			JOptionPane.showMessageDialog(null, "El numero es 5");
		}
		else {
			JOptionPane.showMessageDialog(null, "El numero es diferente de 5");
		}
		
	}
}
