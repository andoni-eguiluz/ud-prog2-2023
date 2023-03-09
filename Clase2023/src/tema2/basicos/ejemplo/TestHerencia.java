package tema2.basicos.ejemplo;

import java.util.ArrayList;

public class TestHerencia {
	public static void main(String[] args) {
		prueba();
	}
	
	public static void prueba() {
		Esfera e1 = new Esfera( 100, 150, 2 );
		System.out.println( e1.toString() );
		Planeta p1 = new Planeta();
		Planeta p2 = new Planeta( 200, 200, 80, "Tierra" );
		p2.setRadio(0);
		System.out.println( p2 );
		Planeta p3 = new Planeta( 200, 200, 1, "Marte" );
		ArrayList<Planeta> lPlanetas = new ArrayList<>();
		lPlanetas.add( p3 );
//		lPlanetas.add( e1 );
		
		ArrayList<Esfera> lEsferas = new ArrayList<>();
		lEsferas.add( e1 );
		lEsferas.add( p3 ); 
		Esfera e5 = p3;
		Object o = p3;
	}
}
