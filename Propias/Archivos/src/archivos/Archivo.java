package archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Archivo {
	
	public String arch = "prueba.dat";
	
	public void crearArch() throws IOException {
		
		FileWriter archivo = new FileWriter(arch);  //busco el archivo
		BufferedWriter br = new BufferedWriter(archivo);  //lo meto en buffer
		PrintWriter salidaArch =  new PrintWriter(br);  //ahora declaro la clase con el archivo en buffer para poder escribir
		for (int i=0; i<10; i++) {
			salidaArch.print(((int)(Math.random()*100)) + " ");
		}
		salidaArch.println(); //no me lee el \n y aparte de eso los caracteres del espannol si salen bien
		salidaArch.print("Bien");
		salidaArch.close(); //lo cierro OJO
	}
	
	public void leerArch() throws IOException, FileNotFoundException {
		StringTokenizer tokenizer;
		String linea;
		
		FileReader fr = new FileReader(arch); //creo el lector de archivo
		BufferedReader bf = new BufferedReader(fr); //para cargar el archivo al buffer y leerlo
		linea = bf.readLine();
		
		while (linea!=null) {
			String cosa;
			tokenizer = new StringTokenizer(linea);
			System.out.println(linea + "\n\n");
			while (tokenizer.hasMoreTokens()) {
				cosa = tokenizer.nextToken();
				System.out.println(cosa);
			}
			
			linea = bf.readLine();
		}
		
		bf.close();
	}
}
