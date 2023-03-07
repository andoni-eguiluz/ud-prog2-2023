package tema1.basicos;

import java.util.ArrayList;

public class PruebaArrayList {

	private static ArrayList<Integer> l;  // Wrappers  -int - Integer  double - Double
	
	public static void main(String[] args) {
		pruebas();
		// ... ¿existe l?
		// ... ¿existe l2?
	}
	
	private static void pruebas() {
		int i1 = 5;
		int i2 = 3;
		l = new ArrayList<>();
		l.add( new Integer(7) );
		l.add( Integer.valueOf(5) );
		Integer i3 = new Integer(3);
		l.add( 0, i3 );
		l.remove( 1 );  // borra el que esté en la pos 1
		l.remove (i3);  // borra el integer 3 donde esté
		System.out.println( l + " - tamaño " + l.size() );
		l.clear();  // borra elementos
		ArrayList<Integer> l2 = new ArrayList<>();
		l2.add( new Integer(3) );
	}
}
