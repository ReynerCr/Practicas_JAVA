//encapsulamiento y metodos accesores (getters y setters)
package paquete1;

public class Clase1 {
	private int edad;
	private String nombre;
	
	//método setter: establecemos la edad
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	//método getter: mostramos la edad
	public int getEdad () {
		return(edad);
	}
	
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
}
