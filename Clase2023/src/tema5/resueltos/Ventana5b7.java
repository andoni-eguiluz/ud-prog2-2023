package tema5.resueltos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** Solución ejercicio 5a.4
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
@SuppressWarnings("serial")
public class Ventana5b7 extends JFrame {

	/** Método de prueba de la ventana del ejercicio 5a.4
	 * @param args
	 */
	public static void main(String[] args) {
		Ventana5b7 vent = new Ventana5b7();
		vent.setVisible( true );
	}
	
	private JLabel lTitulo;
	private JTextField tfCodPostal;
	
	// No static 
	public Ventana5b7() {
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
		this.lTitulo = lTitulo;
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
		final JTextField tfNombre = new JTextField( "<Nombre>", 15 );
		JLabel lCodPostal = new JLabel( "Cod.Postal:" );
		tfCodPostal = new JTextField( 8 );
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
		this.setMinimumSize( new Dimension( 500, 250 ) );
		
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
		
		// 6. Gestión de eventos
		// a) Clase externa
		// ActionListener escuchador = new EscuchadorBotonCancelar();
		// bCancelar.addActionListener( new EscuchadorBotonCancelar( lTitulo ) );
		// b) Clase interna
		bCancelar.addActionListener( new EscuchadorBotonCancelarInterna() );
		// c) Clase interna anónima
		ActionListener al = 
			new /* clase sin nombre implements */ ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println( "Pulsado!" );
					lTitulo.setText( "Ventana cancelada" );
				}
			}
		;
		bCancelar.addActionListener( al );
		// Seguimos con internas anónimas
		bAdelante.addActionListener( new ActionListener() {
			/* private JTextField tfNombre = tfNombre */
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println( "Pulsado adelante");
				tfNombre.setText( "hola" );
			}
		});
		System.out.println( "Fin constructor" );
		tfNombre.addFocusListener( new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				System.out.println( "lost" );
				if (tfNombre.getText().equals("<Nombre>") || tfNombre.getText().isEmpty()) {
					bAdelante.setEnabled( false );
				} else {
					bAdelante.setEnabled( true );
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				System.out.println( "gain" );
			}
		} );
		// Prueba de mouse listener
		// ¿Podemos dibujar una línea entre pulsación y suelta?
		lLogo.addMouseListener( new MouseListener() {
			private Point puntoPulsacion = null;
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println( "pressed " + e );
				puntoPulsacion = e.getPoint();
				// Añadir gestores de eventos en caliente?  Se puede pero con cuidado:
				// (esto añadiría varios gestores de eventos si se hace varias veces)
//				tfNombre.addActionListener( new ActionListener() {
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						System.out.println( "Gestor de eventos nuevo!!!");
//					}
//				});
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println( "released " + e );
				lLogo.getGraphics().setColor( Color.RED );
				lLogo.getGraphics().drawLine( puntoPulsacion.x, puntoPulsacion.y, e.getX(), e.getY() );
				Graphics g = lLogo.getGraphics();
				g.setColor( Color.RED );
				g.drawLine( puntoPulsacion.x, puntoPulsacion.y, e.getX(), e.getY() );
			}
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println( "exited " + e );
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println( "entered " + e.getPoint() + " " + e.getLocationOnScreen() + " " + e.getSource() );
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println( "clicked " + e );
			}
		} );
		// Programación de click de mouse listener para código postal 48007 al hacer click en el label
		lCodPostal.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfCodPostal.setText( "48007" );
				long tiempo = System.currentTimeMillis();
				// Nunca nada que tarde tiempo
				// while (System.currentTimeMillis() - tiempo < 5000) {
					// tarda 2 sgs
				// }
			}
		});
		// Línea continua amarilla con el movimiento de ratón
		lLogo.addMouseMotionListener( new MouseMotionListener() {
			Point puntoAnterior = null;
			@Override
			public void mouseMoved(MouseEvent e) {
				System.out.println( "move " + e.getPoint() );
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				System.out.println( "drag " + e.getPoint() );
				if (puntoAnterior!=null) {
					Graphics g = lLogo.getGraphics();
					g.setColor( Color.YELLOW );
					g.drawLine( puntoAnterior.x, puntoAnterior.y, e.getX(), e.getY() );
				}
				puntoAnterior = e.getPoint();
			}
		});
	}
	
	public String getValorCodPostal() {
		return tfCodPostal.getText();
	}

	// Clase interna
	class EscuchadorBotonCancelarInterna implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println( "Pulsado!" );
			lTitulo.setText( "Ventana cancelada" );
		}
	}

}

class EscuchadorBotonCancelar implements ActionListener {
	private JLabel miLabel;
	public EscuchadorBotonCancelar( JLabel label ) {
		miLabel = label;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println( "Pulsado!" );
		miLabel.setText( "Ventana cancelada" );
// NUNCA un proceso largo en un gestor de eventos
//		while (true) {
//			System.out.println( "en bucle" );
//		}
	}
}

