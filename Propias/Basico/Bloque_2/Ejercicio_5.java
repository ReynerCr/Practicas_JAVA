import javax.swing.JOptionPane;

public class Ejercicio_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char letra;
		
		letra = JOptionPane.showInputDialog("Ingrese una letra").charAt(0);
		if (Character.isUpperCase(letra)) {
			JOptionPane.showMessageDialog(null, "Es una letra mayuscula");
		}
		else {
			JOptionPane.showMessageDialog(null, "Es una letra minuscula o no es una letra");
		}
	}
}
