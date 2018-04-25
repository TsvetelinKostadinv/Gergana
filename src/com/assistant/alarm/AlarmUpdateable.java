package com.assistant.alarm;

import java.time.LocalDateTime;

import com.assistant.updater.UpdateManager;
import com.assistant.updater.Updateable;

public class AlarmUpdateable extends Updateable{
	
	private Alarm alarm;
	
	private LocalDateTime currTime;
	
	
	public AlarmUpdateable(Alarm alarm)
	{
		this.setUpdateInterval(60); // 60 seconds in a minute (It should be updated every 60 seconds)
		this.alarm = alarm;
	}
	
	public Alarm getAlarm()
	{
		return alarm;
	}
	
	public void setAlarm(Alarm alarm)
	{
		this.alarm = alarm;
	}
	
	@Override
	public void update() {
		updateTime();
		
		if(currTime.getHour() == alarm.getHour()
				&& currTime.getMinute() == alarm.getMinutes())
		{
			alarm.ringAlarm();
		}
		
	}

	private void updateTime() {
		currTime = LocalDateTime.now();
	}


}
