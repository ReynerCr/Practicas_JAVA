package hijas;

import java.util.InputMismatchException;

import implementacion.Utilidades;

public class LacteosLiquidos extends Lacteos {
	private int litros;

	public LacteosLiquidos() {
		super();
		litros = 0;
	}

	public LacteosLiquidos(String codigo, String descripcion, int cantidadEnExistencia, float costo, float venta, int litros) {
		super(codigo, descripcion, cantidadEnExistencia, costo, venta);
		this.litros = litros;
	}

	public int getLitros() {
		return litros;
	}

	public void setLitros(int litros) {
		this.litros = litros;
	}
	
	public void cargarDatos() {
		do {
			try {
				System.out.println("Litros: ");
				litros = Utilidades.entrada.nextInt();
				
				if (litros<=0) {
					throw new InputMismatchException(); //no es mismatch, lo se, no quiero repetir codigo
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Hubo un error al leer los datos o ingreso algo mal, reingrese despues de la pausa.");
				litros = 0;
				Utilidades.pausa();
			}//catch
			
			Utilidades.limpiar();
		} while (litros == 0);
	}//cargarDatos
	
	
	

}
