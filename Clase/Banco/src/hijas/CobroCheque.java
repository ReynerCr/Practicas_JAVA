package hijas;

import padres.Transaccion;

public class CobroCheque extends Transaccion {

	public CobroCheque(double monto) {
		super(monto);
	}
	
	public double getMonto() {
		return 0; //no sirve de nada si monto en transaccion es privado
	}
	
	public void mostrar() {
		System.out.println("Tipo de transaccion: cobro de cheque.");
		super.mostrar();
	}

}
