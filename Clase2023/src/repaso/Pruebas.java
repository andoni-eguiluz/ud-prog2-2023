package repaso;

import java.util.ArrayList;

public class Pruebas {
	static int var;
	public static void main(String[] args) {
		Pruebas.var = 5;
	//	i = 5;
		Pruebas p = new Pruebas();
		p.i = 5;
		p.hacer();
		Pruebas p2 = new Pruebas();
		p2.i = 7;
		p2.hacer();
		ArrayList<Integer> l = new ArrayList<>();
		l.add( 5 );
		System.out.println( l.get(0) + 3 );
		ArrayList<java.awt.Point> lP;
		Madre dato;
		dato = new Madre();
		dato = new Hija();
		dato.m();
		I varI = new Madre();
		Calculable calc = new Hija();
		try {
			calc.calcular();
		} catch (NullPointerException e) {
			System.out.println( "Usuario: programa finalizado" );
		} catch (IndexOutOfBoundsException e) {
			System.out.println( "Usuario: programa finalizado por índice incorrecto" );
		}
	}
	
	
	// ---- PLANTILLA (modelo de creación de objetos)
	
	int i;
	
	public Pruebas() {
		
	}
	
	void hacer() {
		this.i++;
	}
	
}

interface I {
	public abstract void m();
}

interface Calculable {
	double calcular();
}

class Madre implements I {
	public void m() {
		System.out.println( "m" );
	}
}

class Hija extends Madre implements I, Calculable {
	@Override
	public void m() {
		System.out.println( "h" );
	}
	@Override
	public double calcular() throws NullPointerException {
		// .. imaginemos que puede haber un NPE
		return -7;
	}
}
