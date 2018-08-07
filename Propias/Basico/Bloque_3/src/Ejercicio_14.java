import javax.swing.JOptionPane;

public class Ejercicio_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Pedir 10 sueldos. Mostrar su suma y decir cuantos hay mayores de 1000$
		
		int mayores=0;
		float sueldo, suma=0;
		
		for (int i=0; i<10; i++) {
			
			sueldo = Float.parseFloat(JOptionPane.showInputDialog("Ingrese sueldo"));
			
			while (sueldo <= 0) {
				sueldo = Float.parseFloat(JOptionPane.showInputDialog("No válido, ingrese otro sueldo"));
			}
			
			suma += sueldo;
			
			if (sueldo > 1000) {
				mayores++;
			}
		}
		System.out.println("La suma de los sueldos es de: "+suma);
		System.out.println("Sueldos mayores de 1000$: "+mayores);
		
	}

}
