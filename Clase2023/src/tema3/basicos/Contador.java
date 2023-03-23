package tema3.basicos;

public class Contador {
	private int cont = 0;
	/** Inicializa un contador con valor 1
	 */
	public Contador() {
		cont = 1;
	}
	
	public int get() {
		return cont;
	}
	
	public void inc() {
		cont++;
	}
	
	@Override
	public String toString() {
		return "" + cont;
	}
}
