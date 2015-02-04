package com.fyp.activityrecommendation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

public class LaunchScreen extends Activity
{
	
	Button createaccount;
	Button signin ;
	
	
    public void onCreate(Bundle savedInstanceState)
    {
	     // StrictMode is most commonly used to catch accidental disk or network access on the application's main thread	
	     StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
	  .detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
	        
	     super.onCreate(savedInstanceState);
	        
	     setContentView(R.layout.activity_launch_screen);		        
	        
	     signin = (Button) findViewById(R.id.signin);
	     createaccount = (Button) findViewById(R.id.createaccount);
	                
	     createaccount.setOnClickListener
	     (
	    		 new View.OnClickListener()
	    		 {        
	    			 public void onClick(View v)
	    			 {
	    				 Intent intent = new Intent(getApplicationContext(), CreateAccActivity.class);
				         startActivity(intent);
	    			 }
	    		 }
	    
	     );
	     
	     signin.setOnClickListener
	     (
	    		 new View.OnClickListener()
	    		 {        
	    			 public void onClick(View v)
	    			 {
	    				 Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
				         startActivity(intent);
	    			 }
	    		 }
	    
	     );
    }
    
	
}
