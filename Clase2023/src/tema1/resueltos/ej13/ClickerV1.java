package tema1.resueltos.ej13;

import java.awt.Color;
import java.awt.Point;
import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class ClickerV1 {
	public static void main(String[] args) {
		// Pruebas de ventana gráfica
		VentanaGrafica vent = new VentanaGrafica( 800, 600, "Mi ventanita" );
		vent.dibujaCirculo( 100, 150, 25, 3, Color.CYAN, new Color( 115, 45, 18 ) );
		Point punto = vent.getRatonClicado();
		punto = vent.esperaAClick();
		System.out.println( punto );
	}
}
