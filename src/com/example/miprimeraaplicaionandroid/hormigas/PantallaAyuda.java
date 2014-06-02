package com.example.miprimeraaplicaionandroid.hormigas;

import java.util.List;

import android.provider.ContactsContract.CommonDataKinds.Event;

import com.example.miprimeraalicacionandroid.Graficos;
import com.example.miprimeraalicacionandroid.Input.TouchEvent;
import com.example.miprimeraalicacionandroid.Juego;
import com.example.miprimeraalicacionandroid.Pantalla;

public class PantallaAyuda extends Pantalla {

	public PantallaAyuda(Juego juego) {
		super(juego);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents= juego.getInput().getTouchEvents();
		juego.getInput().getKeyEvents();
		
		int len=touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event=touchEvents.get(i);
			
			if(event.type==TouchEvent.TOUCH_UP){
				juego.setScreen(new PantallaAyuda2(juego));
				if(event.x>256&&event.y>416){
					
					Assets.pulsar.play(1);
					return;
				}
			}
		}

	}

	@Override
	public void present(float deltaTime) {
		// TODO Auto-generated method stub
		Graficos g= juego.getGraficos();
		g.drawPixmap(Assets.fondo, 0, 0);
		g.drawPixmap(Assets.ayuda1, 64, 100);
		g.drawPixmap(Assets.botones, 256, 416,0,64,64,64);
		if(Configuraciones.soundEnabled){
			Assets.soundfondo.setLooping(true);
			float soundV=Float.parseFloat("0.8");
			Assets.soundfondo.setVolumen(soundV);
			Assets.soundfondo.play();	
		}
		
		

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
