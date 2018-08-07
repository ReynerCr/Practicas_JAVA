import javax.swing.JOptionPane;

public class Ejercicio_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Cajero automático con 1000$ iniciales, ingresar dinero, retirar o salir.
		float saldo, movimiento;
		int opcion;
		saldo = 1000;
		
		opcion = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido al servicio de cajero automático,"
				+ " su saldo actual es de 1000$\nIngrese el número de la opción que desee realizar:"
				+ "\n\n1. Ingresar dinero a la cuenta.\n2. Retirar dinero de la cuenta.\n3. Salir."));
		
		switch (opcion) {
			case 1:  movimiento = Float.parseFloat(JOptionPane.showInputDialog("¿Cuánto dinero desea ingresar?"));	
				saldo += movimiento;
				JOptionPane.showMessageDialog(null, "Hecho. Su saldo actual es de "+saldo+"$");
				break;
				
			case 2:
				movimiento = Float.parseFloat(JOptionPane.showInputDialog("¿Cuánto dinero desea retirar?"));
				if (saldo-movimiento>=0) {
					saldo -= movimiento;
					JOptionPane.showMessageDialog(null, "Hecho. Su saldo actual es de "+saldo+"$");
				}
				else {
					JOptionPane.showMessageDialog(null, "Imposible efectuar el retiro (falta de fondos).\nSu saldo actual es de "+saldo+"$");
				}
				break;
				
			case 3:
				break;
				
			default:
				JOptionPane.showMessageDialog(null, "No es una opción válida.");;
				break;
		}
		JOptionPane.showMessageDialog(null, "Gracias por utilizar nuestros servicios.");
	}//MAIN

}//CLASS