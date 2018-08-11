package hijas;

import padres.Producto;

public abstract class Lacteos extends Producto {
	
	public Lacteos() {
		super();
	}

	public Lacteos(String codigo, String descripcion, int cantidadEnExistencia, float costo, float venta) {
		super(codigo, descripcion, cantidadEnExistencia, costo, venta);
	}
	
}
