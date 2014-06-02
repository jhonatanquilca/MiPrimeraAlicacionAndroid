package com.example.miprimeraaplicaionandroid.hormigas;

import java.util.List;



import com.example.miprimeraalicacionandroid.Juego;
import com.example.miprimeraalicacionandroid.Graficos;
import com.example.miprimeraalicacionandroid.Input.TouchEvent;
import com.example.miprimeraalicacionandroid.Pantalla;

public class MainMenuScreen extends Pantalla {

	public MainMenuScreen(Juego juego) {
		super(juego);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub
		Graficos g = juego.getGraficos();
		List<TouchEvent> touchEvents = juego.getInput().getTouchEvents();
		juego.getInput().getKeyEvents();

		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
								
			
			if (event.type == TouchEvent.TOUCH_UP) {
				if (inBounds(event, 0, 480, 64, 64)) {
					Configuraciones.soundEnabled = !Configuraciones.soundEnabled;
					if (Configuraciones.soundEnabled) {
						Assets.pulsar.play(1);
					}
				}
				if (inBounds(event, 64, 240, 192, 42)) {
					juego.setScreen(new PantallaJuego(juego));
					if (Configuraciones.soundEnabled) {
						Assets.pulsar.play(1);
						Assets.inicio.stop();
						return;
					}
				}

				if (inBounds(event, 64, 240 + 42, 192, 42)) {
					juego.setScreen(new PantallaMaximasPuntuaciones(juego));
					if (Configuraciones.soundEnabled) {
						Assets.pulsar.play(1);
						Assets.inicio.stop();
						return;
					}
				}
				if (inBounds(event, 64, 240 + 84, 192, 42)) {
					juego.setScreen(new PantallaAyuda(juego));
					if (Configuraciones.soundEnabled) {
						Assets.pulsar.play(1);
						Assets.inicio.stop();
						return;
					}
				}
			}
		}
	}

	private boolean inBounds(TouchEvent event, int x, int y, int ancho, int alto) {
		// TODO Auto-generated method stub
		if (event.x > x && event.x < x + ancho - 1 && event.y > y
				&& event.y < y + alto - 1) {
			return true;

		} else {
			return false;
		}
	}

	@Override
	public void present(float deltaTime) {
		// TODO Auto-generated method stub
		Graficos g=juego.getGraficos();
		
		g.drawPixmap(Assets.fondo, 0, 0);
		g.drawPixmap(Assets.logo, 32, 20);
		g.drawPixmap(Assets.menuprincipal, 64, 220);
		
		
		if(Configuraciones.soundEnabled){
			g.drawPixmap(Assets.botones, 0, 416, 0, 0, 64, 64);
			
			Assets.inicio.setLooping(true);
			Assets.inicio.play();
			
		}else {
			g.drawPixmap(Assets.botones,0, 416, 64, 0, 64, 64);
		Assets.inicio.stop();
		}
		

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		Configuraciones.save(juego.getFileIO());
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
