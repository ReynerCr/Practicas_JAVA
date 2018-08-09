package principal;

import java.io.IOException;
import java.util.Scanner;

import padre.*;
import hijas.*;

public class Implementacion {
	
	public static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		final int tamanno = 5;
		int menu, iterador = 0, aux=0;
		Producto productos[] = new Producto[tamanno];
		do {
			System.out.println("Programa de inventario de lacteos y electronicos.");
			System.out.println("1. Cargar un lacteo.");
			System.out.println("2. Cargar un electronico.");
			System.out.println("3. Ver elementos lacteos.");
			System.out.println("4. Ver elementos electronicos.");
			System.out.println("5. Modificar algun dato de un producto.");
			System.out.println("6. Modificar algun dato de un producto ingresando el codigo.");
			System.out.println("7. Reporte de todos los productos.");
			System.out.println("8. Recuento de elementos ingresados.");
			System.out.println("9. Salir.");
			System.out.print("Opcion: ");  menu = entrada.nextInt();
			
			limpiar();
			
			switch (menu) {
				case 1:
					if (iterador<tamanno) {
						productos[iterador] = new Lacteos();
						productos[iterador].cargarDatos();
						codigoRepetido(productos, iterador);
						iterador++;
					}
					else 
						System.out.println("El vector esta lleno.");
					break;
					
				case 2:
					if (iterador<tamanno) {
						productos[iterador] = new Electronicos();
						productos[iterador].cargarDatos();
						codigoRepetido(productos, iterador);
						iterador++;
					}
					else 
						System.out.println("El vector esta lleno.");
					break;
					
				case 3:
					if (iterador > 0) {
						for (int i=0; i<iterador; i++) {
							if (productos[i] instanceof Lacteos) {
								productos[i].mostrarDatos();
								System.out.println("\n");
								aux++;
							}//if
							if (i==(aux-1) && aux==0)
								System.out.println("No se han ingresado lacteos.");
						}//for
					}//if
					else
						System.out.println("No se han ingresado productos.");
					break;
					
				case 4:
					if (iterador > 0)
						for (int i=0; i<iterador; i++) {
							if (productos[i] instanceof Electronicos) {
								productos[i].mostrarDatos();
								System.out.println("\n");
								aux++;
							}//if
							if (i==(aux-1) && aux==0)
								System.out.println("No se han ingresado electronicos.");
						}//for
					else
						System.out.println("No se han ingresado productos.");
					break;
					
				case 5:
					int pos;
					if (iterador > 0) {
						do {
							System.out.println("Que producto desea modificar?");
							imprimirProductos(productos, iterador);
							System.out.println("Opcion: "); pos = entrada.nextInt(); pos--;
							
							if (pos<0 || pos>iterador) {
								System.out.println("No es una opcion valida, reingrese despues de la pausa.");
							}
							limpiar();
						} while (pos<0 || pos>iterador);

						modificarDato(productos[pos]);
						codigoRepetido(productos, pos); //en caso de que se codigo haya cambiado
					}//if iterador>0
					else
						System.out.println("No se han ingresado productos.");
					break;
					
				case 6:
					if (iterador > 0) {
						do {
							System.out.print("Ingrese codigo del producto que desee modificar: "); pos = entrada.nextInt();
							if (pos<0) {
								System.out.println("Codigo debe ser mayor o igual a 0, reingrese despues de la pausa.");
							}								
								
							limpiar();
						} while (pos<0);
						
						for (int i=0; i<iterador; i++) {
							if ((productos[i].getCodigo()).compareTo(Integer.toString(pos))==0) {
								pos = i;
								break; //rompo ciclo
							}
							else if (i==(iterador-1))
								pos = -1;
						}//for para determinar cual es la posicion del producto a cambiar
						
						if (pos != -1) {
							modificarDato(productos[pos]);
							codigoRepetido(productos, pos); //en caso de que se codigo haya cambiado
						}
						else 
							System.out.println("Codigo no coincide con ninguno de los productos ingresados.");

					}//if iterador>0
					else
						System.out.println("No se han ingresado productos.");
					break;
					
				case 7:
					if (iterador > 0) {
						System.out.println("Reporte de productos:");
						for (int i=0; i<iterador; i++) {
							System.out.print(productos[i].getCodigo()+"\t"+productos[i].getNombre()+"\t"+productos[i].getPrecio()+"\t"+productos[i].getEstado()+"\t"+(productos[i] instanceof Lacteos? "Lacteo":"Electronico")+"\t"+productos[i].getCantidadIngredientes()+"\t");
							if (productos[i].getCantidadIngredientes()>0) {
								for (int j=0; j<productos[i].getCantidadIngredientes(); j++) {
									System.out.print(productos[i].getFormulas(j).getNombre());
									if (j<(productos[i].getCantidadIngredientes()-1))
										System.out.print("\n\t\t\t\t\t\t\t");
								}//for j
							}//if cantidadIngredientes>0
							System.out.println();
						}//for i
						
					}//if
					else 
						System.out.println("No se ingresaron productos.");
					break;
					
				case 8:
					int lacteos = 0, electronicos = 0;
					
					for (int i=0; i<iterador; i++) {
						if (productos[i] instanceof Lacteos)
							lacteos++;
						else
							electronicos++;
					}//for
					
					System.out.println("Total de productos ingresados: "+iterador);
					System.out.println("Productos lacteos ingresados: "+lacteos);
					System.out.println("Productos electronicos ingresados: "+electronicos);				
					break;
					
				case 9: //para evitar el default 
					System.out.println("Gracias por usar el programa.");	
					break;
					
				default:
					System.out.println("No valido, por favor reingrese.");
					break;
			}//switch
			
			limpiar();
		} while (menu!=9);
			
	}//main
	
	public static void limpiar() {
		entrada.nextLine();
		entrada.nextLine();
		for (int i=0; i<40; i++) {
			System.out.println();
		}
	}//limpiar
	
	public static void imprimirProductos(Producto productos[], int iterador) {
		for (int i=0; i<iterador; i++) {
			System.out.println((i+1)+". "+productos[i].getNombre());
		}//for
	}//imprimirProductos
	
	public static void codigoRepetido(Producto productos[], int pos) {
		for (int i=0; i<productos.length && productos[i]!=null; i++) {
			if (i!=pos && productos[pos].getCodigo().compareTo(productos[i].getCodigo())==0) {
				System.out.print("Codigo repetido, reingrese: ");
				productos[pos].setCodigo(Producto.valCodigo());
				codigoRepetido(productos, pos);
			}
		}
	}//codigoRepetido
	
	public static void modificarDato(Producto producto) throws IOException {
		int opcion;
		String aux;
		float auxf;
		
		do {
			System.out.println("1. Codigo.");
			System.out.println("2. Nombre.");
			System.out.println("3. Precio.");
			System.out.println("4. Estado.");
			System.out.println("5. Cantidad de ingredientes.");
			System.out.println("6. Un ingrediente.");
			System.out.println("7. "+(producto instanceof Lacteos? "Caducidad.":"Voltaje."));
			System.out.println("8. Todo.");
			System.out.print("Opcion: "); opcion = entrada.nextInt(); 
			
			if (opcion<0 || opcion>8) {
				System.out.println("No es una opcion valida, reingrese despues de la pausa.");
			}
			limpiar();
		} while (opcion<0 || opcion>8);
		
		switch (opcion) {
			case 1:
				System.out.print("Ingrese nuevo codigo de "+producto.getNombre()+":" );
				aux = Producto.valCodigo();
				producto.setCodigo(aux);
				break;
			
			case 2:
				System.out.print("Ingrese nuevo nombre de "+producto.getNombre()+":");
				aux = entrada.next();
				producto.setNombre(aux);
				break;
			
			case 3:
				System.out.print("Ingrese nuevo precio de "+producto.getNombre()+":");
				auxf = entrada.nextFloat();
				producto.setPrecio(auxf);
				break;
			
			case 4:
				System.out.print("Ingrese nuevo estado de "+producto.getNombre()+":");
				aux = entrada.next();
				producto.setEstado(aux.charAt(0));
				break;
			
			case 5:
				System.out.print("Ingrese nueva cantidad de ingredientes de "+producto.getNombre()+":");
				aux = entrada.next();
				producto.setCantidadIngredientes(Integer.parseInt(aux));
				break;
			
			case 6:
				if (producto.getCantidadIngredientes()>0) {
					do {
						System.out.println("Ingredientes de "+producto.getNombre()+":");
						for (int i=0; i<producto.getCantidadIngredientes(); i++) {
							System.out.println((i+1)+". "+producto.getFormulas(i).getNombre());
						}
						System.out.println("Opcion: "); aux = entrada.next();
						aux = Integer.toString((Integer.parseInt(aux)-1));
						if (Integer.parseInt(aux)<0 || Integer.parseInt(aux)>=producto.getCantidadIngredientes()) {
							System.out.println("Opcion no valida, reingrese despues de la pausa.");
						}
						limpiar();
					} while (Integer.parseInt(aux)<0 || Integer.parseInt(aux)>=producto.getCantidadIngredientes());
					
					producto.getFormulas(Integer.parseInt(aux)).cargarDatos();
					
				}//if
				else
					System.out.println("No hay ingredientes en este elemento.");
				break;
			
			case 7:
				System.out.print("7. Ingrese nuevo/a "+(producto instanceof Lacteos? "caducidad":"voltaje")+": ");
				if (producto instanceof Lacteos) {
					Lacteos laux;
					laux = (Lacteos) producto;
					aux = entrada.next();
					laux.setCaducidad(aux);
					producto = laux;
				}//if
				else {
					Electronicos eaux;
					eaux = (Electronicos) producto;
					aux = entrada.next();
					eaux.setVoltaje(Integer.parseInt(aux));
					producto = eaux;
				}//else
				break;
			
			case 8:
				System.out.println("Cambiar todo de "+producto.getNombre()+".");
				producto.cargarDatos();
				break;
		}//switch
	}//modificarDato
	
}//class Implementacion
