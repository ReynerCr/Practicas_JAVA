package paquete;

public class Doctor extends Persona {
	private String titulacion;
	private int anosExperiencia;

	public Doctor(String titulacion, int anosExperiencia, String nombre, String apellido, int edad) {
		super(nombre, apellido, edad);
		this.titulacion = titulacion;
		this.anosExperiencia = anosExperiencia;
	}

	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	public int getAnosExperiencia() {
		return anosExperiencia;
	}

	public void setanosExperiencia(int anosExperiencia) {
		this.anosExperiencia = anosExperiencia;
	}

	public String toString() {
		return super.getNombre() + " esta curando la lesion de ";
	}

}
