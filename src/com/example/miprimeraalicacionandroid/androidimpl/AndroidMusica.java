package com.example.miprimeraalicacionandroid.androidimpl;

import java.io.IOException;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

import com.example.miprimeraalicacionandroid.Musica;

public class AndroidMusica implements Musica, OnCompletionListener {

	MediaPlayer mediaPlayer;
	boolean isPrepared = false;

	public AndroidMusica(AssetFileDescriptor assetFileDescriptor) {
		// TODO Auto-generated constructor stub
		mediaPlayer = new MediaPlayer();
		try {
			mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(),
					assetFileDescriptor.getStartOffset(),
					assetFileDescriptor.getLength());
			mediaPlayer.prepare();
			isPrepared = true;
			mediaPlayer.setOnCompletionListener(this);

		} catch (Exception e) {
			throw new RuntimeException("No se ha podido cargar la musica");
		}
	}

	@Override
	public void onCompletion(MediaPlayer mp) {
		// TODO Auto-generated method stub
		synchronized (this) {
			isPrepared=false;
		}

	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		if (mediaPlayer.isPlaying()) {
			return;
		}
		try {
			synchronized (this) {//solamente un subproceso puede acceder a dicho método a la vez
				if (!isPrepared) {
					mediaPlayer.prepare();
				}
				mediaPlayer.start();
			}

		} catch (IllegalStateException e) {
			// TODO: handle exception
			
			
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			
			
			
			e.printStackTrace();
		}

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		mediaPlayer.stop();
		synchronized (this) {
			isPrepared=false;
		}

	}

	@Override
	public void puase() {
		// TODO Auto-generated method stub
		if (mediaPlayer.isPlaying()) {
			mediaPlayer.pause();
		}

	}

	@Override
	public void setLooping(boolean looping) {
		// TODO Auto-generated method stub
		mediaPlayer.setLooping(isLooping());

	}

	@Override
	public void setVolumen(float volumen) {
		// TODO Auto-generated method stub
		mediaPlayer.setVolume(volumen, volumen);

	}

	@Override
	public boolean isPlaying() {
		// TODO Auto-generated method stub
		return mediaPlayer.isPlaying();
	}

	@Override
	public boolean isStopped() {
		// TODO Auto-generated method stub
		return !isPrepared;
	}

	@Override
	public boolean isLooping() {
		// TODO Auto-generated method stub

		return mediaPlayer.isLooping();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		if (mediaPlayer.isPlaying()) {
			mediaPlayer.stop();
		}
		mediaPlayer.release();

	}

}
