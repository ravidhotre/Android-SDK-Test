package net.getcloudengine.android_sdk_test.test;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import net.getcloudengine.CloudObject;
import net.getcloudengine.android_sdk_test.MainActivity;



public class CloudObjectTest extends 
	ActivityInstrumentationTestCase2<MainActivity>{
	
	private MainActivity activity;
	
	public CloudObjectTest() {
		super(MainActivity.class);
		
	}

	/*public void testPreconditions() {
	   
	}*/
	
	
	@Override
	  protected void setUp() throws Exception {
		super.setUp();
	    setActivityInitialTouchMode(false);
	    activity = getActivity();
	  }
	
	// Create a CloudObject. Populate with different datatypes
	// and retrive data
	 public void testCloudObjectCreate() {
		    
		 CloudObject bob = new CloudObject("Person");
		   bob.put("name", "Bob");
		   bob.put("age", 28);
		   bob.put("is_admin", true);
		   
		   assertEquals("Incorrect property value", 
				   "Bob", bob.getString("name"));
		   
		   assertEquals("Incorrect property value", 
				   28, bob.getInt("age"));
		   
		   assertEquals("Incorrect property value", 
				   true, bob.getBoolean("is_admin"));
		   
	 }
	 
	
	 
		  

}
