package com.example.miprimeraalicacionandroid;

public interface Musica {
	public void play();
	
	public void stop();
	
	public void puase();
	
	public void setLooping(boolean looping);
	
	public void setVolumen(float volumen);//0=>silencion 1=>a todo volumen
	
	public boolean isPlaying();
	
	public boolean isStopped();
	
	public boolean isLooping();
	
	public void dispose();//cierra el recurso libera memoria

}
