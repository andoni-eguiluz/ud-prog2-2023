package tema1.resueltos;

/** Clase que define usuarios de redes sociales
 * @author andoni.eguiluz at ingenieria.deusto.es
 */
public class UsuarioRedSocial {

	// ATRIBUTOS Y MÉTODOS STATIC (de clase)
	
	// Posibles atributos static (de clase, solo una vez)
	public static int numUsuarios = 0;
	public static void recalcularUsuarios() {
		//...
		// this.nombre = "";  No existe this - no se puede usar en un método static
	}

	
	// ATRIBUTOS Y MÉTODOS NO STATIC (de objeto)
	
	private String nombre;  // COMPOSICIÓN
	private int milesSeguidores;
	private long fechaAlta;
	// ... direccion, correoElectronico...
	
	/** Crea un usuario nuevo con nombre vacío ("") y 0 seguidores
	 */
	public UsuarioRedSocial() {
		nombre = "";
		UsuarioRedSocial.numUsuarios++;
	}
	
	/** Crea un usuario nuevo
	 * @param nombre	Nombre del usuario
	 * @param seguidores	Número de seguidores
	 */
	public UsuarioRedSocial( String nombre, int seguidores ) {
		this.nombre = nombre;
		this.milesSeguidores = seguidores;
	}
	
	
	/** Crea un usuario nuevo con 0 seguidores
	 * @param nombre	Nombre de este usuario
	 */
	public UsuarioRedSocial( String nombre ) {
		this.nombre = nombre;
		this.milesSeguidores = 0;
	}

	
	/** Devuelve el nombre
	 * @return	Nombre actual del usuario
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/** Devuelve los seguidores
	 * @return	Número actual de seguidores, en miles
	 */
	public int getMilesSeguidores() {
		return this.milesSeguidores;
	}
	
	/** Devuelve la fecha de alta
	 * @return	Fecha de alta del usuario, en milisegundos desde el 1 de enero de 1970
	 */
	public long getFechaAlta() {
		return fechaAlta;
	}

	/** Modifica la fecha de alta
	 * @param fechaAlta	Nueva fecha de alta del usuario, en milisegundos desde el 1 de enero de 1970
	 */
	public void setFechaAlta(long fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/** Modifica los seguidores
	 * @param seguidores	Nuevo número de seguidores del usuario, en miles
	 */
	public void setMilesSeguidores(int seguidores) {
		if (seguidores < 0) {
			System.err.println( "Error: los seguidores deben ser positivos o cero" );
		} else {
			this.milesSeguidores = seguidores;
		}
	}

	/** Convierte a String el usuario
	 * @return	String con nombre de usuario, un tabulador y número de seguidores
	 */
	public String convertirAString() {
		return this.nombre + "\t" + milesSeguidores;
	}
	
	/** Saca a consola la información del usuario (nombre y seguidores)
	 */
	public void sacarAConsola() {
		System.out.println( convertirAString() );  // se puede llamar a unos métodos desde otros  (reutilizar)
	}
	
}
