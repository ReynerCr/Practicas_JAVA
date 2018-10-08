package archivos;

import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;

import archivos.Auto;


public class Main {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Auto auto1 = new Auto("Fiat", "Siena", 1999);
		Auto auto2 = new Auto("Chevrolet", "Spark", 2006);
		
		FileOutputStream salArch = new FileOutputStream("autos.dat");
		ObjectOutputStream salStream = new ObjectOutputStream (salArch);
		
		salStream.writeObject(auto1);
		salStream.writeObject(auto2);
		
		salStream.close();
		
		FileInputStream entArch = new FileInputStream("autos.dat");
		ObjectInputStream entStream = new ObjectInputStream (entArch);
		
		Auto auto3 = (Auto) entStream.readObject();
		System.out.println(auto1.toString());
		
		System.out.println("\n-----------");
		
		Auto auto4 = (Auto) entStream.readObject();
		System.out.println(auto4.toString());
		
		System.out.println("\n se acabo");
		
	}

}
