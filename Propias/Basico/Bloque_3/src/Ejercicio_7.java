import javax.swing.JOptionPane;

public class Ejercicio_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Pedir numeros hasta que se introduzca uno negativo y calcular la media.
		
		int numero, elementos=0, total=0;
		float media;
		
		numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero"));
		
		while (numero >= 0) {
		   total += numero;
		   elementos++;
		   numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero"));
		}
		if (elementos == 0) {
			JOptionPane.showMessageDialog(null, "La división entre cero no es posible");
		}
		else {
			media = total/elementos;
			JOptionPane.showMessageDialog(null, "La media es de: "+media);
		}
	}

}
