package implementacion;

import java.util.InputMismatchException;

import padres.Almacen;
import implementacion.Utilidades;

public class Main {

	public static void main (String args[]) {
		Almacen popular = new Almacen();
		int menu;

		do {
			do {
				try {
				System.out.println("\t\tPrograma de gestion del mercado la Popular.");
				System.out.println("1. Annadir un producto al almacen.");
				System.out.println("2. Modificar existencia de un producto.");
				System.out.println("3. Facturar venta.");
				System.out.println("4. Ingresos brutos.");
				System.out.println("5. Egresos de la empresa.");
				System.out.println("6. Reporte de productos exentos de iva con mayores ventas.");
				System.out.println("7. Reporte de productos con existencia baja.");
				System.out.println("8. Salir.");
				System.out.print("Opcion: "); menu = Utilidades.entrada.nextInt();
				} catch (InputMismatchException e) {
					menu = 0;
					System.out.println("No es una opcion valida, reingrese despues de la pausa.");
					Utilidades.pausa();
				}//catch
				
				Utilidades.limpiar();
			} while (menu<1 || menu>8);
		
			switch (menu) {
				case 1:
					popular.annadirProducto();
					break;
				case 2:
					popular.modificarExistenciaProducto();
					break;
				case 3:
					popular.facturarVenta();
					break;
				case 4:
					popular.calcularIngresosBrutos();
					break;
				case 5:
					popular.calcularEgresos();
					break;
				case 6:
					popular.reporteExentosMayoresVentas();
					break;
				case 7:
					popular.reporteBajaExistencia();
					break;
				case 8:
					popular.salir();
					break;
				default:
					System.out.println("No es una opcion valida, reingrese despues de la pausa.");
					Utilidades.pausa();
					break;
			}//switch menu
			
			Utilidades.limpiar();
		} while (menu!=8);
	}//main
	
}
