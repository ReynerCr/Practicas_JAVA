package juego;

import java.awt.Font;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import utilidades.ManejaEventos;

@SuppressWarnings("serial")
public class PanelAuxiliar extends PanelPadre {
	
	public PanelAuxiliar(Image fondo, int opcion) {
		super(fondo);
		
		BotonMenu volver = new BotonMenu("Volver", ManejaEventos.volverAMenu());
		volver.setBounds(30, this.getHeight() - 150, 150, 80);
		this.add(volver);
		
		EtiquetaPersonalizada titulo = new EtiquetaPersonalizada("", 1);
		titulo.setFont(new Font("Arial", Font.BOLD, 25));
		titulo.setBounds((this.getWidth()/2)/2, 80, 300, 50);
		this.add(titulo);
		
		switch (opcion) {
			case 0:
				titulo.setText("Ingrese su nombre:");
				cargarNombre();
				break;
		
			case 1: //instrucciones //TODO
				titulo.setText("Instrucciones:");
				
				break;
			case 2: //top10
				titulo.setText("Top 10:");
				cargarTop10();
				break;
			case 3: //creditos
				titulo.setText("Creditos:");
				cargarCreditos();
				break;
		}//switch(num)
		this.add(titulo);
	}
	
	private void cargarNombre() {
		JTextField cajaT = new JTextField();
		cajaT.setFont(new Font("Arial", Font.BOLD, 20));
		cajaT.setBounds(150, 360, 200, 40);
		cajaT.addActionListener(ManejaEventos.cajaTexto(cajaT));
		this.add(cajaT);
		
		EtiquetaPersonalizada etiqueta = new EtiquetaPersonalizada("Maximo 8 caracteres y ninguno igual a \"@\".", 1);
		etiqueta.setBounds(30, 400, 540, 50); //TODO poner mas weas al constructor de esto para no tener que llamar todo el rato a lo mismo
		this.add(etiqueta);
	}
	
	private void cargarTop10() {
		EtiquetaPersonalizada etiqueticas[] = new EtiquetaPersonalizada[10];
		URL url = this.getClass().getResource("recursos/top10.dat");
		
		Scanner entrada = null;
		try {
			if (url == null)
				throw new FileNotFoundException();
			
			entrada = new Scanner (new File(url.getPath()));
			int i = 0;
			while(entrada.hasNextLine() && i < 10) {
				String cadenas[] = (entrada.nextLine()).split("@");
				Long.parseLong(cadenas[1]); //valido que el puntaje si sean numeros
				etiqueticas[i] = new EtiquetaPersonalizada((i+1) + ". " + cadenas[0] + "......"+ cadenas[1], 2);
				etiqueticas[i].setFont(new Font("Arial", Font.BOLD, 18));
				etiqueticas[i].setBounds(30, 190 + (i*40), 540, 50);
				etiqueticas[i].setTamanyoImagen(540, 30);
				this.add(etiqueticas[i]);
				i++;
			}//while
			
			if (i == 0) 
				throw new FileNotFoundException(); //reutilizo codigo en caso de que nadie haya jugado y terminado
			
			entrada.close();
		} catch (FileNotFoundException e) {
			etiqueticas[0] = new EtiquetaPersonalizada("No hay registros de jugadores.", 2);
			etiqueticas[0].setFont(new Font("Arial", Font.BOLD, 18));
			etiqueticas[0].setBounds(30, 320, 540, 50);
			etiqueticas[0].setTamanyoImagen(540, 50);
			this.add(etiqueticas[0]);
			entrada.close();
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "El archivo esta corrupto, se creara una copia en el directorio y se borrara el original.");
			entrada.close();
			try {
				for (int i = 0; i < etiqueticas.length && etiqueticas[i]!=null; i++)
					this.remove(etiqueticas[i]);
				
				String dir = this.getClass().getResource("recursos/").getPath();
				dir = dir + "DANADO_top10.dat";
				
				FileWriter fw = new FileWriter(new File(dir));
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);
				
				entrada = new Scanner(new File(url.getPath()));
				
				while (entrada.hasNextLine())
					pw.println(entrada.nextLine());
				
				entrada.close();
				pw.close();
				
				System.out.println(new File(url.getPath()).delete());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Ocurrio un error grave: " + e.getMessage());
			}//catch
		}//catch
	}
	
	private void cargarCreditos() {
		EtiquetaPersonalizada etiqueta;
		
		etiqueta = new EtiquetaPersonalizada("Reyner Contreras;  C.I: V.-26934400;  seccion 01.", 2);
		etiqueta.setFont(new Font("Arial", Font.BOLD, 18));
		etiqueta.setBounds(30, 280, 540, 50);
		etiqueta.setTamanyoImagen(540, 50);
		this.add(etiqueta);
		
		etiqueta = new EtiquetaPersonalizada("John Llanes;  C.I: V.-30853320;  seccion 04.", 2);
		etiqueta.setFont(new Font("Arial", Font.BOLD, 18));
		etiqueta.setBounds(30, 340, 540, 50);
		etiqueta.setTamanyoImagen(540, 50);
		this.add(etiqueta);
		
		etiqueta = new EtiquetaPersonalizada("Version: 1.00", 2);
		etiqueta.setFont(new Font("Arial", Font.BOLD, 25));
		etiqueta.setBounds((this.getWidth()/2)/2, 500, 300, 50);
		this.add(etiqueta);
	}
}
