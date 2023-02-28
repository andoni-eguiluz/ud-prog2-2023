package tema1.resueltos;

public class Ejercicio10iConObjetos {
	//	Crea dos arrays, uno con los nombres de 4 o 5 usuarios de cualquier red social que uses,
	//	y otro con sus seguidores. Realiza un programa que muestre por consola esos usuarios 
	//  primero sin ordenar y luego ordenados por número de seguidores 
	//	(de mayor a menor).

	public static void main(String[] args) {
		// String[] usuarios = { "@sama", "@JeffBezos", "@BillGates", "@elonmusk" };
		// int[] seguidores = { 1300, 61000, 62000, 128900 };
		
		/* Manera 1: crear array y luego meter datos
		UsuarioRedSocial[] usuariosRS = new UsuarioRedSocial[4];
		usuariosRS[0] = new UsuarioRedSocial();
		// System.out.println( usuariosRS[0].nombre.substring(0,2) );  NO FUNCIONA - NullPointer
		usuariosRS[0].nombre = new String("@sama");
		// System.out.println( usuariosRS[0].nombre.substring(0,2) );
		usuariosRS[0].seguidores = 1300;
		// Faltaría 1, 2, 3  */
		
		/* Manera 2: crear objetos y luego crear el array */
//		UsuarioRedSocial usuario1 = new UsuarioRedSocial( "@sama", 1300 );
//		UsuarioRedSocial usuario2 = new UsuarioRedSocial( "@JeffBezos", 61000 );
//		UsuarioRedSocial usuario3 = new UsuarioRedSocial( "@BillGates", 62000 );
//		UsuarioRedSocial usuario4 = new UsuarioRedSocial( "@elonmusk", 128900 );
//		UsuarioRedSocial[] usuariosRS = new UsuarioRedSocial[] { usuario1, usuario2, usuario3, usuario4 };
		
		// Manera 3: crear el array creando los objetos al vuelo
		UsuarioRedSocial[] usuariosRS = new UsuarioRedSocial[] { 
			new UsuarioRedSocial( "@sama", 1300 ),
			new UsuarioRedSocial( "@JeffBezos", 61000 ),
			new UsuarioRedSocial( "@BillGates", 62000 ),
			new UsuarioRedSocial( "@elonmusk", 128900 )
		};
		
		// new UsuarioRedSocial();  Crea un objeto pero no va a ningún sitio
		visualizarUsuariosYSeguidores( usuariosRS );
		ordenaUsuariosPorSeguidores( usuariosRS );
		visualizarUsuariosYSeguidores( usuariosRS );
		
		pruebasVarias();
	}
	
	private static void pruebasVarias() {
		UsuarioRedSocial u = new UsuarioRedSocial();
		u.setMilesSeguidores( -5000 );  // Importancia del set para modificar con posible error (con atributos no podríamos detectarlo)
		u.sacarAConsola();
	}
	
	
	// Visualiza línea a línea usuario tabulador nº seguidores
	private static void visualizarUsuariosYSeguidores(UsuarioRedSocial[] usuariosRS) {
		for (int i=0; i<usuariosRS.length; i++) {
			// System.out.println( usuariosRS[i].convertirAString() );
			usuariosRS[i].sacarAConsola();
		}
	}
	
	private static void ordenaUsuariosPorSeguidores(UsuarioRedSocial[] usuariosRS) {
		for (int pasada=0; pasada<usuariosRS.length-1; pasada++) {
			for (int comp=0; comp<usuariosRS.length-1; comp++) {  // TODO mejorar que solo se hagan las comparaciones necesarias
				boolean hayQueIntercambiar = usuariosRS[comp].getMilesSeguidores() < usuariosRS[comp+1].getMilesSeguidores();
				if (hayQueIntercambiar) {
					UsuarioRedSocial aux = usuariosRS[comp];
					usuariosRS[comp] = usuariosRS[comp+1];
					usuariosRS[comp+1] = aux;
				}
			}
		}
	}
	
}
