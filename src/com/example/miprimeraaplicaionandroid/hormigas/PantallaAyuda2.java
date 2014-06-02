package com.example.miprimeraaplicaionandroid.hormigas;

import java.util.List;

import com.example.miprimeraalicacionandroid.Graficos;
import com.example.miprimeraalicacionandroid.Input.TouchEvent;
import com.example.miprimeraalicacionandroid.Juego;
import com.example.miprimeraalicacionandroid.Pantalla;

public class PantallaAyuda2 extends Pantalla {

	public PantallaAyuda2(Juego juego) {
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
				juego.setScreen(new PantallaAyuda3(juego));
				
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
		Graficos g =juego.getGraficos();
		g.drawPixmap(Assets.fondo, 0, 0);
		g.drawPixmap(Assets.ayuda2, 64,100);
		g.drawPixmap(Assets.botones, 256, 416,0,64,64,64);
		

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
