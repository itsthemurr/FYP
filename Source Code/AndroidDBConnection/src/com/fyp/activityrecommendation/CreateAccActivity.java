package com.fyp.activityrecommendation;
import java.util.ArrayList;
import java.util.regex.Pattern;

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
	 Button next;
	 EditText confirmpassword;
	 
	 String returnString; 

	 public final Pattern EMAIL = Pattern.compile
	(
             "[a-zA-Z0-9+._%-+]{1,256}" +
             "@" +
             "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" +
             "(" +
             "." +
             "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" +
             ")+"
	);
	 
	 private boolean checkEmail(String email)
	 {
	        return EMAIL.matcher(email).matches();
	 }
	 
	 
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
		     next = (Button) findViewById(R.id.next);
		     confirmpassword = (EditText) findViewById(R.id.editText6);
		     
		     
		     
		     
		     // define the action when user clicks on create account button
		     next.setOnClickListener
		     (			
		    		 
		    		 new View.OnClickListener()
		    		 
		    		 
		    		 {        
			    			 public void onClick(View v)
			    			 {
			    				 
			    				 String emailval=email.getText().toString();

			    				 //Username, fullname, country & password must be of a certain length
			    				 if( username.getText().toString().length() <= 4 )	 
			    				 {
			    					 username.setError( "Username must be at least 5 characters long" );
			    				 }
			    				 else if (fullname.getText().toString().length() <= 6)
			    				 {
			    					 fullname.setError("Please enter your full name");
			    				 }
			    				 else if(email.getText().toString().length() < 5 || checkEmail(emailval) == false)
			    				 {
			    					 email.setError("Invalid Email Address");	
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
			    					 if (password.getText().toString().equals(confirmpassword.getText().toString()))
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
									          
										  
										  
										     
									          
										  // call executeHttpPost method passing necessary parameters 
										  try 
										  {
											  CustomHttpClient.executeHttpPost(
										        	  
													  " http://fyptest.site50.net/createaccount.php",postParameters);
											  
										      
										     
										      // store the result returned by PHP script that runs MySQL query
		             	  
										  }

									      catch (Exception e)
									      {
									      	  Log.e("log_tag","Error in http connection!!" + e.toString());     
								          }
			    					 }
			    					 else
			    					 {
			    						 confirmpassword.setError("Passwords must match");
			    					 }
			    					 
			    					 
						          }
						          
							          
							          
							          
			    				 
		    			 }
			    			 
			    			 
		    			 
		    			 
		    		 }
		    );
		     
		     
	    }
	    
	   
}