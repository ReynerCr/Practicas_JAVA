import javax.swing.JOptionPane;

public class Ejercicio_20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Pedir 5 calificaciones de alumnos y decir si hay algún suspenso (0-10)
		float calificacion;
		boolean suspensos = false;
		
		for (int i=1; i<=5; i++) {
			do {
				calificacion = Float.parseFloat(JOptionPane.showInputDialog("Calificación del alumno "+i+":"));
			} while (calificacion < 0 || calificacion > 10);
			
			if (calificacion < 4.5) {
				suspensos = true;
			}
		}
		
		if (suspensos == true) {
			JOptionPane.showMessageDialog(null, "Hay al menos un suspendido.");
		}
		else {
			JOptionPane.showMessageDialog(null, "No hay suspendidos.");
		}
	}

}
