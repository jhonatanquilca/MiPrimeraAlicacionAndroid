package com.example.miprimeraalicacionandroid.androidimpl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class AndroidFastRenderView extends SurfaceView implements Runnable {

	AndroidJuego juego;
	Bitmap fremeBuffer;
	Thread renderThread = null;
	SurfaceHolder holder;
	volatile boolean running = false;

	public AndroidFastRenderView(AndroidJuego juego, Bitmap frameBuffer) {
		// TODO Auto-generated constructor stub
		super(juego);
		this.juego = juego;
		this.fremeBuffer = frameBuffer;
		this.holder = getHolder();
	}

	public void resume() {
		running = true;
		renderThread = new Thread(this);
		renderThread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Rect dstRect = new Rect();
		long startTime = System.nanoTime();// restreador del parametro delta el
		// debuelve un tiempo en nano segundos // cual nos revisa los fotogramas
		while (running) {
			if (!holder.getSurface().isValid()) {
				continue;
			}

			float deltaTime = (System.nanoTime() - startTime) / 1000000000.0f;
			startTime = System.nanoTime();

			juego.getCurrentScreen().update(deltaTime);
			juego.getCurrentScreen().present(deltaTime);

			Canvas canvas = holder.lockCanvas();
			canvas.getClipBounds(dstRect);
			canvas.drawBitmap(fremeBuffer, null, dstRect, null);
			holder.unlockCanvasAndPost(canvas);
		}

	}

	public void pause() {
		running = false;
		while (true) {
			try {
				renderThread.join();
			} catch (InterruptedException e) {
				// retry
			}
		}
	}
}
