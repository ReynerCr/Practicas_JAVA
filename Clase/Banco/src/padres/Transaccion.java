package padres;

public abstract class Transaccion {
	
	private double monto;
	
	public Transaccion(double monto) {
		this.monto = monto;
	}

	public abstract double getMonto();
	
	public void mostrar() {
		System.out.println("Monto: "+monto);
	}

}
