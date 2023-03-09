package tema2.basicos.ejemplo;

public class Esfera extends Object {
	protected double xCentro = 100;
	private double yCentro = 100;
	private double radio = 10;
	public Esfera() {
		super();
		System.out.println( "Constructor Esfera p.d." );
	}
	public Esfera(double xCentro, double yCentro, double radio) {
		super();
		System.out.println( "Constructor Esfera xyr" );
		this.xCentro = xCentro;
		this.yCentro = yCentro;
		this.setRadio( radio );
	}
	public double getxCentro() {
		return xCentro;
	}
	public void setxCentro(double xCentro) {
		this.xCentro = xCentro;
	}
	public double getyCentro() {
		return yCentro;
	}
	public void setyCentro(double yCentro) {
		this.yCentro = yCentro;
	}
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	@Override
	public String toString() {
		return String.format( "(%.1f,%.1f)R%.1f", xCentro, yCentro, radio );
	}
	
}
