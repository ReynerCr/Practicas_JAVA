import javax.swing.JOptionPane;

public class Ejercicio_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Juego de adivinar numero aleatorio, decirle al usuario si es mayor o menor al ingresado y contar
		 * cuantas veces ingresó números.
		 */
		
		int numero, contador=0, aleatorio;
		
		aleatorio = (int) (Math.random()*100);
		numero = Integer.parseInt(JOptionPane.showInputDialog("Juego de adivinar el número. "
				+ "Ingrese un número entre 0 y 100"));
		
		while (numero!=aleatorio) {
			
			if (numero>=0 && numero<=100) {
				contador++;
				if (numero>aleatorio) {
					numero = Integer.parseInt(JOptionPane.showInputDialog(numero+" es mayor al número. Ingrese otro"));
				}
				else if (numero<aleatorio) {
					numero = Integer.parseInt(JOptionPane.showInputDialog(numero+" es menor al número. Ingrese otro"));
				}
			}
			
			else {
				numero = Integer.parseInt(JOptionPane.showInputDialog("Número no válido, ingrese otro"));
				
			}
		}
		
		contador++;
	
		JOptionPane.showMessageDialog(null, "Felicitaciones, el número era "+aleatorio+""
				+ "\nLas veces que intentó fueron de "+contador);
		
	}

}
