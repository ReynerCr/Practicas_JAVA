package utilerias;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Archivos {
	public static void crearProductos() throws IOException {
		FileWriter fw = new FileWriter(new File("Productos.dat"));
		BufferedWriter bw = new BufferedWriter (fw);
		PrintWriter pw = new PrintWriter(bw);
		
		pw.println("12");
		pw.println("P-1 CercasElectricas 300000 10 3");
		pw.println("P-2 Inyectadoras 50 300 8");
		pw.println("P-3 Baldes 20000 50 20");
		pw.println("P-4 Mangueras 32000 15 5");
		pw.println("P-5 LlavesDePaso 50000 20 5");
		
		pw.close();
	}
	
	public static void crearClientes() throws IOException {
		FileWriter fw = new FileWriter(new File("Clientes.dat"));
		BufferedWriter bw = new BufferedWriter (fw);
		PrintWriter pw = new PrintWriter(bw);
		
		pw.println("12345789 Jesus Perez");
		pw.println("15456789 Carlos Garcia");
		pw.println("17895436 Juan Rosales");
		pw.println("11486258 Marta Chacon");
		pw.println("18233753 Luisa Almao");
		
		pw.close();
	}
	
	public static void crearSucursales() throws IOException {
		FileWriter fw = new FileWriter(new File("Sucursales.dat"));
		BufferedWriter bw = new BufferedWriter (fw);
		PrintWriter pw = new PrintWriter(bw);
		
		pw.println("A-1 LosGrandes SanCristobal");
		pw.println("A-2 LosGuaros Barquisimeto");
		
		pw.close();
	}
	
	public static void crearPuntosDeVenta() throws IOException {
		FileWriter fw = new FileWriter(new File("PuntosDeVenta.dat"));
		BufferedWriter bw = new BufferedWriter (fw);
		PrintWriter pw = new PrintWriter(bw);
		
		pw.println("Barrio Obrero");
		pw.println("A-2");
		pw.println("3");
		pw.println("P-2 100");
		pw.println("P-4 6");
		pw.println("P-1 5");
		pw.println("Barrio Sucre");
		pw.println("A-1");
		pw.println("4");
		pw.println("P-5 10");
		pw.println("P-1 5");
		pw.println("P-3 30");
		pw.println("P-2 150");
		
		pw.close();
	}
	
	public static void limpiarSalida() throws IOException {
		FileWriter fw = new FileWriter("salida.dat");
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		pw.close();
	}//Solo en caso de que haya un error en la ejecucion de la simulacion
}
