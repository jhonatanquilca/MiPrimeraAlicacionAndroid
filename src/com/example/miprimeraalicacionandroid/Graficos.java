package com.example.miprimeraalicacionandroid;

public interface Graficos {
	// dibujara en el frame buffer
	public static enum PixmapFormant {
		ARGB8888, ARG4444, RGB565
	}

	public Pixmap newPixmap(String fileName, PixmapFormant formant);// cargara
																	// una
																	// imagen
																	// jpg o png

	public void clear(int color);// especificados con valores de 32 bits
									// ARGB8888

	public void drawPixel(int x, int y, int color);// punto

	public void drawLine(int ix, int iy, int fx, int fy, int color);

	public void drawRect(int ix, int iy, int ancho, int alto, int color);// rectangulo

	public void drawPixmap(Pixmap pixmap, int x, int y, int srcX, int srcY,
			int srcAncho, int srcAlto);

	public void drawPixmap(Pixmap pixmap, int x, int y);

	public int getAncho();

	public int hetAlto();

}
