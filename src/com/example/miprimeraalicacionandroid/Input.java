package com.example.miprimeraalicacionandroid;

import java.util.List;

public interface Input {
	
	public static class KeyEvent {
		public static final int KEY_DOWN = 0;
		public static final int KEY_UP = 1;

		public int type;
		public int keycode;
		public int keyChar;

		public String toString() {
			StringBuilder builder = new StringBuilder();
			if (type == KEY_DOWN) {
				builder.append("Tecla Pulsada, ");
			} else {
				builder.append("Tecla levantada");
			}

			builder.append(keycode);
			builder.append(",");
			builder.append(keyChar);
			return builder.toString();
		}
	}
	
	public static class TouchEvent{
		public static final int TOUCH_DOWN=0;
		public static final int TOUCH_UP=1;
		public static final int TOUCH_DRAGGED=2;
		
		public int type;
		public int x,y;
		public int pointer;
		
		
		public String toString() {
			StringBuilder builder=new StringBuilder();
			if(type==TOUCH_DOWN){
				builder.append("touch down. ");				
			}else if(type==TOUCH_DRAGGED){
				builder.append("touch daggred, ");
			}else {
				builder.append("touch up, ");
			}
			
			builder.append(pointer);
			builder.append(",");
			builder.append(x);
			builder.append(",");
			builder.append(y);
			return builder.toString();
			
		}
	}
	
	
	public boolean isKeyPressed(int KeyCode);
	public boolean isTouchDown(int pointer);
	
	public int getTouhcX(int pointer);
	public int getTouchY(int pointer);
	
	public float getAccelX();
	public float getAccelY();
	public float getAccelZ();

	public List<KeyEvent> getKeyEvents();
	public List<TouchEvent> getTouchEvents();
}
