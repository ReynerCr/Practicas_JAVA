package archivos;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		Archivo archivito = new Archivo();
		
		try {
			archivito.leerArch();
		}
		catch (IOException e) {
			if (e instanceof FileNotFoundException) {
				noArch(archivito);
			}//para cuando no se encuentra el archivo
			else {
				System.out.println("Ocurrio un error inesperado que no se resolver.");
			}//para IOException en general
		}//catch

		finally {
			System.out.println("\n\n\nSe termino la ejecucion del programa.");
		}
		
	}
	
	public static void noArch(Archivo archivito) {
		System.out.println("No se encontro el archivo, se creara:\n\n");
		
		try {
			archivito.crearArch();
			archivito.leerArch();
		} catch (IOException e1) {
			System.out.println("Ops, ocurrio un error inesperado que no se resolver.");
		}
		
	}//noArch para cuando no se encontro

}
