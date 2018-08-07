import javax.swing.JOptionPane;

public class Ejercicio_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int edad, suma_edad=0, mayores_18=0, alumnos_altos=0;
		float altura, suma_altura=0, media_edad, media_altura;
		
		JOptionPane.showMessageDialog(null, "Programa para hacer cosas varias.");
		
		for (int i=1; i<=5; i++) {
			
			edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del alumno "+i));
			
			while (edad<=0) {
				edad = Integer.parseInt(JOptionPane.showInputDialog("Valor no valido. Reingrese la edad del alumno "+i));
			}//while edad
			
			altura = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la altura del alumno "+i));
			
			while (altura<=0) {
				altura = Float.parseFloat(JOptionPane.showInputDialog("Valor no valido. Reingrese la altura del alumno "+i));
			}//while altura
			
			suma_edad += edad;
			suma_altura += altura;
			
			if (edad > 18) {
				mayores_18++;
			}
			if (altura > 1.75) {
				alumnos_altos++;
			}
			
		}//for
		
		media_edad = (float) suma_edad/5;
		media_altura = suma_altura/5;
		System.out.println("Media de edades: "+media_edad+"\n"
				+ "Media de alturas: "+media_altura+"\n"
				+ "Alumnos mayores de 18: "+mayores_18
				+ "\nAlumnos que miden más de 1.75: "+alumnos_altos);
		
	}

}
