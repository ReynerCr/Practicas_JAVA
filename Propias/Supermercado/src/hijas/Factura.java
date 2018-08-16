package hijas;

import padres.Producto;
import hijas.*;

public class Factura {
	private char nacionalidad;
	private int cedula;
	private Producto[] prod = new Producto[30];
	
	public char getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(char nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
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
	public void setProd(Producto[] prod) {
		this.prod = prod;
	}
	public void setProd(Producto prod, int i) {
		this.prod[i] = prod;
	}
}
