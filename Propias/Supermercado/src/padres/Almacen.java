package padres;

import java.util.InputMismatchException;
import implementacion.Menu;
import hijas.*;
import implementacion.Utilidades;


public class Almacen implements Menu {
	
	private Producto[] productos = new Producto[30];
	private Factura[] facturas = new Factura[100];
	
	//funcion para retornar la primera posicion de productos que no este llena
	//si no, retorna -1
	
	public int getPosicionFacturas() {
		int i=0;
		while (facturas[i]!=null && i<facturas.length)
			i++;
		if (i==facturas.length)
			i=-1;
		return i;
	}//getPosicionFacturas
	
	@Override
	public void annadirProducto() {
		int i = Utilidades.getPosicionProductos(productos);	
		
		if (i==-1) {
			System.out.println("No se pueden crear mas productos (vector lleno).");
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
							Utilidades.limpiar();
							System.out.println("Tipo de lacteo?");
							System.out.println("1. Liquido.");
							System.out.println("2. Solido.");
							System.out.print("Opcion: "); aux = Utilidades.entrada.nextInt();
							aux += 4;
								
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
					System.out.println("Error al leer el dato, reingrese todo luego de la pausa.");
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
					
				case 5: //lacteo liquido
					productos[i] = new LacteosLiquidos();
					break;
					
				case 6: //lacteo solido
					productos[i] = new LacteosSolidos();
					break;
			}//switch
			
			productos[i].cargarDatos();
			Utilidades.limpiar();
			
			for (int j=0; j<productos.length && productos[j]!=null; j++) {
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
			
	}//annadirProducto

	@Override
	public void modificarExistenciaProducto() {
		String codigo;
		int i = 0;
		
		if (productos[0] == null) {
			System.out.println("No se han agregado productos.");
		}
		
		else {
			try {
				System.out.print("Ingrese el codigo del producto que desea modificar: "); codigo = Utilidades.entrada.next();
			} catch (InputMismatchException e) {
				System.out.println("Lo sentimos, ocurrio un error y regresara al menu.");
				codigo = "";
				Utilidades.pausa();
			}
			
			Utilidades.limpiar();
			
			while (i<productos.length && productos[i]!=null) {
				if (codigo.compareTo(productos[i].getCodigo())==0) {
					int cantidad;
					
					do {
						try {
							System.out.println("Que cantidad de" + productos[i].getDescripcion() + "desea agregar?"); cantidad = Utilidades.entrada.nextInt();
							
							if (cantidad <= 0) 
								throw new InputMismatchException(); //pereza hacer mas codigo para negativos y cero
							
						} catch (InputMismatchException e) {
							cantidad = 0;
							System.out.println("No es una cantidad valida, reingrese luego de la pausa.");
							Utilidades.pausa();
						}//catch mismatch
						
						Utilidades.limpiar();
					} while (cantidad <= 0);
					
					productos[i].setCantidadEnExistencia(productos[i].getCantidadEnExistencia()+cantidad);
					productos[i].mostrarDatos();
					System.out.println("\nActualizacion correcta.");					
					break;
				}//si ambos codigos son iguales
				i++;
			}//while
			
			if (i==productos.length) {
				System.out.println("Error, no existe un producto con ese codigo.");
			}//mostrar error
			
		}//else para verificar si hay productos
	}//modificarProducto

	@Override
	public void facturarVenta() {
		int i = getPosicionFacturas(), aux;
		
		/*3. Facturar Venta.En este caso debe usar un nuevo objeto de tipo factura para guardar
los datos de la venta, en este objeto debe guardar cada uno de los productos vendidos,
así como sus cantidades y la cédula del cliente. El programa debe verificar que la
cantidad vendida, no sea superior a la cantidad en existencia, en caso de ser positivo, el
producto no podrá venderse. Al final, se debe mostrar el total en bolívares de los
productos exentos de iva, el total en bolívares de los productos con iva, el total a pagar
por concepto de iva, y el total general a pagar por el cliente. Si ningún producto cumple
con la restricción de la cantidad en existencia, la venta debe cancelarse. (Usar un vector
para guardar las facturas)*/
		
		//valido que facturas tiene o no espacios
		if (i==-1) {
			System.out.println("Perdone, nos quedamos sin papel para hacer su factura. Vuelva luego.");
		}
		else {
			facturas[i] = new Factura();
			do {
				
				try {
					System.out.println("Que desea hacer?");
					System.out.println("1. Annadir productos a la lista.");
					System.out.println("2. Mirar la lista.");
					System.out.println("3. Eliminar uno o mas productos de la lista.");
					System.out.println("4. Ir a caja.");
					System.out.print("Opcion: "); aux = Utilidades.entrada.nextInt();
				} catch (InputMismatchException e) {
					aux = 0;
				}//catch
				
				Utilidades.limpiar();
				//Cuando se annadan productos verificar
				switch (aux) {
					case 1: //Annadir productos a la lista
						int j;
						do {
							System.out.println("Descripcion\tCantidad en existencia\tPrecio");
							for (j=0; j<productos.length && productos[j]!=null; j++) {
								if (productos[i].getCantidadEnExistencia()!=0) {
									System.out.println((j+1)+"\t"+productos[j].getCantidadEnExistencia()+"\t"+productos[j].getVenta());
								}
							}//mostrar productos
							System.out.println("Cualquier otra opcion: salir.");
							System.out.print("Opcion: ");
							try {
								j = Utilidades.entrada.nextInt();
								j--;
								if (productos[j].getCantidadEnExistencia()==0) {
									throw new InputMismatchException(); //me ahorro el sout
								}
							} catch(InputMismatchException e) {
								System.out.println("No es una opcion valida, regresara al menu anterior.");
								j=-1;
								Utilidades.pausa();
							}
							
							Utilidades.limpiar();
							
							if (j!=-1) {
								int k;
								
								for (k=0; k<facturas[i].getProd().length && facturas[i].getProd(k)!=null; k++) {
									if (facturas[i].getProd(k).getDescripcion().compareTo(productos[j].getDescripcion())==0) {
										break;
									}
								}//for para cuando se repiten los productos agregados; se sumaran las cantidades
								
								int auxi;
								
								try {
									System.out.print("Que cantidad de productos desea agregar a la lista?");
									auxi = Utilidades.entrada.nextInt();
									if (auxi<0 || auxi>productos[j].getCantidadEnExistencia()) {
										throw new InputMismatchException();
									}
								} catch(InputMismatchException e) {
									System.out.println("No existe esa cantidad de ingredientes (es posible que haya ingresado algo mal), volvera al menu anterior.");
									auxi=0;
									Utilidades.pausa();
									Utilidades.limpiar();
									continue;
								}
								
								//si no existe el producto en la lista
								if (facturas[i].getProd(k)==null) {
									facturas[i].setProd(productos[j], k);
									facturas[i].getProd(k).setCantidadEnExistencia(auxi);
									if (facturas[i].getProd(k) instanceof Viveres || facturas[i].getProd(k) instanceof Enlatados) {
										facturas[i].getProd(k).setVenta((facturas[i].getProd(k).getVenta()*1.12f));
									}
								}
								else {
									facturas[i].getProd(k).setCantidadEnExistencia(facturas[i].getProd(k).getCantidadEnExistencia()+auxi);
								}
								Utilidades.limpiar();
							}//if para validar que j no fue cero (salir)
						} while (j!=-1);
						break;
						
					case 2: //Mirar la lista
						for (j=0; j<facturas[i].getProd().length && facturas[i].getProd(j)!=null; j++) {
							System.out.println((j+1)+"\t"+productos[j].getCantidadEnExistencia()+"\t"+productos[j].getVenta());
						}
						Utilidades.pausa();
						Utilidades.limpiar();
						break;
						
					case 3 ://Eliminar productos de la lista
						do {
							for (j=0; j<facturas[i].getProd().length && facturas[i].getProd(j)!=null; j++) {
								System.out.println((j+1)+"\t"+productos[j].getCantidadEnExistencia()+"\t"+productos[j].getVenta());
							}
							System.out.println("Cualquier otra opcion: salir.");
							System.out.print("Opcion: ");
							try {
								j = Utilidades.entrada.nextInt();
								j--;
								if (j<0 || j>=facturas[i].getProd().length)
									j=-1;
							}
							catch (InputMismatchException e) {
								j=-1;
							}
							
							if (j!=-1) {
								do {
									facturas[i].setProd(facturas[i].getProd(j+1), j);
									j++;
								} while (j<(facturas[i].getProd().length-1));
							}//if para cuando es una opcion valida
							Utilidades.limpiar();
							
						} while (j!=-1);
						break;
						
					case 4: //Caja
						break;
						
					default:
						System.out.println("No es una opcion valida, reingrese luego de la pausa.");
						Utilidades.pausa();
						break;
				}
				
				Utilidades.limpiar();
			} while (aux!=4);
		}//else para validar que hay facturas disponibles
		
	}//facturarVenta

	@Override
	public void calcularIngresosBrutos() {
		
	}//calcularIngresosBrutos

	@Override
	public void calcularEgresos() {
		
	}//calcularEgresos

	@Override
	public void reporteExentosMayoresVentas() {
		
	}//reporteMayoresVentas
	
	@Override
	public void reporteBajaExistencia() {
		for (int i=0; i<productos.length && productos[i]!=null; i++) {
			if (productos[i].getCantidadEnExistencia()<10) {
				System.out.println(productos[i].toString());
			}//baja existencia (menor a 10)
		}//for
	}//reporteBajaExistencia
	
	@Override
	public void salir() {
		System.out.println("\nGracias por usar este programa.");
	}//salir
	
	
}//class Supermercado
