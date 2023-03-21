package tema3.basicos;

import java.util.*;

/** Clase de ejemplo de uso de Java Collections
 * @author andoni.eguiluz at ingenieria.deusto.es
 */
public class EjemploJC {
	public static void main(String[] args) {
		String[] peliculas = {
			"The whale", "Todo a la vez en todas partes", "Elvis", "Avatar 2", "Pinocho",
			"Todo a la vez en todas partes", "Elvis", "Avatar 2",
			"Todo a la vez en todas partes", "Elvis", "Avatar 2",
			"Todo a la vez en todas partes", "Elvis", 
			"Todo a la vez en todas partes", "Avatar 2",
			"Todo a la vez en todas partes", "Avatar 2",
			"Todo a la vez en todas partes", "Avatar 2",
			"Todo a la vez en todas partes", 
		};
		Collection<String> c = null; // Interfaz de colecciones lineales de elementos
		// 1.- Lista - implementada con un array, sin tamaño fijo, puede crecer, insertar/borrar, con repetición
		//     acceso por INDICE - 0, ... n-1
		List<String> listaG = null; // No se puede instanciar, es interface new List<>();
		ArrayList<String> l = new ArrayList<>();
		for (String p : peliculas) {
			l.add( p );
		}
		System.out.println( l );
		
		// Internamente es una lista enlazada
		LinkedList<String> l2 = new LinkedList<>();
		for (String p : peliculas) {
			l2.add( p );
		}
		System.out.println( l2 );
		
		// SETS - colecciones pero no listas
		// Estructura es lineal, pero NO admite repetición, NO tiene índice
		// pero sí se puede recorrer
		
		HashSet<String> s1 = new HashSet<>();
		for (String p : peliculas) {
			s1.add( p );
		}
		System.out.println( s1 );

		TreeSet<String> s2 = new TreeSet<>();
		for (String p : peliculas) {
			s2.add( p );
		}
		System.out.println( s2 );
		
		
	}
}
