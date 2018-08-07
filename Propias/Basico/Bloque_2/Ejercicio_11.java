import javax.swing.JOptionPane;

public class Ejercicio_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//COMPROBAR UNA FECHA
		int dia, mes, anno;
		
		dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dia"));
		mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes"));
		anno = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el anno"));
		
		if ((dia < 1 || dia > 30) || (mes < 1 || mes > 12) || (anno != 0)) {
			if (dia < 1 || dia > 30) {
				JOptionPane.showMessageDialog(null, "Dia no valido");
			}
			if (mes < 1 || mes > 12) {
				JOptionPane.showMessageDialog(null, "Mes no valido");
			}
			if (anno != 0) {       //AÑO CERO SUPUESTAMENTE NO EXISTE.
				JOptionPane.showMessageDialog(null, "anno no valido");
			}
		}//IF PRINCIPAL
		
		else {
			JOptionPane.showMessageDialog(null, "La fecha es "+dia+"/"+mes+"/"+anno);
		}//ELSE
		
	}//MAIN
}//CLASS
