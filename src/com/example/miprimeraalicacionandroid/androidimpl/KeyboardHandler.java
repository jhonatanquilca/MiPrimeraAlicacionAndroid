package com.example.miprimeraalicacionandroid.androidimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import android.view.View;
import android.view.View.OnKeyListener;

import com.example.miprimeraalicacionandroid.Input.KeyEvent;
import com.example.miprimeraalicacionandroid.Pool;
import com.example.miprimeraalicacionandroid.Pool.PoolObjectFactory;

public class KeyboardHandler implements OnKeyListener {

	boolean[] pressedKeys = new boolean[128];
	Pool<KeyEvent> keyEventPool;
	List<KeyEvent> keyEventsBuffer = new ArrayList<KeyEvent>();
	List<KeyEvent> keyEvents=new List<KeyEvent>() {
		
		@Override
		public <T> T[] toArray(T[] array) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<KeyEvent> subList(int start, int end) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public KeyEvent set(int location, KeyEvent object) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean retainAll(Collection<?> arg0) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean removeAll(Collection<?> arg0) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean remove(Object object) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public KeyEvent remove(int location) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public ListIterator<KeyEvent> listIterator(int location) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public ListIterator<KeyEvent> listIterator() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public int lastIndexOf(Object object) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Iterator<KeyEvent> iterator() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public int indexOf(Object object) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public KeyEvent get(int location) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean containsAll(Collection<?> arg0) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean contains(Object object) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public boolean addAll(int arg0, Collection<? extends KeyEvent> arg1) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean addAll(Collection<? extends KeyEvent> arg0) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void add(int location, KeyEvent object) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public boolean add(KeyEvent object) {
			// TODO Auto-generated method stub
			return false;
		}
	};

	public KeyboardHandler(View view) {
		// TODO Auto-generated constructor stub
		PoolObjectFactory<KeyEvent> factory = new PoolObjectFactory<KeyEvent>() {

			@Override
			public KeyEvent createObject() {
				return new KeyEvent();
			}
		};

		keyEventPool = new Pool<KeyEvent>(factory, 100);
		view.setOnKeyListener(this);
		view.setFocusableInTouchMode(true);
		view.requestFocus();
	}

	@Override
	public boolean onKey(View v, int keyCode, android.view.KeyEvent event) {
		// TODO Auto-generated method stub
		if (event.getAction() == android.view.KeyEvent.ACTION_MULTIPLE) {
			return false;
		}

		synchronized (this) {
			KeyEvent keyEvent = keyEventPool.newObject();
			keyEvent.keycode = keyCode;
			keyEvent.keyChar = (char) event.getUnicodeChar();
			if (event.getAction() == android.view.KeyEvent.ACTION_DOWN) {
				keyEvent.type = keyEvent.KEY_DOWN;
				if (keyCode > 0 && keyCode < 127) {
					pressedKeys[keyCode] = true;
				}
			}
			if (event.getAction() == android.view.KeyEvent.ACTION_UP) {
				keyEvent.type = keyEvent.KEY_UP;
				if (keyCode > 0 && keyCode < 127) {
					pressedKeys[keyCode] = false;
				}
				keyEventsBuffer.add(keyEvent);
			}

			return false;
		}
	}

	public boolean iskeyPressed(int KeyCode) {
		if (KeyCode < 0 || KeyCode < 127) {
			return false;
		}
		return pressedKeys[KeyCode];
	}

	public List<KeyEvent> getKeyEvents() {
		synchronized (this) {
			int len = keyEvents.size();
			for (int i = 0; i < len; i++) {
				keyEventPool.free(keyEvents.get(i));
			}
			keyEvents.clear();
			keyEvents.addAll(keyEventsBuffer);
			keyEventsBuffer.clear();
			return keyEvents;

		}
	}

}
