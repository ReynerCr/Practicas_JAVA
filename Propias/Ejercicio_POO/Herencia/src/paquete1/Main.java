package paquete1;

public class Main {

	public static void main(String[] args) {
		Estudiante estudiante1 = new Estudiante();
		Estudiante estudiante2 = new Estudiante("Reyner", "Contreras", 18, 2, 7);
		
		
		
		estudiante1.setNombre("Daniel");
		estudiante1.setApellido("Varian");
		estudiante1.setEdad(18);
		estudiante1.setCodigoEstudiante(1);
		estudiante1.setNotaFinal(6);
		
		estudiante1.mostrarDatos();
		System.out.println();
		estudiante2.mostrarDatos();
			
	}

}
