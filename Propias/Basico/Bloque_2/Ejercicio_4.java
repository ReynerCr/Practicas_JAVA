import javax.swing.JOptionPane;

public class Ejercicio_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numero1, numero2;
		numero1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero"));
		numero2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero"));
		
		if (numero1 > numero2) {
			JOptionPane.showMessageDialog(null, "El primer numero "+numero1+" es mayor al segundo "+numero2);
		}
		
		else if (numero1 < numero2) {
			JOptionPane.showMessageDialog(null, "El segundo numero "+numero2+" es mayor al primero"+numero1);
		}  
		
		else if (numero1 == numero2) {
			JOptionPane.showMessageDialog(null, "Ambos numeros son iguales y son "+numero1);
		}
		
	}//public static
}//class
