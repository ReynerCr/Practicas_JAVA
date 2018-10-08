package datos;

import java.util.Scanner;
import java.util.StringTokenizer;

import utilerias.Utilidades;

public class Producto implements ManipulacionDatos {
	private String codigo;
	private String descripcion;
	private float costo;
	private static float porcentajeGanancia;
	private int existencia;
	private final int stockMinimo;
	

	public Producto() {
		codigo = "";
		descripcion = "";
		costo = 0.0f;
		existencia = 0;
		stockMinimo = 0;
	}

	public Producto(String codigo, String descripcion, float costo, int existencia, int stockMinimo) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.costo = costo;
		this.existencia = existencia;
		this.stockMinimo = stockMinimo;
	}
	
	//Para copiar otro producto
	public Producto(Producto prod) {
		this.codigo = prod.getCodigo();
		this.descripcion = prod.getDescripcion();
		this.costo = prod.getCosto();
		this.existencia = prod.getExistencia();
		this.stockMinimo = prod.getStockMinimo();
	}
	
	public Producto(Scanner archivo) {
		StringTokenizer tokenizer = new StringTokenizer(archivo.nextLine());
		leerDatos(archivo, tokenizer);
		stockMinimo = Integer.parseInt(tokenizer.nextToken());
	}
	
	public String getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public float getCosto() {
		return costo;
	}

	public static float getPorcentajeGanancia() {
		return porcentajeGanancia;
	}

	public int getExistencia() {
		return existencia;
	}
	
	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public static void setPorcentajeGanancia(float porcentajeGanancia) {
		Producto.porcentajeGanancia = porcentajeGanancia;
	}
	
	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}

	public void asignarNuevaExistencia(int existencia) {
		this.existencia += existencia;
	}//asignarNuevaExistencia

	public void decrementarExistencia(int existencia) {
		this.existencia -= existencia; //esto lo tengo que verificar fuera
	}//decrementarExistencia
	

	@Override
	public void leerDatos(Scanner archivo, StringTokenizer tokenizer) {		
		codigo = tokenizer.nextToken();
		descripcion = tokenizer.nextToken();  descripcion = Utilidades.separarCad(descripcion);  descripcion = Utilidades.acomodarMayusculas(descripcion);
		costo = Float.parseFloat(tokenizer.nextToken());
		existencia = Integer.parseInt(tokenizer.nextToken());
	}//leerDatos

	@Override
	public void mostrarDatos() {
		System.out.println("Producto:");
		System.out.println("Codigo: " + codigo);
		System.out.println("Descripcion: " + descripcion);
		System.out.println("Costo: " + costo);
		System.out.println("porcentaje de ganancia: " + porcentajeGanancia);
		System.out.println("Existencia: " + existencia);
		System.out.println("Stock minimo: " + stockMinimo);
	}//mostrarDatos
}
