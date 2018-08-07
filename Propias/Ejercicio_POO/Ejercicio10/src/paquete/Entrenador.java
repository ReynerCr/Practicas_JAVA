package paquete;

public class Entrenador extends Persona {
	private String estrategia;

	public Entrenador(String estrategia, String nombre, String apellido, int edad) {
		super(nombre, apellido, edad);
		this.estrategia = estrategia;
	}

	public String getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(String estrategia) {
		this.estrategia = estrategia;
	}

}
