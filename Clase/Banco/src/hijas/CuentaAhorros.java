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
		Transaccion transaccionesaux [] = new Transaccion[super.getTransacciones().length+1];
		System.arraycopy(super.getTransacciones(), 0, transaccionesaux, 0, super.getTransacciones().length);
		transaccionesaux[super.getTransacciones().length-1] = t;
		
		super.setTransacciones(transaccionesaux);
	}
	
	public void mostrarEstadoCuenta() {
		System.out.println("Consultar cuenta.");
		System.out.println("Tipo de cuenta: ahorro.");
		super.mostrarEstadoCuenta();
		
		if (super.getUnaTransaccion(0)==null)
			System.out.println("No hay registros de transacciones guardados.");
		
		else {
			System.out.println("\tTransacciones:");
		
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
			
		}//else para cuando hay transacciones
	}//mostrarEstadoCuenta

}
