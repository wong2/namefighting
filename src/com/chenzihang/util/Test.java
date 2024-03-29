package com.chenzihang.util;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class Test extends Activity
{
	String name1, name2;
	String name1MD5, name2MD5;
	String[] kongfu = new String[10];
	
	char[] arrayname1, arrayname2;
	int name1Life = 100, name2Life = 100;
	int aggressivity1 = 0, aggressivity2 = 0;			//攻击力
	int defense1 = 0, defense2 = 0;		//防御力
	int speed1 = 0, speed2 = 0;			//速度
	int skill1 = 0, skill2 = 0;			//技能
	int luck1 = 0, luck2 = 0;	//幸运
	
	Bundle bundle;
	TextView[] text = new TextView[10];
	ImageView[] bloodbar = new ImageView[10];
	int[] type =new int[10];
	int num1 = 0 , num2 = 5;
	int iii = 0;
	MD5 md5;
	Random random1, random2;	
	
	public void onCreate(Bundle  savedInstanceState)
	{
		super.onCreate(savedInstanceState);
        setContentView(R.layout.screen);
        
        kongfu[0] = "咬了一口";
        kongfu[1] = "发动连击";
        kongfu[2] = "下毒";
        kongfu[3] = "使出诅咒";
        kongfu[4] = "使出独门绝技无影脚";
        kongfu[5] = "使出春哥爷们拳";
        kongfu[6] = "使用美人计";
        kongfu[7] = "使出无敌棒棒拳";
        kongfu[8] = "把对方按在地上打了一顿";
        kongfu[9] = "发怒了，暴打了对方一顿";
        
        
        text[0] = (TextView)findViewById(R.id.TextView0);
        text[1] = (TextView)findViewById(R.id.TextView1);
        text[2] = (TextView)findViewById(R.id.TextView2);
        text[3] = (TextView)findViewById(R.id.TextView3);
        text[4] = (TextView)findViewById(R.id.TextView4);
        text[5] = (TextView)findViewById(R.id.TextView5);
        text[6] = (TextView)findViewById(R.id.TextView6);
        text[7] = (TextView)findViewById(R.id.TextView7);
        text[8] = (TextView)findViewById(R.id.TextView8);
        text[9] = (TextView)findViewById(R.id.TextView9);
        
        bloodbar[0] = (ImageView)findViewById(R.id.blood1);
        bloodbar[1] = (ImageView)findViewById(R.id.blood2);
        bloodbar[2] = (ImageView)findViewById(R.id.blood3);
        bloodbar[3] = (ImageView)findViewById(R.id.blood4);
        bloodbar[4] = (ImageView)findViewById(R.id.blood5);
        bloodbar[5] = (ImageView)findViewById(R.id.blood6);
        bloodbar[6] = (ImageView)findViewById(R.id.blood7);
        bloodbar[7] = (ImageView)findViewById(R.id.blood8);
        bloodbar[8] = (ImageView)findViewById(R.id.blood9);
        bloodbar[9] = (ImageView)findViewById(R.id.blood10);
        
        md5 = new MD5();
       
        //get the bundle from the last activity
        bundle = this.getIntent().getExtras();
        name1 = bundle.getString("name1");
        name2 = bundle.getString("name2");
        
        name1MD5 = md5.getMD5ofStr(name1);
        name2MD5 = md5.getMD5ofStr(name2);

        //the first five bits as the five different values
        aggressivity1 = name1MD5.charAt(0);
        defense1 = name1MD5.charAt(1);
        speed1 = name1MD5.charAt(2);
        skill1 = name1MD5.charAt(3);
        luck1 = name1MD5.charAt(4);
        
        aggressivity2 = name2MD5.charAt(0);
        defense2 = name2MD5.charAt(1);
        speed2 = name2MD5.charAt(2);
        skill2 = name2MD5.charAt(3);
        luck2 = name2MD5.charAt(4);
        
        //the main loop
        int i = 0;
        while(name1Life >0 && name2Life >0 && i < 10)
        {
        	if(name1MD5.charAt(i) >= name2MD5.charAt(i))
        	{
        		random1 = new Random();
        		int m = random1.nextInt(10);
        		text[i].setText(name1 + kongfu[m] + ", " + name2 +"受伤了");
        		name2Life -= 20; 
        		type[i] = 1;
        	}
        	else
        	{
        		random2 = new Random();
        		int n = random2.nextInt(10);
        		text[i].setText(name2 + kongfu[n] + "," + name1 + "受伤了");
        		name1Life -= 20;
        		type[i] = 0;
        	}
        	i++;        	
        }
        if(name1Life <= 0)
        {
        	text[i].setText(name1 +" was failed" );
        }
        else
        {
        	text[i].setText(name2 +" was failed");
        }   
        
        iii = i;
        
        final Handler handler = new Handler(); 
        Timer t = new Timer(); 
        t.schedule(new TimerTask() { 
                public void run() { 
                        handler.post(new Runnable() { 
                                public void run() {
                                	delayy(0, iii);
                                } 
                        }); 
                } 
        }, 2000);       
	}
	
	public void delayy(final int j, final int ii)
	{
		if(j==ii)
		{
			text[j].setVisibility(0);
			return;
		}
		if(type[j] == 0)
		{
			bloodbar[num1].setVisibility(View.INVISIBLE);
			num1++;
		}	
		else if(type[j] == 1)
		{
			bloodbar[num2].setVisibility(View.INVISIBLE);
			num2++;
		}
		text[j].setVisibility(0);	
        // SLEEP 2 SECONDS HERE ...
        final Handler handler = new Handler(); 
        Timer t = new Timer(); 
        t.schedule(new TimerTask() { 
                public void run() { 
                        handler.post(new Runnable() { 
                                public void run() {
                                	delayy(j+1, ii);
                                } 
                        }); 
                } 
        }, 2000); 
		
	}
}
