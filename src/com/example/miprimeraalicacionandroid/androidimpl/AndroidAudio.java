package com.example.miprimeraalicacionandroid.androidimpl;

import java.io.IOException;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;

import com.example.miprimeraalicacionandroid.Audio;
import com.example.miprimeraalicacionandroid.Musica;
import com.example.miprimeraalicacionandroid.Sonido;

public class AndroidAudio implements Audio {
	AssetManager assets;// cagar archivos de sonido dentro del soundpool
	SoundPool soundPool;// manejado po r la insatancia del android

	public AndroidAudio(Activity activity) {
		// TODO Auto-generated constructor stub
		activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);//
		this.assets = activity.getAssets();
		this.soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);

	}

	@Override
	public Musica nuevaMusica(String nombreArchivo) {
		// TODO Auto-generated method stub
		try {
			AssetFileDescriptor assetFileDescriptor = assets
					.openFd(nombreArchivo);
			return new AndroidMusica(assetFileDescriptor);
		} catch (IOException e) {
			// TODO: handle exception
			throw new RuntimeException("No se ha cargado el archivo '"
					+ nombreArchivo + "'");
		}

	}
	
	@Override
	public Sonido nuevoSonido(String fileName) {
		// TODO Auto-generated method stub
		try {
			AssetFileDescriptor assetFileDescriptor=assets.openFd(fileName);
			return new AndroidSonido(soundPool, soundPool.load(assetFileDescriptor, 1));
			
		} catch (IOException e) {
			// TODO: handle exception
			throw new RuntimeException("No se ha cargado del archivo '"+fileName+"'");
		}
	}
	

}
