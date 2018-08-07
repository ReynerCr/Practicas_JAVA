package hijas;

import padres.Transaccion;

public class Deposito extends Transaccion {
	
	public Deposito(int tipo, double monto) {
		super(tipo, monto);
	}
	
	public double getMonto() {
		return 0; //no sirve de nada si monto en transaccion es privado
	}
	
	public void mostrar() {
		System.out.println("Tipo de transaccion: deposito.");
		super.mostrar();
		System.out.println("Estado: "+(super.getTipo()==1? "correcta.":"fallida."));
	}

}
