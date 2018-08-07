package paquete1;

public class Triangulo_Isosceles {
	//Atributos
	private double base;
	private double lado;
	private double perimetro;
	private double area;
	
	public Triangulo_Isosceles(double base, double lado) {
		this.base = base;
		this.lado = lado;
	}
	
	public double obtenerPerimetro() {
		perimetro = (lado * 2) + base;
		return perimetro;
	}
	
	public double obtenerArea() {
		area = (base * (Math.sqrt(Math.pow(lado, 2) - (Math.pow(base, 2) / 4)))) / 2;
		return area;
	}
	
}
