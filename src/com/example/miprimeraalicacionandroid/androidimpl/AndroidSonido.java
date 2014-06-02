package com.example.miprimeraalicacionandroid.androidimpl;

import android.media.SoundPool;

import com.example.miprimeraalicacionandroid.Sonido;

public class AndroidSonido implements Sonido{

	int soundId;
	SoundPool soundPool;
	 public AndroidSonido(SoundPool soundPool,int soundId) {
		// TODO Auto-generated constructor stub
		 this.soundId=soundId;
		 this.soundPool=soundPool;
	}
	 @Override
	public void play(float volume) {
		// TODO Auto-generated method stub
	soundPool.play(soundId, volume,volume, 0, 0, 1);	
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		soundPool.unload(soundId);//elimina el sonido en reproduccion "detiene"
	}
	 
}
