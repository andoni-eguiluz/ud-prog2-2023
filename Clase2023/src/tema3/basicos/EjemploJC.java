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
		
		Collection<String> coleccion = null; // Interfaz de colecciones lineales de elementos
		List<String> lista = null; // No se puede instanciar, es interface new List<>();
			// Hereda de Collection (toda List es una Collection)

		// ¿Tipos de listas? 2 clases implementan el interfaz:
		// 1.- ArrayList - implementada con un array, sin tamaño fijo, puede crecer, insertar/borrar, con repetición
		//     acceso por INDICE - 0, ... n-1
		ArrayList<String> l = new ArrayList<>();
		for (String p : peliculas) {
			l.add( p );
		}
		System.out.println( l );
		
		// 2.- LinkedList. Internamente es una lista enlazada
		LinkedList<String> l2 = new LinkedList<>();
		for (String p : peliculas) {
			l2.add( p );
		}
		System.out.println( l2 );
		if (l2.contains( "Elvis")) {
			System.out.println( "Elvis está en la lista" );
		}
		
		// Mejor LinkedList cuando solo se inserta/borra en los extremos. En cualquier otro caso, mejor ArrayList.
		
		// SETS - colecciones pero no listas
		Set<String> set = null;  // Interfaz
		// Estructura es lineal, pero NO admite repetición, NO TIENE ÍNDICES (no se puede sacar de "posición")
		// Sí se puede recorrer  (también implementa Iterable)

		// Implementación 1: hash (sin orden)
		HashSet<String> s1 = new HashSet<>();
		for (String p : peliculas) {
			s1.add( p );
		}
		System.out.println( s1 );
		System.out.println( "Elvis".hashCode() );  // Las tripas del hashset

		// Implementación 2: tree (con orden natural)
		TreeSet<String> s2 = new TreeSet<>();
		for (String p : peliculas) {
			s2.add( p );
		}
		System.out.println( s2 );
		if (s2.contains( "Elvis")) {
			System.out.println( "Elvis está en la lista" );
		}
		for (String dato : s2) {
			System.out.println( "Dato " + dato );
		}
		
		// MAPAS
		// Operaciones: put para meter / get para coger / containsKey si existe clave / remove
		// Clave?  (por qué busco)
		// Dato/valor? (qué es lo que hay asociado a la clave)
		// Contar votos -> Clave = nombre de la peli / Valor = Nº de votos
		HashMap<String,Integer> mapa = new HashMap<>();
		// Tarea: contar votos
		for (String peli : peliculas) {
			if (mapa.containsKey(peli)) {
				/*
				Integer numVotos = mapa.get( peli );
				int numVotosInt = numVotos.intValue();  // unbox
				numVotosInt = numVotosInt + 1;
				Integer numVotos2 = Integer.valueOf( numVotosInt );  // box
				// mapa.put( peli, numVotos2 ); igual que el replace
				mapa.replace( peli, numVotos2 );
				*/
				mapa.replace( peli, mapa.get(peli) + 1 );  // boxing y unboxing
			} else {
				mapa.put( peli, Integer.valueOf(1) );
			}
			System.out.println( mapa );
		}
		System.out.println( mapa );
		
		// Rehacer lo mismo con contadores mutables
		TreeMap<String,Contador> mapa2 = new TreeMap<>();
		for (String peli : peliculas) {
			if (!mapa2.containsKey(peli)) {
				mapa2.put( peli, new Contador() );
			} else {
				mapa2.get( peli ).inc();
			}
		}
		System.out.println( mapa2 );
		int maxVotos = 0;
		String peliMax = "";
		for (String clave : mapa2.keySet()) {
			System.out.println( " Película " + clave + " votos " + mapa2.get(clave) );
			if (maxVotos < mapa2.get(clave).get()) {
				maxVotos = mapa2.get(clave).get();
				peliMax = clave;
			}
		}
		System.out.println( "Ganadora: " + peliMax + " con " + maxVotos );

		// Ejercicio: sacar de cada peli los "jueces" que la han votado
		HashMap<String,ArrayList<Integer>> mapaVotos;
		
		// TODO ESTO igual pero con
		// clase Pelicula que contenga nombre de película
		
	}
}
