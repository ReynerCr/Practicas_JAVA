package padres;

import java.util.InputMismatchException;
import implementacion.Menu;
import hijas.*;
import implementacion.Utilidades;


public class Supermercado implements Menu {
	
	private Producto[] productos = new Producto[30];
	
	//funcion para retornar la primera posicion de productos que no este llena
	//si no, retorna -1
	public int getPosicion() {
		int i=0;
		
		while (productos[i]!=null && i<productos.length)
			i++;
		
		if (i==productos.length)
			i=-1;
		
		return i;
	}//getPosicion
	
	@Override
	public void añadirProducto() {
		int i = getPosicion();	
		
		if (i==-1) {
			System.out.println("Vector de productos lleno.");
			Utilidades.pausa();
		}//if para cuando el vector de productos esta lleno.

		else {
			int aux;
			do {
				try {
					System.out.println("Que tipo de producto desea agregar?");
					System.out.println("1. Enlatado.");
					System.out.println("2. Viver.");
					System.out.println("3. Carne.");
					System.out.println("4. Lacteo.");	
					System.out.print("Opcion: "); aux = Utilidades.entrada.nextInt();
					
					if (aux < 1 || aux > 4) {
						System.out.println("No es una opcion valida, reingrese luego de la pausa.");
						aux = 0;
						Utilidades.pausa();
					}
					else if  (aux == 4) {
						do {
							System.out.println("Tipo de lacteo?");
							System.out.println("5. Liquido.");
							System.out.println("6. Solido.");
							System.out.print("Opcion: "); aux = Utilidades.entrada.nextInt();
								
							if (aux!=5 || aux!=6) {
								System.out.println("No es una opcion valida, reingrese luego de la pausa.");
								aux = 0;
								Utilidades.pausa();
							}
							
						} while (aux!=5 || aux!=6);
					}//else si el producto es lacteo
					
					Utilidades.limpiar();
					
				} catch (InputMismatchException e) {
					aux = 0;
					System.out.println("Error al leer el dato, reingrese desde el inicio luego de la pausa.");
					Utilidades.pausa();
				}//catch
				
			} while (aux!=0);
			
			switch (aux) {
				case 1: //enlatado
					productos[i] = new Enlatados();
					break;
					
				case 2: //viver
					productos[i] = new Viveres();
					break;
					
				case 3://carne
					productos[i] = new Carnes();
					break;
					
				case 5: //lacteos
					productos[i] = new LacteosLiquidos();
					break;
					
				case 6: //lacteos
					productos[i] = new LacteosSolidos();
					break;
			}//switch
			
			productos[i].cargarDatos();
			Utilidades.limpiar();
			
			for (int j=0; j<productos.length; j++) {
				if (j!=i && productos[j].getCodigo() == productos[i].getCodigo()) {
					System.out.println("Error, ya existe un producto con el mismo codigo, se eliminara.");
					productos[i] = null; //borro lo que hice antes
					i = -1;
					break; //rompo ciclo, no tiene sentido seguir
				}//if para comparar codigos, si son iguales i se hará -1
			}//for
			
			//si i==-1 significa que el codigo se repite
			if (i!=-1) {
				System.out.println("Operacion satisfactoria.");
			}
			Utilidades.pausa();
			Utilidades.limpiar();
		}//else para cuando hay espacio en vector de productos
			
	}//añadirProducto

	@Override
	public void modificarProducto() {
		
	}//modificarProducto

	@Override
	public void facturarVenta() {
		
	}//facturarVenta

	@Override
	public void calcularIngresosBrutos() {
		
	}//calcularIngresosBrutos

	@Override
	public void calcularEgresos() {
		
	}//calcularEgresos

	@Override
	public void reporteMayoresVentas() {
		
	}//reporteMayoresVentas
	
	@Override
	public void reporteBajaExistencia() {
		
	}//reporteBajaExistencia
	
	@Override
	public void salir() {
		System.out.println("\nGracias por usar este programa.");
	}//salir
	
	
}//class Supermercado
