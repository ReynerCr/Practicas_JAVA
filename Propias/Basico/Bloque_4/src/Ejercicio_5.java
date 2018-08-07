import java.util.Scanner;

public class Ejercicio_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		
		int conteo_ceros=0, conteo_positivos=0, conteo_negativos=0;
		float[] numero = new float[5];
		float media_positivos, media_negativos, suma_positivos=0f, suma_negativos=0f;
		
		for (int i=0; i<5; i++ ) {
			System.out.print(i+1+". Ingrese numero");
			numero[i] = entrada.nextFloat();
			
			if (numero[i]==0) {
				conteo_ceros++;
			}
			else if (numero[i]<0) {
				conteo_negativos++;
				suma_negativos += numero[i];
			}
			else {
				conteo_positivos++;
				suma_positivos += numero[i];
			}
		}//for
		
		if (conteo_positivos == 0) {
			System.out.println("No hubo positivos entre los números");
		}
		else {
			media_positivos = suma_positivos/conteo_positivos;
			System.out.println("La media de positivos es de: "+media_positivos);
		}
		
		if (conteo_negativos == 0) {
			System.out.println("No hubo negativos entre los números");
		}
		else {
			media_negativos = (suma_negativos/ conteo_negativos);
			System.out.println("La media de negativos es de: "+media_negativos);
		}
		
		if (conteo_ceros == 0) {
			System.out.println("No hubo ceros entre los números");
		}
		else {
			System.out.println("La cantidad de ceros entre los números es de: "+conteo_ceros);
		}
		entrada.close();
		
	}

}
