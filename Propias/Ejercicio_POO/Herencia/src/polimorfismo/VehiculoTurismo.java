package polimorfismo;

public class VehiculoTurismo extends Vehiculo {
	int numeroPuertas;

	public VehiculoTurismo(String matricula, String marca, String modelo, int numeroPuertas) {
		super(matricula, marca, modelo);
		this.numeroPuertas = numeroPuertas;
	}

	public int getNumeroPuertas() {
		return numeroPuertas;
	}

	public void setNumeroPuertas(int numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}

	@Override
	public String mostrarDatos() {
		return ("Modelo: " + matricula + "\n" + "Marca: " + marca + "\n" + "Modelo: " + modelo + "\n"
				+ "Numero de puertas: " + numeroPuertas);
	}

}
