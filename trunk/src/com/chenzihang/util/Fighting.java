package com.chenzihang.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Fighting	extends Activity
{
	private EditText mEditText01;
	private EditText mEditText02;
	private Button button_start;
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
        setContentView(R.layout.fighting);
        
        mEditText01 = (EditText)findViewById(R.id.EditText01);
        mEditText02 = (EditText)findViewById(R.id.EditText02);
        
        button_start = (Button)findViewById(R.id.Button01);
        button_start.setOnClickListener(new OnClickListener()
        {
			@Override
			public void onClick(View v) 
			{
				Intent intent1 = new Intent();
				intent1.setClass(Fighting.this,Screen.class);
				startActivity(intent1);
			}
        });                                                                                                                                    
	}
}