package utilerias;

public class listaEspera {
	private Factura facturas[] = new Factura[5];
	public int contador = 0; //para saber hasta donde esta llena 
	
	public listaEspera() {
		super();
		for (int i = 0; i < facturas.length; i++) {
			facturas[i] = new Factura();
		}//for
	}

	public listaEspera(Factura[] facturas) {
		for (int i = 0; i < facturas.length; i++) {
			this.facturas[i] = new Factura(facturas[i]);
			contador++;
		}//for
	}

	public Factura[] getFacturas() {
		return facturas;
	}
	
	public Factura getFacturas(int i) {
		return facturas[i];
	}

	public void setFactura(Factura fact, int i) {
		facturas[i] = new Factura(fact);
	}
}//class listaEspera
