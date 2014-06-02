package com.example.miprimeraalicacionandroid;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface FileIO {
	//leer y escribir archivo
	public InputStream leerAsset(String nombreArchivo) throws IOException;
	
	public InputStream leerArchivo(String nombreArchivo) throws IOException;
	//se realizara desde la tarjeta de memoria
	public OutputStream escribirArchivo(String nombreArchivo) throws IOException;
	
	
}
