package com.assistant.updater;

import java.util.ArrayList;
import java.util.List;

public class Updater implements UpdateManager {

	List<Updateable> updateables = new ArrayList<Updateable>();
	List<Integer> delays = new ArrayList<Integer>();
	
	@Override
	public void subscribeUpdater(Updateable updater) 
	{
		updateables.add(updater);
		delays.add(updater.getUpdateInterval());
	}

	@Override
	public void unsubscribeUpdater(Updateable updater) 
	{
		if(updateables.contains(updater))
		{
			int index = updateables.indexOf(updater);
			updateables.remove(updater);
			delays.remove(index);
		}
	}

	@Override
	public void updateAll() 
	{
		System.out.println("Updating...");
		Integer currDelay = null;
		Updateable currUpd = null;
		for(int i=0;i<updateables.size();i++)
		{
			currDelay = delays.get(i);
			currUpd = updateables.get(i);
			if(delays.get(i) >= currUpd.getUpdateInterval())
			{
				System.out.println("Updated it");
				currUpd.update();
				currDelay=0;
			}else {
				currDelay = currDelay+1;
			}
			delays.set(i, currDelay);
		}
	}

}
