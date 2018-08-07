import java.util.Scanner;

public class Ejercicio_16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Programa para gestionar las notas de un centro educativo. Cada grupo compuesto por 5 alumnos. Leer las notas de tres trimestres
		 * de UN grupo. Al final mostrar la nota media del grupo en cada trimestre, y la media del alumno que se encuentra en la posición N
		 * (digitada por el usuario)
		 */
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		
		String clase[] = new String[5];
		float primer[], segundo[], tercer[], nota, media_primer=0f, media_segundo=0f, media_tercer=0f, media_N;
		int N;
		primer = new float[5];
		segundo = new float[5];
		tercer = new float[5];
		
		
		System.out.println("Programa para gestionar notas de un grupo de cinco alumnos.");
		//Pido los nombres
		System.out.println("Ingrese los nombres de los alumnos: ");
		for (int i=0; i<5; i++) {
			System.out.print((i+1)+". Ingrese el nombre: ");
			clase[i] = entrada.next();
		}
		
		//Pedir las tres calificaciones de cada alumno y acomodarlas en los respectivos arreglos
		System.out.println("\nAhora ingrese las tres calificaciones de cada alumnos (0-10)"); 
		
		for (int i=0; i<5; i++) {
			for (int j=0; j<3; j++) {
				System.out.print((j+1)+". "+clase[i]+": ");
				nota = entrada.nextFloat();
				if (nota<0 || nota>10) {
					System.out.println("No es una nota válida, reingrese la nota de ese trimestre");
					j--;
					continue;
				}
				switch (j) {
					case 0: primer[i] = nota;
							break;
					case 1: segundo[i] = nota;
							break;
					case 2: tercer[i] = nota;
							break;
				}//switch j
			}//for J
			System.out.println();
		}//for I
		
		
		//Sacar la nota media del grupo de cada trimestre
		for (int i=0; i<3; i++) {
			for (int j=0; j<5; j++) {
				switch (i) {
					case 0: media_primer += primer[j];
							break;
					case 1: media_segundo += segundo[j];
							break;
					case 2: media_tercer += tercer[j];
							break;
				}//switch j
			}//for j
		}//for i
	
		media_primer /=5;
		media_segundo /=5;
		media_tercer /=5;
	
		//Imprimir las notas medias
		System.out.println("La nota media del grupo en el primer trimestre es de: "+media_primer);
		System.out.println("La nota media del grupo en el segundo trimestre es de: "+media_segundo);
		System.out.println("La nota media del grupo en el tercer trimestre es de: "+media_tercer);
		
		//For para mostrar los alumnos y los números de los mismos, no es necesario pero queda bonito.
		System.out.println("\nALUMNOS:"); 
		for (int i=0; i<5; i++) {
			System.out.println((i+1)+". "+clase[i]);
		}
		//Pedir número del alumno
		System.out.print("Ingrese el número del alumno del que desea saber la nota media: ");
		N = (entrada.nextInt())-1;
		
		//Verificar que el número ingresado es correcto o no, y en ese caso, se pide de nuevo
		while (N<0 || N>4) {
			System.out.print("No existe ese alumno en el curso, reingrese: ");
			N = (entrada.nextInt())-1;
		} 
		
		//Sacar la nota media del alumno y mostrarla
		media_N = (primer[N] + segundo[N] + tercer[N])/3;
		System.out.println("\nNota media de "+clase[N]+": "+media_N);
		System.out.println("Fin de programa.");
	}

}
