package com.assistant.test;

import com.assistant.alarm.Alarm;
import com.assistant.alarm.AlarmUpdateable;
import com.assistant.updater.UpdateManager;
import com.assistant.updater.Updater;

public class test {

	public static void main(String[] args) {
		
		UpdateManager man = new Updater();
		
		Alarm alarm = new Alarm(11, 11);
		AlarmUpdateable upd = new AlarmUpdateable(alarm);
		
		man.subscribeUpdater(upd);
		
		while (true) 
		{
			man.updateAll();
		}
		
	}

}
