package tema1.resueltos.ej13;

import java.awt.Color;
import java.awt.Point;
import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class ClickerV1 {
	public static void main(String[] args) {
		Circulo c = new Circulo( 15, 100, 200, Color.CYAN, Color.BLUE );
		System.out.println( c.toString() );
		Point punto = new Point( 200, 150 );
		Circulo c2 = new Circulo( 15, punto, Color.WHITE, Color.BLUE );
		System.out.println( c2 );
		Circulo c3 = new Circulo( 20, 80, 90 );
		System.out.println( c3 + " color " + c3.getColorBorde() );
		Circulo c4 = new Circulo();
		System.out.println( c4 );
		crearVentana( c4 );
	}
	
	private static void crearVentana( Circulo c) {
		// Pruebas de ventana gráfica
		VentanaGrafica vent = new VentanaGrafica( 800, 600, "Mi ventanita" );
		vent.dibujaCirculo( c.getxCentro(), c.getyCentro(), c.getRadioEnPixels(), Circulo.getGrosor(), 
				c.getColorBorde(), c.getColorRelleno() );
		Point punto = vent.getRatonClicado();
		punto = vent.esperaAClick();
		System.out.println( punto );
	}
}
