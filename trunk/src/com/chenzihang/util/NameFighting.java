package com.chenzihang.util;

import android.app.Activity;
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
				Intent intent1 = new Intent();
				intent1.setClass(NameFighting.this, Fighting.class);
				startActivity(intent1);
				
			}
        	
        });
        
        button_quit.setOnClickListener(new OnClickListener()
        {

			@Override
			public void onClick(View v)
			{
				finish();
				
			}
        	
        });
        
        button_help.setOnClickListener(new OnClickListener()
        {

			@Override
			public void onClick(View v)
			{
				Intent intent2 = new Intent();
				intent2.setClass(null, null);
				startActivity(intent2);
				
			}
        	
        });
    }
    
}