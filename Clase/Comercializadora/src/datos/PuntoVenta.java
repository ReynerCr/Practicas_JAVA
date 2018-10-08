package datos;

import java.util.Scanner;
import java.util.StringTokenizer;

import datos.Producto;
import datos.Sucursal;
import utilerias.Datos;
import utilerias.Utilidades;

public class PuntoVenta implements ManipulacionDatos {
	private String direccion;
	private Sucursal aQuienReporta;
	private int cantidadItemsInventario;
	private Producto [] inventarioAsignado;


	public PuntoVenta() {
		this.direccion = "";    
		this.aQuienReporta = null;
		this.cantidadItemsInventario = 0;
		this.inventarioAsignado = null;
	}

	public PuntoVenta(String direccion, Sucursal aQuienReporta, int cantidadItemsInventario, Producto[] inventarioAsignado) {
		this.direccion = direccion;
		this.aQuienReporta = new Sucursal(aQuienReporta);
		this.cantidadItemsInventario = cantidadItemsInventario;
		
		this.inventarioAsignado = new Producto[cantidadItemsInventario];
		for (int i = 0; i < cantidadItemsInventario; i++) {
			this.inventarioAsignado[i] = new Producto (inventarioAsignado[i]);
		}//for copiar inventario asignado
	}
	
	public PuntoVenta(PuntoVenta ptoVenta) {
		this.direccion = ptoVenta.getDireccion();
		this.aQuienReporta = new Sucursal(ptoVenta.getaQuienReporta());
		this.cantidadItemsInventario = ptoVenta.getCantidadItemsInventario();
		
		this.inventarioAsignado = new Producto[ptoVenta.getCantidadItemsInventario()];
		for (int i = 0; i < cantidadItemsInventario; i++) {
			this.inventarioAsignado[i] = new Producto (ptoVenta.getInventarioAsignado(i));
		}//for copiar inventario asignado
	}
	
	public PuntoVenta(Scanner archivo) {
		StringTokenizer tokenizer = new StringTokenizer("");
		leerDatos(archivo, tokenizer);
	}
	
	public String getDireccion() {
		return direccion;
	}

	public Sucursal getaQuienReporta() {
		return aQuienReporta;
	}

	public int getCantidadItemsInventario() {
		return cantidadItemsInventario;
	}

	public Producto[] getInventarioAsignado() {
		return inventarioAsignado;
	}
	
	public Producto getInventarioAsignado(int i) {
		return inventarioAsignado[i];
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setaQuienReporta(Sucursal aQuienReporta) {
		this.aQuienReporta = aQuienReporta;
	}

	public void setCantidadItemsInventario(int cantidadItemsInventario) {
		this.cantidadItemsInventario = cantidadItemsInventario;
	}

	public void setInventarioAsignado(Producto[] inventarioAsignado) {
		this.inventarioAsignado = inventarioAsignado;
	}

	@Override
	public void mostrarDatos() {
		System.out.println("Punto de venta:");
		System.out.println("Direccion: " + direccion);
		System.out.println("Sucursal a la que pertenece: " + aQuienReporta.getNombre());
		System.out.println("Cantidad de items en el inventario: " + cantidadItemsInventario);
		
		System.out.println("Productos en inventario: ");
		for (int i = 0; i < cantidadItemsInventario; i++) {
			System.out.println((i + 1) + ". " + inventarioAsignado[i].getDescripcion() + " " + inventarioAsignado[i].getExistencia());
		}//for para mostrar las descripciones de cada uno de los productos
	}//mostrarDatos

	@Override
	public void leerDatos(Scanner archivo, StringTokenizer tokenizer) {
		direccion = archivo.nextLine();
		String codigoSucursal = archivo.nextLine();
		cantidadItemsInventario = Integer.parseInt(archivo.nextLine());
		
		//revisar la cantidad de items
		int j = 0;
		while (codigoSucursal.compareTo(Datos.getSucursales(j).getCodigo())!=0 && j < Datos.getSucursales().length) {
			j++;
		}//Reviso si la sucursal existe
		if (j == Datos.getSucursales().length) {
			j = 0;
			while (j < cantidadItemsInventario) {
				archivo.nextLine();
				j++;
			}//while para saltarme los productos
		}//si la sucursal no existe me salto todo hasta el siguiente puntoVenta
		
		else {
			aQuienReporta = new Sucursal(Datos.getSucursales(j));

			j = 0;
			inventarioAsignado = new Producto[cantidadItemsInventario];
			while (j < inventarioAsignado.length) {
				int k = 0;
				String linea = archivo.nextLine();
				tokenizer = new StringTokenizer (linea);
				String aux = tokenizer.nextToken();
				
				while (k < Datos.getInvGeneral().length && aux.compareTo(Datos.getInvGeneral(k).getCodigo())!=0) {
					k++;
				}//while para comparar los codigos
				
				if (k != Datos.getInvGeneral().length) {
					inventarioAsignado[j] = new Producto(Datos.getInvGeneral(k));
					aux = tokenizer.nextToken();
					inventarioAsignado[j].setExistencia(Integer.parseInt(aux));
					Datos.getInvGeneral(k).decrementarExistencia(Integer.parseInt(aux));
				}//si existe el producto
				else {
					inventarioAsignado[j] = null;
				}//si no existe el producto
				
				j++;
			}//while cargar items
			
			inventarioAsignado = Utilidades.arreglarArray(inventarioAsignado);
		}//else para cuando existe la sucursal
	}//leerDatos
	
}//class PuntoVenta
