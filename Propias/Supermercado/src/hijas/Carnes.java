package hijas;

import padres.Producto;

import java.util.InputMismatchException;

import implementacion.Utilidades;

public class Carnes extends Producto {
	private int kilos;

	public Carnes() {
		super();
		kilos = 0;
	}

	public Carnes(String codigo, String descripcion, int cantidadEnExistencia, float costo, float venta, int kilos) {
		super(codigo, descripcion, cantidadEnExistencia, costo, venta);
		this.kilos = kilos;
	}

	public int getKilos() {
		return kilos;
	}

	public void setKilos(int kilos) {
		this.kilos = kilos;
	}
	
	public void cargarDatos() {
		do {
			try {
				System.out.println("Kilos: ");
				kilos = Utilidades.entrada.nextInt();
				
				if (kilos<=0) {
					throw new InputMismatchException(); //no es mismatch, lo se, no quiero repetir codigo
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Hubo un error al leer los datos o ingreso algo mal, reingrese despues de la pausa.");
				Utilidades.pausa();
				kilos = 0;
			}//catch
			
			Utilidades.limpiar();
		} while (kilos == 0);
	}//cargarDatos
	
}
