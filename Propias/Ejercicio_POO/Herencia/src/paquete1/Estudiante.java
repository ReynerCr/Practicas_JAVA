package paquete1;

public class Estudiante extends Persona {
	private int codigoEstudiante;
	private float notaFinal;

	public Estudiante() {
		codigoEstudiante = 0;
		notaFinal = 0;
	}

	public Estudiante(String nombre, String apellido, int edad, int codigoEstudiante, float notaFinal) {
		super(nombre, apellido, edad);
		this.codigoEstudiante = codigoEstudiante;
		this.notaFinal = notaFinal;
	}

	public int getCodigoEstudiante() {
		return codigoEstudiante;
	}

	public void setCodigoEstudiante(int codigoEstudiante) {
		this.codigoEstudiante = codigoEstudiante;
	}

	public float getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(float notaFinal) {
		this.notaFinal = notaFinal;
	}

	public void mostrarDatos() {
		System.out.println("Nombre: " + getNombre() + "\n" + "Apellido: " + getApellido() + "\n" + "Edad:" + getEdad()
				+ "\n" + "Codigo de estudiante: " + codigoEstudiante + "\n" + "Nota final: " + notaFinal);
	}
}
