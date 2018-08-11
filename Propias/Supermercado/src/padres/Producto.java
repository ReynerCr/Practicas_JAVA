package padres;

import java.util.InputMismatchException;
import implementacion.Utilidades;

public abstract class Producto {

	private String codigo; 
	private String descripcion;
	private int cantidadEnExistencia; 
	private float costo; 
	private float venta;
	
	public Producto(String codigo, String descripcion, int cantidadEnExistencia, float costo, float venta) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.cantidadEnExistencia = cantidadEnExistencia;
		this.costo = costo;
		this.venta = venta;
	}
	
	public Producto() {
		this.codigo = "";
		this.descripcion = "";
		this.cantidadEnExistencia = 0;
		this.costo = 0.0f;
		this.venta = 0.0f;
	}

	public String getCodigo() {
		return codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public int getCantidadEnExistencia() {
		return cantidadEnExistencia;
	}
	public float getCosto() {
		return costo;
	}
	public float getVenta() {
		return venta;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setCantidadEnExistencia(int cantidadEnExistencia) {
		this.cantidadEnExistencia = cantidadEnExistencia;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	public void setVenta(float venta) {
		this.venta = venta;
	}
	
	public void cargarDatos() {
		do {
			try {
				System.out.println("Ingrese los datos del producto.");
				System.out.print("Codigo: "); codigo = Utilidades.entrada.next();
				System.out.print("Descripcion: "); descripcion = Utilidades.entrada.next();
				System.out.print("Cantidad en existencia: "); cantidadEnExistencia = Utilidades.entrada.nextInt();
				System.out.print("Costo: "); costo = Utilidades.entrada.nextFloat();
			} catch (InputMismatchException e) {
				codigo = "";
				descripcion = ""; 
				cantidadEnExistencia = 0;   
				costo = 0.0f;
				venta = 0.0f;
				System.out.println("Error al leer alguno de los datos, reingrese luego de la pausa.");
				Utilidades.pausa();
				Utilidades.limpiar();
			}//catch
		} while (codigo.compareTo("")!=0);
		
	}//cargarDato
	

}
