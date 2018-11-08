package hijas;

import padres.Productos;
import padres.Fecha;

public class Celulares extends Productos {
	private int capacidadMemoria;
	private String tipoInteractividad;
	
	
		
	public Celulares() {
		this.setMarca("");
		this.setModelo("");
		this.setColor("");
		this.setSerial("");
		this.setCostoAdquisicion( 0.0f);
		this.setPrecioVenta(0.0f);
		this.setFechaDespacho(new Fecha());
		this.capacidadMemoria = 0;
		this.tipoInteractividad = "";
	}

	public Celulares(String marca, String modelo, String color, String serial, float costoAdquisicion, float precioVenta, Fecha fechaDespacho, int capacidadMemoria, String tipoInteractividad) {
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setColor(color);
		this.setSerial(serial);
		this.setCostoAdquisicion(costoAdquisicion);
		this.setPrecioVenta(precioVenta);
		this.setFechaDespacho(fechaDespacho);
		this.capacidadMemoria = capacidadMemoria;
		this.tipoInteractividad = tipoInteractividad;
	}
	
	public int getCapacidadMemoria() {
		return capacidadMemoria;
	}
	public void setCapacidadMemoria(int capacidadMemoria) {
		this.capacidadMemoria = capacidadMemoria;
	}
	public String getTipoInteractividad() {
		return tipoInteractividad;
	}
	public void setTipoInteractividad(String tipoInteractividad) {
		this.tipoInteractividad = tipoInteractividad;
	}
	
	
}
