package com.example.miprimeraalicacionandroid.androidimpl;

import java.io.IOException;
import java.io.InputStream;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;

import com.example.miprimeraalicacionandroid.Graficos;
import com.example.miprimeraalicacionandroid.Pixmap;

public class AndroidGtaficos implements Graficos {

	AssetManager assets;// cargar insatancias bit map
	Bitmap frameBuffer;// representa el frame buffer artificial
	Canvas canvas;// canvas artificial
	Paint paint;
	Rect srcRect = new Rect();
	Rect dstRect = new Rect();

	public AndroidGtaficos(AssetManager assets, Bitmap framebuffer) {
		// TODO Auto-generated constructor stub
		this.assets = assets;
		this.frameBuffer = framebuffer;
		this.canvas = new Canvas(framebuffer);
		this.paint = new Paint();
	}

	@Override
	public Pixmap newPixmap(String fileName, PixmapFormant formant) {
		Config config = null;
		if (formant == PixmapFormant.RGB565) {
			config = Config.RGB_565;
		} else if (formant == PixmapFormant.ARG4444) {
			config = Config.ARGB_4444;
		} else {
			config = Config.ARGB_8888;
		}

		Options options = new Options();
		options.inPreferredConfig = config;

		InputStream in = null;
		Bitmap bitmap = null;
		try {
			in = assets.open(fileName);
			bitmap = BitmapFactory.decodeStream(in);
			if (bitmap == null) {
				throw new RuntimeException("NO se pudo gargar el bitmap '"
						+ fileName + "'");
			}
		} catch (IOException e) {
			// TODO: handle exception
			throw new RuntimeException("NO se pudo gargar el bitmap '"
					+ fileName + "'");
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO: handle exception
				}
			}
		}

		if (bitmap.getConfig() == Config.RGB_565) {
			formant = PixmapFormant.RGB565;
		} else if (bitmap.getConfig() == Config.ARGB_4444) {
			formant = PixmapFormant.ARG4444;
		} else {
			formant = PixmapFormant.ARGB8888;
		}

		return new AndroidPixmap(bitmap, formant);
	}

	@Override
	public void clear(int color) {
		// TODO Auto-generated method stub
		canvas.drawRGB((color & 0xff0000) >> 16, (color & 0xf00) >> 8,
				(color & 0xff));// obtiene los clores para que limpie el frame

	}

	@Override
	public void drawPixel(int x, int y, int color) {
		// TODO Auto-generated method stub
		paint.setColor(color);
		canvas.drawPoint(x, y, paint);

	}

	@Override
	public void drawLine(int ix, int iy, int fx, int fy, int color) {
		paint.setColor(color);
		canvas.drawLine(iy, iy, fx, fy, paint);

	}

	@Override
	public void drawRect(int ix, int iy, int ancho, int alto, int color) {
		// TODO Auto-generated method stub
		paint.setColor(color);
		paint.setStyle(Style.FILL);
		canvas.drawRect(ix, iy, ix + ancho - 1, iy + alto - 1, paint);

	}

	@Override
	public void drawPixmap(Pixmap pixmap, int x, int y, int srcX, int srcY,
			int srcAncho, int srcAlto) {
		// TODO Auto-generated method stub
		srcRect.left = srcX;// fuente del mienbro rect
		srcRect.top = srcY;
		srcRect.right = srcX + srcAncho - 1;
		srcRect.bottom = srcY + srcAlto - 1;

		dstRect.left = x;// destino del miembro rect
		dstRect.top = y;
		dstRect.right = x + srcAncho - 1;
		dstRect.bottom = y + srcAlto - 1;

		canvas.drawBitmap(((AndroidPixmap) pixmap).bitmap, srcRect, dstRect,
				null);

	}

	@Override
	public void drawPixmap(Pixmap pixmap, int x, int y) {
		// TODO Auto-generated method stub
		canvas.drawBitmap(((AndroidPixmap) pixmap).bitmap, x, y, null);

	}

	@Override
	public int getAncho() {
		// TODO Auto-generated method stub
		return frameBuffer.getWidth();
	}

	@Override
	public int hetAlto() {
		// TODO Auto-generated method stub
		return frameBuffer.getHeight();
	}

}
