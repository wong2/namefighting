package com.chenzihang.util;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Test extends Activity
{
	String name1 ,name2;
	String name1MD5,name2MD5;
	char[] arrayname1,arrayname2;
	Bundle bundle;
	TextView text;
	MD5 md5;
	int name1Life = 100,name2Life = 100;
	
	public void onCreate(Bundle  savedInstanceState)
	{
		super.onCreate(savedInstanceState);
        setContentView(R.layout.screen);
        
        text = (TextView)findViewById(R.id.TextView01);
        
        md5 = new MD5();
        
        bundle = this.getIntent().getExtras();
        
        name1 = bundle.getString("name1");
        name2 = bundle.getString("name2");
        
        name1MD5 = md5.getMD5ofStr(name1);
        name2MD5 = md5.getMD5ofStr(name2);

   //     int i = 0;
 
        
        
 /*       text.setText("your name is " + name1MD5+name2MD5);	*/
        
	}

}
