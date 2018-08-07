package hijas;

import padres.Cuenta;
import padres.Transaccion;
//intereses
public class CuentaAhorros extends Cuenta {
	
	
	public CuentaAhorros() {
		super(" ", " ", 0.0);
	}

	public CuentaAhorros(String cliente, String cuenta, double saldo) {
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
