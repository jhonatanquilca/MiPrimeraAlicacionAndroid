package com.example.miprimeraalicacionandroid.androidimpl;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class AccelerometerHandler implements SensorEventListener {
	float accelX;
	float accelY;
	float accelZ;

	public AccelerometerHandler(Context context) {
		// TODO Auto-generated constructor stub
		SensorManager manager = (SensorManager) context
				.getSystemService(Context.SENSOR_SERVICE);

		if (manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() != 0) {
			Sensor accelerometer = manager.getSensorList(
					Sensor.TYPE_ACCELEROMETER).get(0);
			manager.registerListener(this, accelerometer,
					SensorManager.SENSOR_DELAY_GAME);

		}
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		accelX=event.values[0];
		accelY=event.values[1];
		accelZ=event.values[2];		

	}
	 
	public float getAccelX() {
		return accelX;
	}
	
	public float getAccelY() {
		return accelY;
	}
	public float getAccelZ() {
		return accelZ;
	}

}
