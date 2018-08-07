package paquete1;

public class Clase2 {
	public static void main (String [] args) {
		Clase1 objeto1 = new Clase1();
		
		//objeto1.edad = 18; no se puede, es privado
		objeto1.setEdad(18); //se puede, setter
		System.out.println("La edad es: "+objeto1.getEdad());
		
		objeto1.setNombre("Reyner");
		System.out.println("El nombre es: "+objeto1.getNombre());
	}
}
