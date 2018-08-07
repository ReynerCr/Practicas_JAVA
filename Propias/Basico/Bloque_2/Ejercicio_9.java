import javax.swing.JOptionPane;

public class Ejercicio_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Ordenar 3 numeros de mayor a menor.
		
		int n1, n2, n3, mayor, medio, menor;
		mayor = 0;
		menor = 0;
		medio = 0;
		
		n1  = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero"));
		n2  = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero"));
		n3  = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tercer numero"));
		
		if (n1 >= n2 &&  n1 >= n3) {
			mayor = n1;
			
			if (n2 >= n3) {
				medio = n2;
				menor = n3;
			}
			
			else {
				medio = n3;
				menor = n2;
			}
		}//CASO N! >
		
		else if (n2 >= n1 && n2 >= n3) {
			mayor = n2;
			if (n1 >= n3) {
				medio = n1;
				menor = n3;
			}
			
			else {
				medio = n3;
				menor = n1;
			}
		}//CASO N2 >
		
		else if (n3 >= n1 && n3 >= n2) {
			mayor = n3;
			if (n1 >= n2) {
				medio = n1;
				menor = n2;
			}
			
			else {
				medio = n2;
				menor = n1;
			}
		}//CASO N3 >
		
		JOptionPane.showMessageDialog(null, "Mayor="+mayor+"; Medio="+medio+"; Menor="+menor);
	} // STATIC
} //CLASS
