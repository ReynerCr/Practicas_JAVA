package personas;

import java.util.Scanner;
import java.util.StringTokenizer;

import datos.ManipulacionDatos;

public class Cliente implements ManipulacionDatos {
	private String cedula;
	private String nombre;
	
	public Cliente() {
		this.cedula = "";
		this.nombre = "";
	}

	public Cliente(String cedula, String nombre) {
		this.cedula = cedula;
		this.nombre = nombre;
	}
	
	public Cliente(Scanner archivo) {
		StringTokenizer tokenizer = new StringTokenizer(archivo.nextLine());
		leerDatos(archivo, tokenizer);
	}

	public Cliente(Cliente cliente) {
		this.cedula = cliente.getCedula();
		this.nombre = cliente.getNombre();
	}

	public String getCedula() {
		return cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public void mostrarDatos() {
		System.out.println("Datos del cliente:");
		System.out.println("Cedula: " + cedula);
		System.out.println("Nombre: " + nombre);
	}//mostrarDatos

	@Override
	public void leerDatos(Scanner archivo, StringTokenizer tokenizer) {
		cedula = tokenizer.nextToken();
		nombre = tokenizer.nextToken() + " " + tokenizer.nextToken();
	}
	
	
}
