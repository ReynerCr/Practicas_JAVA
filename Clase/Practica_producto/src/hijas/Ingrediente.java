package hijas;

import java.io.IOException;
import java.util.Scanner;

import padre.Producto;

public class Ingrediente {
	
	public static Scanner entrada = new Scanner(System.in);
	
	private String codigo;
	private String nombre;
	private String unidadMedida;
	private float costo;
	private float precio;
	
	
	public Ingrediente() {
		this.codigo = "";
		this.nombre = "";
		this.unidadMedida = "";
		this.costo = 0.0f;
		this.precio = 0.0f;
	}

	public Ingrediente(String codigo, String nombre, String unidadMedida, float costo, float precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.unidadMedida = unidadMedida;
		this.costo = costo;
		this.precio = precio;
	}
	
	
	public String getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public float getCosto() {
		return costo;
	}
	public float getPrecio() {
		return precio;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	public void cargarDatos() throws IOException {
		System.out.println("Ingrese los datos del ingrediente.");
		System.out.print("Ingrese codigo: "); codigo = Producto.valCodigo();
		System.out.print("Nombre: "); nombre = entrada.next();
		System.out.print("Unidad de medida: "); unidadMedida = entrada.next();
		System.out.print("Costo: "); costo = entrada.nextFloat();
		calcularPrecio();
	}
	
	public void mostrarDatos() {
		System.out.println("Codigo: "+codigo);
		System.out.println("Nombre: "+nombre);
		System.out.println("Unidad de medida: "+unidadMedida);
		System.out.println("Costo: "+costo);
		System.out.println("Precio: "+precio);
	}
	
	public String mostDatEnLinea() {
		return (codigo+"\t"+nombre+"\t"+unidadMedida+"\t"+costo+"\t"+precio);
	}
	
	public void calcularPrecio() {
		this.precio = (this.costo*1.40f)*1.12f;
	}

}
