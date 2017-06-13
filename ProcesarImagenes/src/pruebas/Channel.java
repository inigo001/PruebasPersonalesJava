package pruebas;

import java.awt.Color;

public enum Channel {
	RED(new Color(255, 0, 0)), GREEN(new Color(0, 255, 0)), BLUE(new Color(0, 0, 255)), BRIGHTNESS(
			new Color(127, 127, 127)),LUMINANCE(new Color(200,200,200));

	private Color color;

	Channel(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}
}
