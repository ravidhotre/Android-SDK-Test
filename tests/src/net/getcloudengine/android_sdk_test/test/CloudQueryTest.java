package net.getcloudengine.android_sdk_test.test;

import java.util.List;

import net.getcloudengine.CloudException;
import net.getcloudengine.CloudObject;
import net.getcloudengine.CloudQuery;
import net.getcloudengine.FindCallback;
import net.getcloudengine.android_sdk_test.MainActivity;
import android.test.ActivityInstrumentationTestCase2;



public class CloudQueryTest extends
	ActivityInstrumentationTestCase2<MainActivity>{

	private MainActivity activity;
	
	public CloudQueryTest() {
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
	
	
	
	 //Save and retrieve objects to server
	 public void testCloudQuery(){
		 
		 CloudObject bob = new CloudObject("Person");
		   bob.put("name", "Bob");
		   bob.put("age", 28);
		   bob.put("is_admin", true);
		   bob.saveInBackground();
		   
		   CloudObject sheryl = new CloudObject("Person");
		   sheryl.put("name", "Sheryl");
		   sheryl.put("age", 21);
		   sheryl.put("is_admin", false);
		   sheryl.saveInBackground();
		   
		   
		   //Retrieve the object
		   CloudQuery query = new CloudQuery("Person");
		   query.findInBackground(new FindCallback(){

				@Override
				public void done(List<CloudObject> result, CloudException e) {
					assertEquals("Incorrect number of objects returned", 
							   2, result.size());
					
					CloudObject obj; String name;
					for(int i=0; i < result.size(); i++){
						obj = result.get(i);
						name = obj.getString("name");
						if(name == "Bob"){
							assertEquals("Incorrect property value for returned object",
									28, obj.getInt("age"));
							assertEquals("Incorrect property value for returned object",
									true, obj.getBoolean("is_admin"));
						}
						else{
							assertEquals("Incorrect property value for returned object",
									"Sheryl", name);
							assertEquals("Incorrect property value for returned object",
									28, obj.getInt("age"));
							assertEquals("Incorrect property value for returned object",
									true, obj.getBoolean("is_admin"));
						}
					}
					
					// Cleanup. Delete both the objects on server
					for(int i=0; i < result.size(); i++){
						obj = result.get(i);
						obj.delete();
					}
				}
			   
		   });
		   
		   try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 }
}
