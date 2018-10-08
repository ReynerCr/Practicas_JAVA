package utilerias;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

import datos.Producto;

public class Utilidades {
	
	public static Scanner entrada = new Scanner(System.in);
	
	public static void limpiar() {
		for (int i = 0; i < 40; i++) {
			System.out.println();
		}//for
	}//limpiar
	
	public static void pausa() {
		entrada.nextLine();
		entrada.nextLine();
	}//pausa
	
	public static String separarCad(String cadena) {
		//Paso la cadena a cadena de char para poder separar
		char cad[] = cadena.toCharArray();
		
		for (int j = 1; j < cad.length; j++) {
			if (Character.isUpperCase(cad[j])) {
				cadena = cadena.substring(0, j) + " " + cadena.substring(j, cadena.length());
				cad = cadena.toCharArray();
				j++;
			}//if letra es mayuscula
		}//for j
		
		return cadena;
	}//separarCad
	
	public static String acomodarMayusculas(String cadena) {
		cadena = cadena.toLowerCase();  cadena = cadena.toUpperCase().charAt(0) + cadena.substring(1, cadena.length());
		return cadena;
	}//acomodarMayusculas
	
	//metodo para cargar string validando que no contengan ya sea numeros o letras (no ambos)
	public static String cargarUnString(String palabra, int tipoDato) {
		boolean condicion = true;
		String cadena;
		do {
			System.out.print(palabra + ": "); cadena = Utilidades.entrada.next();
			
			if (tipoDato == 0 || tipoDato == 1) {
				condicion = Utilidades.noContenga(cadena, tipoDato);
				
				if (!condicion) {
					System.out.println("No es un/una " + palabra + " valida (hay algun/alguna " + (tipoDato == 0 ? "numero":"letra") + "). Reingrese luego de la pausa.");
					Utilidades.pausa();
					Utilidades.limpiar();
				}//if condicion no se cumple
			}//if para que la funcion no necesariamente valide si contiene x tipo de dato
			
		} while (!condicion);
		
		return cadena;
	}//cargarUnString
	
	public static void imprimirString(String cadena) throws IOException {
		FileWriter fw = new FileWriter("salida.dat", true); //para activar el appends
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		System.out.println(cadena);
		pw.println(cadena);
		
		pw.close();
	}//imprimirString
	
	public static Producto[] arreglarArray(Producto productos[]) {
		int i = 0, j = 0;
		while (i < productos.length) {
			if (productos[i] != null) {
				j++;
			}
			i++;
		}//while
		
		Producto arreglado[] = new Producto[j];

		j = 0;
		for (i = 0; i < productos.length; i++) {
			if (productos[i] != null) {
				arreglado[j] = new Producto(productos[i]);
				j++;
			}
		}//for
		
		return arreglado;
	}//arreglarArray
	
	public static boolean noContenga(String cadena, int tipoDato) {
		boolean condicion = true;
		
		char cad[] = cadena.toCharArray();
		
		for (int i = 0; i < cad.length; i++) {
			//0 para revisar que no contenga numeros; 1 para revisar que no contenga letras
			if ((tipoDato == 0 ? !Character.isDigit(cad[i]):!Character.isLetter(cad[i]))) {
				pausa();  limpiar();
				condicion = false;
				break;
			}//if no es numero
		}//for
		
		return condicion;
	}//noContenga
	
	public static int cargarUnEntero(String palabra, int numDesde) {
		//numDesde es el numero desde el cual se va a validar el entero. Por ejm: un codigo no deberia ser negativo, siendo el codigo minimo 0.
		int numero;
		
		do {
			try {
				System.out.println(palabra + ": "); numero = entrada.nextInt();
				
				if (numero < numDesde) {
					System.out.println("No es un valor valido para " + palabra + ". Reingrese luego de la pausa.");
					pausa();  limpiar();
				}
			} catch (InputMismatchException e) {
				System.out.println("Lo sentimos, ocurrio un error al ingresar el numero, reingrese luego de la pausa.");
				pausa();  limpiar();
				
				numero = numDesde - 1;
			}//catch
		} while (numero >= numDesde);
		
		return numero;
	}//cargarUnEntero
	
	public static float cargarUnFloat(String palabra, float numDesde) {
		//numDesde es el numero desde el cual se va a validar el entero. Por ejm: un codigo no deberia ser negativo, siendo el codigo minimo 0.
		float numero;
		
		do {
			try {
				System.out.println(palabra + ": "); numero = entrada.nextFloat();
				
				if (numero < numDesde) {
					System.out.println("No es un valor valido para " + palabra + ". Reingrese luego de la pausa.");
					pausa();  limpiar();
				}
			} catch (InputMismatchException e) {
				System.out.println("Lo sentimos, ocurrio un error al ingresar el numero, reingrese luego de la pausa.");
				pausa();  limpiar();
				
				numero = numDesde - 1;
			}//catch
		} while (numero >= numDesde);
		
		return numero;
	}//cargarUnFloat	
	
}//class Utilidades
