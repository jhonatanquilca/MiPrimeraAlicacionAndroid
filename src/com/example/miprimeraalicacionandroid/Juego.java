 package com.example.miprimeraalicacionandroid;

public interface Juego {
	public Input getInput();
	
	public FileIO getFileIO();
	
	public Graficos getGraficos();
	
//	public Musica getmMusica();
	
	public Audio getaAudio();
	
	public Musica getMusica();
	
	public void setScreen(Pantalla pantalla);
	
	public Pantalla getCurrentScreen();
	 
	public Pantalla getStartScreen();
	
	

}
