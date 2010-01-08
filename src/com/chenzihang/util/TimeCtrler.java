package com.chenzihang.util;

import java.text.ParseException;
import java.util.Date;

public class TimeCtrler 
{
	long l;
	java.util.Date now;
	java.text.DateFormat df;
	java.util.Date start;
	
	public TimeCtrler()
	{
		df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			start = df.parse(df.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public long getTimePassBy()
	{
			try {
				now = df.parse(df.format(new Date()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			l=(now.getTime()-start.getTime()) / 1000;
			return l;
	}
}
