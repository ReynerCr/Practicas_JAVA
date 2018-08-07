package implementacion;

import java.util.Scanner;
import padres.Banco;

public class Main {
	
	public Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		Banco banco = new Banco();
		banco.iniciar(); //iniciar todo, no necesito mas en el main.
	}//main
	
}
