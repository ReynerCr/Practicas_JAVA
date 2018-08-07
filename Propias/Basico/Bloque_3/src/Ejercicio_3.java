import javax.swing.JOptionPane;

public class Ejercicio_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ingresar numeros y determinar si son pares o impares; 0 para salir.
		
		int numero;
		numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));
		while (numero!=0) {
			if (numero%2==0) {
				System.out.println("El numero "+numero+" es par");
			}
			else {
				System.out.println("El numero "+numero+" es impar");
			}
			numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese otro numero"));
		}
	}

}
