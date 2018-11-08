package principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

import hijas.Celulares;
import hijas.Televisores;
import padres.Fecha;
import padres.Productos;

public class Principal {

	public static void main(String[] args) {
		//los 4 productos se añaden a mano
		Productos vProductos[] = new Productos[0];
		vProductos = cargarProductos(vProductos);
		
		porcentajeCelularesLenovo(vProductos);  //apartado 1
		listadoTvsHyundai(vProductos); //apartado 2
		posibleGanancia(vProductos); //apartado 3
		listaProductosSeptiembre2018(vProductos); //apartado 4
	}//main
	
	//1. Calcular el porcentaje de celulares de marca “Lenovo” a excepción del modelo “A960”.
	public static void porcentajeCelularesLenovo(Productos productos[]) {
		float porcentaje = 0;
		int cantidadCelulares = 0;
		for (int i = 0; i < productos.length; i++) {
			if (productos[i] instanceof Celulares) {
				cantidadCelulares++;
				if (productos[i].getMarca().compareTo("Lenovo") == 0 && productos[i].getModelo().compareTo("A960") != 0)
					porcentaje++;
			}//if es celular
		}//for i
		porcentaje /= cantidadCelulares;
		porcentaje *= 100;
		
		System.out.println("1. Porcentaje de celulares de marca \"LENOVO\" (sin contar el model \"A960\"): " + porcentaje + "%");
		System.out.println("\n");
	}//porcentajeCelularesLenovo
	
	//2. Mostrar un listado por pantalla de los televisores de 42 pulgadas marca Hyundai y con menos de 3 puertos HDMI
	public static void listadoTvsHyundai(Productos productos[]) {
		boolean existencia = false;
		
		System.out.println("2. Listado de televisores hyundai de 42 pulgadas con menos de 3 puertos HDMI:");
		
		for (int i = 0; i < productos.length; i++) {
			if (productos[i] instanceof Televisores) {
				if (productos[i].getMarca().compareTo("Hyundai") == 0) {
					Televisores tvH = (Televisores) productos[i];
					if ((tvH.getTamanhoPulgadas() == 42) && (tvH.getNumPuertosHDMI() < 3)) {
						existencia = true;
						System.out.println(tvH.obtenerDatos());
					}
				}//if es hyundai
			}//if es televisor
		}//for i
		
		if (!existencia) {
			System.out.println("No hay televisores en la lista que cumplan con esas especificaciones.");
		}
		
		System.out.println("\n");
	}//listadoTvsHyndai
	
	//3. Calcular cuánto aspira ganar la empresa por concepto de ventas de todos los productos registrados.
	public static void posibleGanancia(Productos productos[]) {
		float costo = 0.0f;
		float venta = 0.0f;
		
		for (int i = 0; i < productos.length; i++) {
			costo += productos[i].getCostoAdquisicion();
			venta += productos[i].getPrecioVenta();
		}//for i
		
		System.out.println("3. Lo que aspira ganar la empresa por la venta de todos los productos registrados: ");
		System.out.println("Posible ganancia por la venta de todos los productos (sin contar el costo de adquisicion): " + venta);
		System.out.println("Posible ganancia por la venta de todos los productos (contando el costo de adquisicion): " + (venta - costo));
		
		System.out.println("\n");
	}//posibleGanancia
	
	//4. Mostrar un listado de los productos que fueron despachados en el mes Septiembre de 2018.
	public static void listaProductosSeptiembre2018(Productos productos[]) {
		int k = 0;

		System.out.println("4.\tProductos despachados en Septiembre/2018");
		System.out.println("Tipo\t\tMarca\tModelo\tPrecio de Venta");
		for (int i = 0; i < productos.length; i++) {
			if ((productos[i].getFechaDespacho().mes == 9) && (productos[i].getFechaDespacho().anho == 2018)) {
				if (productos[i] instanceof Celulares) 
					System.out.print("Celular\t\t");
				else
					System.out.print("Televisor\t");
				
				System.out.println(productos[i].getMarca() + "\t" + productos[i].getModelo() + "\t" + productos[i].getPrecioVenta());
				k++;
			}//if mes == septiembre && anho == 2018
		}//for i
		
		if (k == 0) {
			System.out.println("No hubo ninguno producto despachado en septiembre de 2018.");
		}//si no hubo productos que cumpliesen con las condiciones
	}//listaProductosSeptiembre2018
	
	public static Productos[] cargarProductos(Productos productos[]) {
		try {
			Scanner entArch = new Scanner(new File("src\\archivo\\datosParcial2.in"));
			String linea;
			while (entArch.hasNextLine()) {
				linea = entArch.nextLine();
				StringTokenizer tokenizer = new StringTokenizer(linea, "-");
				switch (tokenizer.nextToken()) {
					case "C":
						Celulares cel = new Celulares();
						cel = (Celulares) cargarUnProducto(cel, tokenizer);
						cel.setCapacidadMemoria(Integer.parseInt(tokenizer.nextToken("-")));
						cel.setTipoInteractividad(tokenizer.nextToken("-"));
						productos = productosDinamicos(productos);
						productos[productos.length - 1] = cel;
						break;
					case "T":
						Televisores tv = new Televisores();
						tv = (Televisores) cargarUnProducto(tv, tokenizer);
						tv.setTamanhoPulgadas(Integer.parseInt(tokenizer.nextToken()));
						tv.setNumPuertosHDMI(Integer.parseInt(tokenizer.nextToken()));
						productos = productosDinamicos(productos);
						productos[productos.length - 1] = tv;
						break;
					default:
						System.out.println("Se saltara un producto que empieza por: " + linea);
						break;
				}//switch para tipo de producto
			}//mientras el archivo contenga mas lineas
			entArch.close();
		}//try
		catch (FileNotFoundException e) {
			System.out.println("No se encontro el archivo.");
		}
		
		return productos;
	}//cargarProductos
	
	public static Productos cargarUnProducto(Productos prod, StringTokenizer tokenizer) {
		prod.setMarca(tokenizer.nextToken());
		prod.setModelo(tokenizer.nextToken());
		prod.setColor(tokenizer.nextToken());
		prod.setSerial(tokenizer.nextToken());
		prod.setCostoAdquisicion(Float.parseFloat(tokenizer.nextToken()));
		prod.setPrecioVenta(Float.parseFloat(tokenizer.nextToken()));
		
		String fechita = tokenizer.nextToken();
		StringTokenizer tokencito = new StringTokenizer(fechita, "/");
		
		Fecha fecha = new Fecha(Integer.parseInt(tokencito.nextToken()), Integer.parseInt(tokencito.nextToken()), Integer.parseInt(tokencito.nextToken()));
		prod.setFechaDespacho(fecha);
		
		return prod;
	}//cargarUnProducto
	
	//copio el vector de productos en uno nuevo que va a tener una posicion mas y retorno este
	public static Productos[] productosDinamicos(Productos[] productos) {
		Productos vProductos[] = new Productos[productos.length + 1];
		for (int i = 0; i < productos.length; i++) {
			vProductos[i] = productos[i];
		}
		
		return vProductos;
	}//productosDinamicos
	
}
