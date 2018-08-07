package hijas;

import padres.Transaccion;

public class Retiro extends Transaccion {
	
	public Retiro(int tipo, double monto) {
		super(tipo, monto);
	}
	
	public double getMonto() {
		return 0; //no sirve de nada si monto en transaccion es privado
	}
	
	public void mostrar() {
		System.out.println("Tipo de transaccion: retiro");
		super.mostrar();
		System.out.println("Estado: "+(super.getTipo()==1? "correcta.":"fallida."));
	}
	
}
