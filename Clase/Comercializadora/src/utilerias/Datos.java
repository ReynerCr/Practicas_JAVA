package utilerias;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import datos.Producto;
import datos.PuntoVenta;
import datos.Sucursal;
import personas.Cliente;

public class Datos {
	private static Producto invGeneral[] = null;
	private static Cliente clientes[] = null;
	private static Sucursal sucursales[] = null;
	private static PuntoVenta puntosVentas[] = null;
	
	public static void cargarDatos() throws IOException {
		//Leo todos los datos de los archivos y los cargo en los vectores previamente creados:
				//try catch para Producto.dat y la carga de productos
				try {
					Datos.invGeneral = llenarInvProductos(invGeneral);
				}  catch (Exception e) {	
					Archivos.crearProductos();
					Datos.invGeneral = llenarInvProductos(invGeneral);
				}
				
				//try catch para Clientes.dat y la carga de clientes
				try {
					Datos.clientes = cargarClientes(clientes);
				}  catch (Exception e) {	
					Archivos.crearClientes();
					Datos.clientes = cargarClientes(clientes);
				}
				
				//try catch para Sucursales.dat y la carga de sucursales
				try {
					Datos.sucursales = cargarSucursales(sucursales);
				} catch (Exception e) {	
					Archivos.crearSucursales();
					sucursales = cargarSucursales(sucursales);
				}
				//try catch para PuntosDeVenta.dat y la carga de puntos de venta
				try {
					Datos.puntosVentas = cargarPuntosVentas(puntosVentas, sucursales, invGeneral);
				} catch (Exception e) {	
					Archivos.crearPuntosDeVenta();
					Datos.puntosVentas = cargarPuntosVentas(puntosVentas, sucursales, invGeneral);
				}
	}//Datos()
	
	private static Producto[] llenarInvProductos(Producto invGeneral[]) throws FileNotFoundException {
		//Declaro variables para poder pasarle al constructor parametrico
		String linea; //para guardar cada linea leida
		Scanner archivo = new Scanner(new File("Productos.dat"));
		
		int i = 1;
		while (archivo.hasNextLine()) {
			i++;
			archivo.nextLine();
		}//while para contar la cantidad de productos que hay en el archivo
		
		//Reinicializo el scanner
		archivo.close(); archivo = null; archivo = new Scanner(new File("Productos.dat"));
		
		i -= 2; //linea vacia al final y porcentajeGanancia no cuentan
		invGeneral = new Producto[i];
		
		//cargo el porcentaje de ganancia
		linea = archivo.nextLine();
		int porcentajeGanancia; //porcentaje de ganancia de los productos
		porcentajeGanancia = Integer.parseInt(linea);
		
		i = 0;
		//Ahora si cargo los datos del archivo en el vector
		while (archivo.hasNextLine()) {			
			invGeneral[i] = new Producto(archivo);
			i++;
		}//while
		
		//como costo es estatico no hay problema en que haga esto, asi se asigna para todos los productos
		Producto.setPorcentajeGanancia(porcentajeGanancia);
		archivo.close();
		
		return invGeneral;
	}//llenarInvProductos
	
	private static Cliente[] cargarClientes(Cliente clientes[]) throws FileNotFoundException {
		Scanner archivo = new Scanner(new File("Clientes.dat"));
		
		int i = 1;
		while (archivo.hasNextLine()) {
			i++;
			archivo.nextLine();
		}//while para contar la cantidad de posibles clientes
		
		//Reinicializo el scanner
		archivo.close(); archivo = null; archivo = new Scanner(new File("Clientes.dat"));
		
		i--; //linea vacia al final
		clientes = new Cliente[i];
		
		i = 0;
		while (archivo.hasNextLine()) {
			clientes[i] = new Cliente(archivo);
			i++;
		}//while
		
		archivo.close();
		
		return clientes;
	}//cargarClientes

	private static Sucursal[] cargarSucursales(Sucursal sucursales[]) throws FileNotFoundException {
		Scanner archivo = new Scanner(new File("Sucursales.dat"));

		int i = 1;
		while (archivo.hasNextLine()) {
			i++;
			archivo.nextLine();
		}//while para contar cantidad de sucursales

		//Reinicializo el scanner
		archivo.close(); archivo = null; archivo = new Scanner(new File("Sucursales.dat"));
		
		i--; //linea vacia al final
		sucursales = new Sucursal[i];

		i = 0;
		while (archivo.hasNextLine()) {
			sucursales[i] = new Sucursal(archivo);
			i++;
		}//while
		
		archivo.close();
		
		return sucursales;
	}//cargarSucursales
	
	private static PuntoVenta[] cargarPuntosVentas(PuntoVenta puntosVentas[], Sucursal sucursales[], Producto invGeneral[]) throws FileNotFoundException {
		Scanner archivo = new Scanner(new File("PuntosDeVenta.dat"));

		int i = 0;
		while (archivo.hasNextLine()) {
			int j; //cantidad de productos
			int k = 0; //iterador para j
			archivo.nextLine();  archivo.nextLine();
			j = Integer.parseInt(archivo.next());
			while (k<j) {
				archivo.nextLine();
				k++;
			}//para saltarme los productos
			
			archivo.nextLine();
			i++;
		}//while para contar cantidad de puntos de venta
		
		//Reinicializo el scanner
		archivo.close();  archivo = null;  archivo = new Scanner(new File("PuntosDeVenta.dat"));
		puntosVentas = new PuntoVenta[i];
		
		i = 0;
		//esta es la magia, la carga de los puntos de venta
		while (i < puntosVentas.length) {
			puntosVentas[i] = new PuntoVenta(archivo);
			i++;
		}//while de carga de puntos de ventas
		
		archivo.close();
		return puntosVentas;
	}//cargarPuntosVentas

	public static Producto[] getInvGeneral() {
		return invGeneral;
	}

	public static Cliente[] getClientes() {
		return clientes;
	}

	public static Sucursal[] getSucursales() {
		return sucursales;
	}

	public static PuntoVenta[] getPuntosVentas() {
		return puntosVentas;
	}

	public static void setInvGeneral(Producto[] invGeneral) {
		Datos.invGeneral = invGeneral;
	}

	public static void setClientes(Cliente[] clientes) {
		Datos.clientes = clientes;
	}

	public static void setSucursales(Sucursal[] sucursales) {
		Datos.sucursales = sucursales;
	}

	public static void setPuntosVentas(PuntoVenta[] puntosVentas) {
		Datos.puntosVentas = puntosVentas;
	}
	
	public static Producto getInvGeneral(int i) {
		return invGeneral[i];
	}

	public static Cliente getClientes(int i) {
		return clientes[i];
	}

	public static Sucursal getSucursales(int i) {
		return sucursales[i];
	}

	public static PuntoVenta getPuntosVentas(int i) {
		return puntosVentas[i];
	}
	
}//class Datos
