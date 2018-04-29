package com.assistant.test;

import com.assistant.alarm.Alarm;
import com.assistant.alarm.AlarmUpdateable;
import com.assistant.updater.UpdateManager;
import com.assistant.updater.Updater;

public class test {

	public static void main(String[] args) throws InterruptedException {
		
		UpdateManager man = new Updater();
		
		Alarm alarm = new Alarm(17, 37);
		AlarmUpdateable upd = new AlarmUpdateable(alarm);
		
		man.subscribeUpdater(upd);
		
		while (true) 
		{
			Thread.sleep(1000);
			man.updateAll();
		}
		
	}

}
