package net.getcloudengine.android_sdk_test;

import net.getcloudengine.CloudEngine;
import net.getcloudengine.CloudObject;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;


/**
 * The main purpose of this application is to test CloudEngine's Android SDK API. 
 * It will also be used to test the server API in end-to-end or round-trip testcases.
 * This application will be used along with the actual Android test cases in /tests 
 * folder (Android-SDK-Testcases project) to test the API.
 * 
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		CloudEngine.initialize(
				this, 
				"", 
				"");
		setContentView(R.layout.activity_main);
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

}
