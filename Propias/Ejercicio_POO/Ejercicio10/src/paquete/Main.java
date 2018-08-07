package paquete;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner entrada = new Scanner(System.in);
	static ArrayList<Persona> equipo = new ArrayList<Persona>();

	public static void main(String arg[]) {
		int menu;
		menu = entrada.nextInt();

		do {
			System.out.println("Menu:");
			System.out.println("1. Viaje de equipo.");
			System.out.println("2. Entrenamiento.");
			System.out.println("3. Partido de futbol.");
			System.out.println("4. Planificar entrenamiento.");
			System.out.println("5. Entrevista.");
			System.out.println("6. Curar lesion.");
			System.out.println("7. Salir.");

			switch (menu) {
			case 1:
				System.out.println("El equipo viajo hacia USA para su partido.");
				break;

			case 2:
				System.out.println("El equipo esta entrenando.");
				break;

			case 3:
				System.out.println("El equipo esta jugando contra sus rivales.");
				break;

			case 4:
				System.out.println("El entrenador esta planificando un entrenamiento.");
				break;

			case 5:
				System.out.println("Jugador x fue entrevistado.");
				break;

			case 6:
				// for each evaluando vector y determinando los tipos de cada cosa
				System.out.println("El doctor esta curando la lesion de algun jugador.");
				break;

			case 7:
				break;

			default:
				System.out.println("Opcion no valida, reingrese.");
				break;
			}
		} while (menu != 7);

	}// main

	public void llenarDatos() {
		Byte aux;
		int edad;
		String nombre, apellido;

		do {
			System.out.println("Que tipo de miembro desea agregar?");
			System.out.println("1. Futbolista.");
			System.out.println("2. Entrenador.");
			System.out.println("3. Medico.");
			System.out.println("4. Ninguno, salir.");
			aux = entrada.nextByte();

			switch (aux) {
			case 1:
				int dorsal, posicion;
				System.out.println("Ingrese datos del futbolista:");
				System.out.println("Nombre: ");
				nombre = entrada.next();
				System.out.println("Apellido: ");
				apellido = entrada.next();
				System.out.println("Dorsal: ");
				dorsal = entrada.nextInt();
				System.out.println("Posicion: ");
				posicion = entrada.nextInt();
				System.out.println("Edad: ");
				edad = entrada.nextInt();

				Futbolista futbolista = new Futbolista(dorsal, posicion, nombre, apellido, edad);
				equipo.add(futbolista);
				break;

			case 2:
				String estrategia;

				System.out.println("Ingrese datos del entrenador:");
				System.out.println("Nombre: ");
				nombre = entrada.next();
				System.out.println("Apellido: ");
				apellido = entrada.next();
				System.out.println("Edad: ");
				edad = entrada.nextInt();
				System.out.println("Estrategia: ");
				estrategia = entrada.next();

				Entrenador entrenador = new Entrenador(estrategia, nombre, apellido, edad);
				equipo.add(entrenador);
				break;

			case 3:
				int anosExperiencia;
				String titulacion;

				System.out.println("Ingrese datos del doctor:");
				System.out.println("Nombre: ");
				nombre = entrada.next();
				System.out.println("Apellido: ");
				apellido = entrada.next();
				System.out.println("Edad: ");
				edad = entrada.nextInt();
				System.out.println("Años de experiencia: ");
				anosExperiencia = entrada.nextInt();
				System.out.println("Titulacion: ");
				titulacion = entrada.next();

				Doctor doctor = new Doctor(titulacion, anosExperiencia, nombre, apellido, edad);
				equipo.add(doctor);
				break;

			case 4:
				break;

			default:
				System.out.println("Valor ingresado no valido, reingrese.");
				break;
			}

			System.out.println("Desea agregar otro miembro?");
			aux = entrada.nextByte();

		} while (aux != 4);

	}// llenarDatos
}// Main class
