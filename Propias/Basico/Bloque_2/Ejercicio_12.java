import javax.swing.JOptionPane;

public class Ejercicio_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Comprobar fecha pero con meses de 28, 30 y 31 dias (sin bisiestos pero yo se lo agrego).
		
		//28 dias o 29: febrero
		//30 dias: abril, junio, septiembre, noviembre
		//31 dias: enero, marzo, mayo, julio, agosto, octubre, diciembre
		
		int dia, mes, año;
		
		dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese dia"));
		mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese mes"));
		año = Integer.parseInt(JOptionPane.showInputDialog("Ingrese año"));
		
		if (dia >= 1 && dia <= 31) {
			if (mes >= 1 && mes <= 12) {
				if (año != 0) {
					if (mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12)  {
						JOptionPane.showMessageDialog(null, "La fecha es "+dia+"/"+mes+"/"+año);
					}//31
					else if (mes==2 && dia <= 29) {
						if (año % 4 == 0 && dia == 29) {
							JOptionPane.showMessageDialog(null, "BISIESTO, la fecha es "+dia+"/"+mes+"/"+año);
						}
						
						else {
							if (dia == 29) {
								JOptionPane.showMessageDialog(null, "No es bisiesto, dia incorrecto");
							}
							else {
								JOptionPane.showMessageDialog(null, "La fecha es "+dia+"/"+mes+"/"+año);
							}
						}
						
					}//febrero
					
					else if ((mes==4 || mes==6 || mes==9 || mes==11) && dia!=31) {
						JOptionPane.showMessageDialog(null, "La fecha es "+dia+"/"+mes+"/"+año);
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Fecha incorrecta");
					}
					
				}// if año
				else {
					JOptionPane.showMessageDialog(null, "Año incorrecto");
				}
			} //if mes
			else {
				JOptionPane.showMessageDialog(null, "Mes incorrecto");
			}
		}//if dia
		else {
			JOptionPane.showMessageDialog(null, "Dia incorrecto");
		}
	}//MAIN
}//CLASS
