package tema1.resueltos.ej13;

import java.awt.Point;
import java.util.ArrayList;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class GrupoCirculos {
	private ArrayList<Circulo> listaCirculos;
	public GrupoCirculos() {
		listaCirculos = new ArrayList<Circulo>();
	}
	public void anyadir( Circulo circulo ) {
		listaCirculos.add( circulo );
	}
	public void remove( Circulo circulo ) {
		listaCirculos.remove( circulo );
	}
	public int size() {
		return listaCirculos.size();
	}
	public void dibujar( VentanaGrafica vent ) {
		for (Circulo circulo : listaCirculos) {
			circulo.dibujar( vent );
		}
	}
	public Circulo encuentraCirculoEnPunto( Point punto ) {
		Circulo hayCirculoClicado = null;
		for (Circulo circulo : listaCirculos) {
			if (circulo.contienePunto( punto )) {
				hayCirculoClicado = circulo;
				break;
			}
		}
		return hayCirculoClicado;
	}
}
