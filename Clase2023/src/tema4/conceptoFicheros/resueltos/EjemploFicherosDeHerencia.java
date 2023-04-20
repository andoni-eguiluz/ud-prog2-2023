package tema4.conceptoFicheros.resueltos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/** Ejemplo para aprender a hacer ficheros binarios y de texto
 * con una pequeña jerarquía Usuario / UsuarioDePago / UsuarioGratis
 * @author andoni.eguiluz at ingenieria.deusto.es
 */
public class EjemploFicherosDeHerencia {
	private static ArrayList<Usuario> lUsuarios = new ArrayList<>();
	public static void main(String[] args) {
		lUsuarios.add( new UsuarioDePago( "a", new Password("aa"), 25.0 ) );
		lUsuarios.add( new UsuarioGratis( "b", new Password("bb"), 5 ) );
		lUsuarios.add( new UsuarioDePago( "c", new Password("cc"), 18.0 ) );
		System.out.println( "Antes de fichero: " + lUsuarios );
		// TODO
		// Implementar y llamar guardarUsuariosEnFicheroBinario()
		guardarUsuariosEnFicheroBinario();
		// Implementar y llamar cargarUsuariosEnFicheroBinario()
		lUsuarios = cargarUsuariosEnFicheroBinario();
		System.out.println( "Después de fichero binario: " + lUsuarios );
		// Implementar y llamar guardarUsuariosEnFicheroDeTexto()
		guardarUsuariosEnFicheroDeTexto();
		// Implementar y llamar cargarUsuariosEnFicheroDeTexto()
		lUsuarios = cargarUsuariosEnFicheroDeTexto();
		System.out.println( "Después de fichero de texto: " + lUsuarios );
	}

	private static void guardarUsuariosEnFicheroBinario() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( "usuarios.dat" ) );
			oos.writeObject( lUsuarios );
			oos.close();
		} catch (IOException e) {
			System.out.println( "No se ha podido escribir el fichero de usuarios binario" );
			e.printStackTrace();
		}
	}
	/** Lee el fichero binario
	 * @return	Devuelve la lista de usuarios del fichero, o null si hay error
	 */
	private static ArrayList<Usuario> cargarUsuariosEnFicheroBinario() {
		try {
			ObjectInputStream ois = new ObjectInputStream( new FileInputStream( "usuarios.dat" ) );
			ArrayList<Usuario> l = (ArrayList<Usuario>) ois.readObject();
			ois.close();
			return l;
		} catch (IOException | ClassNotFoundException | ClassCastException e) {
			e.printStackTrace();
			return null;
		}
	}
	private static void guardarUsuariosEnFicheroDeTexto() {
		File fic = new File( "data" );
		fic.mkdir();
		try (PrintStream ps = new PrintStream( "data/usuarios.txt" )) {
			for (Usuario usuario : lUsuarios) {
				ps.println( usuario.aLinea() );
			}
		} catch (FileNotFoundException e) {
			System.out.println( "Error en gestión de fichero" );
			e.printStackTrace();
		}
	}
	private static ArrayList<Usuario> cargarUsuariosEnFicheroDeTexto() {
		try (Scanner scanner = new Scanner( new FileInputStream( "data/usuarios.txt" ) )) {
			ArrayList<Usuario> l = new ArrayList<>();
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				Usuario usuario = Usuario.crearDesdeLinea( linea );
			}
			return l;
		} catch (FileNotFoundException e) {
			
		}
		return null;
	}
	
}



abstract class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String nick;
	protected Password password;
	private /*transient*/ String passwordAsteriscos;
	public Usuario(String nick, Password password) {
		this.nick = nick; this.password = password;
		passwordAsteriscos = password.toString();
	}
	public String getNick() { return nick; }
	public Password getPassword() { return password; }
	@Override public String toString() { return nick + " " + passwordAsteriscos; }
	public abstract String aLinea();
	
	public static Usuario crearDesdeLinea( String linea ) {
		// TODO Pendiente: hacer crearDesdeLinea en clases hijas
		Usuario ret = UsuarioDePago.crearDesdeLinea( linea );
		if (ret!=null) {
			return ret;
		}
		ret = UsuarioGratis.crearDesdeLinea( linea );
		return ret;
	}
}

class UsuarioDePago extends Usuario { // implements Serializable {
	private static final long serialVersionUID = 1L;
	private double cuota;
	public UsuarioDePago(String nick, Password password, double cuota) {
		super(nick, password);
		this.cuota = cuota;
	}
	public double getCuota() { return cuota; }
	@Override public String toString() { return super.toString() + " " + cuota; }

	@Override
	public String aLinea() {
		return "DEPAGO\t" + nick + "\t" + password.getPassword() + "\t" + cuota;
	}
}

class UsuarioGratis extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private int numAnuncios;
	public UsuarioGratis(String nick, Password password, int numAnuncios) {
		super(nick, password);
		this.numAnuncios = numAnuncios;
	}
	public int getNumAnuncios() { return numAnuncios; }
	@Override public String toString() { return super.toString() + " " + numAnuncios; }

	@Override
	public String aLinea() {
		return "GRATIS\t" + nick + "\t" + password.getPassword() + "\t" + numAnuncios;
	}
}

class Password implements Serializable {
	private static final long serialVersionUID = 1L;
	private String password;
	public Password(String password) {
		super();
		this.password = password;
	}
	public String getPassword() { return password; }
	@Override
	public String toString() { return password.replaceAll( ".", "*" ); }
}
