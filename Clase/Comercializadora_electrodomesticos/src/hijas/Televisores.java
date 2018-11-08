package hijas;

import padres.Productos;
import padres.Fecha;

public class Televisores extends Productos {
	private int tamanhoPulgadas;
	private int numPuertosHDMI;
	
	public Televisores() {
		this.setMarca("");
		this.setModelo("");
		this.setColor("");
		this.setSerial("");
		this.setCostoAdquisicion( 0.0f);
		this.setPrecioVenta(0.0f);
		this.setFechaDespacho(new Fecha(0, 0, 0));
		this.tamanhoPulgadas = 0;
		this.numPuertosHDMI = 0;
	}
	
	public Televisores(String marca, String modelo, String color, String serial, float costoAdquisicion, float precioVenta, Fecha fechaDespacho, int tamanhoPulgadas, int numPuertosHDMI) {
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setColor(color);
		this.setSerial(serial);
		this.setCostoAdquisicion(costoAdquisicion);
		this.setPrecioVenta(precioVenta);
		this.setFechaDespacho(fechaDespacho);
		this.tamanhoPulgadas = tamanhoPulgadas;
		this.numPuertosHDMI = numPuertosHDMI;
	}
	
	public int getTamanhoPulgadas() {
		return tamanhoPulgadas;
	}
	public void setTamanhoPulgadas(int tamanhoPulgadas) {
		this.tamanhoPulgadas = tamanhoPulgadas;
	}
	public int getNumPuertosHDMI() {
		return numPuertosHDMI;
	}
	public void setNumPuertosHDMI(int numPuertosHDMI) {
		this.numPuertosHDMI = numPuertosHDMI;
	}

	public String obtenerDatos() {
		return ("Marca: " + getMarca() + "\tModelo: " + getModelo() + "\tColor: " + getColor() + "\tCosto: " + getCostoAdquisicion() + "\tPrecio de venta: " + getPrecioVenta() + "\tFecha de despacho: " + (getFechaDespacho().dia + "\\" + getFechaDespacho().mes + "\\" + getFechaDespacho().anho) + "\tTamanho: " + tamanhoPulgadas + "pulgadas" + "\tNumero de puertos HDMI: " + numPuertosHDMI);
	}
	
	
	
}
