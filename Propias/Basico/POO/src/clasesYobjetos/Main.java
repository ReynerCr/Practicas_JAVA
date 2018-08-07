package clasesYobjetos;

import javax.swing.JOptionPane;

public class Main {
	public static void main (String [] args) {
		int n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero: "));
		int n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero: "));
		
		Operacion op = new Operacion();
		
		System.out.println("La suma es: "+op.sumar(n1, n2));
		System.out.println("La resta es: "+op.restar(n1, n2));
		System.out.println("La multiplicacion es: "+op.multiplicar(n1, n2));
		System.out.println("La division es: "+op.dividir(n1, n2));
		  
	}
}
