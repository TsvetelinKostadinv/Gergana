package com.assistant.updater;

public interface UpdateManager 
{
	/**
	 * This method subscribes to the updater in order to be updated on a specified delay
	 * 
	 * @param updater to be added
	 */
	public abstract void subscribeUpdater(Updateable updater);

	
	/**
	 * This method removes the Updateable from the updating list(if it is there) and will no longer be updated
	 * 
	 * @param updater to be removed
	 */
	public abstract void unsubscribeUpdater(Updateable updater);
	
	/**
	 * This method calls the update method of all of the Updateables whose delays have passed
	 * 
	 */
	public abstract void updateAll();
	
}