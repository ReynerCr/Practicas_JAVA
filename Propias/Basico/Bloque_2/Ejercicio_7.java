import javax.swing.JOptionPane;

public class Ejercicio_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* SUELDO SEMANAL DE OBRERO
		 * Si trabaja 40 horas o menos, se le paga 16$ por hora
		 * Si trabaja más de 40 horas, se le paga 16$ por las 40 primeras horas, y 20$ por cada hora extra.
		 */
		int horas, sueldo;
		horas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de horas trabajadas"));
		
		if (horas < 41) {
			sueldo = horas * 16;
			
		}
		else {
			sueldo = (40 * 16) + ((horas - 40) * 20);
		}
		JOptionPane.showMessageDialog(null, "El sueldo será de "+sueldo+"$");
	}
}
