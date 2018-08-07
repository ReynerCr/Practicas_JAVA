package objetos;

public class Cuadrilatero {
	//Atributos
	private float lado1;
	private float lado2;
	
	//Métodos
	
	//Método contructor para cuadrilátero NO CUADRADO
	public Cuadrilatero(float lado1, float lado2) {
		this.lado1 = lado1;
		this.lado2 = lado2;
	}
	
	//Método constructor para cuadrados
	public Cuadrilatero(float lado1) {
		this.lado1 = this.lado2 = lado1;
	}
	
	//Método para el perímetro
	public float getPerimetro() {
		float perimetro = 2 * (lado1+lado2);
		return perimetro;
	}
	
	//Método para el área
	public float getArea() {
		float area = (lado1 * lado2);
		return area;
	}
	
}
