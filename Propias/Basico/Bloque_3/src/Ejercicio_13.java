import javax.swing.JOptionPane;

public class Ejercicio_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Pedir 10 numeros. Mostrar la media de positivos y negativos y cantidad de ceros;
		
		int numero, suma=0, resta=0, negativos=0, positivos=0, ceros=0;
		float  media_positivos, media_negativos;
		
		for (int i=0; i<10; i++) {
			numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));
			
			if (numero == 0) {
				ceros++;
			}
			else if (numero < 0) {
				resta += numero;
				negativos++;
			}
			else if (numero > 0) {
				suma += numero;
				positivos++;
			}
		}
		
		if (positivos == 0) {
			System.out.println("No se puede sacar la media de positivos");
		}
		else {
			media_positivos = (float) suma/positivos;
			System.out.println("La media de los positivos es de: "+media_positivos);
		}
		
		if (negativos == 0) {
			System.out.println("No se puede sacar la media de negativos");
		}
		else {
			media_negativos = (float) resta/negativos;
			System.out.println("La media de los negativos es de: "+media_negativos);
		}
		
		if (ceros == 0) {
			System.out.println("No hubieron ceros");
		}
		else {
			System.out.println("La cantidad de ceros fue de: " +ceros);
		}
		
	}

}
