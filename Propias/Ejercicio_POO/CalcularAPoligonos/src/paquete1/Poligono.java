package paquete1;



public abstract class Poligono {
	
	protected int numeroLados;
	
	public Poligono(int numeroLados) {
		this.numeroLados = numeroLados;
	}
	
	public abstract double area();
	
	@Override
	public String toString() {
		return "Numero de lados: "+numeroLados;
	}
	
}
