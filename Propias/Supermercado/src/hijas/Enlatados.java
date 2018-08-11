package hijas;

import padres.Producto;

import java.util.InputMismatchException;

import implementacion.Utilidades;

public class Enlatados extends Producto {
	private String marca;
	private int unidades;
	
	public Enlatados() {
		super();
		marca = "";
		unidades = 0;
	}
	public Enlatados(String codigo, String descripcion, int cantidadEnExistencia, float costo, float venta, String marca, int unidades) {
		super(codigo, descripcion, cantidadEnExistencia, costo, venta);
		this.marca = marca;
		this.unidades = 0;
	}
	
	public String getMarca() {
		return marca;
	}
	public int getunidades() {
		return unidades;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setunidades(int unidades) {
		this.unidades = unidades;
	}
	
	public void cargarDatos() {
		do {
			try {
				System.out.println("Marca: ");  marca = Utilidades.entrada.next();
				System.out.println("Unidades: ");  unidades = Utilidades.entrada.nextInt();
				if (unidades <= 0) {
					throw new InputMismatchException(); //Pereza hacer do while para comprobar unidades
				}
			} catch (InputMismatchException e) {
				System.out.println("Hubo un error al leer los datos o ingreso algo mal, reingrese despues de la pausa.");
				marca = "";
				unidades = 0;
				Utilidades.pausa();
			}//catch
			
			Utilidades.limpiar();
		} while (unidades == 0);
	}//cargarDatos
	
	
	
	//venta +12%
}
