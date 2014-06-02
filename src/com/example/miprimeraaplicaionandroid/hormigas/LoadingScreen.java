package com.example.miprimeraaplicaionandroid.hormigas;

import com.example.miprimeraalicacionandroid.Graficos;
import com.example.miprimeraalicacionandroid.Juego;
import com.example.miprimeraalicacionandroid.Pantalla;
import com.example.miprimeraalicacionandroid.Graficos.PixmapFormant;

public class LoadingScreen extends Pantalla {

	public LoadingScreen(Juego juego) {
		super(juego);
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub
		Graficos g=juego.getGraficos();
		Assets.fondo=g.newPixmap("fondo.png", PixmapFormant.RGB565);
		Assets.logo=g.newPixmap("logo.png", PixmapFormant.RGB565);
		Assets.menuprincipal=g.newPixmap("menuprincipal.png", PixmapFormant.RGB565);	
		Assets.botones=g.newPixmap("botones.png", PixmapFormant.RGB565);
		Assets.ayuda1=g.newPixmap("ayuda1.png", PixmapFormant.RGB565);
		Assets.ayuda2=g.newPixmap("ayuda2.png", PixmapFormant.RGB565);
		Assets.ayuda3=g.newPixmap("ayuda3.png", PixmapFormant.RGB565);
		Assets.numeros=g.newPixmap("numeros.png", PixmapFormant.RGB565);
		Assets.preparados=g.newPixmap("preparado.png", PixmapFormant.RGB565);
		Assets.menupausa=g.newPixmap("menupausa.png", PixmapFormant.RGB565);
		Assets.finjuego=g.newPixmap("finjuego.png", PixmapFormant.RGB565);
		Assets.soloarriba=g.newPixmap("soloarriba.png", PixmapFormant.RGB565);
		Assets.soloizquierda=g.newPixmap("soloizquerda.png", PixmapFormant.RGB565);
		Assets.soloderecha=g.newPixmap("soloderecha.png", PixmapFormant.RGB565);
		Assets.soloabajo=g.newPixmap("soloiabajo.png", PixmapFormant.RGB565);
		Assets.cargando=g.newPixmap("cargando.png", PixmapFormant.RGB565);
		Assets.cubo1=g.newPixmap("cubo1.png", PixmapFormant.RGB565);
		Assets.cubo2=g.newPixmap("cubo2.png", PixmapFormant.RGB565);
		Assets.cubo3=g.newPixmap("cubo3.png", PixmapFormant.RGB565);
		//sonidos....................
		Assets.pulsar=juego.getaAudio().nuevoSonido("plusacion.ogg");
		Assets.ataque=juego.getaAudio().nuevoSonido("ataque.ogg");
		Assets.derrota=juego.getaAudio().nuevoSonido("derrota.ogg");
		//----mas----------
		Assets.soundfondo=juego.getaAudio().nuevaMusica("fondo.ogg");
		Assets.pasos=juego.getaAudio().nuevoSonido("pasos.ogg");
		Assets.inicio=juego.getaAudio().nuevaMusica("inicio.ogg");
		//los almacenamos en el alamcenamiento exteno
		Configuraciones.load(juego.getFileIO());
		
		juego.setScreen(new MainMenuScreen(juego));
		
		
	}

	@Override
	public void present(float deltaTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
