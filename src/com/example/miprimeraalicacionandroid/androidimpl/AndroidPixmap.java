package com.example.miprimeraalicacionandroid.androidimpl;

import android.graphics.Bitmap;

import com.example.miprimeraalicacionandroid.Graficos.PixmapFormant;
import com.example.miprimeraalicacionandroid.Pixmap;

public class AndroidPixmap implements Pixmap{
	Bitmap bitmap;
	PixmapFormant format;
	
	public AndroidPixmap(Bitmap bitmap,PixmapFormant formant) {
		// TODO Auto-generated constructor stub
		this.bitmap=bitmap;
		this.format=formant;
	}

	@Override
	public int getAncho() {
		// TODO Auto-generated method stub
		return bitmap.getWidth();
	}

	@Override
	public int getAlto() {
		// TODO Auto-generated method stub
		return bitmap.getHeight();
	}

	@Override
	public PixmapFormant getFormant() {
		// TODO Auto-generated method stub
		return format;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		bitmap.recycle();//libera memoria 
	}
	
	

}
