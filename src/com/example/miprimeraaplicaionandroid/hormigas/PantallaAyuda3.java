package com.example.miprimeraaplicaionandroid.hormigas;

import java.util.List;

import com.example.miprimeraalicacionandroid.Graficos;
import com.example.miprimeraalicacionandroid.Juego;
import com.example.miprimeraalicacionandroid.Pantalla;
import com.example.miprimeraalicacionandroid.Input.TouchEvent;

public class PantallaAyuda3 extends Pantalla {

	public PantallaAyuda3(Juego juego) {
		super(juego);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub
		List<TouchEvent> touchEvents=juego.getInput().getTouchEvents();
		juego.getInput().getKeyEvents();
		
		int len=touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event=touchEvents.get(i);
			if(event.type==TouchEvent.TOUCH_UP){
				juego.setScreen(new MainMenuScreen(juego));
				
				if(event.x>256&&event.y>416){
					Assets.pulsar.play(1);
					Assets.soundfondo.stop();
					return;
				}
				
			}
			
		}

	}

	@Override
	public void present(float deltaTime) {
		// TODO Auto-generated method stub
		Graficos g=juego.getGraficos();
		g.drawPixmap(Assets.fondo, 0, 0);
		g.drawPixmap(Assets.ayuda3, 64, 100);
		g.drawPixmap(Assets.botones, 256, 416, 0, 128, 64, 64);

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
