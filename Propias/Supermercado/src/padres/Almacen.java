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
					System.out.println("4. Ir a caja y/o salir.");
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
								System.out.println((j+1)+"\t"+productos[j].getCantidadEnExistencia()+"\t"+productos[j].getVenta());
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
										throw new InputMismatchException(); //ahorro codigo si la cantidad que se pide es mayor a la existente o si esta mal
									}
								} catch(InputMismatchException e) {
									System.out.println("No se puede agregar esa cantidad de ese producto a la lista, volvera al menu anterior.");
									auxi=0;
									Utilidades.pausa();
									Utilidades.limpiar();
									continue;
								}
								
								productos[j].setCantidadEnExistencia(productos[j].getCantidadEnExistencia()-auxi);
								
								//si no existe el producto en la lista
								if (facturas[i].getProd(k)==null) {
									facturas[i].setProd(productos[j], k);
									facturas[i].getProd(k).setCantidadEnExistencia(auxi);
									
								}
								//si existe el producto se actualiza
								else {
									facturas[i].getProd(k).setCantidadEnExistencia(facturas[i].getProd(k).getCantidadEnExistencia()+auxi);
								}
								
								//ahora si arreglo precios para la muestra final
								if (facturas[i].getProd(k) instanceof Viveres || facturas[i].getProd(k) instanceof Enlatados) {
									facturas[i].getProd(k).setVenta(((productos[j].getVenta()*0.12f) + (productos[j].getVenta())));
								}//Cuando son enlatados o viveres se le añade iva del 12%
								
								facturas[i].getProd(k).setVenta(facturas[i].getProd(k).getCantidadEnExistencia() * facturas[i].getProd(k).getVenta());
								Utilidades.limpiar();
							}//if para validar que j no fue menos uno
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
								System.out.println("No existe ese producto en su lista, volvera al menu anterior.");
								j=-1;
								Utilidades.pausa();
								continue;
							}
							
							//devuelvo los productos al estante
							int k=0;
							while (k<productos.length && productos[k]!=null && productos[k].getDescripcion().compareTo(facturas[i].getProd(j).getDescripcion())!=0) {
								k++;
							}
							productos[k].setCantidadEnExistencia(productos[k].getCantidadEnExistencia()+facturas[i].getProd(j).getCantidadEnExistencia());
							
							if (j!=-1) {
								do {
									facturas[i].setProd(facturas[i].getProd(j+1), j);
									j++;
								} while (j<(facturas[i].getProd().length) && facturas[i].getProd(j+1)!=null);
								facturas[i].setProd(null, j); //REVISAR ESTO AL CORRERLO, ME HUELE A MAL
							}//if para cuando es una opcion valida
							Utilidades.limpiar();
							
						} while (j!=-1);
						break;
						
					case 4: //Caja
						//validar que al menos haya algo en la lista
						if (facturas[i].getProd(0)==null) {
							System.out.println("No comprara nada, vuelva luego.");
							facturas[i] = null;
						}
						else {
							//aqui deberia pedir nacionalidad, que no es nada dificil, pero ya se queda asi.
							int cedula;
							
							do {
								try {
									System.out.print("Ingrese su cedula: "); cedula = Utilidades.entrada.nextInt();
									if (cedula<=0) {
										throw new InputMismatchException();
										
									}//cedulas en cero y negativas no son validas
								} catch (InputMismatchException e) {
									cedula = 0;
									System.out.println("Ocurrio un error al momento de ingresar su cedula, reingre luego de la pausa.");
									Utilidades.pausa();
								}
								
								Utilidades.limpiar();
							} while (cedula == 0);
							
							//guardo la cedula en la factura
							facturas[i].setCedula(cedula);
							
							float conIva = 0f, sinIva = 0f, iva = 0f; 
							for (j=0; j<facturas[i].getProd().length && facturas[i].getProd(j)!=null; j++) {
								System.out.println((j+1)+"\t"+productos[j].getCantidadEnExistencia()+"\t"+productos[j].getVenta());
								
								if (facturas[i].getProd(j) instanceof Enlatados || facturas[i].getProd(j) instanceof Viveres) {
									conIva += facturas[i].getProd(j).getVenta();
									iva += (facturas[i].getProd(j).getVenta() / 1.12f);
								}//para calcular total de suma de productos con iva y suma total de iva
								else {
									sinIva += facturas[i].getProd(j).getVenta();
								}
								
							}//muestro la lista y aprovecho para hacer los calculos
							
							System.out.println("\nTotal de roductos exentos de iva: "+sinIva+"bs.");
							System.out.println("Total de productos con iva: "+conIva+"bs.");
							System.out.println("Total de iva: "+iva+"bs.");
							System.out.println("Total: "+(sinIva+conIva)+"bs.");
							System.out.println("\nGracias por comprar en el supermercado La Popular, esperamos que vuelva pronto.");
							
							Utilidades.pausa();
							Utilidades.limpiar();
						}
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
		float sumatoria = 0f;
		
		for (int i=0; i<facturas.length && facturas[i]!=null; i++) {
			for (int j=0; j<facturas[i].getProd().length && facturas[i].getProd(j)!=null; j++) {
				sumatoria += facturas[i].getProd(j).getVenta();
			}//for productos de facturas[i]
		}//for facturas
		
		System.out.println("Total de dinero ingresado a la empresa por venta de productos: "+sumatoria);
		Utilidades.limpiar();
	}//calcularIngresosBrutos

	@Override
	public void calcularEgresos() {
		float sumatoria = 0;
		
		for (int i=0; i<productos.length && productos[i]!=null; i++) {
			sumatoria += productos[i].getCosto();
		}
		
		System.out.println("Total de dinero egresado por compra de productos: "+sumatoria);
		Utilidades.limpiar();
	}//calcularEgresos

	@Override
	public void reporteExentosMayoresVentas() {
		int i=0, j=0;
		//Crear vector de productos con 30 espacios (productos.length) y llenarlo con los productos que vaya consiguiendo sin iva (igualo) y luego si reviso todas los precios de esos productos
		//que guarde en el vector para saber
		
		while (i<productos.length && productos[i]!=null) { 
			if (productos[i] instanceof Carnes || productos[i] instanceof LacteosSolidos || productos[i] instanceof LacteosLiquidos)
				j++;
			
			i++;
		}//while
		
		Producto mayoresVentas[] = new Producto[j];
		j=0;
		
		while (i<productos.length && productos[i]!=null) { 
			if (productos[i] instanceof Carnes || productos[i] instanceof LacteosSolidos || productos[i] instanceof LacteosLiquidos) {
				mayoresVentas[j] = productos[i];
				j++;
			}
				
			i++;
		}//while
			
		for (i=0; i<facturas.length && facturas[i]!=null; i++) {
			for (j=0; j<facturas[i].getProd().length && facturas[i].getProd(j)!=null; j++) {
				
				//AQUI TENGO QUE HACER OTRO FOR PARA COMPARAR DESCRPCIONES DE MAYORESVENTAS CON LAS FACTURAS, SI SON IGUALES HAGO SUMATORIA
				//Y ASI PARA TENER EN MAYORES VENTAS LA VENTA TOTAL DE CADA PRODUCTO, LUEGO SOLO TENGO QUE ORDENARLOS DE MAYOR A MENOR Y MOSTRAR LOS 10
				//PRIMEROS.
				
				/*if (facturas[i].getProd(j) instanceof Carnes || facturas[i].getProd(j) instanceof LacteosLiquidos || facturas[i].getProd(j) instanceof LacteosSolidos) {
				
				}//si productos son carnes o lacteos no se les aplica el iva y por tanto me sirven para lo que necesito
				*/
			}//for productos de facturas[i]
		}//for facturas 
		
		
		Utilidades.limpiar();
	}//reporteMayoresVentas
	
	@Override
	public void reporteBajaExistencia() {
		for (int i=0; i<productos.length && productos[i]!=null; i++) {
			if (productos[i].getCantidadEnExistencia()<10) {
				System.out.println(productos[i].toString());
			}//si baja existencia de producto (menor a 10)
		}//for
	}//reporteBajaExistencia
	
	@Override
	public void salir() {
		System.out.println("\nGracias por usar este programa.");
	}//salir
	
	
}//class Supermercado
