import utilerias.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Implementacion {

	public static void main(String[] args) throws IOException {
		//cargo los datos del archivo donde se manejan los vectores de sucursales, clientes, inventario de la empresa y puntos de venta
		Datos.cargarDatos();
		
		//Simulacion: la variable tiempo guarda los minutos y cada 8 min llega un cliente
		Factura facturas[] = new Factura[100];
		
		listaEspera espera[] = new listaEspera[Datos.getPuntosVentas().length];
		for (int h = 0; h < espera.length; h++) {
			espera[h] = new listaEspera();
		}//inicializo listas de espera
		
		int tiempo = 8, i = 0;
		try {
			do {
				if (tiempo % 8 == 0) {
					Utilidades.imprimirString("Llego un cliente al min " + tiempo + ".");
					int y = (int)(Math.random() * Datos.getPuntosVentas().length); //PARA PUNTO VENTA
					facturas[i] = new Factura();
					espera[y].getFacturas(espera[y].contador).setProductos(facturas[i].llenar(Datos.getClientes((int)(Math.random() * Datos.getClientes().length)), tiempo, y)); 
					facturas[i].mostrar();
					
					if (espera[y] != null) {
						if (espera[y].getFacturas(espera[y].contador).getProductos(0) != null) {
							espera[y].getFacturas(espera[y].contador).setCliente(facturas[i].getCliente());
							espera[y].getFacturas(espera[y].contador).setDireccionPtoVenta(facturas[i].getDireccionPtoVenta());
							espera[y].getFacturas(espera[y].contador).calcularCostoTotal();
							espera[y].getFacturas(espera[y].contador).setHora(0); //si la hora es cero, entonces es que esta en espera
						}//if hubo algun producto que no se pudo vender completo
					}//que no sea nulo
					
					if (facturas[i].getProductos(0) != null) {
						i++;
					}//if facturas[i] al menos tiene una venta; si no, luego se remplaza al re-crearse
				}//si pasaron 8 min (llega cliente)
				
				int x = 0; //para manejar las listas de espera
				int h = 0; //para saber cuantos productos se han quedado sin existencia
				
				for (int z = 0; z < Datos.getPuntosVentas().length; z++) {
					for (int k = 0; k < Datos.getPuntosVentas(z).getInventarioAsignado().length; k++) {
						if (Datos.getPuntosVentas(z).getInventarioAsignado(k).getStockMinimo() > (Datos.getPuntosVentas(z).getInventarioAsignado(k).getExistencia())) {
							for (int t = 0; t < Datos.getInvGeneral().length; t++) {
								if (Datos.getInvGeneral(t).getCodigo().compareTo(Datos.getPuntosVentas(z).getInventarioAsignado(k).getCodigo())==0) {
									if (Datos.getInvGeneral(t).getExistencia() != 0) {
										int cantidadAsignar = (int) (Math.random() * (Datos.getInvGeneral(t).getExistencia() - Datos.getPuntosVentas(z).getInventarioAsignado(k).getStockMinimo())) + Datos.getInvGeneral(t).getStockMinimo();
										Datos.getPuntosVentas(z).getInventarioAsignado(k).asignarNuevaExistencia(cantidadAsignar);
										Datos.getInvGeneral(t).decrementarExistencia(cantidadAsignar);
									}
									else {
										Utilidades.imprimirString(Datos.getInvGeneral(t).getDescripcion() + " no disponible.");
										h++;
									}
								}//if cantidad en existencia es menor a stockMinimo
							}//for para revisar la comercializadora
						}//if codigos son iguales
						if (Datos.getPuntosVentas(z).getInventarioAsignado(k).getExistencia() == 0) {
							h++;
							Utilidades.imprimirString(Datos.getPuntosVentas(z).getInventarioAsignado(k).getDescripcion() + " no disponible.");
						}
					}//for k (aprovecho a revisar si necesito productos en un ptoVenta
					
					if (espera[z].contador == 5) {
						x = z;
					}//para comprobar si alguna lista de espera esta llena
				}//for para revisar los ptosVentas y las listas de espera
				
				if (h == (Datos.getInvGeneral().length + (Datos.getPuntosVentas(0).getCantidadItemsInventario() + Datos.getPuntosVentas(1).getCantidadItemsInventario()))) {
					Utilidades.imprimirString("No hay productos disponibles y no se puede reabastecer los puntos de venta.");
					break;
				}//si no se puede reabastecer los puntos de venta
				
				if (tiempo % 60 == 0 || x != 0) {
					
				}//si ha pasado una hora o la lista de espera es 5 (reviso las listas de espera)
				
				tiempo++;
			} while (tiempo < 480); //480 minutos son 8 horas
		
			Utilidades.imprimirString("Fin de la simulacion.");
		} catch (FileNotFoundException e) {
			crearArchivos();
		}//solo para cuando hay un error de IOException en la simulacion (porque algo le paso a salida.dat o algun archivo no se cargo bien)
	}//main

	public static void crearArchivos() throws IOException {
		Archivos.crearClientes();
		Archivos.crearProductos();
		Archivos.crearPuntosDeVenta();
		Archivos.crearSucursales();
		Archivos.limpiarSalida();
	}//crearArchivos, que solo se utiliza si hay un error durante la ejecucion del programa
	
	

}//class Implementacion
