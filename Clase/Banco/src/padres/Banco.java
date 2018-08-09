package padres;

import padres.Cuenta;
import hijas.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Banco {
	
	Cuenta cuentas[] = new Cuenta[1]; 
	public static Scanner entrada = new Scanner(System.in);
	
	public Banco() { /*constructor vacio, no hace falta realmente*/ }
		
	public int menu() {
		int menu;
		do {
			System.out.println("Sistema de banco X. ");
			System.out.println("1. Crear cuenta.");
			System.out.println("2. Consultar cuenta.");
			System.out.println("3. Realizar transaccion.");
			System.out.println("4. Salir.");
			System.out.print("Opcion: "); 
			try {
				menu = entrada.nextInt();
			} catch (InputMismatchException e) {
				menu = 0;
			}
			
			if (menu<1 || menu>4) {
				System.out.println("No es una opcion valida, reingrese luego de la pausa.");
				pausa();
			}
			
			limpiar();
		} while(menu<1 || menu>4);
		return menu;
	}//menu
	
	public void crearCuenta() { 
			int opcion;
			
			//cuentas "dinamicas"
			if (cuentas[cuentas.length-1]!=null) {
				Cuenta cuentasaux[] = new Cuenta[cuentas.length+1];
				System.arraycopy(cuentas, 0, cuentasaux, 0, cuentas.length);
				cuentas = cuentasaux;
			}
			
			do {
				System.out.println("Que tipo de cuenta desea crear?");
				System.out.println("1. Corriente.");
				System.out.println("2. Ahorro.");
				System.out.print("Opcion: "); 
				try {
					opcion = entrada.nextInt();
				} catch (InputMismatchException e) {
					opcion = 0;
				}

				if(opcion<1 || opcion>2) {
					System.out.println("No es una opcion valida, reingrese luego de la pausa.");
					pausa();
				}
				
				limpiar();
			} while (opcion<1 || opcion>2);
			
			int i = cuentas.length - 1;
			double auxD;
			String auxS;
			
			System.out.println("Llenar cuenta. IMPORTANTE: NO OLVIDE SU CUENTA Y NOMBRE.");
			try {
				System.out.print("Ingrese su nombre: "); auxS = entrada.next();
				System.out.println("Su numero de cuenta es: "+(i+1));
				System.out.print("Ingrese saldo inicial que desea ingresar: "); auxD = entrada.nextDouble();
			} catch (InputMismatchException e) {
				auxS = "";
				auxD = 0.0;
				System.out.println("Lo sentimos, ha ocurrido un error al leer los datos, intente de nuevo al volver al menu. Gracias.");
				opcion = 0;
				pausa();
			}
			
			switch (opcion) {
				case 1:
					cuentas[i] = new CuentaCorriente(auxS, Integer.toString(i+1), auxD);
					break;
				case 2:
					cuentas[i] = new CuentaAhorros(auxS, Integer.toString(i+1), auxD);
					break;
				default: //error
					break;				
			}//switch
	}//crearCuenta
	
	public int getPosCuenta() {
		int i = 0;
		String aux;
		String nombre;
		
		System.out.println("Ingrese sus datos: ");
		try {
			System.out.print("Numero de cuenta: "); aux = entrada.next();
			System.out.print("Ingrese nombre: "); nombre = entrada.next();
		} catch (InputMismatchException e) {
			i = cuentas.length+1; //evitar que el while de abajo se cumpla
			aux = "";
			nombre = "";
			System.out.println("Lo sentimos, ha ocurrido un error al leer los datos, intente de nuevo al volver al menu. Gracias.");
			pausa();
		}
		
		while (i<cuentas.length && cuentas[i]!=null) {
			if (cuentas[i].getCuenta().compareTo(aux)==0) //medida de seguridad
				if (cuentas[i].getCliente().compareTo(nombre)==0)
					return i;

				i++;
		}//Comparar cuentas
		
		System.out.println("\nLa cuenta no existe o ingreso mal algun dato.");
		return -1;
	}//getPosCuenta: no esta en diagrama pero me sirve para ahorrar codigo
	
	public void consultarCuenta() {
		if (cuentas[0] == null) 
			System.out.println("No hay cuentas en el sistema.");

		else {
			int i;
			
			i = getPosCuenta();
			
			if (i!=-1) {
				limpiar();
				if (cuentas[i] instanceof CuentaCorriente) {
					CuentaCorriente corriente = (CuentaCorriente) cuentas[i];
					corriente.mostrarEstadoCuenta();
				}
				else {
					CuentaAhorros ahorro = (CuentaAhorros) cuentas[i];
					ahorro.mostrarEstadoCuenta();
				}
			}//if existe la cuenta
			
			System.out.println("\nSe cerrara la sesion.");
			
		}//else si existe al menos una cuenta
		
		pausa();
	}//consultarCuenta
	
	public void realizarTransaccion() {
		if (cuentas[0] == null)
			System.out.println("No hay cuentas en el sistema.");
		
		else {
			int i=0;
			System.out.println("Realizar una transaccion.");
			i = getPosCuenta();
			
			if (i!=-1) {
				int aux;
				double auxf;
				limpiar();
				do {
					System.out.println("\nQue tipo de transaccion desea realizar?");
					System.out.println("1. Deposito.");
					System.out.println("2. "+(cuentas[i] instanceof CuentaCorriente? "Cobrar cheque.":"Retiro."));
					System.out.print("Opcion: "); 
					try {
						aux = entrada.nextInt();
					} catch (InputMismatchException e) {
						aux = 0;
					}
					
					if (aux<=0 || aux>2) {
						System.out.println("No es una opcion valida, reingrese luego de la pausa.");
						pausa();
					}
					limpiar();
				} while (aux<=0 || aux>2);
				System.out.println("Su saldo actual es de: "+cuentas[i].getSaldo());
				switch (aux) {
					case 1: //Deposito
						do {
							System.out.print("Ingrese la cantidad que desee depositar: "); 
							try {
								auxf = entrada.nextFloat();
								
								if (auxf<0) {
									auxf *= -1;
									System.out.println("La cantidad que se va a depositar no puede ser negativa, lo corregiremos por usted.");
									pausa();
								}//deposito negativo
								
							} catch (InputMismatchException e) {
								auxf = 0;
								System.out.println("Lo sentimos, hubo un problema al leer los datos, reingrese luego de la pausa.");
								pausa();
								limpiar();
							}//catch mismatch
							
						} while (auxf==0);
						
						cuentas[i].setSaldo(cuentas[i].getSaldo()+auxf);
						limpiar();
						
						Deposito deposito = new Deposito(auxf);
						cuentas[i].addTransaccion(deposito);
						System.out.println("\nHecho. Su saldo actual es de: "+cuentas[i].getSaldo());
						break;
					case 2: //Retiro o cobro de cheque
						do {
							System.out.print("Ingrese la cantidad que vaya a "+(cuentas[i] instanceof CuentaCorriente? "cobrar: ":"retirar: ")); 
							try {
								auxf = entrada.nextFloat();
								
								if (auxf<0) {
									auxf *= -1;
									System.out.println("La cantidad que se va a "+(cuentas[i] instanceof CuentaCorriente? "cobrar":"retirar")+" no puede ser negativa, lo corregiremos por usted.");
									pausa();
								}//retiro o cobro de cheque negativo
								
							} catch (InputMismatchException e) {
								auxf = 0;
								System.out.println("Lo sentimos, hubo un problema al leer los datos, reingrese luego de la pausa.");
								pausa();
								limpiar();
							}//catch mismatch
							
							limpiar();	
						} while(auxf==0);
						
						if (auxf<=cuentas[i].getSaldo()) {
							cuentas[i].setSaldo(cuentas[i].getSaldo()-auxf);
							System.out.println("\nHecho. Su saldo actual es de: "+cuentas[i].getSaldo());
							
							if (cuentas[i] instanceof CuentaAhorros) {
								Retiro retiro = new Retiro(auxf*-1);
								cuentas[i].addTransaccion(retiro);
							}//ahorro
							else {
								CobroCheque cheque = new CobroCheque(auxf*-1);
								cuentas[i].addTransaccion(cheque);
							}//corriente
							
						}//if saldo actual mayor que el que se retirara
						else {
							if (cuentas[i] instanceof CuentaAhorros) {
								System.out.println("No se puede procesar su retiro: saldo insuficiente.");
							}//ahorro
							else {
								System.out.println("No puede cobrar su cheque: saldo insuficiente.");
							}//corriente							
						}//else para saldo insuficiente
						break;
						
				}//switch aux
			}//if existe la cuenta
			System.out.println("\nSe cerrara la sesion.");
		}//else si existe al menos una cuenta
		pausa();
	}//realizarTransaccion
	
	public void iniciar() {
		int menu;
		do {
			menu = menu();
			switch(menu) {
				case 1: //crear cuenta
					crearCuenta();
					break;
				
				case 2: //consultar cuenta
					consultarCuenta();
					break;
			
				case 3: //realizar transaccion
					realizarTransaccion();
					break;
					
				case 4: //salir
					System.out.println("Gracias por usar este sistema.");					
					break;
			}//switch
			limpiar();
		} while (menu != 4);
	}//iniciar
	
	public static void pausa() {
		entrada.nextLine();
		entrada.nextLine();
	}//hacer una pausa
	
	public static void limpiar() {
		for (int i=0; i<40; i++) { System.out.println(); }
	}//"limpiar" pantalla
	
}
