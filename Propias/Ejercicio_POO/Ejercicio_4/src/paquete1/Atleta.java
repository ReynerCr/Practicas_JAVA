package paquete1;

public class Atleta {
	//Atributos
	private int numeroCorredor;
	private int tiempo;
	private String nombre;
	
	//Métodos
	//constructor
	public Atleta(int numeroCorredor, int tiempo, String nombre) {
		this.numeroCorredor = numeroCorredor;
		this.tiempo = tiempo;
		this.nombre = nombre;
	}
	
	//Getter de tiempo
	public int getTiempo() {
		return tiempo;
	}
	
	//Mostrar datos al final
	public String mostrarDato() {
		return "Numero de corredor: "+numeroCorredor+"\nNombre: "+nombre+"\nTiempo: "+tiempo+" s";
	}
	
}
