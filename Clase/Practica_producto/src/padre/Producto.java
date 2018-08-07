package padre;

import java.io.IOException;
import java.util.Scanner;

import hijas.Ingrediente;

public class Producto {
	
	public static Scanner entrada = new Scanner(System.in);
	
	private String codigo;
	private String nombre;
	private float precio;
	private int cantidad;
	private char estado;
	private int cantidadIngredientes;
	private Ingrediente formulas[];
	
	public Producto() {
		this.codigo = "0";
		this.nombre = " ";
		this.precio = 0.0f;
		this.cantidad = 0;
		this.estado = 'I';
		this.cantidadIngredientes = 0;
	}

	public Producto(String codigo, String nombre, float precio, int cantidad, char estado, int cantidadIngredientes) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.estado = estado;
		this.cantidadIngredientes = cantidadIngredientes;
		formulas = new Ingrediente[cantidadIngredientes];
	}
	
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public char getEstado() {
		return estado;
	}
	
	public int getCantidadIngredientes() {
		return cantidadIngredientes;
	}

	public Ingrediente[] getFormulas() {
		return formulas;
	}
	
	public Ingrediente getFormulas(int i) {
		return formulas[i];
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}	
	
	public void setCantidadIngredientes(int cantidadIngredientes) throws IOException {
		this.cantidadIngredientes = cantidadIngredientes;
		Ingrediente formulasn[] = new Ingrediente[cantidadIngredientes];
		
		for (int i=0; (cantidadIngredientes>formulas.length? i<formulas.length:i<cantidadIngredientes); i++) {
			formulasn[i] = new Ingrediente();
			formulasn[i] = formulas[i];
		}//copio todo lo de formulas en formulasn
		
		if (cantidadIngredientes>formulas.length) {
			for (int i = formulas.length; i<cantidadIngredientes; i++) {
				formulasn[i] = new Ingrediente();
				formulasn[i].cargarDatos();
				System.out.println();
			}//for
		}//if
		
		setFormulas(formulasn); //ahora setteo formulasn en formulas
	}

	public void setFormulas(Ingrediente formulas[]) {
		this.formulas = formulas;
	}

	public void setFormulas(Ingrediente formula, int i) {
		this.formulas[i] = formula;
	}
	
	
	public void cargarDatos() throws IOException {
		System.out.println("Ingrese datos del producto.");
		System.out.print("Codigo: "); codigo = valCodigo();
		System.out.print("Nombre: "); nombre = entrada.next();
		System.out.print("Precio: "); precio = entrada.nextFloat();
		System.out.print("Cantidad: "); cantidad = entrada.nextInt();
		System.out.print("Estado (A=activo/I=inactivo): "); estado = entrada.next().toUpperCase().charAt(0);
		System.out.print("Cantidad de ingredientes: "); cantidadIngredientes = entrada.nextInt();
		formulas = new Ingrediente[cantidadIngredientes];
		for (int i = 0; i<cantidadIngredientes; i++) {
			formulas[i] = new Ingrediente();
			System.out.println();
			System.out.print((i+1)+" ");
			formulas[i].cargarDatos();
		}
	}
	
	public void mostrarDatos() {
		System.out.println("Codigo: "+this.codigo);
		System.out.println("Nombre: "+this.nombre);
		System.out.println("Precio: "+this.precio);
		System.out.println("Cantidad: "+this.cantidad);
		System.out.print("Estado: ");
		if (this.estado == 'A')
			System.out.println("activo");
		else 
			System.out.println("inactivo");
		if (cantidadIngredientes > 0) {
			System.out.println("Ingredientes: ");
			for (int i=0; i<cantidadIngredientes; i++) {
				System.out.println((i+1)+". "+formulas[i].mostDatEnLinea());
			}
		}//if
		System.out.println();
	}
	
	//para optimizar y no importar implementación, creo el método aquí y luego lo uso en implementacion;
	public static String valCodigo() {
		String cod;
		do {
			cod = entrada.next();
			if (Integer.parseInt(cod)<0) {
				System.out.print("Codigo debe ser mayor a cero, reingrese: ");
				entrada.nextLine();
				entrada.nextLine();
			}
		} while (Integer.parseInt(cod)<0);
		return cod;
	}//valCodigo
	
}
