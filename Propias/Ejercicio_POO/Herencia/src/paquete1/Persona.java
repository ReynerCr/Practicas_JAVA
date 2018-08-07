package paquete1;

public class Persona {

	private String nombre;
	private String apellido;
	private int edad;

	public Persona() {
		nombre = "blanco";
		apellido = "nieve";
		edad = -1;
		System.out.println("Entro desde el hijo uwu.");
	}

	public Persona(String nombre, String apellido, int edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	// setter
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	// getter
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getEdad() {
		return edad;
	}

}// fin de clase
