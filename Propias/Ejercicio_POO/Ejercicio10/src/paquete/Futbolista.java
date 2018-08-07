
package paquete;

public class Futbolista extends Persona {
	private int dorsal;
	private int posicion;

	public Futbolista(int dorsal, int posicion, String nombre, String apellido, int edad) {
		super(nombre, apellido, edad);
		this.dorsal = dorsal;
		this.posicion = posicion;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

}
