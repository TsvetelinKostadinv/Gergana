package com.assistant.alarm;

import com.assistant.exceptions.TimeIncorrectFormatException;

public class Alarm 
{
	private String name;
	
	private HourMinuteContainer alarm;
	
	public Alarm(HourMinuteContainer alarm)
	{
		this.alarm = alarm;
	}
	
	
	/**
	 * 
	 * Constructor of the alarm object.
	 * If the passed parameters are not within correct range - hours [0;23] and minutes [0;59]
	 * everything is lowered within range
	 * 
	 * @param hours
	 * @param minutes
	 */
	public Alarm(int hours, int minutes)
	{
		try {
			this.alarm = new HourMinuteContainer(hours, minutes);
		} catch (TimeIncorrectFormatException e) {
			
			
			while(hours>=24)
			{
				hours-=24;
			}
			while(hours<0) 
			{
				hours+=24;
			}
			while(minutes>=60)
			{
				minutes-=60;
			}
			while(minutes<0) 
			{
				minutes+=60;
			}
			
			try {
				this.alarm = new HourMinuteContainer(hours, minutes);
			} catch (TimeIncorrectFormatException e1) {}
		}
	}
	
	public void setAlarm(HourMinuteContainer alarm)
	{
		this.alarm = alarm;
	}
	
	public void setAlarm(int hours, int minutes)
	{
		try {
			this.alarm = new HourMinuteContainer(hours, minutes);
		} catch (TimeIncorrectFormatException e) {
			
			
			while(hours>=24)
			{
				hours-=24;
			}
			while(hours<0) 
			{
				hours+=24;
			}
			while(minutes>=60)
			{
				minutes-=60;
			}
			while(minutes<0) 
			{
				minutes+=60;
			}
			
			try {
				this.alarm = new HourMinuteContainer(hours, minutes);
			} catch (TimeIncorrectFormatException e1) {}
		}
	}
	
	public HourMinuteContainer getAlarm()
	{
		return alarm;
	}
	
	public void incrementTime()
	{
		alarm.incrementMinutes();
	}
	
	public void incrementTime(int time)
	{
		alarm.incrementMinutes(time);
	}
	
	public void decrementTime()
	{
		alarm.decrementMinutes();
	}
	
	public void decrementTime(int time)
	{
		alarm.decrementMinutes(time);
	}
	
	public int getHour()
	{
		return alarm.getHour();
	}
	
	public int getMinutes()
	{
		return alarm.getMinutes();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void ringAlarm()
	{
		System.out.println("Alarm with name: "+ name+" rings!");
	}
	
}
