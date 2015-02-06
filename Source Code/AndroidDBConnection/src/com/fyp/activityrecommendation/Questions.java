package com.fyp.activityrecommendation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class Questions extends Activity
{
	
	@Override
    public void onCreate(Bundle savedInstanceState)
    {
		super.onCreate(savedInstanceState);
        
	     setContentView(R.layout.activity_questions);
    
    }
	
	int sex = 0;
	int age = 0;
	int active = 0;
	int cultural = 0;
	
	public void onRadioButtonClicked(View view)
	{
	    // Is the button now checked?
	    boolean checked = ((RadioButton) view).isChecked();
	    
	    // Check which radio button was clicked
	    switch(view.getId())
	    {
	    
	    	//What gender is the individual?
	        case R.id.male:
	            if (checked)
	                sex = 1;
	            break;
	        case R.id.female:
	            if (checked)
	                sex = 2;
	            break;
	            
	            
	        //What is the age range of the individual?
	        case R.id.ageeleven:
	            if (checked)
	                age = 11;
	            break;
	        case R.id.agefifteen:
	            if (checked)
	                age = 15;
	            break;
	        case R.id.ageeighteen:
	            if (checked)
	                age = 18;
	            break;
	        case R.id.agetwentyfive:
	            if (checked)
	                age = 25;
	            break;
	        case R.id.agethirtyfive:
	            if (checked)
	                age = 35;
	            break;
	        case R.id.agefortyfive:
	            if (checked)
	                age = 45;
	            break;
	        case R.id.agefiftyfive:
	            if (checked)
	                age = 55;
	            break;
	        case R.id.agesixtyfive:
	            if (checked)
	                age = 65;
	            break;
	            
	            
	         //How active is the individual?   
	        case R.id.actone:
	            if (checked)
	            	active = 1;
	            break;
	        case R.id.acttwo:
	            if (checked)
	            	active = 2;
	            break;
	        case R.id.actthree:
	            if (checked)
	            	active = 3;
	            break;
	        case R.id.actfour:
	            if (checked)
	            	active = 4;
	            break;
	        case R.id.actfive:
	            if (checked)
	            	active = 5;
	            break;
	            
	            
	            
	        //How cultural is the individual?
	        case R.id.culone:
	            if (checked)
	            	cultural = 1;
	            break;
	        case R.id.cultwo:
	            if (checked)
	            	cultural = 2;
	            break;
	        case R.id.culthree:
	            if (checked)
	            	cultural = 3;
	            break;
	        case R.id.culfour:
	            if (checked)
	            	cultural = 4;
	            break;
	        case R.id.culfive:
	            if (checked)
	            	cultural = 5;
	            break;
	            
	            
	    }
	    
	}
}

