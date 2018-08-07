import javax.swing.JOptionPane;

public class Ejercicio_16 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		//pasar de kg a otra unidad de masa.
		
		float kg, valor;
		int opcion;
		
		kg = Float.parseFloat(JOptionPane.showInputDialog("Ingrese cuantos kg"));
		opcion = Integer.parseInt(JOptionPane.showInputDialog("Programa para convertir kg a otras unidades de masa."
				+ "\n\n1. Kilogramos a miligramos."
				+ "\n2. Kilogramos a centigramos."
				+ "\n3. Kilogramos a decigramos."
				+ "\n4. Kilogramos a gramos."
				+ "\n5. Kilogramos a decagramos."
				+ "\n6. Kilogramos a hectogramos."));

		switch (opcion) {
			case 1: valor = kg * 1000000;
			JOptionPane.showMessageDialog(null, "El resultado es de "+valor+"mg");
				break;
				
			case 2: valor = kg * 100000;
			JOptionPane.showMessageDialog(null, "El resultado es de "+valor+"cg");
				break;
				
			case 3: valor = kg * 10000;
			JOptionPane.showMessageDialog(null, "El resultado es de "+valor+"dc");
				break;
				
			case 4: valor = kg * 1000;
			JOptionPane.showMessageDialog(null, "El resultado es de "+valor+"g");
				break;
				
			case 5: valor = kg * 100;
			JOptionPane.showMessageDialog(null, "El resultado es de "+valor+"Dc");
				break;
				
			case 6: valor = kg * 10;
			JOptionPane.showMessageDialog(null, "El resultado es de "+valor+"hg");
				break;
				
			default:
				JOptionPane.showMessageDialog(null, "La opción ingresada no es correcta.");
				break;
		}//switch
	
	}//main

}//class
