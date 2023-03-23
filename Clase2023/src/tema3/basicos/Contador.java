package tema3.basicos;

/** Clase contador mutable - para el ejemplo de Java Collections (EjemploJC)
 * @author andoni.eguiluz at ingenieria.deusto.es
 */
public class Contador {
	private int cont = 0;
	/** Inicializa un contador con valor 1
	 */
	public Contador() {
		cont = 1;
	}
	
	/** Devuelve el valor del contador
	 * @return	Valor actual
	 */
	public int get() {
		return cont;
	}
	
	/** Incrementa el contador en una unidad
	 */
	public void inc() {
		cont++;
	}
	
	@Override
	public String toString() {
		return "" + cont;
	}
}
