
public class Ejercicio_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// mostrar el producto de los 10 primeros numeros impares
		
		long producto = 1;
		
		for (int i=1; i<=20; i+=2) {
			producto *= i;
		}
		System.out.println("El producto es " +producto);
	}

}
