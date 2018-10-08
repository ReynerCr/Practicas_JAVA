package utilerias;

import java.io.IOException;

import datos.Producto;
import datos.PuntoVenta;
import personas.Cliente;

public class Factura {
	private Cliente cliente;
	private Producto productos[];
	private String direccionPtoVenta;
	private String sucursal;
	private float costoTotal;
	private int hora; //realmente sera el minuto de la simulacion
	
	public Factura() {
		super();
		this.cliente = null;
		this.productos = null;
		this.direccionPtoVenta = "";
		this.costoTotal = 0;
	}

	public Factura(Cliente cliente, Producto[] productos, String direccionPtoVenta, float costoTotal) {
		this.cliente = cliente;
		this.productos = productos;
		this.direccionPtoVenta = direccionPtoVenta;
		this.costoTotal = costoTotal;
	}
	
	public Factura(Factura facturita) {
		cliente = facturita.getCliente();       
		
		productos = new Producto[facturita.getProductos().length];
		for (int i = 0; i < productos.length; i++) {
			productos[i] = new Producto(facturita.getProductos(i));
		}//for
		
		direccionPtoVenta = facturita.getDireccionPtoVenta();
		sucursal = facturita.getSucursal();
		costoTotal = facturita.getCostoTotal();
		hora = facturita.getHora();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Producto[] getProductos() {
		return productos;
	}
	
	public Producto getProductos(int i) {
		return productos[i];
	}

	public String getDireccionPtoVenta() {
		return direccionPtoVenta;
	}
	
	public float getCostoTotal() {
		return costoTotal;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = new Cliente(cliente);
	}

	public void setProductos(Producto[] productos) {
		this.productos = productos;
	}

	public void setDireccionPtoVenta(String direccionPtoVenta) {
		this.direccionPtoVenta = direccionPtoVenta;
	}
	
	public void setCostoTotal(float costoTotal) {
		this.costoTotal = costoTotal;
	}
	
	public String getSucursal() {
		return sucursal;
	}

	public int getHora() {
		return hora;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public Producto[] llenar(Cliente cliente, int hora, int y) {
		PuntoVenta ptoVenta = Datos.getPuntosVentas(y);
		Producto invGeneral[] = Datos.getInvGeneral();
		
		this.hora = hora;
		this.cliente = cliente; //no importa que mi factura apunte al cliente porque no modificare al mismo
		direccionPtoVenta = ptoVenta.getDireccion(); //para poder identificar donde compro, no necesito todo el objeto.
		sucursal = ptoVenta.getaQuienReporta().getNombre();
		this.productos = new Producto[(int)(Math.random() * 3)]; //maximo 3 productos por cliente
		
		Producto espera[] = new Producto[this.productos.length]; //por si no cuadran las existencias
		
		for (int i = 0; i < this.productos.length; i++) {
			int j = ((int) (Math.random() * invGeneral.length)); //producto
			int cant = ((int) (Math.random() * 15) + 1); //cantidad del producto
			int x = 0; //para espera[x]
			
			for (int k = 0; k < ptoVenta.getInventarioAsignado().length; k++) {
				if (ptoVenta.getInventarioAsignado(k).getCodigo().compareTo(invGeneral[j].getCodigo())==0) {
					this.productos[i] = new Producto(ptoVenta.getInventarioAsignado(k));
					
					if (ptoVenta.getInventarioAsignado(k).getExistencia() == 0) {
						espera[x] = new Producto(ptoVenta.getInventarioAsignado(k));
						espera[x].setExistencia(cant);
						x++;
					}//si no hay existencia de producto
					else if (cant > ptoVenta.getInventarioAsignado(k).getExistencia()) {
						this.productos[i] = new Producto(ptoVenta.getInventarioAsignado(k));
						this.productos[i].setExistencia(ptoVenta.getInventarioAsignado(k).getExistencia());
						ptoVenta.getInventarioAsignado(k).setExistencia(0);
						
						espera[x] = new Producto(ptoVenta.getInventarioAsignado(k));
						espera[x].setExistencia(cant - this.productos[i].getExistencia());
						x++;
					}//si la existencia no es suficiente
					else {
						this.productos[i] = new Producto(ptoVenta.getInventarioAsignado(k));
						this.productos[i].setExistencia(cant);
						ptoVenta.getInventarioAsignado(k).decrementarExistencia(cant);
					}//para cuando la existencia es suficiente
					
					if (this.productos[i]!=null) {
						Utilidades.pausa();
					}
				}//if coinciden los codigos de los productos
				else {
					this.productos[i] = null; //esto lo arreglo con Utilidades
					espera[x] = new Producto(invGeneral[j]);
					espera[x].setExistencia(cant);
					x++;
				}//else
			}//for para buscar el producto en el ptoVenta
		}//for para llenar el vector de productos
		
		this.productos = Utilidades.arreglarArray(productos);
		espera = Utilidades.arreglarArray(espera);
		
		calcularCostoTotal();
		
		return espera;
	}//llenar
	
	public void mostrar() throws IOException {
		Utilidades.imprimirString("Nombre: " + cliente.getNombre());
		Utilidades.imprimirString("Cedula: " + cliente.getCedula());
		Utilidades.imprimirString("    Producto\tCantidad\tCosto");
		for (int i = 0; i < productos.length; i++) {
			Utilidades.imprimirString((i+1) + ". " + productos[i].getDescripcion() + "\t" + productos[i].getExistencia() + "\t" + productos[i].getCosto());
		}//for para imprimir los productos
		Utilidades.imprimirString("Total: \t" + costoTotal);
		Utilidades.imprimirString("Direccion: " + direccionPtoVenta);
		Utilidades.imprimirString("De la sucursal: " + sucursal);
		Utilidades.imprimirString("Hora: " + hora + "min");
	}//mostrar
	
	public void calcularCostoTotal() {
		costoTotal = 0f;
		for (int i = 0; i < productos.length; i++) {
			costoTotal += productos[i].getCosto() * (1 + Producto.getPorcentajeGanancia()/100);
		}//for
	}//calcularCostoTotal
}//class Factura
