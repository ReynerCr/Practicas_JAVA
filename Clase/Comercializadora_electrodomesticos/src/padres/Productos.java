package padres;

import padres.Fecha;

public abstract class Productos {
	private String marca;
	private String modelo;
	private String color;
	private String serial;
	private float costoAdquisicion;
	private float precioVenta;
	private Fecha fechaDespacho;
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public float getCostoAdquisicion() {
		return costoAdquisicion;
	}
	public void setCostoAdquisicion(float costoAdquisicion) {
		this.costoAdquisicion = costoAdquisicion;
	}
	public float getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}
	public Fecha getFechaDespacho() {
		return fechaDespacho;
	}
	public void setFechaDespacho(Fecha fechaDespacho) {
		if (this.fechaDespacho == null) {
			this.fechaDespacho = new Fecha();
		}
		
		this.fechaDespacho.dia = fechaDespacho.dia;
		this.fechaDespacho.mes = fechaDespacho.mes;
		this.fechaDespacho.anho = fechaDespacho.anho;
	}
}
