import javax.swing.JOptionPane;

public class Ejercicio_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TOMAR DOS NUMEROS Y DECIR SI AMBOS SON PARES O IMPARES
		float numero1, numero2;
		
		numero1 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el primer numero"));
		numero2 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el segundo numero"));
		
		if (numero1%2==0 && numero2%2==0) {
			JOptionPane.showMessageDialog(null, +numero1+" y " +numero2+" son numeros pares");
		}
		else if (numero1%2!=0 && numero2%2!=0) {
			JOptionPane.showMessageDialog(null, +numero1+" y " +numero2+" son numeros impares");
		}
		else {
			JOptionPane.showMessageDialog(null, +numero1+" y " +numero2+" no son a la vez pares o impares.");
		}
	}
}
