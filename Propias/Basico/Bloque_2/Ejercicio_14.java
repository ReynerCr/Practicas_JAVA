import javax.swing.JOptionPane;

public class Ejercicio_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Pedir una nota de 0 a 10 y mostrarla de la forma: insuficiente, suficiente, bien, notable y sobresaliente.
		float nota;
		nota = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la calificación."));
		
		if (nota<0 || nota>10) {
			JOptionPane.showMessageDialog(null, "No es una calificación admitida");
		}
		
		else {
			if (nota<4.5) {
				JOptionPane.showMessageDialog(null, "Insuficiente.");
			}
			else if (nota>=4.5 && nota<6)  {
				JOptionPane.showMessageDialog(null, "Suficiente.");
			}
			else if (nota>=6 && nota<8) {
				JOptionPane.showMessageDialog(null, "Bien.");
			}
			else if (nota>=8 && nota<9.5) {
				JOptionPane.showMessageDialog(null, "Notable.");
			}
			else if (nota>=9.5) {
				JOptionPane.showMessageDialog(null, "Sobresaliente.");
			}
		}//else
		
	}//main
	
}//class
