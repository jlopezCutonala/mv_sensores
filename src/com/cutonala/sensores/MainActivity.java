package com.cutonala.sensores;

import java.util.ArrayList;
import java.util.List;

import android.hardware.SensorManager;
import android.hardware.Sensor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.app.ListActivity;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       SensorManager sensorManager
        = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
       List<Sensor> listSensor
        = sensorManager.getSensorList(Sensor.TYPE_ALL);

       List<String> listSensorType = new ArrayList<String>();
       for(int i=0; i<listSensor.size(); i++){
        listSensorType.add(listSensor.get(i).getName());
       }
      
       setListAdapter(new ArrayAdapter<String>(this,
               android.R.layout.simple_list_item_1,
               listSensorType));
       getListView().setTextFilterEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
