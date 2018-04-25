package com.assistant.alarm;

import com.assistant.exceptions.TimeIncorrectFormatException;

class HourMinuteContainer 
{
	private int hour;
	private int minutes;
	
	public HourMinuteContainer(int hour, int minutes) throws TimeIncorrectFormatException 
	{
		if(hour<0 || hour>=24)
		{
			throw new TimeIncorrectFormatException();
		}else {
			this.hour = hour;
		}
		if(minutes<0 || minutes>=60)
		{
			throw new TimeIncorrectFormatException();
		}else {
			this.minutes = minutes;
		}
	}

	public int getHour() 
	{
		return hour;
	}
	
	public void setHour(int hour) throws TimeIncorrectFormatException 
	{
		if(hour>=0 && hour<24) this.hour = hour;
		else throw new TimeIncorrectFormatException();
	}

	public int getMinutes() 
	{
		return minutes;
	}

	public void setMinutes(int minutes) throws TimeIncorrectFormatException 
	{
		if(minutes>=0 && minutes<60) this.minutes = minutes;
		else throw new TimeIncorrectFormatException();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof HourMinuteContainer)
		{
			if(((HourMinuteContainer) obj).getHour() == this.getHour() &&
					((HourMinuteContainer) obj).getMinutes() == this.getMinutes())
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return this.getHour()+":"+this.getMinutes();
	}
	
	public void incrementMinutes()
	{
		minutes++;
		if(minutes>=60)
		{
			hour++;
			minutes=0;
			if(hour>=24)
			{
				hour=0;
			}
		}
	}
	
	public void incrementMinutes(int amount)
	{
		minutes+=amount;
		if(minutes>=60)
		{
			hour++;
			minutes=0;
			if(hour>=24)
			{
				hour=0;
			}
		}
	}
	
	public void decrementMinutes()
	{
		minutes--;
		if(minutes<0)
		{
			hour--;
			minutes=59;
			if(hour<0)
			{
				hour=23;
			}
		}
	}
	
	public void decrementMinutes(int amount)
	{
		minutes-=amount;
		if(minutes<0)
		{
			hour--;
			minutes=59;
			if(hour<0)
			{
				hour=23;
			}
		}
	}
	
}
