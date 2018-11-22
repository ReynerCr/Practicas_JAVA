package utilidades;

@SuppressWarnings("serial")
public class Menu extends PanelPadre {
	
	private static Menu instance = null;
	
	private BotonMenu nuevoJ;
	private BotonMenu instrucciones;
	private BotonMenu top10;
	private BotonMenu creditos;
	private BotonMenu salir;	
	
	private Menu() {
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		iniciarBotones();
	}
	
	public static Menu getInstance() {
		if (instance == null)
			instance = new Menu();
		
		return instance;
	}
	
	public void iniciarBotones() {
		nuevoJ = new BotonMenu("Nuevo juego");
		nuevoJ.addActionListener(ManejaEventos.nuevoJuego());
		nuevoJ.setBounds((this.getWidth()/2)/2, 200, 300, 50);
		
		instrucciones = new BotonMenu("Instrucciones");
		instrucciones.addActionListener(ManejaEventos.instrucciones());
		instrucciones.setBounds((this.getWidth()/2)/2, nuevoJ.getY() + 80, 300, 50);
		
		top10 = new BotonMenu("Top 10");
		top10.addActionListener(ManejaEventos.top10());
		top10.setBounds((this.getWidth()/2)/2, instrucciones.getY() + 80, 300, 50);
		
		creditos = new BotonMenu("Creditos");
		creditos.addActionListener(ManejaEventos.creditos());
		creditos.setBounds((this.getWidth()/2)/2, top10.getY() + 80, 300, 50);
		
		salir = new BotonMenu("Salir");
		salir.addActionListener(ManejaEventos.salir());
		salir.setBounds((this.getWidth()/2)/2, creditos.getY() + 80, 300, 50);
		
		this.add(nuevoJ);
		this.add(instrucciones);
		this.add(top10);
		this.add(creditos);
		this.add(salir);
	}
}
