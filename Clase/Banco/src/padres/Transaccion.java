package padres;

public abstract class Transaccion {
	
	private double monto;
	private int tipo;

	public Transaccion() {
		this.monto = 0.0;
	}
	
	public Transaccion(int tipo, double monto) {
		this.tipo = tipo;
		this.monto = monto;
	}

	public abstract double getMonto();
	
	public int getTipo() {
		return tipo;
	}
	
	public void mostrar() {
		System.out.println("Monto: "+monto);
	}

}
