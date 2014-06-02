package com.example.miprimeraalicacionandroid.androidimpl;

import com.example.miprimeraalicacionandroid.Audio;
import com.example.miprimeraalicacionandroid.FileIO;
import com.example.miprimeraalicacionandroid.Graficos;
import com.example.miprimeraalicacionandroid.Input;
import com.example.miprimeraalicacionandroid.Juego;
import com.example.miprimeraalicacionandroid.Musica;
import com.example.miprimeraalicacionandroid.Pantalla;


import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.Window;
import android.view.WindowManager;

public class AndroidJuego extends Activity implements Juego {
	AndroidFastRenderView renderView;
	Graficos graficos;
	Audio audio;
	Musica musica;
	Input input;
	FileIO fileIO;
	Pantalla pantalla;
	WakeLock wakeLock;// impide quela pantalla se apage

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		// frame buffer artificial
		boolean isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
		int frameBufferWidth = isLandscape ? 480 : 320;//
		int frameBufferHeight = isLandscape ? 320 : 480;//
		Bitmap frameBuffer = Bitmap.createBitmap(frameBufferWidth,
				frameBufferHeight, Config.RGB_565);

		float scaleX = (float) frameBufferWidth
				/ getWindowManager().getDefaultDisplay().getWidth();
		float scaleY = (float) frameBuffer.getHeight()
				/ getWindowManager().getDefaultDisplay().getHeight();

		renderView = new AndroidFastRenderView(this, frameBuffer);
		graficos = new AndroidGtaficos(getAssets(), frameBuffer);
		fileIO = new AndroidFileIO(getAssets());
		audio = new AndroidAudio(this);
		input = new AndroidInput(this, renderView, scaleX, scaleY);
		pantalla = getStartScreen();
		
		setContentView(renderView);

		PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
		wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK,
				"GLGame");

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		wakeLock.acquire();
		pantalla.resume();
		renderView.resume();

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		wakeLock.release();
		renderView.pause();
		pantalla.pause();
		if (isFinishing()) {
			pantalla.dispose();
		}
	}

	@Override
	public Input getInput() {
		// TODO Auto-generated method stub
		return input;
	}

	@Override
	public FileIO getFileIO() {
		// TODO Auto-generated method stub
		return fileIO;
	}

	@Override
	public Graficos getGraficos() {
		// TODO Auto-generated method stub
		return graficos;
	}

	@Override
	public Audio getaAudio() {
		// TODO Auto-generated method stub
		return audio;
	}

	@Override
	public void setScreen(Pantalla pantalla) {
		// TODO Auto-generated method stub
		if (pantalla == null) {
			throw new IllegalArgumentException("Pantalla no debe ser null");
		}

		this.pantalla.pause();
		this.pantalla.dispose();
		pantalla.resume();
		pantalla.update(0);
		this.pantalla=pantalla;

	}
	
	@Override
	public Pantalla getCurrentScreen() {
		// TODO Auto-generated method stub
		return pantalla;
	}

	@Override
	public Pantalla getStartScreen() {
		return null;
	}

	@Override
	public Musica getMusica() {
		// TODO Auto-generated method stub
		return musica;
	}

	

	
}
