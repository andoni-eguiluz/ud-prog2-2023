package tema1.resueltos.ej13;

import java.awt.Color;
import java.awt.Point;
import java.util.Date;
import java.util.Random;

public class Circulo {

	private static float grosor = 1.0f; // grosor del círculo, en píxeles
	private static final int RADIO_MINIMO = 10; // Radio mínimo de círculo aleatorio
	private static final int RADIO_MAXIMO = 20; // Radio máximo de círculo aleatorio
	private static final int X_MAXIMA = 500;
	private static final int Y_MAXIMA = 300;
	private static final Random random = new Random();

	public static float getGrosor() {
		return grosor;
	}

	public static void setGrosor(float grosor) {
		Circulo.grosor = grosor;
	}

	
	// NO STATIC
	
	private int radioEnPixels;  // radio del círculo, en píxeles
	private int xCentro;
	private int yCentro;
	private Color colorBorde;
	private Color colorRelleno;
	private long tiempoCreacionMs;
	
	/** Crea un círculo nuevo
	 * @param radioEnPixels	Radio del círculo en píxeles. Debe ser positivo
	 * @param xCentro	Coordenada x del centro del círculo, en píxeles (de izquierda a derecha)
	 * @param yCentro	Coordenada y del centro del círculo, en píxeles (de arriba abajo)
	 * @param colorBorde	Color del borde
	 * @param colorRelleno	Color de rellenoe
	 */
	public Circulo(int radioEnPixels, int xCentro, int yCentro, Color colorBorde, Color colorRelleno) {
		this.radioEnPixels = radioEnPixels;
		this.xCentro = xCentro;
		this.yCentro = yCentro;
		this.colorBorde = colorBorde;
		this.colorRelleno = colorRelleno;
		tiempoCreacionMs = System.currentTimeMillis();
	}
	
	/** Crea un círculo nuevo
	 * @param radioEnPixels	Radio del círculo en píxeles. Debe ser positivo
	 * @param centro	Coordenadas del centro del círculo, en píxeles
	 * @param colorBorde	Color del borde
	 * @param colorRelleno	Color de rellenoe
	 */
	public Circulo(int radioEnPixels, Point centro, Color colorBorde, Color colorRelleno) {
		this( radioEnPixels, centro.x, centro.y, colorBorde, colorRelleno );
//		this.radioEnPixels = radioEnPixels;
//		this.xCentro = centro.x;
//		this.yCentro = centro.y;
//		this.colorBorde = colorBorde;
//		this.colorRelleno = colorRelleno;
//		tiempoCreacionMs = System.currentTimeMillis();
	}
	
	/** Crea un círculo nuevo de color azul y relleno amarillo
	 * @param radioEnPixels	Radio del círculo en píxeles. Debe ser positivo
	 * @param xCentro	Coordenada x del centro del círculo, en píxeles (de izquierda a derecha)
	 * @param yCentro	Coordenada y del centro del círculo, en píxeles (de arriba abajo)
	 */
	public Circulo(int radioEnPixels, int xCentro, int yCentro) {
		this.radioEnPixels = radioEnPixels;
		this.xCentro = xCentro;
		this.yCentro = yCentro;
		colorBorde = Color.BLUE;
		colorRelleno = Color.YELLOW;
		tiempoCreacionMs = System.currentTimeMillis();
	}
	
	// Constructor aleatorio
	public Circulo() {
		radioEnPixels = RADIO_MINIMO + random.nextInt( RADIO_MAXIMO-RADIO_MINIMO+1 ); // 0-10 + 10
		xCentro = random.nextInt( X_MAXIMA );
		yCentro = random.nextInt( Y_MAXIMA );
		colorBorde = new Color( random.nextInt(256), random.nextInt(256), random.nextInt(256));
		Color[] colores = { Color.BLUE, Color.PINK, Color.CYAN, Color.GREEN };
		colorRelleno = colores[ random.nextInt( colores.length ) ];
		tiempoCreacionMs = System.currentTimeMillis();
	}
	
	
	
	
	public int getxCentro() {
		return xCentro;
	}

	public void setxCentro(int xCentro) {
		this.xCentro = xCentro;
	}

	public int getyCentro() {
		return yCentro;
	}

	public void setyCentro(int yCentro) {
		this.yCentro = yCentro;
	}

	public Color getColorBorde() {
		return colorBorde;
	}

	public void setColorBorde(Color colorBorde) {
		this.colorBorde = colorBorde;
	}

	public Color getColorRelleno() {
		return colorRelleno;
	}

	public void setColorRelleno(Color colorRelleno) {
		this.colorRelleno = colorRelleno;
	}

	public int getRadioEnPixels() {
		return radioEnPixels;
	}

	public long getTiempoCreacionMs() {
		return tiempoCreacionMs;
	}

	public String toString() {
		return String.format( "(%d,%d) - %d", xCentro, yCentro, radioEnPixels );
	}
	

	
}
