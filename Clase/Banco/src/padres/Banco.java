package padres;

import padres.Cuenta;
import hijas.*;

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
			System.out.print("Opcion: "); menu = entrada.nextInt();
			
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
			
			//cuentas dinamicas
			if (cuentas[cuentas.length-1]!=null) {
				Cuenta cuentasaux[] = new Cuenta[cuentas.length+1];
				System.arraycopy(cuentas, 0, cuentasaux, 0, cuentas.length);
				cuentas = cuentasaux;
			}
			
			do {
				System.out.println("Que tipo de cuenta desea crear?");
				System.out.println("1. Corriente.");
				System.out.println("2. Ahorro.");
				System.out.print("Opcion: "); opcion = entrada.nextInt();

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
			System.out.print("Ingrese su nombre: "); auxS = entrada.next();
			System.out.println("Su numero de cuenta es: "+(i+1));
			System.out.print("Ingrese saldo inicial que desea ingresar: "); auxD = entrada.nextDouble();
					
			switch (opcion) {
				case 1:
					cuentas[i] = new CuentaCorriente(auxS, Integer.toString(i+1), auxD);
					break;
				case 2:
					cuentas[i] = new CuentaAhorros(auxS, Integer.toString(i+1), auxD);
					break;
			}//switch
	}//crearCuenta
	
	public int getPosCuenta() {
		int i = 0;
		String aux;
		String nombre;
		
		System.out.println("Ingrese sus datos: ");
		System.out.print("Numero de cuenta: "); aux = entrada.next();
		System.out.print("Ingrese nombre: "); nombre = entrada.next();
		
		while (i<cuentas.length && cuentas[i]!=null) {
			
			if (cuentas[i].getCuenta().compareTo(aux)==0) //medida de seguridad
				if (cuentas[i].getCliente().compareTo(nombre)==0)
					return i;

				i++;
		}/*Comparar cuentas*/
		
		System.out.println("\nLa cuenta no existe o ingreso mal algun dato.");
		return -1;
	}//getPosCuenta
	
	public void consultarCuenta() {
		if (cuentas[0] == null) 
			System.out.println("No hay cuentas en el sistema.");

		else {
			int i;
			System.out.print("Consultar cuenta: ");
			i = getPosCuenta();
			
			if (i!=-1) {
				limpiar();
				cuentas[i].mostrarEstadoCuenta();
				System.out.print("Tipo de cuenta: ");
				System.out.println((cuentas[i] instanceof CuentaCorriente? "corriente.":"ahorro."));
				
				if (cuentas[i].getUnaTransaccion(0)==null)
					System.out.println("No hay registros de transacciones guardados.");
				
				else {
					System.out.println("\tTransacciones:");
					if (cuentas[i] instanceof CuentaAhorros) {
						CuentaAhorros cuenta = (CuentaAhorros) cuentas[i];
						cuenta.mostrarTransaccion();
					}//if
					else {
						CuentaCorriente cuenta = (CuentaCorriente) cuentas[i];
						cuenta.mostrarTransaccion();
					}//else de CuentaCorriente
				}//else para cuando existen transacciones
					
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
				
				do {
					System.out.println("Estado de cuenta.");
					cuentas[i].mostrarEstadoCuenta();
					System.out.println("\nQue tipo de transaccion desea realizar?");
					System.out.println("1. Deposito.");
					System.out.println("2. Retiro.");
					System.out.print("Opcion: "); aux = entrada.nextInt();
					
					if (aux<0 || aux>2) {
						System.out.println("No es una opcion valida, reingrese luego de la pausa.");
						pausa();
						limpiar();
					}
					
				} while (aux<0 || aux>2);
				
				System.out.println("Su saldo actual es de: "+cuentas[i].getSaldo());
				switch (aux) {
					case 1: //Deposito
						System.out.print("Ingrese la cantidad que desee depositar: "); auxf = entrada.nextFloat();
						cuentas[i].setSaldo(cuentas[i].getSaldo()+auxf);
						
						Deposito deposito = new Deposito(1, auxf);
						cuentas[i].addTransaccion(deposito);
						System.out.println("\nHecho. Su saldo actual es de: "+cuentas[i].getSaldo());
						break;
					case 2: //Retiro
						System.out.print("Ingrese la cantidad que desee retirar: "); auxf = entrada.nextFloat();
						if (auxf<=cuentas[i].getSaldo()) {
							cuentas[i].setSaldo(cuentas[i].getSaldo()-auxf);
							System.out.println("\nHecho. Su saldo actual es de: "+cuentas[i].getSaldo());
							Retiro retiro = new Retiro(1, auxf);
							cuentas[i].addTransaccion(retiro);
						}//if saldo actual mayor que el que se retirara
						else {
							Retiro retiro = new Retiro(0, auxf); //retiro fallido
							cuentas[i].addTransaccion(retiro);
							System.out.println("No se puede procesar su retiro: saldo insuficiente.");
						}
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
