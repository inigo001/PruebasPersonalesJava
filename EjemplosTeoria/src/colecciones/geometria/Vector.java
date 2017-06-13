package colecciones.geometria;

public class Vector {
	//
	public static double A_DEFECTO = 0;
	public static double B_DEFECTO = 0;
	//
	private double a;
	private double b;

	public Vector(double a, double b) {
		this.a = a;
		this.b = b;
	}

	public Vector(Punto punto1, Punto punto2) {
		this.a = punto2.getX() - punto1.getX();
		this.b = punto2.getY() - punto1.getY();
	}

	public Vector() {
		this(A_DEFECTO, B_DEFECTO);
	}

	public Vector(Vector vector) {
		this(vector.a, vector.b);
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "[" + this.a + "," + this.b + "]";
	}
}