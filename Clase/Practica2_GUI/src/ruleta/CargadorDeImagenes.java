package ruleta;

import java.net.URL;

import javax.swing.ImageIcon;

public class CargadorDeImagenes {
	private static CargadorDeImagenes instancia = null;
	
	private static final int MAX_IMAGENES = 38;
	public static final int CUADRO_BLANCO = 0;
	public static final int CUADRO_AMARILLO = 1;
	public static final int LETRAS_INICIO = 2;
	public static final int LETRAS_FIN = 28;
	public static final int FLECHA = 29;
	public static final int RULETA_INICIO = 30;
	public static final int RULETA_FIN = 37;
	
	private ImageIcon imagenes[];
	
	/** Constructor que carga todas las imagenes en un string de ImageIcon. */
	private CargadorDeImagenes() {
		URL url;
		imagenes = new ImageIcon[MAX_IMAGENES];
		String nombImagenes[] = new String[MAX_IMAGENES];
		nombImagenes[0] = "cuadro1.jpg";
		nombImagenes[1] = "cuadro2.jpg";
		
		int aux = 65;
		for (int i = 2; i < MAX_IMAGENES; i++) {
			if (i >= LETRAS_INICIO && i <= LETRAS_FIN && aux != 79) {
				nombImagenes[i] = "cuadro" + (char) aux + ".jpg";
				aux++;
			}//si es letra
			else if (aux == 79) {
				nombImagenes[i] = "cuadroNN.jpg"; //aqui el 165 de la enye no lo agarraba asi que renombre.
				i++;
				nombImagenes[i] = "cuadro" + (char) aux + ".jpg";
				aux++;
			}//si es enye
			else if (i == FLECHA) {
				nombImagenes[i] = "flecha.gif";
				aux = 0;
			}//si es flecha y aprovecho a reutilizar aux
			else if (i >= RULETA_INICIO) {
				nombImagenes[i] = "ruleta" + aux + ".gif";
				aux++;
			}//si es ruleta
		}//for
		
		for (int i = 0; i < MAX_IMAGENES; i++) {
			url = this.getClass().getResource("recursos/"+nombImagenes[i]);
			imagenes[i] = new ImageIcon(url);
		}//for
	}//CargadorDeImagenes()
	
	/** Metodo que devuelve la instancia en caso de ya haber sido creada,
	 *  o la crea en caso contrario.  */
	public static CargadorDeImagenes getInstancia() {
		if (instancia == null) 
			instancia = new CargadorDeImagenes();
		
		return instancia;
	}//getInstancia()
	
	/** Metodo para devolver una imagen. */
	public ImageIcon getImagen(int nImagen) {
		if (nImagen < 0 || nImagen >= MAX_IMAGENES || imagenes[nImagen] == null)
			return null;
		
		return imagenes[nImagen];
	}//getImagen(int)
	
}//CargadorDeImagenes
