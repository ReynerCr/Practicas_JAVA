package datos;

import java.util.Scanner;
import java.util.StringTokenizer;

import utilerias.*;

public class Sucursal implements ManipulacionDatos {
	private String codigo;
	private String nombre;
	private String ciudad;
	
	
	public Sucursal() {
		this.codigo = "";
	}

	public Sucursal(String codigo, String nombre, String ciudad) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.ciudad = ciudad;
	}
	
	public Sucursal(Sucursal sucursal) {
		this.codigo = sucursal.getCodigo();
		this.nombre = sucursal.getNombre();
		this.ciudad = sucursal.getCiudad();
	}
	
	public Sucursal(Scanner archivo) {
		StringTokenizer tokenizer = new StringTokenizer(archivo.nextLine());
		leerDatos(archivo, tokenizer);
	}
	
	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	
	@Override
	public void mostrarDatos() {
		System.out.println("Sucursal:");
		System.out.println("Codigo: " + codigo);
		System.out.println("Nombre: " + nombre);
		System.out.println("Ciudad: " + ciudad);
	}//mostrarDatos

	@Override
	public void leerDatos(Scanner archivo, StringTokenizer tokenizer) {
		codigo = tokenizer.nextToken();
		nombre = tokenizer.nextToken(); nombre = Utilidades.separarCad(nombre);
		ciudad = tokenizer.nextToken(); ciudad = Utilidades.separarCad(ciudad);
	}
}//class Sucursal
