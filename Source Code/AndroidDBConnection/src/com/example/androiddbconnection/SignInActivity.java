package com.example.androiddbconnection;

import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;

import com.example.androiddbconnection.CustomHttpClient;
import com.example.androiddbconnection.SignInActivity;


import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SignInActivity extends Activity
{
	//To take create account details
		 EditText username;
		 EditText password;
		 Button signin;
		 Button goback;
		 
		 String returnString;   // to store the result of MySQL query after decoding JSON
		 
		    /** Called when the activity is first created. */
		    @Override
		    public void onCreate(Bundle savedInstanceState)
		    {
			     // StrictMode is most commonly used to catch accidental disk or network access on the application's main thread	
			     StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
			  .detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
			        
			     super.onCreate(savedInstanceState);
			        
			     setContentView(R.layout.activity_sign_in);		        
			        
			     username = (EditText) findViewById(R.id.editText1);
			     password = (EditText) findViewById(R.id.editText2);
			     signin = (Button) findViewById(R.id.signin);
			     goback = (Button) findViewById(R.id.createacc);
			                
			     goback.setOnClickListener
			     (
			    		 new View.OnClickListener()
			    		 {        
			    			 public void onClick(View v)
			    			 {
			    				 Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
						         startActivity(intent);
			    			 }
			    		 }
			    
			     );
			     
			     
			     // define the action when user clicks on create account button
			     signin.setOnClickListener
			     (
			    		 
			    		 new View.OnClickListener()
			    		 {        
			    			 public void onClick(View v)
			    			 {
								     // declare parameters that are passed to PHP script i.e. UserName, Fullname  
								     ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
								          
								     // define the parameters
								     postParameters.add(new BasicNameValuePair("username",username.getText().toString()));
								     postParameters.add(new BasicNameValuePair("password",password.getText().toString()));
							          
								     String response = null;
							          
							          // call executeHttpPost method passing necessary parameters 
							          try 
							          {
								        	  response = CustomHttpClient.executeHttpPost(
								        	  
								        	  "http://www.itsthemurr.com/PHP/SignIn.php",postParameters);
								     
								        	  // store the result returned by PHP script that runs MySQL query
								        	  String result = response.toString();   	  
							          }
							          
			          
							          catch (Exception e)
							          {
							        	  Log.e("log_tag","Error in http connection!!" + e.toString());     
							          }
							          
							          
							          
			    			 }
			    			 
			    			 
			    		 }
			    );
			     
			     
		    }
}
