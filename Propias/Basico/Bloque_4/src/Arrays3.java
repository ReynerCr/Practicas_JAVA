//bucle for_each
public class Arrays3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] nombres = {"Alejandro", "Maria", "Luisa", "Juan", "Marcisa", "Luis", "Roberto", "Flor", "Jessica"};
		
		/*for (int i=0; i<nombres.length; i++) {
			System.out.println(nombres[i]);
		} //NOMBRES.LENGTH: da el numero de "cosas" en un arreglo. */
		
		for (String i:nombres) {  // FOR EACH o FOR MEJORADO for (tipo_de_dato nombre_dato:nombre_cadena) {
			System.out.println(i);
		}
	}

}
