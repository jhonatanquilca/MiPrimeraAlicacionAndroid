package com.example.miprimeraaplicaionandroid.hormigas;

import java.util.List;

import com.example.miprimeraalicacionandroid.Graficos;
import com.example.miprimeraalicacionandroid.Input.TouchEvent;
import com.example.miprimeraalicacionandroid.Juego;
import com.example.miprimeraalicacionandroid.Pantalla;

public class PantallaMaximasPuntuaciones extends Pantalla {

	String[] lines = new String[5];

	public PantallaMaximasPuntuaciones(Juego juego) {
		super(juego);
		// TODO Auto-generated constructor stub
		for (int i = 0; i < 5; i++) {
			lines[i] = "" + (i + 1) + "." + Configuraciones.highscores;
		}
	}

	public void dibujarTexto(Graficos g, String line, int x, int y) {
		int len = line.length();
		for (int i = 0; i < len; i++) {
			char caracter = line.charAt(i);
			if (caracter == ' ') {
				x += 20;
				continue;
			}

			int srcX = 0;
			int srcAncho = 0;
			if (caracter == '.') {
				srcX = 200;
				srcAncho = 10;
			} else {
				srcX = (caracter - '0') * 20;
				srcAncho = 20;
			}

			g.drawPixmap(Assets.numeros, x, y, srcX, 0, srcAncho, 32);
			x += srcAncho;

		}

	}

	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub
		List<TouchEvent> touchEvents = juego.getInput().getTouchEvents();
		juego.getInput().getKeyEvents();

		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) {
				if (event.x < 64 && event.y > 416) {
					Assets.pulsar.play(1);
				}
				juego.setScreen(new MainMenuScreen(juego));
				return;
			}
		}
	}

	@Override
	public void present(float deltaTime) {
		// TODO Auto-generated method stub
		Graficos g = juego.getGraficos();

		g.drawPixmap(Assets.fondo, 0, 0);
		g.drawPixmap(Assets.menuprincipal, 64, 20, 0, 42, 196, 42);

		int y = 100;
		for (int i = 0; i < 5; i++) {
			dibujarTexto(g, lines[i], 20, y);
			y += 50;
		}

		g.drawPixmap(Assets.botones, 0, 416, 64,64, 64, 64);
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
