package geom3d;

import geom2d.Cuadrado;

public class Prisma extends Figura3D {

	public Prisma(Cuadrado base, double altura) {
		super(base, altura);
	}

	@Override
	protected double areaBase() {
		return base.area();
	}

	public Cuadrado getBase() {
		return (Cuadrado) (this.base);
	}

	public void setBase(Cuadrado base) {
		this.base = base;
	}

	public double getLado() {
		return ((Cuadrado) (this.base)).getLado();
	}

	public void setLado(double lado) {
		((Cuadrado) (this.base)).setLado(lado);
	}

}
