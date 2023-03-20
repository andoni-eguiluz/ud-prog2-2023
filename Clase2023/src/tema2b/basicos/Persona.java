package tema2b.basicos;

import java.util.ArrayList;
import java.util.Arrays;

// @SuppressWarnings("rawtypes")
// public class Persona implements Comparable {  // Interfaz raw (Object) sin genericidad
public class Persona implements Comparable<Persona> {  // Interfaz con genericidad, específico de la clase Persona
	
	/** Método de prueba de la clase Persona
	 * @param args	No utilizado
	 */
	public static void main(String[] args) {
		Persona p1 = new Persona( 11111111, 'c', "Andoni", "Pérez" );
		Persona p2 = new Persona( 22222222, 'd', "Luis", "González" );
		Persona p3 = new Persona( 33333333, 'e', "María", "Ruiz" );
		ArrayList<Persona> l = new ArrayList<>();
		l.add( p1 );
		l.add( p2 );
		l.add( p3 );
		// Otra manera:
		// ArrayList<Persona> l2 = new ArrayList<>( Arrays.asList( p1, p2, p3 ) );
		System.out.println( l );
		l.sort( null );
		System.out.println( l );
	}

	//  Interfaz Comparable
//	@Override
//	public int compareTo(Object o) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	
	// Interfaz Comparable<Persona>
	@Override
	public int compareTo(Persona o) {
		// objeto this y objeto o --> negativo si this < o, 0 si this==o, + si this > o
		// Orden natural: decidimos dni
	}
	
	@Override
	public String toString() {
		return "" + dniNumero + dniLetra + ": " + nombre + " " + apellidos;
	}
	
	
	
	private int dniNumero;
	private char dniLetra;
	private String nombre;
	private String apellidos;
	public Persona(int dniNumero, char dniLetra, String nombre, String apellidos) {
		super();
		this.dniNumero = dniNumero;
		this.dniLetra = dniLetra;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	public int getDniNumero() {
		return dniNumero;
	}
	public void setDniNumero(int dniNumero) {
		this.dniNumero = dniNumero;
	}
	public char getDniLetra() {
		return dniLetra;
	}
	public void setDniLetra(char dniLetra) {
		this.dniLetra = dniLetra;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
}
