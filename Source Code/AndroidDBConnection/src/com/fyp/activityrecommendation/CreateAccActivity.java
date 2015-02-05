package com.fyp.activityrecommendation;
import java.util.ArrayList;


import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateAccActivity extends Activity
{
	 
	 //To take create account details
	 EditText username;
	 EditText fullname;
	 EditText email;
	 EditText country;
	 EditText password;
	 Button createaccount;
	 
	
	 
	 
	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState)
	    {
		     // StrictMode is most commonly used to catch accidental disk or network access on the application's main thread	
		     StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
		  .detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
		        
		     super.onCreate(savedInstanceState);
		        
		     setContentView(R.layout.activity_create_account);		        
		        
		     username = (EditText) findViewById(R.id.editText1);
		     fullname = (EditText) findViewById(R.id.editText2);	
		     email = (EditText) findViewById(R.id.editText3);	
		     country = (EditText) findViewById(R.id.editText4);	
		     password = (EditText) findViewById(R.id.editText5);	
		     createaccount = (Button) findViewById(R.id.createaccount);
		     
		     
		     
		     
		     // define the action when user clicks on create account button
		     createaccount.setOnClickListener
		     (			
		    		 
		    		 new View.OnClickListener()
		    		 
		    		 
		    		 {        
			    			 public void onClick(View v)
			    			 {
		    				 
			    				 //Username, fullname, country & password must be of a certain length
			    				 if( username.getText().toString().length() <= 4 )	 
			    				 {
			    					 username.setError( "Username must be at least 5 characters long" );
			    				 }
			    				 else if (fullname.getText().toString().length() <= 6)
			    				 {
			    					 fullname.setError("Please enter your full name");
			    				 }
			    				 else if(country.getText().toString().length() <=3)
			    				 {
			    					  country.setError("Valid country required");   
			    				 }
			    				 else if(password.getText().toString().length() <= 6)
			    				 {
			    					 password.setError("Password must be at least 7 charachters long");
			    				 }
			    				 else 
						         {
			    					 
			    						 
				    					 Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
								          startActivity(intent);
								          
								          // declare parameters that are passed to PHP script i.e. UserName, Fullname  
										  ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
										          
										  // define the parameters
										  postParameters.add(new BasicNameValuePair("username",username.getText().toString()));
										  postParameters.add(new BasicNameValuePair("fullname",fullname.getText().toString()));
										  postParameters.add(new BasicNameValuePair("email",email.getText().toString()));
										  postParameters.add(new BasicNameValuePair("country",country.getText().toString()));
										  postParameters.add(new BasicNameValuePair("password",password.getText().toString()));
									          
										  String response = null;
										     
										     
									          
										  // call executeHttpPost method passing necessary parameters 
										  try 
										  {
											  response = CustomHttpClient.executeHttpPost(
										        	  
													  " http://fyptest.site50.net/createaccount.php",postParameters);
										     
										      // store the result returned by PHP script that runs MySQL query
										  	  
			             	  
										  }
									          
					          
									      catch (Exception e)
									      {
									      	  Log.e("log_tag","Error in http connection!!" + e.toString());     
								          }
			    					 
			    					 
						          }
						          
							          
							          
							          
			    				 
		    			 }
		    			 
		    			 
		    		 }
		    );
	    }
}