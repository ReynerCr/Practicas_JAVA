package implementacion;

import padres.Producto;

public class Factura {
	private int cedula;
	private Producto[] prod = new Producto[30];
	
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public Producto[] getProd() {
		return prod;
	}
	public Producto getProd(int i) {
		return prod[i];
	}	
	
}//class Factura
