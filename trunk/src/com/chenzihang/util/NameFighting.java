package com.chenzihang.util;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NameFighting extends Activity
{
    private Button button_start;
    private Button button_quit;
    private Button button_help;
   
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        button_start = (Button)findViewById(R.id.Button_begin);
        button_quit = (Button)findViewById(R.id.Button_quit);
        button_help = (Button)findViewById(R.id.Button_help);
        
        button_start.setOnClickListener(new OnClickListener()
        {

			@Override
			public void onClick(View v)
			{
				Intent intent0 = new Intent();
				intent0.setClass(NameFighting.this, Fighting.class);
				startActivity(intent0);
			}
        	
        });
        
        button_help.setOnClickListener(new OnClickListener()
        {

			@Override
			public void onClick(View v)
			{
				
			}
        	
        });
        
        button_quit.setOnClickListener(new OnClickListener()
        {

        	@Override
        	public void onClick(View v)
        	{
        		AlertDialog.Builder builder = new AlertDialog.Builder(NameFighting.this);
        		builder.setIcon(R.drawable.alert_dialog_icon);
        		builder.setTitle("Hello");
        		builder.setMessage("Really Quit?");
        		builder.setPositiveButton("Yes",
        				new DialogInterface.OnClickListener() 
        			{
        					public void onClick(DialogInterface dialog, int whichButton) 
        					{
        						finish();
        					}
	        		});
        		
        		builder.setNegativeButton("No",
        				new DialogInterface.OnClickListener() 
        				{
        					public void onClick(DialogInterface dialog, int whichButton)
        					{
        						
        					}
        				});
        		builder.show();
        		
        	}
        	
        });
    }
    
}