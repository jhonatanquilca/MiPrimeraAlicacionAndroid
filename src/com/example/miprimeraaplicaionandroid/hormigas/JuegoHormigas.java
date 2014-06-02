package com.example.miprimeraaplicaionandroid.hormigas;


import com.example.miprimeraalicacionandroid.Pantalla;
import com.example.miprimeraalicacionandroid.androidimpl.AndroidJuego;;;

public class JuegoHormigas extends AndroidJuego {
	@Override
	public Pantalla getStartScreen() {
		// TODO Auto-generated method stub
		return new LoadingScreen(this);
	}

}
