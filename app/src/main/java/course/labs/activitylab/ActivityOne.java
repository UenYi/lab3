package course.labs.activitylab;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ActivityOne extends Activity {

	// string for logcat documentation
	private final static String TAG = "Lab-ActivityOne";
	private int createCtr = 0;
	private int startCtr = 0;
	private int resumeCtr = 0;
	private int pauseCtr = 0;
	private int stopCtr = 0;
	private int destroyCtr = 0;
	private int restartCtr = 0;
	private SharedPreferences prefs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);

		prefs = getPreferences(MODE_PRIVATE);
		if(prefs != null) {
			createCtr = prefs.getInt("createCount", 0);
			startCtr = prefs.getInt("startCount", 0);
			resumeCtr = prefs.getInt("resumeCount", 0);
			pauseCtr = prefs.getInt("pauseCount", 0);
			stopCtr = prefs.getInt("stopCounter", 0);
			destroyCtr = prefs.getInt("destroyCount", 0);
			restartCtr = prefs.getInt("restartCount", 0);
		}

		//Log cat print out
		Log.i(TAG, "onCreate called" + createCtr);

		createCtr++;
		((TextView)findViewById(R.id.create)).setText(getString(R.string.onCreate) + " " + createCtr);
		((TextView)findViewById(R.id.start)).setText(getString(R.string.onStart) + " " + startCtr);
		((TextView)findViewById(R.id.resume)).setText(getString(R.string.onResume) + " " + resumeCtr);
		((TextView)findViewById(R.id.pause)).setText(getString(R.string.onPause) + " " + pauseCtr);
		((TextView)findViewById(R.id.stop)).setText(getString(R.string.onStop) + " " + stopCtr);
		((TextView)findViewById(R.id.destroy)).setText(getString(R.string.onDestroy) + " " + destroyCtr);
		((TextView)findViewById(R.id.restart)).setText(getString(R.string.onRestart) + " " + restartCtr);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceSate){
		Log.i(TAG, "onRestoreInstanceState called");
		createCtr = savedInstanceSate.getInt("createCount");
		startCtr = savedInstanceSate.getInt("startCount");
		resumeCtr = savedInstanceSate.getInt("resumeCount");
		pauseCtr = savedInstanceSate.getInt("pauseCount");
		stopCtr = savedInstanceSate.getInt("stopCount");
		destroyCtr = savedInstanceSate.getInt("destroyCount");
		restartCtr = savedInstanceSate.getInt("restartCount");

		((TextView)findViewById(R.id.create)).setText(getString(R.string.onCreate) + " " + createCtr);
		((TextView)findViewById(R.id.start)).setText(getString(R.string.onStart) + " " + startCtr);
		((TextView)findViewById(R.id.resume)).setText(getString(R.string.onResume) + " " + resumeCtr);
		((TextView)findViewById(R.id.pause)).setText(getString(R.string.onPause) + " " + pauseCtr);
		((TextView)findViewById(R.id.stop)).setText(getString(R.string.onStop) + " " + stopCtr);
		((TextView)findViewById(R.id.destroy)).setText(getString(R.string.onDestroy) + " " + destroyCtr);
		((TextView)findViewById(R.id.restart)).setText(getString(R.string.onRestart) + " " + restartCtr);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_one, menu);
		return true;
	}

	// lifecycle callback overrides

	@Override
	public void onStart(){
		super.onStart();

		//Log cat print out
		Log.i(TAG, "onStart called" + startCtr);

		startCtr++;
		((TextView)findViewById(R.id.start)).setText(getString(R.string.onStart) + " " + startCtr);
	}

	@Override
	public void onResume(){
		super.onResume();

		//Log cat print out
		Log.i(TAG, "onResume called");

		resumeCtr++;
		((TextView)findViewById(R.id.resume)).setText(getString(R.string.onResume) + " " + resumeCtr);
	}

	@Override
	public void onPause(){
		super.onPause();

		//Log cat print out
		Log.i(TAG, "onPause called");

		pauseCtr++;
	}

	@Override
	public void onStop(){
		super.onStop();

		//Log cat print out
		Log.i(TAG, "onStop called");

		stopCtr++;

		SharedPreferences.Editor editor = prefs.edit();
		editor.putInt("createCount",createCtr);
		editor.putInt("startCount",startCtr);
		editor.putInt("resumeCount",resumeCtr);
		editor.putInt("pauseCount",pauseCtr);
		editor.putInt("stopCount",stopCtr);
		editor.putInt("destroyCount",destroyCtr);
		editor.putInt("restartCount",restartCtr);

		editor.commit();
	}

	@Override
	public void onRestart(){
		super.onRestart();

		//Log cat print out
		Log.i(TAG, "onRestart called");

		restartCtr++;
	}

	@Override
	public void onDestroy(){
		super.onDestroy();

		//Log cat print out
		Log.i(TAG, "onDestroy called");

		destroyCtr++;
	}

	@Override
		public void onSaveInstanceState(Bundle savedInstanceState){
			Log.i(TAG, "onSaveInstanceState called");
			savedInstanceState.putInt("createCount",createCtr);
			savedInstanceState.putInt("startCount", startCtr);
			savedInstanceState.putInt("resumeCount",resumeCtr);
			savedInstanceState.putInt("pauseCount",pauseCtr);
			savedInstanceState.putInt("stopCount",stopCtr);
			savedInstanceState.putInt("restartCount",restartCtr);
			savedInstanceState.putInt("destroyCount",destroyCtr);
		}
		
		public void launchActivityTwo(View view) {
			Intent intent = new Intent(ActivityOne.this,ActivityTwo.class);
			startActivity(intent);
		}

	public void clearCounters(View view){
		Log.i(TAG,"clearCounters called");
		createCtr = 0;
		startCtr=0;
		resumeCtr=0;
		pauseCtr=0;
		stopCtr=0;
		destroyCtr=0;
		restartCtr=0;
		((TextView)findViewById(R.id.create)).setText(getString(R.string.onCreate) + " " + createCtr);
		((TextView)findViewById(R.id.start)).setText(getString(R.string.onStart) + " " + startCtr);
		((TextView)findViewById(R.id.resume)).setText(getString(R.string.onResume) + " " + resumeCtr);
		((TextView)findViewById(R.id.pause)).setText(getString(R.string.onPause) + " " + pauseCtr);
		((TextView)findViewById(R.id.stop)).setText(getString(R.string.onStop) + " " + stopCtr);
		((TextView)findViewById(R.id.destroy)).setText(getString(R.string.onDestroy) + " " + destroyCtr);
		((TextView)findViewById(R.id.restart)).setText(getString(R.string.onRestart) + " " + restartCtr);
	}
		

}
