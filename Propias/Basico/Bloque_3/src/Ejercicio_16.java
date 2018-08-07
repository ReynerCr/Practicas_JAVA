import javax.swing.JOptionPane;

public class Ejercicio_16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Pedir un numero 0-10 y mostrar la tabla de multiplicar del mismo
		
		int numero;
		
		do {
			numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero entre 0 y 10"));
		} while (numero<0 || numero>10);
			
		System.out.println("TABLA DE MULTIPLICAR DEL "+numero+"\n");
		for (int i=1; i<=10; i++) {
			System.out.println(numero+"x"+i+"="+numero*i);
		}
		
	}

}
