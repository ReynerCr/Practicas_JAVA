package hijas;

import padres.Cuenta;
import padres.Transaccion;
import hijas.Deposito;
import hijas.Retiro;

public class CuentaCorriente extends Cuenta {
	
	public CuentaCorriente() {
		super(" ", " ", 0.0);
	}

	public CuentaCorriente(String cliente, String cuenta, double saldo) {
		super(cliente, cuenta, saldo);
	}

	public void addTransaccion(Transaccion t) {
		super.setUnaTransaccion(super.getTransacciones().length-1, t);
	}
	
	public void mostrarTransaccion() {
		Retiro ret;
		Deposito dep;
		for (int i=0; i<super.getTransacciones().length-1; i++) {
			System.out.print((i+1)+". ");
			if (getUnaTransaccion(i) instanceof Retiro) {
				ret = (Retiro) getUnaTransaccion(i);
				ret.mostrar();
			}
			else {
				dep = (Deposito) getUnaTransaccion(i);
				dep.mostrar();
			}			
			System.out.println();
		}//for
	}

}
