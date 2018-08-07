import javax.swing.JOptionPane;

public class Ejercicio_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Pedir un numero N y mostrar todos los números del 1 a N
		
		int N;
		
		N = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));
		
		for (int i=1; i<=N; i++) {
			System.out.println(i);
		}
		
	}

}
