package com.chenzihang.util;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Screen extends Activity
{
	private String name1,name1MD5;
	private String name2,name2MD5;
	private Bundle bundle;
	private TextView text;
	
	public void onCreat(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen);
		
		bundle = this.getIntent().getExtras();
		
		name1 = bundle.getString("name1");
		name2 = bundle.getString("name2");			
		
		
		
		text = (TextView)findViewById(R.id.TextView01);
		text.setText("your name is " +name1);
		text.setText("your name is " +name2);			
	}
	
}


 
 
 
 