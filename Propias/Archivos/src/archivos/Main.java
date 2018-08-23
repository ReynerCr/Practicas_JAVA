package archivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		/*Archivo archivito = new Archivo();
		
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
		}*/
		Scanner entrada = null;
		
		try {
			entrada = new Scanner(new File("prueba.dat"));
			
		} catch (FileNotFoundException e) {
			System.out.println("No se encontro el archivo, se procedera a crearlo.");
		}
		
		entrada = new Scanner(new File("prueba.dat"));
		crearArch();
		leerArch(entrada);
		
		entrada.close();
		System.out.println("Se termino la ejecucion del programa.");
		
		
	}
	
	public static void crearArch() throws IOException {
		FileWriter fw = new FileWriter("prueba.dat", true);  //true permite APPEND al archivo
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		pw.println("Holaa");
		pw.println("Hasta aquí queda");
		pw.println("------");
		pw.close();
	}
	
	public static void leerArch(Scanner entrada) {
		while (entrada.hasNextLine()) {
			String linea;
			linea = entrada.nextLine();
			System.out.println(linea);
		}
	}
	
	/*public static void noArch(Archivo archivito) {
		System.out.println("No se encontro el archivo, se creara:\n\n");
		
		try {
			archivito.crearArch();
			archivito.leerArch();
		} catch (IOException e1) {
			System.out.println("Ops, ocurrio un error inesperado que no se resolver.");
		}
		
	}//noArch para cuando no se encontro*/

}
