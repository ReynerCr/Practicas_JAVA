package archivos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import archivos.Auto;


public class Main {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Auto auto1 = new Auto("Fiat", "Siena", 1999);
		Auto auto2 = new Auto("Chevrolet", "Spark", 2006);

		//creo archivo autos
		FileOutputStream salArch = new FileOutputStream("autos.dat");
		ObjectOutputStream salStream = new ObjectOutputStream (salArch);
		salStream.writeObject(auto1);
		salStream.writeObject(auto2);
		salStream.close();
		
		//leo archivo autos
		FileInputStream entArch = new FileInputStream("autos.dat");
		ObjectInputStream entStream = new ObjectInputStream (entArch);
		auto1 = (Auto) entStream.readObject();
		auto2 = (Auto) entStream.readObject();
		entStream.close();
		
		//imprimo autos
		System.out.println(auto1.toString());
		System.out.println(auto2.toString());		
		System.out.println("\nSe acabo.");
		
	}

}
