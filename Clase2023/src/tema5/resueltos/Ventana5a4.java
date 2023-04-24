package tema5.resueltos;

import java.awt.*;
import javax.swing.*;

public class Ventana5a4 extends JFrame {
	public static void main(String[] args) {
		Ventana5a4 vent = new Ventana5a4();
		vent.setVisible( true );
	}
	
	public Ventana5a4() {
		// 0. Configuración general
		this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		this.setSize( 600, 400 );
		setAlwaysOnTop( true );
		setLocationRelativeTo( null );
		setLocation( 2000, 0 );
		// 1. Crear contenedores
		JPanel pSuperior = new JPanel();
		JPanel pInferior = new JPanel();
		JScrollPane scrollCentral = new JScrollPane();
		JPanel pDerecha = new JPanel();
		// 2. Crear componentes
		JLabel lTitulo = new JLabel( "Ventana super útil" );
		JButton bCancelar = new JButton( "Cancelar" );
		JButton bAdelante = new JButton( "¡Adelante!" );
		JTextArea taTexto = new JTextArea(5,10);
		// 3. Formato de contenedores
		getContentPane().setLayout( new BorderLayout() ); // No hace falta
		pSuperior.setBackground( Color.CYAN );
		pSuperior.setLayout( new FlowLayout( FlowLayout.CENTER ) );
		pInferior.setLayout( new FlowLayout( FlowLayout.RIGHT ) );
		pInferior.setBackground( Color.PINK );
		scrollCentral.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pDerecha.setLayout( new GridLayout( 4, 3 ) );
		// 4. Formato de componentes
		lTitulo.setFont( new Font( "Arial", Font.BOLD, 24 ) );
		bCancelar.setBackground( Color.RED );
		bCancelar.setForeground( Color.WHITE );
		bAdelante.setBackground( Color.GREEN );
		bAdelante.setEnabled( false );
		// 5. Añadir componentes a contenedores
		pSuperior.add( lTitulo );
		// pSuperior.add( new JButton("Prueba") );
		getContentPane().add( pSuperior, BorderLayout.NORTH );
		pInferior.add( bCancelar );
		pInferior.add( bAdelante );
		getContentPane().add( pInferior, BorderLayout.SOUTH );
		scrollCentral.setViewportView( taTexto );
		getContentPane().add( scrollCentral, BorderLayout.CENTER );
	}
}
