package geom3d;

import geom2d.Figura2D;

public abstract class Figura3D {

	protected Figura2D base;
	protected double altura;
	
	public Figura3D(Figura2D base, double altura) {
		super();
		this.base = base;
		this.altura = altura;
	}

	//protected double areaBase() {		return base.area();	}
	
	protected abstract double areaBase();

	protected double volumen() {
		return areaBase() * altura;
	}

	protected double getAltura() {
		return altura;
	}

	protected void setAltura(double altura) {
		this.altura = altura;
	}
	
	

}
