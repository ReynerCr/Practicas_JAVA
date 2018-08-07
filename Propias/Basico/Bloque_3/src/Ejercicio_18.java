import javax.swing.JOptionPane;

public class Ejercicio_18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// MODIFICACIONES DEL ANTERIOR, SOLO 3 PRODUCTOS
		int codigo, litros, contador=0, litros_articulo1=0;
		float precio_factura=0, facturacion_total=0;
		System.out.println("Programa de facturación.");
		
		for (int i=1; i<=5; i++) {
			
			do {
				codigo = Integer.parseInt(JOptionPane.showInputDialog("Artículo N° "+i+"\nDigite el código del artículo: "));
			} while (codigo < 1 || codigo > 3);
			
			litros = Integer.parseInt(JOptionPane.showInputDialog("Artículo N° "+i+"\nDigite la cantidad en litros: "));
			
			switch (codigo) {
				case 1:
					litros_articulo1 += litros;
					precio_factura = 0.6f * litros;
					break;
				case 2:
					precio_factura = 3f * litros;
					break;
				case 3:
					precio_factura = 1.25f * litros;
					 break;
			}
			
			if (precio_factura > 600) {
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
