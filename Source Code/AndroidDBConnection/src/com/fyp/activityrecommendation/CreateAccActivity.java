package com.fyp.activityrecommendation;
import java.util.ArrayList;
import java.util.regex.Pattern;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
	 EditText username, fullname, email, country, password, confirmpassword;
	 Button next;
	 
	 String returnString; 
 
	 //Email validation (Setting the format & length)
	 public final Pattern EMAIL = Pattern.compile
	(
             "[a-zA-Z0-9+._%-+]{1,256}" +
             "@" +
             "[a-zA-Z0-9][a-zA-Z0-9-]{1,64}" +
             "(" +
             "." +
             "[a-zA-Z0-9][a-zA-Z0-9-]{2,25}" +
             ")+"
	);
	 
	 private boolean checkEmail(String email)
	 {
	        return EMAIL.matcher(email).matches();
	 }
	 
	 //Username validation (Setting the format & length)
	 public final Pattern USERNAME = Pattern.compile("[a-zA-Z0-9_.]{4,40}");
	 
	 private boolean checkUsername(String username)
	 {
		 	return USERNAME.matcher(username).matches();
	 }
	 
	//Fullname validation (Setting the format & length)
	 public final Pattern FULLNAME = Pattern.compile("[a-zA-Z0-9 ']{1,100}");
	 
	 private boolean checkFullname(String fullname)
	 {
		 	return FULLNAME.matcher(fullname).matches();
	 }
	 
	 //Country validation (Setting the format & length)
	 public final Pattern COUNTRY = Pattern.compile("[a-zA-Z ]{3,60}");
	 private boolean checkCountry(String country)
	 {
		 	return COUNTRY.matcher(country).matches();
	 }
	 
	 //Password validation (Setting the format & length)
	 public final Pattern PASSWORD = Pattern.compile("[a-zA-Z0-9]{6,50}");
	 private boolean checkPassword(String password)
	 {
		 	return PASSWORD.matcher(password).matches();
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
			    				 String usernameval=username.getText().toString();
			    				 String countryval=country.getText().toString();
			    				 String passwordval=password.getText().toString();
			    				 String fullnameval=fullname.getText().toString();
			    				 
			    				 //Username, fullname, country & password must be of a certain length 
			    				 if(checkUsername(usernameval) == false)
		    					 {
		    						 username.setError("Username must be at least 5 characters long & can only contain letters, numbers, '_' or a '.'");
		    					 }
			    				 if (checkFullname(fullnameval) == false)
			    				 {
			    					 fullname.setError("Names should only contain letters");
			    				 }
			    				 if(checkEmail(emailval) == false)
			    				 {
			    					 email.setError("Invalid Email Address");	
			    				 }
			    				 if(checkCountry(countryval) == false)
			    				 {
			    					  country.setError("Not a valid country");   
			    				 }
			    				 if(checkPassword(passwordval) == false)
			    				 {
			    					 password.setError("Password must be at least 6 charachters long & contain letters and number ONLY");
			    				 }

			    				 if(checkUsername(usernameval) == true && checkFullname(fullnameval) == true && checkEmail(emailval) == true
			    							 && checkCountry(countryval) == true && checkPassword(passwordval) == true)
			    				 {
			    						 
				    					 if (password.getText().toString().equals(confirmpassword.getText().toString()))
				    					 {
	
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
												  CustomHttpClient.executeHttpPost(
											        	  
														  response = "http://fyptest.site50.net/CreateAccount.php",postParameters);
												  
												  String result = response.toString(); 
												  
												  try
												  {
									        			returnString = "";
									        			JSONArray jArray = new JSONArray(result);
									        			
									        			for(int i=0;i<jArray.length();i++)
									        			{
									                         JSONObject json_data = jArray.getJSONObject(i);
									                         Log.i("log_tag",json_data.getString("output")       
									                         );
									                         
									                         int returnVal = Integer.parseInt(returnString);
									                         
									                         if (returnVal == 1)
									                         {
									                        	 username.setError("Username already exists");
									                         }
									                         if (returnVal == 2)
									                         {
									                        	 Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
									    				         startActivity(intent);
									                         }
									                         
									        			}
									        		}
									        		
									        		catch(JSONException e)
									        		{
									        			Log.e("log_tag", "Error parsing data "+e.toString());
									        		}
											      
												  if (result == "one")
											      {
											    	  username.setError("Username already in use");
											      }
											      else if (result == "two")
											      {
											    	  Intent intent = new Intent(getApplicationContext(), Questions.class);
											          startActivity(intent);
											      }
											      
											     
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
	    
	   
