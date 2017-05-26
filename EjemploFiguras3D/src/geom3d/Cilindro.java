package geom3d;

import geom2d.Circulo;

public class Cilindro extends Figura3D {

	public Cilindro(Circulo base, double altura) {
		super(base, altura);
	}

	@Override
	protected double areaBase() {
		return this.base.area();
	}

	public Circulo getBase() {
		return (Circulo) (this.base);
	}

	public void setBase(Circulo base) {
		this.base = base;
	}

	public double getRadio() {
		return ((Circulo) (this.base)).getRadio();
	}

	public void setRadio(double radio) {
		((Circulo) (this.base)).setRadio(radio);
	}

}
