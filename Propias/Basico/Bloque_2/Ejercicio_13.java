import javax.swing.JOptionPane;

public class Ejercicio_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero1, numero2, valor=0;
		char letra;
		
		
		numero1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer número."));
		numero2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo número."));
		letra = JOptionPane.showInputDialog("¿Qué tipo de operación desea realizar?").charAt(0);
		
		if (letra == 's' || letra == 'S') {
			valor = numero1 + numero2;
			JOptionPane.showMessageDialog(null, "Valor="+valor);
		}
		else if (letra == 'r' || letra == 'R') {
			valor = numero1 - numero2;
			JOptionPane.showMessageDialog(null, "Valor="+valor);
		}
		else if (letra == 'm' || letra == 'M' || letra == 'p' || letra == 'P') {
			valor = numero1 * numero2;
			JOptionPane.showMessageDialog(null, "Valor="+valor);
		}
		else if (letra == 'd' || letra == 'D') {
			valor = numero1 / numero2;
			JOptionPane.showMessageDialog(null, "Valor="+valor);
		}
		else {
			JOptionPane.showMessageDialog(null, "No es una operación válida.");
		}
		
	}//MAIN
}//CLASS
