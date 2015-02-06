package com.fyp.activityrecommendation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class Questions extends Activity
{
	
	int sex = 0;
	int age = 0;
	
	
	
		public void onRadioButtonClicked(View view)
		{
		    // Is the button now checked?
		    boolean checked = ((RadioButton) view).isChecked();
		    
		    // Check which radio button was clicked
		    switch(view.getId())
		    {
		        case R.id.male:
		            if (checked)
		                sex = 1;
		            break;
		        case R.id.female:
		            if (checked)
		                sex = 2;
		            break;
		            
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
		    }
		}
    
}

