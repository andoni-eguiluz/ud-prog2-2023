package tema2.basicos.ejemplo;

public class Planeta extends Esfera {
	// atributos xCentro, yCentro, radio
	private String nombre;
	
	public Planeta() {
		super();
		System.out.println( "Constructor planeta p.d.");
	}
	
	public Planeta(double xCentro, double yCentro, double radio) {
		super(xCentro, yCentro, radio);
		System.out.println( "Constructor planeta xyr" );
	}
	
	public Planeta( String nombre ) {
		super();
		this.nombre = nombre;
	}

	public Planeta( double xCentro, double yCentro, double radio, String nombre ) {
		super( xCentro, yCentro, radio );
//		this.xCentro = xCentro;
//		setyCentro( yCentro );
//		this.radio = radio;
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Planeta "+ nombre + ": " + super.toString();
	}
	
	@Override
	public void setRadio(double radio) {
		if (radio < 10) {
			System.err.println( "Error: radio " + radio + " es menor que 10" );
		} else {
			super.setRadio(radio);
		}
	}
	
}
