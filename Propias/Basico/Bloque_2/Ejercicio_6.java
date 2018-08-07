import javax.swing.JOptionPane;

public class Ejercicio_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//EJERCICIO DEL MEGAPLAZA, SE HACE 20% DE DESCUENTO A PERSONAS CUYA COMPRA SUPERE 300$ 
		float pago;
		pago = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor de la compra"));
		
		if (pago > 300) {
			pago -= (pago * 0.20); 
		}
		JOptionPane.showMessageDialog(null, "El valor es de: "+pago);
	}
}
