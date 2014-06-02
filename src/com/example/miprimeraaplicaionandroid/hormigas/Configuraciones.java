package com.example.miprimeraaplicaionandroid.hormigas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.example.miprimeraalicacionandroid.FileIO;

public class Configuraciones {

	public static boolean soundEnabled = true;
	public static int[] highscores = new int[] { 100, 80, 50, 30, 10 };

	public static void load(FileIO files) {// inntenta cargar un archivo llamdo
											// ormigas dentro del direcctorio
											// assets
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(
					files.leerArchivo(".hormigas")));
			// lee las entradas del archivo linea a linea
			// si el almacenamiento o en archivo no esta diponible se bolveran
			// los valores por defecto
			soundEnabled = Boolean.parseBoolean(in.readLine());
			for (int i = 0; i < 5; i++) {
				highscores[i] = Integer.parseInt(in.readLine());
			}
		} catch (IOException e) {
			// TODO: handle exception
		} catch (NumberFormatException e) {
			// TODO: handle exception
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e2) {
				// TODO: handle exception
			}

		}
	}

	public static void save(FileIO files) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(
					files.escribirArchivo(".hormigas")));
			out.write(Boolean.toString(soundEnabled));
			out.write("\n");
			for (int i = 0; i < 5; i++) {
				out.write(Integer.toString(highscores[i]));
				out.write("\n");
			}

		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e2) {
				// TODO: handle exception
			}
		}

	}

	public static void addScores(int score) {
		for (int i = 0; i < 5; i++) {
			if (highscores[i] < score) {
				for (int j = 4; j > i; j = j - 1) {
					highscores[j] = highscores[j - 1];
					highscores[i] = score;
					break;
				}
			}
		}
	}
}
