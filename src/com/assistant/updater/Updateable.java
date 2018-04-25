package com.assistant.updater;

public abstract class Updateable {
	/**
	 * This variable defines the delay(in seconds) between each call of update()
	 * 
	 * @author Tsvetelin
	 * 
	 */
	private int updateInterval = 0;
	
	public abstract void update();

	public int getUpdateInterval() {
		return updateInterval;
	}

	public void setUpdateInterval(int updateInterval) {
		this.updateInterval = updateInterval;
	}
	
}
