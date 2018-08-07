package padres;

import padres.Transaccion;

public abstract class Cuenta {
	
	private Transaccion transacciones[] = new Transaccion[1];
	
	private String cliente;
	private String cuenta;
	private double saldo;
	
	public Cuenta() {
		cliente = " ";
		cuenta = " ";
		saldo = 0.0;
	}

	public Cuenta(String cliente, String cuenta, double saldo) {
		this.cliente = cliente;
		this.cuenta = cuenta;
		this.saldo = saldo;
	}
	

	public String getCliente() {
		return cliente;
	}

	public String getCuenta() {
		return cuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public Transaccion getUnaTransaccion(int i) {
		return this.transacciones[i];
	}
	
	public Transaccion[] getTransacciones() {
		return this.transacciones;
	}
	
	public void setUnaTransaccion(int i, Transaccion t) {
		Transaccion transaccionesaux [] = new Transaccion[transacciones.length+1];
		System.arraycopy(transacciones, 0, transaccionesaux, 0, transacciones.length);
		transacciones = transaccionesaux;
		
		transacciones[i] = t;
	}
	
	public abstract void addTransaccion(Transaccion t);
	
	public void mostrarEstadoCuenta() {
		System.out.println("Cliente: "+cliente);
		System.out.println("Numero de cuenta: "+cuenta);
		System.out.println("Saldo: "+saldo);
	}
	
	
}
