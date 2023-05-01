package tema5.resueltos;

import java.awt.*;
import javax.swing.*;

/** Solución ejercicio 5a.4
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
@SuppressWarnings("serial")
public class Ventana5a4 extends JFrame {

	/** Método de prueba de la ventana del ejercicio 5a.4
	 * @param args
	 */
	public static void main(String[] args) {
		Ventana5a4 vent = new Ventana5a4();
		vent.setVisible( true );
	}
	
	// No static 
	public Ventana5a4() {
		// Inicialización de la ventana
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 600, 400 );
		setAlwaysOnTop( true );
		setLocationRelativeTo( null );
		
		// 1. Crear contenedores
		JPanel pSuperior = new JPanel();
		JPanel pInferior = new JPanel();
		JPanel pDerecho = new JPanel();
		JPanel pIzquierdo = new JPanel();
		JPanel pIzq1 = new JPanel();
		JPanel pIzq2 = new JPanel();
		JPanel pIzq3 = new JPanel();
		
		// 2. Crear componentes
		JLabel lTitulo = new JLabel( "Ventana super útil" );
		JButton bCancelar = new JButton( "¡Cancela!" );
		JButton bAdelante = new JButton( "A por ello" );
		JTextArea taTexto = new JTextArea();
		JButton[] bTeclas = new JButton[12];
		String sTeclas = "123456789<0*";
		for (int i=0; i<sTeclas.length(); i++) {
			bTeclas[i] = new JButton( sTeclas.substring(i, i+1) );
		}
		JLabel lLogo = new JLabel( new ImageIcon( "src/tema5/ejercicios/UD-blue-peq.png" ) );
		JComboBox<String> cbTipo = new JComboBox<>( new String[] { "Creativx", "Organizadx", "Disciplinadx", "Dinámicx" } );
		JLabel lNombre = new JLabel( "Nombre:" );
		JTextField tfNombre = new JTextField( "<Nombre>", 15 );
		JLabel lCodPostal = new JLabel( "Cod.Postal:" );
		JTextField tfCodPostal = new JTextField( 8 );
		JCheckBox checkUrgente = new JCheckBox( "Urgente" );
		
		// 3. Formato de contenedores
		getContentPane().setLayout( new BorderLayout() );
		pSuperior.setBackground ( Color.CYAN );
		pInferior.setBackground( Color.PINK );
		pInferior.setLayout( new FlowLayout( FlowLayout.RIGHT ) );
		pDerecho.setLayout( new GridLayout( 4, 3 ) );
		pIzquierdo.setLayout( new BoxLayout( pIzquierdo, BoxLayout.Y_AXIS ) );
		pIzq1.setLayout( new FlowLayout( FlowLayout.LEFT ) );
		pIzq2.setLayout( new FlowLayout( FlowLayout.LEFT ) );
		pIzq1.setMaximumSize( new Dimension( 300, 35 ) );
		pIzq2.setMaximumSize( new Dimension( 300, 35 ) );
		pIzq3.setMaximumSize( new Dimension( 300, 35 ) );
		setMinimumSize( new Dimension( 500, 250 ) );
		
		// 4. Formato de componentes
		lTitulo.setFont( new Font( "Arial", Font.BOLD, 24 ) );
		bCancelar.setBackground( Color.RED );
		bCancelar.setForeground( Color.WHITE );
		bAdelante.setBackground( Color.GREEN );
		bAdelante.setEnabled( false );
		cbTipo.setMaximumSize( new Dimension( 300, 35 ) );
		lNombre.setBackground( Color.ORANGE );
		lNombre.setOpaque( true );
		tfCodPostal.setBackground( Color.YELLOW );
		
		// 5. Añadir componentes a contenedores
		getContentPane().add( pSuperior, BorderLayout.NORTH );
		getContentPane().add( pInferior, BorderLayout.SOUTH );
		getContentPane().add( new JScrollPane( taTexto ), BorderLayout.CENTER );
		getContentPane().add( pDerecho, BorderLayout.EAST );
		getContentPane().add( pIzquierdo, BorderLayout.WEST );
		pSuperior.add( lTitulo );
		pInferior.add( bCancelar );
		pInferior.add( bAdelante );
		for (JButton b : bTeclas) {
			pDerecho.add( b );
		}
		pIzquierdo.add( lLogo );
		pIzquierdo.add( cbTipo );
		pIzquierdo.add( pIzq1 );
		pIzquierdo.add( pIzq2 );
		pIzquierdo.add( pIzq3 );
		pIzq1.add( lNombre );
		pIzq1.add( tfNombre );
		pIzq2.add( lCodPostal );
		pIzq2.add( tfCodPostal );
		pIzq3.add( checkUrgente );
	}
}