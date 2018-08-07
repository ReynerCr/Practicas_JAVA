import javax.swing.JOptionPane;

public class Ejercicio_17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int codigo, litros, contador=0, litros_articulo1=0;
		float precio_litro, precio_factura, facturacion_total=0;
		System.out.println("Programa de facturación.");
		
		for (int i=1; i<=5; i++) {
			codigo = Integer.parseInt(JOptionPane.showInputDialog("Artículo N° "+i+"\nDigite el código del artículo: "));
			litros = Integer.parseInt(JOptionPane.showInputDialog("Artículo N° "+i+"\nDigite la cantidad en litros: "));
			precio_litro = Float.parseFloat(JOptionPane.showInputDialog("Artículo N° "+i+"\nDigite el precio por litros: "));
			
			precio_factura = (float) (precio_litro * litros);
			if (codigo == 1) {
				litros_articulo1 += litros;
			}
			
			if (precio_factura>600) {
				contador++;
			}
			
			facturacion_total += precio_factura;
		}
		
		System.out.println("Resumen de ventas");
		System.out.println("Facturación total: "+facturacion_total);
		System.out.println("Cantidad en litros vendidos del articulo 1: "+litros_articulo1);
		System.out.println("Cantidad de facturas de más de 600$: "+contador);
	}

}
